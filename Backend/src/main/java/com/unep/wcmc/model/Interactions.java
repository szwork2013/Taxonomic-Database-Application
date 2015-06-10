package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Interactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String StringerdependentRelationship;

    private String ontogeny;

    private String sexRatio;

    private String naturalMortalityRate;

    private String populationSize;

    private String groupsSize;

    private String socialSpecies;

    private String otherObservations;

}
