BEGIN;

-- Table: natural_history

DROP TABLE IF EXISTS natural_history;

CREATE TABLE natural_history
(
  id bigserial NOT NULL,
  eating_habits character varying(255),
  eating_habits_other_comments character varying(255),
  expert_specialist character varying(255),
  feeding_agregations character varying(255),
  trophic_level character varying(255),
  cont_decline_habitat_quality boolean,
  habitat character varying(255),
  restricted_to_primary_habitats boolean,
  tolerant_to_habitat_mod character varying(255),
  variation_in_habitat_use character varying(255),
  captive_breeding_program boolean,
  perc_and_period_of_decline double precision,
  subpopulations_fluctuations boolean,
  subpopulations_decline bigint,
  subpopulations_number_of bigint,
  subpopulations_trend integer,
  flutuation_mature_individuals boolean,
  perc_immature_individuals double precision,
  number_of_mature_individuals bigint,
  trend_in_mature_individuals integer,
  max_no_of_mature_individuals bigint,
  population_severely_fragmented boolean,
  extinction_probability_in_brazil double precision,
  decline_reversible_and_ceased boolean,
  perc_population_decline double precision,
  justification_of_pop_decline character varying(255),
  population_decline_based_on character varying(255),
  maximum_size integer,
  habitat_type_id bigint,
  CONSTRAINT natural_history_pkey PRIMARY KEY (id),
  CONSTRAINT fk_4yet5c8yyeloe7h7ywqcn04u5 FOREIGN KEY (habitat_type_id)
      REFERENCES habitat_type (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE natural_history
  OWNER TO postgres;

END;