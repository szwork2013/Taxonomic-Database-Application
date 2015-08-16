package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PopulationData implements Serializable {

    @Column(name = "known_estimated_population_brazil")
    private String knownEstimatedPopulationBrazil;

    @Column(name = "sex_ratio")
    private String sexRatio;

    @Column(name = "natural_mortality_rate")
    private String naturalMortalityRate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "local",
                    column = @Column(name = "global_size_local")),
            @AttributeOverride(name = "abundance",
                    column = @Column(name = "global_size_abundance")),
            @AttributeOverride(name = "unit",
                    column = @Column(name = "global_size_unit")),
            @AttributeOverride(name = "reference",
                    column = @Column(name = "global_size_reference"))
    })
    private PopulationSize globalSize;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "local",
                    column = @Column(name = "brazil_size_local")),
            @AttributeOverride(name = "abundance",
                    column = @Column(name = "brazil_size_abundance")),
            @AttributeOverride(name = "unit",
                    column = @Column(name = "brazil_size_unit")),
            @AttributeOverride(name = "reference",
                    column = @Column(name = "brazil_size_reference"))
    })
    private PopulationSize brazilSize;

    @Column(name = "size_of_groups")
    private String sizeOfGroups;

    @Column(name = "social_species")
    private Boolean socialSpecies;

    @Column(name = "social_species_desc")
    private String socialSpeciesDesc;

    @Column(name = "other_observations_population_data")
    private String otherObservations;

    public String getKnownEstimatedPopulationBrazil() {
        return knownEstimatedPopulationBrazil;
    }

    public void setKnownEstimatedPopulationBrazil(String knownEstimatedPopulationBrazil) {
        this.knownEstimatedPopulationBrazil = knownEstimatedPopulationBrazil;
    }

    public String getSexRatio() {
        return sexRatio;
    }

    public void setSexRatio(String sexRatio) {
        this.sexRatio = sexRatio;
    }

    public String getNaturalMortalityRate() {
        return naturalMortalityRate;
    }

    public void setNaturalMortalityRate(String naturalMortalityRate) {
        this.naturalMortalityRate = naturalMortalityRate;
    }

    public PopulationSize getGlobalSize() {
        return globalSize;
    }

    public void setGlobalSize(PopulationSize globalSize) {
        this.globalSize = globalSize;
    }

    public PopulationSize getBrazilSize() {
        return brazilSize;
    }

    public void setBrazilSize(PopulationSize brazilSize) {
        this.brazilSize = brazilSize;
    }

    public String getSizeOfGroups() {
        return sizeOfGroups;
    }

    public void setSizeOfGroups(String sizeOfGroups) {
        this.sizeOfGroups = sizeOfGroups;
    }

    public Boolean getSocialSpecies() {
        return socialSpecies;
    }

    public void setSocialSpecies(Boolean socialSpecies) {
        this.socialSpecies = socialSpecies;
    }

    public String getSocialSpeciesDesc() {
        return socialSpeciesDesc;
    }

    public void setSocialSpeciesDesc(String socialSpeciesDesc) {
        this.socialSpeciesDesc = socialSpeciesDesc;
    }

    public String getOtherObservations() {
        return otherObservations;
    }

    public void setOtherObservations(String otherObservations) {
        this.otherObservations = otherObservations;
    }
}
