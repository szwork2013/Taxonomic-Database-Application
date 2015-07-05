BEGIN;
	
-- Table: hierarchy_order

DROP TABLE IF EXISTS hierarchy_order;

CREATE TABLE hierarchy_order
(
  id bigserial NOT NULL,
  name character varying(255),
  CONSTRAINT hierarchy_order_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE hierarchy_order
  OWNER TO postgres;

END; 