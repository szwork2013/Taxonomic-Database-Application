BEGIN;

-- Table: kingdom

DROP TABLE IF EXISTS kingdom;

CREATE TABLE kingdom
(
  id bigserial NOT NULL,
  name character varying(255),
  CONSTRAINT kingdom_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE kingdom
  OWNER TO postgres;

END;