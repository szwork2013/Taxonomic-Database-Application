package com.unep.wcmc.model;

import javax.persistence.Entity;

@Entity
public final class ExtinctionRisk extends TaxonomicEntity {

    private String nationalAssesConservStatus;

    private String previousNationalAssessment;

    private String reasonsForChange;

    private String globalConservStatusAssess;

    private String inNationalEndangeredFauna;

    private String otherListsEndangeredSpecies;

}
