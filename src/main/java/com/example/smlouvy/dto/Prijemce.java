
package com.example.smlouvy.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "datovaSchranka",
    "nazev",
    "ico",
    "adresa",
    "utvar"
})
public class Prijemce {

    @JsonProperty("datovaSchranka")
    private String datovaSchranka;
    @JsonProperty("nazev")
    private String nazev;
    @JsonProperty("ico")
    private String ico;
    @JsonProperty("adresa")
    private Object adresa;
    @JsonProperty("utvar")
    private Object utvar;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("datovaSchranka")
    public String getDatovaSchranka() {
        return datovaSchranka;
    }

    @JsonProperty("datovaSchranka")
    public void setDatovaSchranka(String datovaSchranka) {
        this.datovaSchranka = datovaSchranka;
    }

    @JsonProperty("nazev")
    public String getNazev() {
        return nazev;
    }

    @JsonProperty("nazev")
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @JsonProperty("ico")
    public String getIco() {
        return ico;
    }

    @JsonProperty("ico")
    public void setIco(String ico) {
        this.ico = ico;
    }

    @JsonProperty("adresa")
    public Object getAdresa() {
        return adresa;
    }

    @JsonProperty("adresa")
    public void setAdresa(Object adresa) {
        this.adresa = adresa;
    }

    @JsonProperty("utvar")
    public Object getUtvar() {
        return utvar;
    }

    @JsonProperty("utvar")
    public void setUtvar(Object utvar) {
        this.utvar = utvar;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
