package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class General {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String scientificName;

    private String commonName;

    private String coverMap;

    private String coverPhoto;

    private String icons;

    private String extinctionRisk;

}
