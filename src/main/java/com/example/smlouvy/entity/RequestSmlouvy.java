package com.example.smlouvy.entity;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestSmlouvy {

    private String ico;
    private String projektIdnetifikator;
    private LocalDateTime podpisDatum;


    public static LocalDateTime fromString(String date){
        return LocalDateTime.parse(date);

    }
}
