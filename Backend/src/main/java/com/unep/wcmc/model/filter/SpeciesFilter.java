package com.unep.wcmc.model.filter;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unep.wcmc.model.ExtinctionRiskCategory;

/**
 * Species filter definition
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class SpeciesFilter {
	
	@NotNull
	@JsonProperty("query")
	private String query;
	@JsonProperty("filter")
	private ParamFilter paramFilters;
	
	public SpeciesFilter() {
	}
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Boolean getEndemicFromBrazil() {
		return paramFilters == null ? null : paramFilters.endemicFromBrazil;
	}

	public void setEndemicFromBrazil(Boolean endemicFromBrazil) {
		paramFilters.endemicFromBrazil = endemicFromBrazil;
	}

	public String getOccurrenceState() {
		return paramFilters == null ? null : paramFilters.occurrenceState;
	}

	public void setOccurrenceState(String occurrenceState) {
		paramFilters.occurrenceState = occurrenceState;
	}

	public String getOccurrenceBiomes() {
		return paramFilters == null ? null : paramFilters.occurrenceBiomes;
	}

	public void setOccurrenceBiomes(String occurrenceBiomes) {
		paramFilters.occurrenceBiomes = occurrenceBiomes;
	}

	public String getOccurrenceProtectedAreas() {
		return paramFilters == null ? null : paramFilters.occurrenceProtectedAreas;
	}

	public void setOccurrenceProtectedAreas(String occurrenceProtectedAreas) {
		paramFilters.occurrenceProtectedAreas = occurrenceProtectedAreas;
	}

	public String getActionPlan() {
		return paramFilters == null ? null : paramFilters.actionPlan;
	}

	public void setActionPlan(String actionPlan) {
		paramFilters.actionPlan = actionPlan;
	}

	public String getExtinctionRiskCategory() {
		return paramFilters == null ? null : paramFilters.extinctionRiskCategory;
	}

	public void setInNationalEndangeredFauna(Boolean inNationalEndangeredFauna) {
		paramFilters.inNationalEndangeredFauna = inNationalEndangeredFauna;
	}

	public Boolean getInNationalEndangeredFauna() {
		return paramFilters == null ? null : paramFilters.inNationalEndangeredFauna;
	}
	
	public ExtinctionRiskCategory getExtinctionRiskCategoryEnum() {
		return ExtinctionRiskCategory.valueOf(getExtinctionRiskCategory());
	}

	public void setExtinctionRiskCategory(String extinctionRiskCategory) {
		paramFilters.extinctionRiskCategory = extinctionRiskCategory;
	}

	public Long getHabitat() {
		return paramFilters == null ? null : paramFilters.habitat_id;
	}

	public void setHabitat(Long habitat_id) {
		paramFilters.habitat_id = habitat_id;
	}	
}
