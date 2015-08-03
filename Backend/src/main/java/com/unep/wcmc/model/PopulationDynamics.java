package com.unep.wcmc.model;

import javax.persistence.*;

import java.io.Serializable;

@Embeddable
public class PopulationDynamics implements Serializable {

    @Embedded
    private PopulationTrend populationTrend;

    @Embedded
    private DensityData densityData;
    
	@OneToOne
	@JoinColumn(name = "past_reduction_with_ceased_and_reversible")
	private PopulationReduction popReductionWithCausesCeased;

	@OneToOne
	@JoinColumn(name = "past_reduction_without_ceased_and_not_reversible")
	private PopulationReduction popReductionWithCausesNotCeased;
	
	@OneToOne
	@JoinColumn(name = "projection_of_future_reduction")
	private PopulationReduction projectionOfFutureReduction;

	@OneToOne
	@JoinColumn(name = "reduction_include_past_and_future")
	private PopulationReduction reductionIncludeBothPastAndFuture;

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

	public PopulationReduction getPopReductionWithCausesCeased() {
		return popReductionWithCausesCeased;
	}

	public void setPopReductionWithCausesCeased(
			PopulationReduction popReductionWithCausesCeased) {
		this.popReductionWithCausesCeased = popReductionWithCausesCeased;
	}

	public PopulationReduction getPopReductionWithCausesNotCeased() {
		return popReductionWithCausesNotCeased;
	}

	public void setPopReductionWithCausesNotCeased(
			PopulationReduction popReductionWithCausesNotCeased) {
		this.popReductionWithCausesNotCeased = popReductionWithCausesNotCeased;
	}

	public PopulationReduction getProjectionOfFutureReduction() {
		return projectionOfFutureReduction;
	}

	public void setProjectionOfFutureReduction(
			PopulationReduction projectionOfFutureReduction) {
		this.projectionOfFutureReduction = projectionOfFutureReduction;
	}

	public PopulationReduction getReductionIncludeBothPastAndFuture() {
		return reductionIncludeBothPastAndFuture;
	}

	public void setReductionIncludeBothPastAndFuture(
			PopulationReduction reductionIncludeBothPastAndFuture) {
		this.reductionIncludeBothPastAndFuture = reductionIncludeBothPastAndFuture;
	}
}
