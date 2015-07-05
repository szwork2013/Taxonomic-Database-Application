BEGIN; 
	
-- Table: video

DROP TABLE IF EXISTS video;

CREATE TABLE video
(
  id bigserial NOT NULL,
  author character varying(255),
  date timestamp without time zone,
  file bytea,
  legend character varying(255),
  site_description character varying(255),
  CONSTRAINT video_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE video
  OWNER TO postgres;
	
END;