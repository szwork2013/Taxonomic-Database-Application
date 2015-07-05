BEGIN;
	
-- Table: genus

DROP TABLE IF EXISTS genus;

CREATE TABLE genus
(
  id bigserial NOT NULL,
  genus character varying(255),
  CONSTRAINT genus_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE genus
  OWNER TO postgres;

END; 