BEGIN;

-- Table: extinction_risk_configuration

DROP TABLE IF EXISTS extinction_risk_configuration;

CREATE TABLE extinction_risk_configuration
(
  id bigserial NOT NULL,
  category character varying(255),
  b2a_number_of_locations integer,
  c_number_of_mature_individuals bigint,
  d_number_of_mature_individuals bigint,
  c2a_number_of_mature_individuals_in_sub bigint,
  b2_area_of_ocuppancy bigint,
  b1_extent_of_occurrence bigint,
  c2a_perc_mature_individuals_one_sub integer,
  a1_perc_population_decline double precision,
  a2_perc_population_decline double precision,
  e_prob_extinction_in_the_wild double precision,
  CONSTRAINT extinction_risk_configuration_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE extinction_risk_configuration
  OWNER TO postgres;

END; 