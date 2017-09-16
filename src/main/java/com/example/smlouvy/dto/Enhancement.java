
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
    "Created",
    "Title",
    "Description",
    "Changed",
    "Public",
    "EnhancerType"
})
public class Enhancement {

    @JsonProperty("Created")
    private String created;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Changed")
    private Changed changed;
    @JsonProperty("Public")
    private Boolean _public;
    @JsonProperty("EnhancerType")
    private String enhancerType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("Created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Changed")
    public Changed getChanged() {
        return changed;
    }

    @JsonProperty("Changed")
    public void setChanged(Changed changed) {
        this.changed = changed;
    }

    @JsonProperty("Public")
    public Boolean getPublic() {
        return _public;
    }

    @JsonProperty("Public")
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    @JsonProperty("EnhancerType")
    public String getEnhancerType() {
        return enhancerType;
    }

    @JsonProperty("EnhancerType")
    public void setEnhancerType(String enhancerType) {
        this.enhancerType = enhancerType;
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
