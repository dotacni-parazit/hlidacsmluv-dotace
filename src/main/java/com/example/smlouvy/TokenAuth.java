package com.example.smlouvy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TokenAuth implements ClientRequestFilter {

    private String token;

    @Autowired
    public TokenAuth(@Value("${hlidacsmluv.token}") String token) {
        this.token = token;
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        log.debug("Adding authorization token header");
        final MultivaluedMap<String, Object> headers = requestContext.getHeaders();
        headers.add("Authorization", "Token " + token);
        log.debug("headers: {}", requestContext.getHeaders());
    }
}
