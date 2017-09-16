package com.example.smlouvy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.smlouvy.Fetch;
import com.example.smlouvy.dto.Smlouva;
import com.example.smlouvy.entity.RequestSmlouvy;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Component
@Path("/smlouvy")
@Slf4j
@Produces({"application/json; charset=UTF-8"})
@Consumes({"application/json; charset=UTF-8"})

public class SmlouvyEndpoint {

    @Autowired
    private Fetch fetch;

    @POST
    @Path("/search")
    public List<Smlouva> test(@NotNull RequestSmlouvy requestSmlouvy) {
        log.info("Requested {}", requestSmlouvy);

        return fetch.fetchDataByQuery(requestSmlouvy);
    }
}