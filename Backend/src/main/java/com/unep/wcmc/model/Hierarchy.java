package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hierarchy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String kingdomName;

    private String phylumName;

    private String className;

    private String orderName;

    private String familyName;

    private int genusName;

    private String species;

    private String subspecies;

}
