BEGIN;
	
-- Table: genus

DROP TABLE IF EXISTS genus;

CREATE TABLE genus
(
  id bigserial NOT NULL,
  genus character varying(255),
  integration_source bigint,
  CONSTRAINT genus_pkey PRIMARY KEY (id),
  CONSTRAINT fk_ahd2b2chmandsihdh70yldjho FOREIGN KEY (integration_source)
      REFERENCES integration_source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE genus
  OWNER TO postgres;

END; 