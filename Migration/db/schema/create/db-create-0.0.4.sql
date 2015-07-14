BEGIN;

-- Table: integration_source

DROP TABLE IF EXISTS integration_source;

CREATE TABLE integration_source
(
  id bigserial NOT NULL,
  source character varying(255),
  CONSTRAINT integration_source_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE integration_source
  OWNER TO postgres;

END;