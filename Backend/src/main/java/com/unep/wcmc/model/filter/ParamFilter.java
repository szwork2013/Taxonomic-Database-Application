package com.unep.wcmc.model.filter;

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
	@JsonProperty("habitat")
	String habitat;
	
	public ParamFilter() {
	}
}
