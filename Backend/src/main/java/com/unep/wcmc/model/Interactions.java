package com.unep.wcmc.model;

import javax.persistence.Entity;

@Entity
public final class Interactions extends TaxonomicEntity {

    private String StringerdependentRelationship;

    private String ontogeny;

    private String sexRatio;

    private String naturalMortalityRate;

    private String populationSize;

    private String groupsSize;

    private String socialSpecies;

    private String otherObservations;

}
