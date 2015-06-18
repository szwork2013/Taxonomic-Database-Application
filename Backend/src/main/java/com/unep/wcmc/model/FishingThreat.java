package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FishingThreat implements Serializable {

    @Column(name = "fishing_scale")
    private String fishingScale;

    @Column(name = "fishing_grounds")
    private String fishingGrounds;

    @Column(name = "fishing_petrecho")
    private String fishingPetrecho;

    @Column(name = "fishing_effort")
    private String fishingEffort;

    @Column(name = "landing_catch")
    private String landingCatch;

    @Column(name = "cpue")
    private String cpue;

    @Column(name = "value_of_mercado")
    private String marketValue;

    @Column(name = "fishing_trend")
    private String fishingTrend;

    public String getFishingScale() {
        return fishingScale;
    }

    public void setFishingScale(String fishingScale) {
        this.fishingScale = fishingScale;
    }

    public String getFishingGrounds() {
        return fishingGrounds;
    }

    public void setFishingGrounds(String fishingGrounds) {
        this.fishingGrounds = fishingGrounds;
    }

    public String getFishingPetrecho() {
        return fishingPetrecho;
    }

    public void setFishingPetrecho(String fishingPetrecho) {
        this.fishingPetrecho = fishingPetrecho;
    }

    public String getFishingEffort() {
        return fishingEffort;
    }

    public void setFishingEffort(String fishingEffort) {
        this.fishingEffort = fishingEffort;
    }

    public String getLandingCatch() {
        return landingCatch;
    }

    public void setLandingCatch(String landingCatch) {
        this.landingCatch = landingCatch;
    }

    public String getCpue() {
        return cpue;
    }

    public void setCpue(String cpue) {
        this.cpue = cpue;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getFishingTrend() {
        return fishingTrend;
    }

    public void setFishingTrend(String fishingTrend) {
        this.fishingTrend = fishingTrend;
    }

}
