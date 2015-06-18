package com.unep.wcmc.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PopulationDynamics implements Serializable {

    private Double populationDeclinedIn10YearsPercent;

    private Boolean pastReductionInCaseOrReversiveCauseCeased;

    private String basedPopulationDeclined;

    private Long matureIndividualsNumber;

    private TrendOccurence matureIndividualsNumberTrend;

    private Double declinePeriodPercent;

    private Long matureIndividualsSubpopulationMaxNumber;

    private Double imatureIndividualsSubpopulationPercent;

    private Boolean extremeFlutuationInMatureIndividualsNumber;

    private TrendOccurence numberSubpopulationsTrend;

    private Boolean extremeFlutuationInSubpopulationsNumber;

    private Boolean populationSeverelyFragmented;

    private Double brazilExtinctionProbability;

    public Double getPopulationDeclinedIn10YearsPercent() {
        return populationDeclinedIn10YearsPercent;
    }

    public void setPopulationDeclinedIn10YearsPercent(Double populationDeclinedIn10YearsPercent) {
        this.populationDeclinedIn10YearsPercent = populationDeclinedIn10YearsPercent;
    }

    public Boolean getPastReductionInCaseOrReversiveCauseCeased() {
        return pastReductionInCaseOrReversiveCauseCeased;
    }

    public void setPastReductionInCaseOrReversiveCauseCeased(Boolean pastReductionInCaseOrReversiveCauseCeased) {
        this.pastReductionInCaseOrReversiveCauseCeased = pastReductionInCaseOrReversiveCauseCeased;
    }

    public String getBasedPopulationDeclined() {
        return basedPopulationDeclined;
    }

    public void setBasedPopulationDeclined(String basedPopulationDeclined) {
        this.basedPopulationDeclined = basedPopulationDeclined;
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

    public TrendOccurence getNumberSubpopulationsTrend() {
        return numberSubpopulationsTrend;
    }

    public void setNumberSubpopulationsTrend(TrendOccurence numberSubpopulationsTrend) {
        this.numberSubpopulationsTrend = numberSubpopulationsTrend;
    }

    public Boolean getExtremeFlutuationInSubpopulationsNumber() {
        return extremeFlutuationInSubpopulationsNumber;
    }

    public void setExtremeFlutuationInSubpopulationsNumber(Boolean extremeFlutuationInSubpopulationsNumber) {
        this.extremeFlutuationInSubpopulationsNumber = extremeFlutuationInSubpopulationsNumber;
    }

    public Boolean getPopulationSeverelyFragmented() {
        return populationSeverelyFragmented;
    }

    public void setPopulationSeverelyFragmented(Boolean populationSeverelyFragmented) {
        this.populationSeverelyFragmented = populationSeverelyFragmented;
    }

    public Double getBrazilExtinctionProbability() {
        return brazilExtinctionProbability;
    }

    public void setBrazilExtinctionProbability(Double brazilExtinctionProbability) {
        this.brazilExtinctionProbability = brazilExtinctionProbability;
    }
}
