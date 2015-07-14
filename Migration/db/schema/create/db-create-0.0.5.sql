BEGIN;

-- Table: phylum

DROP TABLE IF EXISTS phylum;

CREATE TABLE phylum
(
  id bigserial NOT NULL,
  phylum character varying(255),
  integration_source bigint,
  CONSTRAINT phylum_pkey PRIMARY KEY (id),
  CONSTRAINT fk_t6rfs4669if13xgkfx3mcr78a FOREIGN KEY (integration_source)
      REFERENCES integration_source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE phylum
  OWNER TO postgres;

END;