package com.unep.wcmc.repository.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Species filter parameters
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
final class ParamFilter {
	
	@JsonProperty("endemic_from_brasil")
	Boolean endemicFromBrazil;

	@JsonProperty("occurrence_state")
	String occurrenceState;

	@JsonProperty("category")
	String extinctionRiskCategory;

	@JsonProperty("habitat_id")
	Long habitat_id;

	@JsonProperty("occurrence_biomes")
	public String occurrenceBiomes;

	@JsonProperty("occurrence_protected_areas")
	public String occurrenceProtectedAreas;

	@JsonProperty("action_plan")
	public String actionPlan;

	@JsonProperty("in_national_endangered_fauna")
	public Boolean inNationalEndangeredFauna;

	@JsonProperty("national_endangered_fauna")
	public String nationalEndangeredFauna;

	@JsonProperty("uf_state")
	public String ufState;

	@JsonProperty("municipality")
	public String municipality;

	public ParamFilter() {}
}
