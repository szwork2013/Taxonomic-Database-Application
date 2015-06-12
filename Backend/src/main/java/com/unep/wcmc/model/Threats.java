package com.unep.wcmc.model;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@Entity
public class Threats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String populationAffected;
    @Column
    private String affectedArea;
    @Column
    private String descriptionImpact;
    @Column
    private String fishingScale;
    @Column
    private String fishingGrounds;
    @Column
    private String fishingPetrecho;
    @Column
    private String fishingEffort;
    @Column
    private String landingCatch;
    @Column
    private String cpue;
    @Column
    private String marketValue;
    @Column
    private String fishingTrend;
    @Column
    private String speciesResillience;
    @ManyToOne
    @JoinColumn(name="threat_status_id")
    private ThreatStatus threatStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPopulationAffected() {
        return populationAffected;
    }

    public void setPopulationAffected(String populationAffected) {
        this.populationAffected = populationAffected;
    }

    public String getAffectedArea() {
        return affectedArea;
    }

    public void setAffectedArea(String affectedArea) {
        this.affectedArea = affectedArea;
    }

    public String getDescriptionImpact() {
        return descriptionImpact;
    }

    public void setDescriptionImpact(String descriptionImpact) {
        this.descriptionImpact = descriptionImpact;
    }

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

    public String getSpeciesResillience() {
        return speciesResillience;
    }

    public void setSpeciesResillience(String speciesResillience) {
        this.speciesResillience = speciesResillience;
    }

    public ThreatStatus getThreatStatus() {
        return threatStatus;
    }

    public void setThreatStatus(ThreatStatus threatStatus) {
        this.threatStatus = threatStatus;
    }
}
