BEGIN;

-- Table: kingdom

DROP TABLE IF EXISTS kingdom;

CREATE TABLE kingdom
(
  id bigserial NOT NULL,
  name character varying(255),
  integration_source bigint,
  CONSTRAINT kingdom_pkey PRIMARY KEY (id),
  CONSTRAINT fk_dlus5butt07bcw8qxob75chxw FOREIGN KEY (integration_source)
      REFERENCES integration_source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE kingdom
  OWNER TO postgres;

END;