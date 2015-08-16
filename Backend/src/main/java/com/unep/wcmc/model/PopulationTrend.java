package com.unep.wcmc.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
public class PopulationTrend implements Serializable {

    @Column(name = "decline_reversible_and_ceased")
    private Boolean declineReversibleAndCeased;

    @Column(name = "population_decline_based_on")
    @Enumerated(EnumType.ORDINAL)
    private PopulationDeclinedBasedOn populationDeclinedBasedOn;

    @Column(name = "justification_of_pop_decline")
    private String popDeclineJustification;

    @Column(name = "extinction_probability_in_brazil")
    private Double brazilExtinctionProbability;

    @Column(name = "other_observations_on_population_dynamics")
    private String otherObservationsOnPopulationDynamics;

    @Column(name = "trend_brazil_population_size")
    @Enumerated(value = EnumType.ORDINAL)
    private TrendSize trendBrazilPopulationSize;
    
    public Boolean getDeclineReversibleAndCeased() {
        return declineReversibleAndCeased;
    }

    public void setDeclineReversibleAndCeased(Boolean declineReversibleAndCeased) {
        this.declineReversibleAndCeased = declineReversibleAndCeased;
    }

    public PopulationDeclinedBasedOn getPopulationDeclinedBasedOn() {
        return populationDeclinedBasedOn;
    }

    public void setPopulationDeclinedBasedOn(PopulationDeclinedBasedOn populationDeclinedBasedOn) {
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

    public TrendSize getTrendBrazilPopulationSize() {
        return trendBrazilPopulationSize;
    }

    public void setTrendBrazilPopulationSize(TrendSize trendBrazilPopulationSize) {
        this.trendBrazilPopulationSize = trendBrazilPopulationSize;
    }
}
