BEGIN;

-- Table: phylum

DROP TABLE IF EXISTS phylum;

CREATE TABLE phylum
(
  id bigserial NOT NULL,
  phylum character varying(255),
  CONSTRAINT phylum_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE phylum
  OWNER TO postgres;

END;