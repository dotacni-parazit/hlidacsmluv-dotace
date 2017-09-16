package com.example.smlouvy;

import com.example.smlouvy.dto.Smlouva;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@Data
public class Wrapper {
    private long total;
    private List<Smlouva> items;
}
