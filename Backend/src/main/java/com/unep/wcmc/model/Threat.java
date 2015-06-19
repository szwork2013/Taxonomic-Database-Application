package com.unep.wcmc.model;

import javax.persistence.*;

@Entity
public class Threat implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "threat_description")
    private String description;

    @Embedded
    private ThreatStatus threatStatus;

    @Column(name = "future_threat")
    private Boolean futureThreatExistence;

    @Column(name = "single_event")
    private Long geographicallyDistinctAreasNumber;

    @Column(name = "decline_in_number_of_locations")
    private Long declineLocationsNumber;

    @Column(name = "location_fluctuation")
    private Long extremeFlutuationLocationNumber;

    @Column(name = "per_population_affected")
    private Double populationAffected;

    @Column(name = "per_affected_area")
    private Double affectedArea;

    @Column(name = "description_of_the_impact")
    private String descriptionImpact;

    @Embedded
    private FishingThreat fishingThreat;

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

    public Double getPopulationAffected() {
        return populationAffected;
    }

    public void setPopulationAffected(Double populationAffected) {
        this.populationAffected = populationAffected;
    }

    public Double getAffectedArea() {
        return affectedArea;
    }

    public void setAffectedArea(Double affectedArea) {
        this.affectedArea = affectedArea;
    }

    public String getDescriptionImpact() {
        return descriptionImpact;
    }

    public void setDescriptionImpact(String descriptionImpact) {
        this.descriptionImpact = descriptionImpact;
    }

    public FishingThreat getFishingThreat() {
        return fishingThreat;
    }

    public void setFishingThreat(FishingThreat fishingThreat) {
        this.fishingThreat = fishingThreat;
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