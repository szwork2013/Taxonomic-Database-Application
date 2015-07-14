BEGIN;

-- Table: hierarchy_class

DROP TABLE IF EXISTS hierarchy_class;

CREATE TABLE hierarchy_class
(
  id bigserial NOT NULL,
  class character varying(255),
  integration_source bigint,
  CONSTRAINT hierarchy_class_pkey PRIMARY KEY (id),
  CONSTRAINT fk_kmyxht03nbc67yxoqrmfp1jna FOREIGN KEY (integration_source)
      REFERENCES integration_source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE hierarchy_class
  OWNER TO postgres;

END;