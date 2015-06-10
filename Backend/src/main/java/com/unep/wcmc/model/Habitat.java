package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String habitat;

    private String restrictedToPrimaryHabitats;

    private String tolerantToHabitatMod;

    private String variationInHabitatUse;

}
