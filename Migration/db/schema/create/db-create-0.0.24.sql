BEGIN;

-- Table: user_role

DROP TABLE IF EXISTS user_role;

CREATE TABLE user_role
(
  id bigint NOT NULL,
  name character varying(255) NOT NULL,
  role character varying(255) NOT NULL,
  CONSTRAINT user_role_pkey PRIMARY KEY (id),
  CONSTRAINT uk_lnth8w122wgy7grrjlu8hjmuu UNIQUE (name),
  CONSTRAINT uk_s21d8k5lywjjc7inw14brj6ro UNIQUE (role)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_role
  OWNER TO postgres;

END;