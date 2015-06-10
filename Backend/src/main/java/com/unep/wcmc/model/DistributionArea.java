package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DistributionArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean nativeBrazil;

    private Boolean endemicFromBrazil;

    private String nationalDistribution;

    private Boolean onlyFromFewLocalities;

    private Boolean regionIsWellSampled;

    private String globalDistribution;

    private String ocurrenceState;

    private String extendOccurrence;

    private Integer framentationLevel;

    private String trendExtendOccurence;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isNativeBrazil() {
        return nativeBrazil;
    }

    public void setNativeBrazil(boolean nativeBrazil) {
        this.nativeBrazil = nativeBrazil;
    }

    public Boolean isEndemicFromBrazil() {
        return endemicFromBrazil;
    }

    public void setEndemicFromBrazil(Boolean endemicFromBrazil) {
        this.endemicFromBrazil = endemicFromBrazil;
    }

    public String getNationalDistribution() {
        return nationalDistribution;
    }

    public void setNationalDistribution(String nationalDistribution) {
        this.nationalDistribution = nationalDistribution;
    }

    public Boolean isOnlyFromFewLocalities() {
        return onlyFromFewLocalities;
    }

    public void setOnlyFromFewLocalities(Boolean onlyFromFewLocalities) {
        this.onlyFromFewLocalities = onlyFromFewLocalities;
    }

    public Boolean isRegionIsWellSampled() {
        return regionIsWellSampled;
    }

    public void setRegionIsWellSampled(Boolean regionIsWellSampled) {
        this.regionIsWellSampled = regionIsWellSampled;
    }

    public String getGlobalDistribution() {
        return globalDistribution;
    }

    public void setGlobalDistribution(String globalDistribution) {
        this.globalDistribution = globalDistribution;
    }

    public String getOcurrenceState() {
        return ocurrenceState;
    }

    public void setOcurrenceState(String ocurrenceState) {
        this.ocurrenceState = ocurrenceState;
    }

    public String getExtendOccurrence() {
        return extendOccurrence;
    }

    public void setExtendOccurrence(String extendOccurrence) {
        this.extendOccurrence = extendOccurrence;
    }

    public Integer getFramentationLevel() {
        return framentationLevel;
    }

    public void setFramentationLevel(Integer framentationLevel) {
        this.framentationLevel = framentationLevel;
    }

    public String getTrendExtendOccurence() {
        return trendExtendOccurence;
    }

    public void setTrendExtendOccurence(String trendExtendOccurence) {
        this.trendExtendOccurence = trendExtendOccurence;
    }
}
