package com.unep.wcmc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class NaturalHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private FeedingBehavior feedingBehavior;

    @Embedded
    private Habitat habitat;

    @Embedded
    private PopulationDynamics populationDynamics;

    @Embedded
    private Reproduction reproduction;

    @Embedded
    private Interactions interactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FeedingBehavior getFeedingBehavior() {
        return feedingBehavior;
    }

    public void setFeedingBehavior(FeedingBehavior feedingBehavior) {
        this.feedingBehavior = feedingBehavior;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public PopulationDynamics getPopulationDynamics() {
        return populationDynamics;
    }

    public void setPopulationDynamics(PopulationDynamics populationDynamics) {
        this.populationDynamics = populationDynamics;
    }

    public Reproduction getReproduction() {
        return reproduction;
    }

    public void setReproduction(Reproduction reproduction) {
        this.reproduction = reproduction;
    }

    public Interactions getInteractions() {
        return interactions;
    }

    public void setInteractions(Interactions interactions) {
        this.interactions = interactions;
    }
}
