BEGIN;
	
-- Table: family

DROP TABLE IF EXISTS family;
CREATE TABLE family
(
  id bigserial NOT NULL,
  family character varying(255),
  integration_source bigint,
  CONSTRAINT family_pkey PRIMARY KEY (id),
  CONSTRAINT fk_7q1ihyq4ovtdbfde51w0whk02 FOREIGN KEY (integration_source)
      REFERENCES integration_source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE family
  OWNER TO postgres;

END; 