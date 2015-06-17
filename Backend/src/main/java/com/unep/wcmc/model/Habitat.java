package com.unep.wcmc.model;

import javax.persistence.Entity;

@Entity
public final class Habitat extends TaxonomicEntity {

    private String habitat;

    private String restrictedToPrimaryHabitats;

    private String tolerantToHabitatMod;

    private String variationInHabitatUse;

}
