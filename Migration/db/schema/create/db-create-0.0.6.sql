BEGIN;

-- Table: map

DROP TABLE IF EXISTS map;

CREATE TABLE map
(
  id bigserial NOT NULL,
  author character varying(255),
  caption character varying(255),
  date timestamp without time zone,
  description character varying(255),
  file bytea,
  set_as_cover boolean,
  projection character varying(255),
  type character varying(255),
  CONSTRAINT map_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE map
  OWNER TO postgres;

END;