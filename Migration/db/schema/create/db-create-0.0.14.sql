BEGIN;

-- Table: hierarchy_class

DROP TABLE IF EXISTS hierarchy_class;

CREATE TABLE hierarchy_class
(
  id bigserial NOT NULL,
  class character varying(255),
  CONSTRAINT hierarchy_class_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE hierarchy_class
  OWNER TO postgres;

END;