package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Embeddable
public class PopulationDynamics implements Serializable {

    @Embedded
    private PopulationTrend populationTrend;

    @Embedded
    private DensityData densityData;

    @Column(name = "past_reduction_with_ceased_reversible")
    private Boolean reductionWithCausesCeased;
    
	@OneToMany
	private List<PopulationReduction> reductionWithCausesCeasedPeriods;

    @Column(name = "past_reduction_without_ceased_not_reversible")
    private Boolean reductionWithoutCausesNotCeased;

	@OneToMany
	private List<PopulationReduction> reductionWithCausesNotCeasedPeriods;

    @Column(name = "projection_of_future_reduction")
    private Boolean projectionFutureReduction;

	@OneToMany
	private List<PopulationReduction> projectionFutureReductionPeriods;

    @Column(name = "reduction_include_past_and_future")
    private Boolean reductionIncludePastFuture;

	@OneToMany
	private List<PopulationReduction> reductionIncludePastFuturePeriods;

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

    @Column(name = "captive_breeding_program")
    private Boolean captiveBreedingProgram;

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

    public Boolean getCaptiveBreedingProgram() {
        return captiveBreedingProgram;
    }

    public void setCaptiveBreedingProgram(Boolean captiveBreedingProgram) {
        this.captiveBreedingProgram = captiveBreedingProgram;
    }

    public List<PopulationReduction> getReductionWithCausesCeasedPeriods() {
        return reductionWithCausesCeasedPeriods;
    }

    public void setReductionWithCausesCeasedPeriods(List<PopulationReduction> reductionWithCausesCeasedPeriods) {
        this.reductionWithCausesCeasedPeriods = reductionWithCausesCeasedPeriods;
    }

    public Double getReductionWithCausesCeasedTotalPercent() {
        return 0d;
    }

    public Boolean getReductionWithCausesCeased() {
        return reductionWithCausesCeased;
    }

    public void setReductionWithCausesCeased(Boolean reductionWithCausesCeased) {
        this.reductionWithCausesCeased = reductionWithCausesCeased;
    }

    public List<PopulationReduction> getReductionWithCausesNotCeasedPeriods() {
        return reductionWithCausesNotCeasedPeriods;
    }

    public void setReductionWithCausesNotCeasedPeriods(List<PopulationReduction> reductionWithCausesNotCeasedPeriods) {
        this.reductionWithCausesNotCeasedPeriods = reductionWithCausesNotCeasedPeriods;
    }

    public Double getReductionWithCausesNotCeasedTotalPercent() {
        return 0d;
    }

    public Boolean getReductionWithoutCausesNotCeased() {
        return reductionWithoutCausesNotCeased;
    }

    public void setReductionWithoutCausesNotCeased(Boolean reductionWithoutCausesNotCeased) {
        this.reductionWithoutCausesNotCeased = reductionWithoutCausesNotCeased;
    }

    public List<PopulationReduction> getProjectionFutureReductionPeriods() {
        return projectionFutureReductionPeriods;
    }

    public void setProjectionFutureReductionPeriods(List<PopulationReduction> projectionFutureReductionPeriods) {
        this.projectionFutureReductionPeriods = projectionFutureReductionPeriods;
    }

    public Double getProjectionFutureReductionTotalPercent() {
        return 0d;
    }

    public Integer getProjectionFutureReductionTotalYears() {
        return 0;
    }

    public Boolean getProjectionFutureReduction() {
        return projectionFutureReduction;
    }

    public void setProjectionFutureReduction(Boolean projectionFutureReduction) {
        this.projectionFutureReduction = projectionFutureReduction;
    }

    public List<PopulationReduction> getReductionIncludePastFuturePeriods() {
        return reductionIncludePastFuturePeriods;
    }

    public void setReductionIncludePastFuturePeriods(List<PopulationReduction> reductionIncludePastFuturePeriods) {
        this.reductionIncludePastFuturePeriods = reductionIncludePastFuturePeriods;
    }

    public Double getReductionIncludePastFutureTotalPercent() {
        return 0d;
    }

    public Integer getReductionIncludePastFutureTotalYears() {
        return 0;
    }

    public Boolean getReductionIncludePastFuture() {
        return reductionIncludePastFuture;
    }

    public void setReductionIncludePastFuture(Boolean reductionIncludePastFuture) {
        this.reductionIncludePastFuture = reductionIncludePastFuture;
    }


}