package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
public class AreaOccupancy implements Serializable {

    @Column(name = "area_of_occupancy")
    private Double aoo;

    @Column(name = "trend_in_aoo")
    @Enumerated(value = EnumType.ORDINAL)
    private TrendOccurence trend;

    @Column(name = "extreme_fluctuations_aoo")
    private Boolean extremeFluctuations;

    @Column(name = "reduction_in_aoo")
    private String reduction;

    @Column(name = "future_projection_aoo")
    private String futureProjection;

    @Column(name = "fragmentation_level_aoo")
    @Enumerated(value = EnumType.ORDINAL)
    private DefinitionLevel framentationLevel;

    public Double getAoo() {
        return aoo;
    }

    public void setAoo(Double aoo) {
        this.aoo = aoo;
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
