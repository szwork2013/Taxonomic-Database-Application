package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PopulationTrend implements Serializable {

    @Column(name = "decline_reversible_and_ceased")
    private Boolean declineReversibleAndCeased;

    @Column(name = "population_decline_based_on")
    private String populationDeclinedBasedOn;

    @Column(name = "justification_of_pop_decline")
    private String popDeclineJustification;

    @Column(name = "extinction_probability_in_brazil")
    private Double brazilExtinctionProbability;

    @Column(name = "other_observations_on_population_dynamics")
    private String otherObservationsOnPopulationDynamics;
    
    public Boolean getDeclineReversibleAndCeased() {
        return declineReversibleAndCeased;
    }

    public void setDeclineReversibleAndCeased(Boolean declineReversibleAndCeased) {
        this.declineReversibleAndCeased = declineReversibleAndCeased;
    }

    public String getPopulationDeclinedBasedOn() {
        return populationDeclinedBasedOn;
    }

    public void setPopulationDeclinedBasedOn(String populationDeclinedBasedOn) {
        this.populationDeclinedBasedOn = populationDeclinedBasedOn;
    }

    public String getPopDeclineJustification() {
        return popDeclineJustification;
    }

    public void setPopDeclineJustification(String popDeclineJustification) {
        this.popDeclineJustification = popDeclineJustification;
    }

    public Double getBrazilExtinctionProbability() {
        return brazilExtinctionProbability;
    }

    public void setBrazilExtinctionProbability(Double brazilExtinctionProbability) {
        this.brazilExtinctionProbability = brazilExtinctionProbability;
    }

	public String getOtherObservationsOnPopulationDynamics() {
		return otherObservationsOnPopulationDynamics;
	}

	public void setOtherObservationsOnPopulationDynamics(
			String otherObservationsOnPopulationDynamics) {
		this.otherObservationsOnPopulationDynamics = otherObservationsOnPopulationDynamics;
	}
}
