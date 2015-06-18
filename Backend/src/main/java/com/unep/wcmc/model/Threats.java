package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Threats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private Boolean futureThreatExistence;

    private Long geographicallyDistinctAreasNumber;

    private Long declineLocationsNumber;

    private Long extremeFlutuationLocationNumber;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getFutureThreatExistence() {
        return futureThreatExistence;
    }

    public void setFutureThreatExistence(Boolean futureThreatExistence) {
        this.futureThreatExistence = futureThreatExistence;
    }

    public Long getGeographicallyDistinctAreasNumber() {
        return geographicallyDistinctAreasNumber;
    }

    public void setGeographicallyDistinctAreasNumber(Long geographicallyDistinctAreasNumber) {
        this.geographicallyDistinctAreasNumber = geographicallyDistinctAreasNumber;
    }

    public Long getDeclineLocationsNumber() {
        return declineLocationsNumber;
    }

    public void setDeclineLocationsNumber(Long declineLocationsNumber) {
        this.declineLocationsNumber = declineLocationsNumber;
    }

    public Long getExtremeFlutuationLocationNumber() {
        return extremeFlutuationLocationNumber;
    }

    public void setExtremeFlutuationLocationNumber(Long extremeFlutuationLocationNumber) {
        this.extremeFlutuationLocationNumber = extremeFlutuationLocationNumber;
    }
}
