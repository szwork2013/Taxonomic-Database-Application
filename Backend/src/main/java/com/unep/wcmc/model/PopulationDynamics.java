package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PopulationDynamics implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PopulationTrend populationTrend;

    @Embedded
    private DensityData densityData;

	@Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "reduction",
                    column = @Column(name = "reduction_with_causes_ceased")),
            @AttributeOverride(name = "years",
                    column = @Column(name = "reduction_with_causes_ceased_years")),
            @AttributeOverride(name = "percentage",
                    column = @Column(name = "reduction_with_causes_ceased_percent"))
    })
	private PopulationReduction reductionWithCausesCeased;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "reduction",
                    column = @Column(name = "reduction_with_causes_not_ceased")),
            @AttributeOverride(name = "years",
                    column = @Column(name = "reduction_with_causes_not_ceased_years")),
            @AttributeOverride(name = "percentage",
                    column = @Column(name = "reduction_with_causes_not_ceased_percent"))
    })
	private PopulationReduction reductionWithCausesNotCeased;

	@Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "reduction",
                    column = @Column(name = "projection_future_reduction")),
            @AttributeOverride(name = "years",
                    column = @Column(name = "projection_future_reduction_years")),
            @AttributeOverride(name = "percentage",
                    column = @Column(name = "projection_future_reduction_percent"))
    })
	private PopulationReduction projectionFutureReduction;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "reduction",
                    column = @Column(name = "reduction_include_past_future")),
            @AttributeOverride(name = "years",
                    column = @Column(name = "reduction_include_past_future_years")),
            @AttributeOverride(name = "percentage",
                    column = @Column(name = "reduction_include_past_future_percent"))
    })
	private PopulationReduction reductionIncludePastFuture;

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

    @Embedded
    private PopulationData populationData;

    public PopulationDynamics() {
        this.reductionWithCausesCeased = new PopulationReduction();
        this.reductionWithCausesNotCeased = new PopulationReduction();
        this.projectionFutureReduction = new PopulationReduction();
        this.reductionIncludePastFuture = new PopulationReduction();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public PopulationReduction getReductionWithCausesCeased() {
        return reductionWithCausesCeased;
    }

    public void setReductionWithCausesCeased(PopulationReduction reductionWithCausesCeased) {
        this.reductionWithCausesCeased = reductionWithCausesCeased;
    }

    public PopulationReduction getReductionWithCausesNotCeased() {
        return reductionWithCausesNotCeased;
    }

    public void setReductionWithCausesNotCeased(PopulationReduction reductionWithCausesNotCeased) {
        this.reductionWithCausesNotCeased = reductionWithCausesNotCeased;
    }

    public PopulationReduction getProjectionFutureReduction() {
        return projectionFutureReduction;
    }

    public void setProjectionFutureReduction(PopulationReduction projectionFutureReduction) {
        this.projectionFutureReduction = projectionFutureReduction;
    }

    public PopulationReduction getReductionIncludePastFuture() {
        return reductionIncludePastFuture;
    }

    public void setReductionIncludePastFuture(PopulationReduction reductionIncludePastFuture) {
        this.reductionIncludePastFuture = reductionIncludePastFuture;
    }

    public PopulationData getPopulationData() {
        return populationData;
    }

    public void setPopulationData(PopulationData populationData) {
        this.populationData = populationData;
    }
}
