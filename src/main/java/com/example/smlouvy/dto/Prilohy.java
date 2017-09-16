
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
    "FileMetadata",
    "data",
    "nazevSouboru",
    "hash",
    "odkaz",
    "DatlClassification",
    "PlainTextContent",
    "PlainTextContentQuality",
    "LastUpdate",
    "LocalCopy",
    "ContentType",
    "Lenght",
    "WordCount",
    "Pages",
    "EnoughExtractedText"
})
public class Prilohy {

    @JsonProperty("FileMetadata")
    private Object fileMetadata;
    @JsonProperty("data")
    private Object data;
    @JsonProperty("nazevSouboru")
    private String nazevSouboru;
    @JsonProperty("hash")
    private Hash hash;
    @JsonProperty("odkaz")
    private String odkaz;
    @JsonProperty("DatlClassification")
    private Object datlClassification;
    @JsonProperty("PlainTextContent")
    private String plainTextContent;
    @JsonProperty("PlainTextContentQuality")
    private Integer plainTextContentQuality;
    @JsonProperty("LastUpdate")
    private String lastUpdate;
    @JsonProperty("LocalCopy")
    private Object localCopy;
    @JsonProperty("ContentType")
    private String contentType;
    @JsonProperty("Lenght")
    private Integer lenght;
    @JsonProperty("WordCount")
    private Integer wordCount;
    @JsonProperty("Pages")
    private Integer pages;
    @JsonProperty("EnoughExtractedText")
    private Boolean enoughExtractedText;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("FileMetadata")
    public Object getFileMetadata() {
        return fileMetadata;
    }

    @JsonProperty("FileMetadata")
    public void setFileMetadata(Object fileMetadata) {
        this.fileMetadata = fileMetadata;
    }

    @JsonProperty("data")
    public Object getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Object data) {
        this.data = data;
    }

    @JsonProperty("nazevSouboru")
    public String getNazevSouboru() {
        return nazevSouboru;
    }

    @JsonProperty("nazevSouboru")
    public void setNazevSouboru(String nazevSouboru) {
        this.nazevSouboru = nazevSouboru;
    }

    @JsonProperty("hash")
    public Hash getHash() {
        return hash;
    }

    @JsonProperty("hash")
    public void setHash(Hash hash) {
        this.hash = hash;
    }

    @JsonProperty("odkaz")
    public String getOdkaz() {
        return odkaz;
    }

    @JsonProperty("odkaz")
    public void setOdkaz(String odkaz) {
        this.odkaz = odkaz;
    }

    @JsonProperty("DatlClassification")
    public Object getDatlClassification() {
        return datlClassification;
    }

    @JsonProperty("DatlClassification")
    public void setDatlClassification(Object datlClassification) {
        this.datlClassification = datlClassification;
    }

    @JsonProperty("PlainTextContent")
    public String getPlainTextContent() {
        return plainTextContent;
    }

    @JsonProperty("PlainTextContent")
    public void setPlainTextContent(String plainTextContent) {
        this.plainTextContent = plainTextContent;
    }

    @JsonProperty("PlainTextContentQuality")
    public Integer getPlainTextContentQuality() {
        return plainTextContentQuality;
    }

    @JsonProperty("PlainTextContentQuality")
    public void setPlainTextContentQuality(Integer plainTextContentQuality) {
        this.plainTextContentQuality = plainTextContentQuality;
    }

    @JsonProperty("LastUpdate")
    public String getLastUpdate() {
        return lastUpdate;
    }

    @JsonProperty("LastUpdate")
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @JsonProperty("LocalCopy")
    public Object getLocalCopy() {
        return localCopy;
    }

    @JsonProperty("LocalCopy")
    public void setLocalCopy(Object localCopy) {
        this.localCopy = localCopy;
    }

    @JsonProperty("ContentType")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("ContentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("Lenght")
    public Integer getLenght() {
        return lenght;
    }

    @JsonProperty("Lenght")
    public void setLenght(Integer lenght) {
        this.lenght = lenght;
    }

    @JsonProperty("WordCount")
    public Integer getWordCount() {
        return wordCount;
    }

    @JsonProperty("WordCount")
    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    @JsonProperty("Pages")
    public Integer getPages() {
        return pages;
    }

    @JsonProperty("Pages")
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @JsonProperty("EnoughExtractedText")
    public Boolean getEnoughExtractedText() {
        return enoughExtractedText;
    }

    @JsonProperty("EnoughExtractedText")
    public void setEnoughExtractedText(Boolean enoughExtractedText) {
        this.enoughExtractedText = enoughExtractedText;
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
