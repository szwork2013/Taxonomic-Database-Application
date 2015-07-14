BEGIN;

-- Table: habitat_type

DROP TABLE IF EXISTS habitat_type;

CREATE TABLE habitat_type
(
  id bigserial NOT NULL,
  name character varying(255),
  CONSTRAINT habitat_type_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE habitat_type
  OWNER TO postgres;

END;