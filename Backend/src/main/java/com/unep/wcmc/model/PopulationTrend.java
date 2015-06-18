package com.unep.wcmc.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PopulationTrend implements Serializable {

    private String populationSizeInBrazil;

    private String percPopulationDecline;

    private String declineReversibleAndCeased;

    private String populationDeclinedBasedOn;

    private String popDeclineJustification;

    private String brazilPopulationSink;

    private String extinctionProbabilityBrazil;

    private String justificationExistinctProb;

}
