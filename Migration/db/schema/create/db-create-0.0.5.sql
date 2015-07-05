BEGIN;

-- Table: permission

DROP TABLE IF EXISTS permission;

CREATE TABLE permission
(
  id bigint NOT NULL,
  name character varying(255) NOT NULL,
  CONSTRAINT permission_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE permission
  OWNER TO postgres;

END;