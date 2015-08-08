package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
public class ExtentOccurrence implements Serializable {

    @Column(name = "extent_of_occurrence")
    private Double eoo;

    @Column(name = "trend_in_eoo")
    @Enumerated(value = EnumType.ORDINAL)
    private TrendOccurence trend;

    @Column(name = "extreme_fluctuations_eoo")
    private Boolean extremeFluctuations;

    @Column(name = "reduction_in_eoo")
    private String reduction;

    @Column(name = "future_projection_eoo")
    private String futureProjection;

    @Column(name = "fragmentation_level_eoo")
    @Enumerated(value = EnumType.ORDINAL)
    private DefinitionLevel framentationLevel;

    public Double getEoo() {
        return eoo;
    }

    public void setEoo(Double eoo) {
        this.eoo = eoo;
    }

    public TrendOccurence getTrend() {
        return trend;
    }

    public void setTrend(TrendOccurence trend) {
        this.trend = trend;
    }

    public Boolean getExtremeFluctuations() {
        return extremeFluctuations;
    }

    public void setExtremeFluctuations(Boolean extremeFluctuations) {
        this.extremeFluctuations = extremeFluctuations;
    }

    public String getReduction() {
        return reduction;
    }

    public void setReduction(String reduction) {
        this.reduction = reduction;
    }

    public String getFutureProjection() {
        return futureProjection;
    }

    public void setFutureProjection(String futureProjection) {
        this.futureProjection = futureProjection;
    }

    public DefinitionLevel getFramentationLevel() {
        return framentationLevel;
    }

    public void setFramentationLevel(DefinitionLevel framentationLevel) {
        this.framentationLevel = framentationLevel;
    }
}