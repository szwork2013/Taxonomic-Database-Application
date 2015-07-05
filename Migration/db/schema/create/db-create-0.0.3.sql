BEGIN;

-- Table: sound

DROP TABLE IF EXISTS sound;

CREATE TABLE sound
(
  id bigserial NOT NULL,
  author character varying(255),
  date timestamp without time zone,
  file bytea,
  legend character varying(255),
  site_description character varying(255),
  CONSTRAINT sound_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sound
  OWNER TO postgres;

END;