package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
public class DensityData implements Serializable {

    @Column(name = "subpopulations_number_of")
    private Long subPopulationsNumber;

    @Column(name = "subpopulations_trend")
    @Enumerated(value = EnumType.ORDINAL)
    private TrendOccurence subPopulationsNumberTrend;

    @Column(name = "subpopulations_fluctuations")
    private Boolean extremeFlutuationInSubpopulationsNumber;

    @Column(name = "mature_individuals_fluctuations")
    private Boolean extremeFluctuationInMatureIndividualsNumber;
    
    public Long getSubPopulationsNumber() {
        return subPopulationsNumber;
    }

    public void setSubPopulationsNumber(Long subPopulationsNumber) {
        this.subPopulationsNumber = subPopulationsNumber;
    }

    public TrendOccurence getSubPopulationsNumberTrend() {
        return subPopulationsNumberTrend;
    }

    public void setSubPopulationsNumberTrend(TrendOccurence subPopulationsNumberTrend) {
        this.subPopulationsNumberTrend = subPopulationsNumberTrend;
    }

    public Boolean getExtremeFlutuationInSubpopulationsNumber() {
        return extremeFlutuationInSubpopulationsNumber;
    }

    public void setExtremeFlutuationInSubpopulationsNumber(Boolean extremeFlutuationInSubpopulationsNumber) {
        this.extremeFlutuationInSubpopulationsNumber = extremeFlutuationInSubpopulationsNumber;
    }

	public Boolean getExtremeFluctuationInMatureIndividualsNumber() {
		return extremeFluctuationInMatureIndividualsNumber;
	}

	public void setExtremeFluctuationInMatureIndividualsNumber(
			Boolean extremeFluctuationInMatureIndividualsNumber) {
		this.extremeFluctuationInMatureIndividualsNumber = extremeFluctuationInMatureIndividualsNumber;
	}
}
