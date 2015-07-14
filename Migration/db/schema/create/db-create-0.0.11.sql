BEGIN;

-- Table: distribution_area

DROP TABLE IF EXISTS distribution_area;

CREATE TABLE distribution_area
(
  id bigserial NOT NULL,
  endemic_from_brasil boolean,
  extent_of_occurrence double precision,
  fragmentation_level integer,
  global_distribution character varying(255),
  national_distribution character varying(255),
  native_in_brazil boolean,
  area_of_ocuppancy double precision,
  occurrence_state character varying(255),
  occurs_in_brasil boolean,
  only_from_few_localities boolean,
  the_region_is_well_sampled boolean,
  trend_in_extent_of_occurrence integer,
  area_of_occupancy_trend integer,
  CONSTRAINT distribution_area_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE distribution_area
  OWNER TO postgres;

END;