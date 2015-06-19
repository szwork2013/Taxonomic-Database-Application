package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class DistributionArea implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "native_in_brazil")
    private Boolean nativeBrazil;

    @Column(name = "endemic_from_brasil")
    private Boolean endemicFromBrazil;

    @Column(name = "national_distribution")
    private String nationalDistribution;

    @Column(name = "only_from_few_localities")
    private Boolean onlyFromFewLocalities;

    @Column(name = "the_region_is_well_sampled")
    private Boolean regionIsWellSampled;

    @Column(name = "global_distribution")
    private String globalDistribution;

    @Column(name = "occurrence_state")
    private String ocurrenceState;

    @Column(name = "extent_of_occurrence")
    private Double extendOccurrence;

    @Column(name = "fragmentation_level")
    private Integer framentationLevel;

    @Column(name = "trend_in_extent_of_occurrence")
    @Enumerated(value = EnumType.ORDINAL)
    private TrendOccurence trendExtendOccurence;

    @Column(name = "area_of_ocuppancy")
    private Double occupancyArea;

    @Column(name = "area_of_occupancy_trend")
    @Enumerated(value = EnumType.ORDINAL)
    private TrendOccurence trendOccupancyArea;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getNativeBrazil() {
        return nativeBrazil;
    }

    public void setNativeBrazil(Boolean nativeBrazil) {
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
