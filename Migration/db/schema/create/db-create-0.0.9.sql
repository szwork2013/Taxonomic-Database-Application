BEGIN;
	
-- Table: country

DROP TABLE IF EXISTS country;

CREATE TABLE country
(
  id bigserial NOT NULL,
  name character varying(255) NOT NULL,
  CONSTRAINT country_pkey PRIMARY KEY (id),
  CONSTRAINT uk_llidyp77h6xkeokpbmoy710d4 UNIQUE (name)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE country
  OWNER TO postgres;

END; 