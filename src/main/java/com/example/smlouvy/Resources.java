package com.example.smlouvy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@Component
public class Resources {

    private final TokenAuth auth;
    private final String hlidacSmluvHost;

    @Autowired
    public Resources(TokenAuth auth,
                     @Value("${hlidacsmluv.host}") String hlidacSmluvHost) {
        this.auth = auth;
        this.hlidacSmluvHost = hlidacSmluvHost;
    }

    /**
     * Create http client with with auth token.
     */
    @Bean
    public WebTarget apiClient() {
        return ClientBuilder.newClient()
                .target(hlidacSmluvHost)
                .register(auth);
    }
}
