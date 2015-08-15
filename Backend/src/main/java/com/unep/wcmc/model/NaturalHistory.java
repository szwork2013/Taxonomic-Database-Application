package com.unep.wcmc.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class NaturalHistory implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "habitat_id")
    private Habitat habitat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reproduction_id")
    private Reproduction reproduction;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feeding_behavior_id")
    private FeedingBehavior feedingBehavior;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "natural_history_id")
    private List<Interactions> interactions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "population_dynamics_id")
    private PopulationDynamics populationDynamics;

    public NaturalHistory() {
        super();
    }

    public NaturalHistory(PopulationDynamics populationDynamics) {
        this.populationDynamics = populationDynamics;
    }

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

    public List<Interactions> getInteractions() {
        return interactions;
    }

    public void setInteractions(List<Interactions> interactions) {
        this.interactions = interactions;
    }
}
