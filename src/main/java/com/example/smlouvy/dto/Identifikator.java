
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
    "idSmlouvy",
    "idVerze"
})
public class Identifikator {

    @JsonProperty("idSmlouvy")
    private String idSmlouvy;
    @JsonProperty("idVerze")
    private String idVerze;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idSmlouvy")
    public String getIdSmlouvy() {
        return idSmlouvy;
    }

    @JsonProperty("idSmlouvy")
    public void setIdSmlouvy(String idSmlouvy) {
        this.idSmlouvy = idSmlouvy;
    }

    @JsonProperty("idVerze")
    public String getIdVerze() {
        return idVerze;
    }

    @JsonProperty("idVerze")
    public void setIdVerze(String idVerze) {
        this.idVerze = idVerze;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identifikator that = (Identifikator) o;

        if (idSmlouvy != null ? !idSmlouvy.equals(that.idSmlouvy) : that.idSmlouvy != null) return false;
        return idVerze != null ? idVerze.equals(that.idVerze) : that.idVerze == null;
    }

    @Override
    public int hashCode() {
        int result = idSmlouvy != null ? idSmlouvy.hashCode() : 0;
        result = 31 * result + (idVerze != null ? idVerze.hashCode() : 0);
        return result;
    }

}
