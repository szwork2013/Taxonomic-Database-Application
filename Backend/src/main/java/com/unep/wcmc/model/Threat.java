package com.unep.wcmc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Threat implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "threat_description")
    private String description;

    @Column(name = "threat_category")
    private ThreatCategory category;

    @Embedded
    private ThreatStatus threatStatus;

    @Column(name = "future_threat")
    private Boolean futureThreatExistence;

    @Column(name = "single_event")
    private Long geographicallyDistinctAreasNumber;

    @Column(name = "decline_in_number_of_locations")
    private Boolean declineInNumberLocations;

    @Column(name = "location_fluctuation")
    private Boolean extremeFlutuationLocation;

    @Column(name = "per_population_affected")
    private Double populationAffected;

    @Column(name = "per_affected_area")
    private Double affectedArea;

    @Column(name = "description_of_the_impact")
    private String descriptionImpact;

    @Embedded
    private FishingThreat fishingThreat;

    @ManyToOne
    @JoinColumn(name = "specie_id")
    @JsonIgnore
    private Species species;

    public Threat(){
    }

    public Threat(ThreatCategory threatCategory){

        setDescription(threatCategory.getDescription());
        setCategory(threatCategory);
    }

    public Threat(String description){

        setDescription(description);
    }

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

    public Boolean getDeclineInNumberLocations() {
        return declineInNumberLocations;
    }

    public void setDeclineInNumberLocations(Boolean declineInNumberLocations) {
        this.declineInNumberLocations = declineInNumberLocations;
    }

    public Boolean getExtremeFlutuationLocation() {
        return extremeFlutuationLocation;
    }

    public void setExtremeFlutuationLocation(Boolean extremeFlutuationLocation) {
        this.extremeFlutuationLocation = extremeFlutuationLocation;
    }

    public ThreatCategory getCategory() {
        return category;
    }

    public void setCategory(ThreatCategory category) {
        this.category = category;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}