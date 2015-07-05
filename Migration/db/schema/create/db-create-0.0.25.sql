BEGIN;

-- Table: authority

DROP TABLE IF EXISTS authority;

CREATE TABLE authority
(
  permission_id bigint NOT NULL,
  user_role_id bigint NOT NULL,
  CONSTRAINT authority_pkey PRIMARY KEY (user_role_id, permission_id),
  CONSTRAINT fk_6d64vbjfk2mjdlps3phpgmayg FOREIGN KEY (permission_id)
      REFERENCES permission (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_74wtcmhq253rh1q6d0u8ujiyb FOREIGN KEY (user_role_id)
      REFERENCES user_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE authority
  OWNER TO postgres;

END;