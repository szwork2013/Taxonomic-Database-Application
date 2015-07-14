BEGIN;
	
-- Table: hierarchy_order

DROP TABLE IF EXISTS hierarchy_order;

CREATE TABLE hierarchy_order
(
  id bigserial NOT NULL,
  name character varying(255),
  integration_source bigint,
  CONSTRAINT hierarchy_order_pkey PRIMARY KEY (id),
  CONSTRAINT fk_dcsmh67c19aohuhepao9clsa4 FOREIGN KEY (integration_source)
      REFERENCES integration_source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE hierarchy_order
  OWNER TO postgres;

END; 