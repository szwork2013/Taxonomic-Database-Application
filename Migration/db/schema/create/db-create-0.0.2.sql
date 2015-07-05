BEGIN;
	
-- Table: threat_category

DROP TABLE IF EXISTS threat_category;

CREATE TABLE threat_category
(
  id bigserial NOT NULL,
  description character varying(255),
  CONSTRAINT threat_category_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE threat_category
  OWNER TO postgres;

END; 