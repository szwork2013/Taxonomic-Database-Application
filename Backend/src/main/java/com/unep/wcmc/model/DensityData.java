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

    @Column(name = "subpopulations_decline")
    private Long subPopulationsDeclineNumber;

    @Column(name = "subpopulations_fluctuations")
    private Long subPopulationsFluctuationsNumber;

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

    public Long getSubPopulationsDeclineNumber() {
        return subPopulationsDeclineNumber;
    }

    public void setSubPopulationsDeclineNumber(Long subPopulationsDeclineNumber) {
        this.subPopulationsDeclineNumber = subPopulationsDeclineNumber;
    }

    public Long getSubPopulationsFluctuationsNumber() {
        return subPopulationsFluctuationsNumber;
    }

    public void setSubPopulationsFluctuationsNumber(Long subPopulationsFluctuationsNumber) {
        this.subPopulationsFluctuationsNumber = subPopulationsFluctuationsNumber;
    }
}
