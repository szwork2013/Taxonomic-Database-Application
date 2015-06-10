package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExtinctionRisk {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nationalAssesConservStatus;

    private String previousNationalAssessment;

    private String reasonsForChange;

    private String globalConservStatusAssess;

    private String inNationalEndangeredFauna;

    private String otherListsEndangeredSpecies;

}
