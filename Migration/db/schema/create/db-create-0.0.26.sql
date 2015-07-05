BEGIN;

-- Table: users

DROP TABLE IF EXISTS users;

CREATE TABLE users
(
  id bigint NOT NULL,
  address character varying(255),
  email character varying(255) NOT NULL,
  enabled boolean NOT NULL,
  first_name character varying(255),
  last_name character varying(255),
  password character varying(100) NOT NULL,
  phone_number character varying(255),
  username character varying(30) NOT NULL,
  user_role_id bigint NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id),
  CONSTRAINT fk_blvmyr4rgpt5rvfms3obvsus7 FOREIGN KEY (user_role_id)
      REFERENCES user_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
  CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;

END;