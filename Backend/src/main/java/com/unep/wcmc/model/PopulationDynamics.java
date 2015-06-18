package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PopulationDynamics implements Serializable {

    @Embedded
    private PopulationTrend populationTrend;

    @Embedded
    private DensityData densityData;

    @Column(name = "number_of_mature_individuals")
    private Long matureIndividualsNumber;

    @Column(name = "trend_in_mature_individuals")
    @Enumerated(value = EnumType.ORDINAL)
    private TrendOccurence matureIndividualsNumberTrend;

    @Column(name = "perc_and_period_of_decline")
    private Double declinePeriodPercent;

    @Column(name = "max_no_of_mature_individuals")
    private Long matureIndividualsSubpopulationMaxNumber;

    @Column(name = "perc_immature_individuals")
    private Double imatureIndividualsSubpopulationPercent;

    @Column(name = "flutuation_mature_individuals")
    private Boolean extremeFlutuationInMatureIndividualsNumber;

    @Column(name = "population_severely_fragmented")
    private Boolean populationSeverelyFragmented;

    public PopulationTrend getPopulationTrend() {
        return populationTrend;
    }

    public void setPopulationTrend(PopulationTrend populationTrend) {
        this.populationTrend = populationTrend;
    }

    public DensityData getDensityData() {
        return densityData;
    }

    public void setDensityData(DensityData densityData) {
        this.densityData = densityData;
    }

    public Long getMatureIndividualsNumber() {
        return matureIndividualsNumber;
    }

    public void setMatureIndividualsNumber(Long matureIndividualsNumber) {
        this.matureIndividualsNumber = matureIndividualsNumber;
    }

    public TrendOccurence getMatureIndividualsNumberTrend() {
        return matureIndividualsNumberTrend;
    }

    public void setMatureIndividualsNumberTrend(TrendOccurence matureIndividualsNumberTrend) {
        this.matureIndividualsNumberTrend = matureIndividualsNumberTrend;
    }

    public Double getDeclinePeriodPercent() {
        return declinePeriodPercent;
    }

    public void setDeclinePeriodPercent(Double declinePeriodPercent) {
        this.declinePeriodPercent = declinePeriodPercent;
    }

    public Long getMatureIndividualsSubpopulationMaxNumber() {
        return matureIndividualsSubpopulationMaxNumber;
    }

    public void setMatureIndividualsSubpopulationMaxNumber(Long matureIndividualsSubpopulationMaxNumber) {
        this.matureIndividualsSubpopulationMaxNumber = matureIndividualsSubpopulationMaxNumber;
    }

    public Double getImatureIndividualsSubpopulationPercent() {
        return imatureIndividualsSubpopulationPercent;
    }

    public void setImatureIndividualsSubpopulationPercent(Double imatureIndividualsSubpopulationPercent) {
        this.imatureIndividualsSubpopulationPercent = imatureIndividualsSubpopulationPercent;
    }

    public Boolean getExtremeFlutuationInMatureIndividualsNumber() {
        return extremeFlutuationInMatureIndividualsNumber;
    }

    public void setExtremeFlutuationInMatureIndividualsNumber(Boolean extremeFlutuationInMatureIndividualsNumber) {
        this.extremeFlutuationInMatureIndividualsNumber = extremeFlutuationInMatureIndividualsNumber;
    }

    public Boolean getPopulationSeverelyFragmented() {
        return populationSeverelyFragmented;
    }

    public void setPopulationSeverelyFragmented(Boolean populationSeverelyFragmented) {
        this.populationSeverelyFragmented = populationSeverelyFragmented;
    }

}