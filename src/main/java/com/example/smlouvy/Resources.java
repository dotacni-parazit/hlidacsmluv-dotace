package com.example.smlouvy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@Component
public class Resources {

    @Autowired
    private TokenAuth auth;

    @Bean(name = "search")
    public WebTarget hlidacSearch() {
        return ClientBuilder.newClient()
                .target("https://www.hlidacsmluv.cz")
                .register(auth)
                .path("api/v1/search");
    }


    @Bean(name = "detail")
    public WebTarget hlidacDetail() {
        return ClientBuilder.newClient()
                .target("https://www.hlidacsmluv.cz")
                .register(auth)
                .path("api/v1/detail");
    }
}
