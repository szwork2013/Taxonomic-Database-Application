BEGIN;

-- Table: image

DROP TABLE IF EXISTS image;

CREATE TABLE image
(
  id bigserial NOT NULL,
  author character varying(255),
  date timestamp without time zone,
  file bytea,
  legend character varying(255),
  site_description character varying(255),
  cover_image bytea,
  CONSTRAINT image_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE image
  OWNER TO postgres;

END;