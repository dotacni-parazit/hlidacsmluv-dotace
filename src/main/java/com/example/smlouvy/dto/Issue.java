
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
    "IssueTypeId",
    "Created",
    "Title",
    "TextDescription",
    "Public",
    "Permanent",
    "Importance",
    "AffectedParams",
    "AnalyzerType"
})
public class Issue {

    @JsonProperty("IssueTypeId")
    private Integer issueTypeId;
    @JsonProperty("Created")
    private String created;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("TextDescription")
    private String textDescription;
    @JsonProperty("Public")
    private Boolean _public;
    @JsonProperty("Permanent")
    private Boolean permanent;
    @JsonProperty("Importance")
    private Integer importance;
    @JsonProperty("AffectedParams")
    private Object affectedParams;
    @JsonProperty("AnalyzerType")
    private String analyzerType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("IssueTypeId")
    public Integer getIssueTypeId() {
        return issueTypeId;
    }

    @JsonProperty("IssueTypeId")
    public void setIssueTypeId(Integer issueTypeId) {
        this.issueTypeId = issueTypeId;
    }

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

    @JsonProperty("TextDescription")
    public String getTextDescription() {
        return textDescription;
    }

    @JsonProperty("TextDescription")
    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    @JsonProperty("Public")
    public Boolean getPublic() {
        return _public;
    }

    @JsonProperty("Public")
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    @JsonProperty("Permanent")
    public Boolean getPermanent() {
        return permanent;
    }

    @JsonProperty("Permanent")
    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    @JsonProperty("Importance")
    public Integer getImportance() {
        return importance;
    }

    @JsonProperty("Importance")
    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    @JsonProperty("AffectedParams")
    public Object getAffectedParams() {
        return affectedParams;
    }

    @JsonProperty("AffectedParams")
    public void setAffectedParams(Object affectedParams) {
        this.affectedParams = affectedParams;
    }

    @JsonProperty("AnalyzerType")
    public String getAnalyzerType() {
        return analyzerType;
    }

    @JsonProperty("AnalyzerType")
    public void setAnalyzerType(String analyzerType) {
        this.analyzerType = analyzerType;
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
