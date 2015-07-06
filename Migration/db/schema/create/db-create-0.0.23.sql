BEGIN;

-- Table: threat

DROP TABLE IF EXISTS threat;

CREATE TABLE threat
(
  id bigserial NOT NULL,
  per_affected_area double precision,
  decline_in_number_of_locations bigint,
  threat_description character varying(255),
  description_of_the_impact character varying(255),
  location_fluctuation bigint,
  cpue character varying(255),
  fishing_effort character varying(255),
  fishing_grounds character varying(255),
  fishing_petrecho character varying(255),
  fishing_scale character varying(255),
  fishing_trend character varying(255),
  landing_catch character varying(255),
  value_of_mercado character varying(255),
  future_threat boolean,
  single_event bigint,
  per_population_affected double precision,
  local character varying(255),
  municipality character varying(255),
  period bigint,
  "time" bigint,
  trend character varying(255),
  threat_category_id bigint,
  CONSTRAINT threat_pkey PRIMARY KEY (id),
  CONSTRAINT fk_2auutd6r23u9tvbnu3wagagsg FOREIGN KEY (threat_category_id)
      REFERENCES threat_category (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE threat
  OWNER TO postgres;
	
END; 