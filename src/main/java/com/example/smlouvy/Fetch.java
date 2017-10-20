package com.example.smlouvy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.smlouvy.dto.Smlouva;
import com.example.smlouvy.entity.RequestSmlouvy;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Fetch {

    public static final int DAY_DIFF = 2 * 30;

    private final WebTarget searchPath;
    private final WebTarget detailPath;

    @Autowired
    public Fetch(WebTarget apiClient) {
        this.searchPath = apiClient.path("api/v1/search");
        this.detailPath = apiClient.path("api/v1/detail");
    }

    public List<Smlouva> fetchDataByQuery(RequestSmlouvy requestSmlouvy) {

        log.info("fetch request: {}", requestSmlouvy);

        List<Smlouva> relevant = new LinkedList<>();
        relevant.addAll(byFullText(requestSmlouvy));

        List<Smlouva> byIco = byIco(requestSmlouvy);
        // don't create duplicates
        byIco.removeAll(relevant);
        relevant.addAll(byIco);

        log.info("enrighing {} with attachments", relevant.size());
        relevant = relevant.parallelStream()
                .map(this::enrichPrilohy)
                .map(s -> {
                    if (s.getPlatnyZaznam()) {
                        s.setRank(s.getRank() + 50);
                    }

                    if (requestSmlouvy.getPodpisDatum() != null) {
                        s.setRank(s.getRank() + rankDate(s, requestSmlouvy));
                        s.setMonthDiff(dayDiff(s, requestSmlouvy));
                    }
                    return s;
                })
                // sort descending by rank
                .sorted((first, second) -> Integer.compare(second.getRank(), first.getRank()))
                .collect(Collectors.toList());

        return relevant;
    }

    /**
     * Page request until we fetch all data from hlidacsmluv
     *
     * @param query elastic query string
     * @return found data
     */
    private List<Smlouva> pager(String query) {
        WebTarget target = this.searchPath.queryParam("query", query);
        List<Smlouva> items = new LinkedList<>();
        int page = 1;
        boolean needNext = true;
        while (needNext) {
            log.info("fetching page {} of for query {}", page, query);
            Response r = target
                    .queryParam("page", page)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get();

            log.info("Response status {}, headers: {}", r.getStatus(), r.getHeaders());
            final String contentType = String.valueOf(r.getHeaders().get("Content-Type"));
            if (!contentType.contains("json")) {
                log.error("Response for query '{}', page {}, is content type {}. Status code: {}, Headers '{}'.",
                        query, page, contentType, r.getStatus(), r.getHeaders());
                log.debug(r.readEntity(String.class));
                throw new IllegalArgumentException("Hlidac smluv reponded with: " + contentType);
            }
            Wrapper data = r.readEntity(Wrapper.class);
            items.addAll(data.getItems());
            needNext = data.getTotal() > data.getItems().size() && data.getItems().size() > 0;
            page++;
            log.info("found {} items. continue? {}", data.getItems().size(), needNext);
        }
        log.info("Fount total {} items for query {}", items.size(), query);
        return items;
    }

    private List<Smlouva> byIco(RequestSmlouvy r) {
        if (r.getIco() == null) {
            return new LinkedList<>();
        }
        List<Smlouva> found = pager(String.format("ico:%s", r.getIco()));
        if (r.getPodpisDatum() != null) {
            return found.stream()
                    .filter(s -> dayDiff(s, r) < DAY_DIFF)
                    .collect(Collectors.toList());
        }
        return found;
    }

    private List<Smlouva> byFullText(RequestSmlouvy requestSmlouvy) {
        List<Smlouva> relevant = new LinkedList<>();
        // fetch by projekt identifikator

        if (requestSmlouvy.getProjektIdnetifikator() == null) {
            return relevant;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(requestSmlouvy.getProjektIdnetifikator()).append("\"");
        if (requestSmlouvy.getIco() != null) {
            sb.append(" AND ").append(requestSmlouvy.getIco());
        }
        relevant = pager(sb.toString());
        // if we have any data from projekt identifikator
        // we'll verify it's relevant by checking ico (if we have one)
        if (relevant.size() > 0 && requestSmlouvy.getIco() != null) {
            log.info("filtering {} items on ico {}", relevant.size(), requestSmlouvy.getIco());

            relevant = relevant.stream()
                    .filter(s -> hasIco(s, requestSmlouvy.getIco()))
                    .collect(Collectors.toList());
            log.info("after ico filter there is {} items", relevant.size());
        }

        return relevant.stream()
                .map(s -> {
                    if (requestSmlouvy.getIco() != null) {
                        s.setRank(s.getRank() + 30);
                    } else {
                        s.setRank(s.getRank() + 20);
                    }
                    return s;
                })
                .collect(Collectors.toList());
//        return relevant;
    }

    public static boolean hasIco(Smlouva s, String ico) {
        boolean platce = ico.equals(s.getPlatce().getIco());
        boolean prijemce = s.getPrijemce().stream().anyMatch(p -> ico.equals(p.getIco()));
        log.info("{} has ico {}? platce {}, prijemce {}", s.getId(), ico, platce, prijemce);
        return platce || prijemce;
    }

    public Smlouva enrichPrilohy(Smlouva s) {
        log.info("fetching detail by {}", s.getId());
        Smlouva data = detailPath.path(s.getId())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(Smlouva.class);
        data.setRank(s.getRank());
        log.info("found {} with {} attachments", data.getId(), data.getPrilohy().size());
        return data;
    }

    private int dayDiff(Smlouva s, RequestSmlouvy r) {
        return (int) Math.abs(
                ChronoUnit.DAYS.between(r.getPodpisDatum(), s.datumUzavreni)
        );
    }

    public int rankDate(Smlouva s, RequestSmlouvy r) {

        double successPercent = 1 - (dayDiff(s, r) / (double) DAY_DIFF);
        int result = (int) Math.floor(successPercent * 40);

        log.debug("Ranking {} with day diff {} as {}", s.getId(), dayDiff(s, r), result);
        return result;
    }
}
