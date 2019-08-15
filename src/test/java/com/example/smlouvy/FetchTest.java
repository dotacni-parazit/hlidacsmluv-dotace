package com.example.smlouvy;


import com.example.smlouvy.dto.Smlouva;
import com.example.smlouvy.entity.RequestSmlouvy;
import lombok.extern.slf4j.Slf4j;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertThat;

@Slf4j
public class FetchTest {

    public static final String JSON_CONTENT_TYPE = "application/json";
    private Fetch fetch;

    @Rule
    public MockWebServer server = new MockWebServer();


    @Before
    public void init() {
        final String host = "http://localhost:" + server.getPort();
        log.info("using mock server '{}'", host);
        fetch = new Fetch(ClientBuilder.newClient().target(host));

    }

    @Test
    public void testHappyPath() throws IOException {

        enqueue(200, "json/succ_search.json");
        enqueue(200, "json/detail_617873.json");

        RequestSmlouvy r = RequestSmlouvy.builder()
                .ico("234")
                .build();
        System.out.println("testHappyPath");

        List<Smlouva> found = fetch.fetchDataByQuery(r);

        assertThat(found.size(), Matchers.equalTo(1));
        assertThat(found.get(0).getId(), Matchers.equalTo("617873"));
    }

    @Test
    public void testOutOfIntegerPrice() throws IOException {

        enqueue(200, "json/search_big_value.json");
        enqueue(200, "json/detail_big_value.json");

        RequestSmlouvy r = RequestSmlouvy.builder()
                .ico("234")
                .build();
        System.out.println("testHappyPath");

        List<Smlouva> found = fetch.fetchDataByQuery(r);

        assertThat(found.size(), Matchers.equalTo(1));
        assertThat(found.get(0).getId(), Matchers.equalTo("617873"));
    }


    private String fixtureFromClasspath(String path) throws IOException {
        final File file = new ClassPathResource(path).getFile();
        return new String(Files.readAllBytes(file.toPath()), Charset.forName("utf-8"));
    }


    private void enqueue(int responseCode, String classPathFixture) throws IOException {
        server.enqueue(new MockResponse()
                .setResponseCode(responseCode)
                .addHeader(HttpHeaders.CONTENT_TYPE, JSON_CONTENT_TYPE)
                .setBody(fixtureFromClasspath(classPathFixture)));
    }

}
