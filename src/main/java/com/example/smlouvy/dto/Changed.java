
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
    "ParameterName",
    "PreviousValue",
    "NewValue"
})
public class Changed {

    @JsonProperty("ParameterName")
    private String parameterName;
    @JsonProperty("PreviousValue")
    private String previousValue;
    @JsonProperty("NewValue")
    private String newValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ParameterName")
    public String getParameterName() {
        return parameterName;
    }

    @JsonProperty("ParameterName")
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    @JsonProperty("PreviousValue")
    public String getPreviousValue() {
        return previousValue;
    }

    @JsonProperty("PreviousValue")
    public void setPreviousValue(String previousValue) {
        this.previousValue = previousValue;
    }

    @JsonProperty("NewValue")
    public String getNewValue() {
        return newValue;
    }

    @JsonProperty("NewValue")
    public void setNewValue(String newValue) {
        this.newValue = newValue;
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
