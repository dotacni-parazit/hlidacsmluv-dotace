
package com.example.smlouvy.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "identifikator",
    "schvalil",
    "hodnotaBezDph",
    "hodnotaVcetneDph",
    "ciziMena",
    "platnyZaznam",
    "PravniRamec",
    "Prilohy",
    "LastUpdate",
    "CalculatedPriceWithVATinCZK",
    "CalcutatedPriceQuality",
    "Issues",
    "Enhancements",
    "ConfidenceValue",
    "Id",
    "odkaz",
    "casZverejneni",
    "VkladatelDoRejstriku",
    "Platce",
    "Prijemce",
    "predmet",
    "datumUzavreni",
    "cisloSmlouvy",
    "navazanyZaznam",
    "souvisejiciSmlouvy"
})
public class Smlouva {

    @JsonProperty("rank")
    private Integer rank = 0;

    @JsonProperty("monthDiff")
    private Integer monthDiff;

    @JsonProperty("identifikator")
    private Identifikator identifikator;
    @JsonProperty("schvalil")
    private Object schvalil;
    @JsonProperty("hodnotaBezDph")
    private BigDecimal hodnotaBezDph;
    @JsonProperty("hodnotaVcetneDph")
    private BigDecimal hodnotaVcetneDph;
    @JsonProperty("ciziMena")
    private Object ciziMena;
    @JsonProperty("platnyZaznam")
    private Boolean platnyZaznam;
    @JsonProperty("PravniRamec")
    private Integer pravniRamec;
    @JsonProperty("Prilohy")
    private List<Prilohy> prilohy = null;
    @JsonProperty("LastUpdate")
    private String lastUpdate;
    @JsonProperty("CalculatedPriceWithVATinCZK")
    private BigDecimal calculatedPriceWithVATinCZK;
    @JsonProperty("CalcutatedPriceQuality")
    private Integer calcutatedPriceQuality;
    @JsonProperty("Issues")
    private List<Issue> issues = null;
    @JsonProperty("Enhancements")
    private List<Enhancement> enhancements = null;
    @JsonProperty("ConfidenceValue")
    private Integer confidenceValue;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("odkaz")
    private String odkaz;
    @JsonProperty("casZverejneni")
    private String casZverejneni;
    @JsonProperty("VkladatelDoRejstriku")
    private VkladatelDoRejstriku vkladatelDoRejstriku;
    @JsonProperty("Platce")
    private Platce platce;
    @JsonProperty("Prijemce")
    private List<Prijemce> prijemce = null;
    @JsonProperty("predmet")
    private String predmet;
    @JsonProperty("datumUzavreni")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime datumUzavreni;
    @JsonProperty("cisloSmlouvy")
    private String cisloSmlouvy;
    @JsonProperty("navazanyZaznam")
    private Object navazanyZaznam;
    @JsonProperty("souvisejiciSmlouvy")
    private Object souvisejiciSmlouvy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("identifikator")
    public Identifikator getIdentifikator() {
        return identifikator;
    }

    @JsonProperty("identifikator")
    public void setIdentifikator(Identifikator identifikator) {
        this.identifikator = identifikator;
    }

    @JsonProperty("schvalil")
    public Object getSchvalil() {
        return schvalil;
    }

    @JsonProperty("schvalil")
    public void setSchvalil(Object schvalil) {
        this.schvalil = schvalil;
    }

    @JsonProperty("hodnotaBezDph")
    public BigDecimal getHodnotaBezDph() {
        return hodnotaBezDph;
    }

    @JsonProperty("hodnotaBezDph")
    public void setHodnotaBezDph(BigDecimal hodnotaBezDph) {
        this.hodnotaBezDph = hodnotaBezDph;
    }

    @JsonProperty("hodnotaVcetneDph")
    public BigDecimal getHodnotaVcetneDph() {
        return hodnotaVcetneDph;
    }

    @JsonProperty("hodnotaVcetneDph")
    public void setHodnotaVcetneDph(BigDecimal hodnotaVcetneDph) {
        this.hodnotaVcetneDph = hodnotaVcetneDph;
    }

    @JsonProperty("ciziMena")
    public Object getCiziMena() {
        return ciziMena;
    }

    @JsonProperty("ciziMena")
    public void setCiziMena(Object ciziMena) {
        this.ciziMena = ciziMena;
    }

    @JsonProperty("platnyZaznam")
    public Boolean getPlatnyZaznam() {
        return platnyZaznam;
    }

    @JsonProperty("platnyZaznam")
    public void setPlatnyZaznam(Boolean platnyZaznam) {
        this.platnyZaznam = platnyZaznam;
    }

    @JsonProperty("PravniRamec")
    public Integer getPravniRamec() {
        return pravniRamec;
    }

    @JsonProperty("PravniRamec")
    public void setPravniRamec(Integer pravniRamec) {
        this.pravniRamec = pravniRamec;
    }

    @JsonProperty("Prilohy")
    public List<Prilohy> getPrilohy() {
        return prilohy;
    }

    @JsonProperty("Prilohy")
    public void setPrilohy(List<Prilohy> prilohy) {
        this.prilohy = prilohy;
    }

    @JsonProperty("LastUpdate")
    public String getLastUpdate() {
        return lastUpdate;
    }

    @JsonProperty("LastUpdate")
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @JsonProperty("CalculatedPriceWithVATinCZK")
    public BigDecimal getCalculatedPriceWithVATinCZK() {
        return calculatedPriceWithVATinCZK;
    }

    @JsonProperty("CalculatedPriceWithVATinCZK")
    public void setCalculatedPriceWithVATinCZK(BigDecimal calculatedPriceWithVATinCZK) {
        this.calculatedPriceWithVATinCZK = calculatedPriceWithVATinCZK;
    }

    @JsonProperty("CalcutatedPriceQuality")
    public Integer getCalcutatedPriceQuality() {
        return calcutatedPriceQuality;
    }

    @JsonProperty("CalcutatedPriceQuality")
    public void setCalcutatedPriceQuality(Integer calcutatedPriceQuality) {
        this.calcutatedPriceQuality = calcutatedPriceQuality;
    }

    @JsonProperty("Issues")
    public List<Issue> getIssues() {
        return issues;
    }

    @JsonProperty("Issues")
    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @JsonProperty("Enhancements")
    public List<Enhancement> getEnhancements() {
        return enhancements;
    }

    @JsonProperty("Enhancements")
    public void setEnhancements(List<Enhancement> enhancements) {
        this.enhancements = enhancements;
    }

    @JsonProperty("ConfidenceValue")
    public Integer getConfidenceValue() {
        return confidenceValue;
    }

    @JsonProperty("ConfidenceValue")
    public void setConfidenceValue(Integer confidenceValue) {
        this.confidenceValue = confidenceValue;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("odkaz")
    public String getOdkaz() {
        return odkaz;
    }

    @JsonProperty("odkaz")
    public void setOdkaz(String odkaz) {
        this.odkaz = odkaz;
    }

    @JsonProperty("casZverejneni")
    public String getCasZverejneni() {
        return casZverejneni;
    }

    @JsonProperty("casZverejneni")
    public void setCasZverejneni(String casZverejneni) {
        this.casZverejneni = casZverejneni;
    }

    @JsonProperty("VkladatelDoRejstriku")
    public VkladatelDoRejstriku getVkladatelDoRejstriku() {
        return vkladatelDoRejstriku;
    }

    @JsonProperty("VkladatelDoRejstriku")
    public void setVkladatelDoRejstriku(VkladatelDoRejstriku vkladatelDoRejstriku) {
        this.vkladatelDoRejstriku = vkladatelDoRejstriku;
    }

    @JsonProperty("Platce")
    public Platce getPlatce() {
        return platce;
    }

    @JsonProperty("Platce")
    public void setPlatce(Platce platce) {
        this.platce = platce;
    }

    @JsonProperty("Prijemce")
    public List<Prijemce> getPrijemce() {
        return prijemce;
    }

    @JsonProperty("Prijemce")
    public void setPrijemce(List<Prijemce> prijemce) {
        this.prijemce = prijemce;
    }

    @JsonProperty("predmet")
    public String getPredmet() {
        return predmet;
    }

    @JsonProperty("predmet")
    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    @JsonProperty("datumUzavreni")
    public LocalDateTime getDatumUzavreni() {
        return datumUzavreni;
    }

    @JsonProperty("datumUzavreni")
    public void setDatumUzavreni(LocalDateTime datumUzavreni) {
        this.datumUzavreni = datumUzavreni;
    }

    @JsonProperty("cisloSmlouvy")
    public String getCisloSmlouvy() {
        return cisloSmlouvy;
    }

    @JsonProperty("cisloSmlouvy")
    public void setCisloSmlouvy(String cisloSmlouvy) {
        this.cisloSmlouvy = cisloSmlouvy;
    }

    @JsonProperty("navazanyZaznam")
    public Object getNavazanyZaznam() {
        return navazanyZaznam;
    }

    @JsonProperty("navazanyZaznam")
    public void setNavazanyZaznam(Object navazanyZaznam) {
        this.navazanyZaznam = navazanyZaznam;
    }

    @JsonProperty("souvisejiciSmlouvy")
    public Object getSouvisejiciSmlouvy() {
        return souvisejiciSmlouvy;
    }

    @JsonProperty("souvisejiciSmlouvy")
    public void setSouvisejiciSmlouvy(Object souvisejiciSmlouvy) {
        this.souvisejiciSmlouvy = souvisejiciSmlouvy;
    }

    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }

    public Integer getMonthDiff() {
        return monthDiff;
    }

    public void setMonthDiff(Integer monthDiff) {
        this.monthDiff = monthDiff;
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
        if (!(o instanceof Smlouva)) return false;

        Smlouva smlouva = (Smlouva) o;

        return identifikator.equals(smlouva.identifikator);
    }

    @Override
    public int hashCode() {
        return identifikator.hashCode();
    }

}
