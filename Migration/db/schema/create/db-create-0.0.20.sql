BEGIN;

-- Table: state

DROP TABLE IF EXISTS state;

CREATE TABLE state
(
  id bigserial NOT NULL,
  code character varying(255),
  name character varying(255) NOT NULL,
  country_id bigint,
  CONSTRAINT state_pkey PRIMARY KEY (id),
  CONSTRAINT fk_lxoqjm8644epv72af3k3jpalx FOREIGN KEY (country_id)
      REFERENCES country (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_2g0hi7w44i4sjkffh61pusaav UNIQUE (name)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE state
  OWNER TO postgres;

END;