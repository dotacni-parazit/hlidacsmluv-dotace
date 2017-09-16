
package com.example.smlouvy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hodnota",
    "mena"
})
public class CiziMena {

    @JsonProperty("hodnota")
    private Integer hodnota;
    @JsonProperty("mena")
    private String mena;

    @JsonProperty("hodnota")
    public Integer getHodnota() {
        return hodnota;
    }

    @JsonProperty("hodnota")
    public void setHodnota(Integer hodnota) {
        this.hodnota = hodnota;
    }

    @JsonProperty("mena")
    public String getMena() {
        return mena;
    }

    @JsonProperty("mena")
    public void setMena(String mena) {
        this.mena = mena;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

}
