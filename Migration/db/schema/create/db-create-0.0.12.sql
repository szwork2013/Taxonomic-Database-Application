BEGIN;
	
-- Table: family

DROP TABLE IF EXISTS family;

CREATE TABLE family
(
  id bigserial NOT NULL,
  family character varying(255),
  CONSTRAINT family_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE family
  OWNER TO postgres;

END; 