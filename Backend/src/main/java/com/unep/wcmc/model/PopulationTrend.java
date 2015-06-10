package com.unep.wcmc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PopulationTrend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String populationSizeInBrazil;

    private String percPopulationDecline;

    private String declineReversibleAndCeased;

    private String populationDeclinedBasedOn;

    private String popDeclineJustification;

    private String brazilPopulationSink;

    private String extinctionProbabilityBrazil;

    private String justificationExistinctProb;

}
