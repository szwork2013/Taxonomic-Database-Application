package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class DistributionArea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean nativeBrazil;

    private Boolean endemicFromBrazil;

    private String nationalDistribution;

    private Boolean onlyFromFewLocalities;

    private Boolean regionIsWellSampled;

    private String globalDistribution;

    private String ocurrenceState;

    private Double extendOccurrence;

    private Integer framentationLevel;

    private TrendOccurence trendExtendOccurence;

    private Double occupancyArea;

    private TrendOccurence trendOccupancyArea;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getNativeBrazil() {
        return nativeBrazil;
    }

    public void setNativeBrazil(boolean nativeBrazil) {
        this.nativeBrazil = nativeBrazil;
    }

    public Boolean getEndemicFromBrazil() {
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

    public Boolean getOnlyFromFewLocalities() {
        return onlyFromFewLocalities;
    }

    public void setOnlyFromFewLocalities(Boolean onlyFromFewLocalities) {
        this.onlyFromFewLocalities = onlyFromFewLocalities;
    }

    public Boolean getRegionIsWellSampled() {
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

    public Double getExtendOccurrence() {
        return extendOccurrence;
    }

    public void setExtendOccurrence(Double extendOccurrence) {
        this.extendOccurrence = extendOccurrence;
    }

    public Integer getFramentationLevel() {
        return framentationLevel;
    }

    public void setFramentationLevel(Integer framentationLevel) {
        this.framentationLevel = framentationLevel;
    }

    public TrendOccurence getTrendExtendOccurence() {
        return trendExtendOccurence;
    }

    public void setTrendExtendOccurence(TrendOccurence trendExtendOccurence) {
        this.trendExtendOccurence = trendExtendOccurence;
    }

    public Double getOccupancyArea() {
        return occupancyArea;
    }

    public void setOccupancyArea(Double occupancyArea) {
        this.occupancyArea = occupancyArea;
    }

    public TrendOccurence getTrendOccupancyArea() {
        return trendOccupancyArea;
    }

    public void setTrendOccupancyArea(TrendOccurence trendOccupancyArea) {
        this.trendOccupancyArea = trendOccupancyArea;
    }
}
