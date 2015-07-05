BEGIN;

-- Table: conservation_action_type

DROP TABLE IF EXISTS conservation_action_type;

CREATE TABLE conservation_action_type
(
  id bigserial NOT NULL,
  description character varying(255),
  CONSTRAINT conservation_action_type_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE conservation_action_type
  OWNER TO postgres;

END; 