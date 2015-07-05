BEGIN;

-- Table: ocurrence

DROP TABLE IF EXISTS ocurrence;

CREATE TABLE ocurrence
(
  distribution_area bigint NOT NULL,
  latitude character varying(255),
  longitude character varying(255),
  map_id bigint,
  projection character varying(255),
  state_id bigint,
  CONSTRAINT fk_ewu2tyfap3r2wblvah46dipyk FOREIGN KEY (distribution_area)
      REFERENCES distribution_area (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_i4rbouagsbi4y9m3jpm9umn6m FOREIGN KEY (map_id)
      REFERENCES map (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_s146robfrf1ia2yfj5vkwjs4v FOREIGN KEY (state_id)
      REFERENCES state (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ocurrence
  OWNER TO postgres;	

END; 