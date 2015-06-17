package com.unep.wcmc.model;

import javax.persistence.Entity;

@Entity
public final class PopulationTrend extends TaxonomicEntity {

    private String populationSizeInBrazil;

    private String percPopulationDecline;

    private String declineReversibleAndCeased;

    private String populationDeclinedBasedOn;

    private String popDeclineJustification;

    private String brazilPopulationSink;

    private String extinctionProbabilityBrazil;

    private String justificationExistinctProb;

}
