BEGIN;

-- Table: species

DROP TABLE IF EXISTS species;

CREATE TABLE species
(
  id bigserial NOT NULL,
  common_name character varying(255),
  extinction_risk_category integer,
  scientific_name character varying(255),
  conservation_id bigint,
  cover_map_id bigint,
  cover_photo_id bigint,
  distribution_id bigint,
  integration_source bigint,
  natural_history_id bigint,
  taxonomy_id bigint,
  threat_id bigint,
  CONSTRAINT species_pkey PRIMARY KEY (id),
  CONSTRAINT fk_3sl6o4jvho5h78gd2cwxwhdec FOREIGN KEY (cover_photo_id)
      REFERENCES image (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_64mn51il9e0cwnnpe2oeijm5 FOREIGN KEY (integration_source)
      REFERENCES integration_source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_fqbhk1wlljbq24i08g30rw4mh FOREIGN KEY (taxonomy_id)
      REFERENCES taxonomy (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_j5q27cgdvhxbu4nkvjjmp2p5p FOREIGN KEY (conservation_id)
      REFERENCES conservation (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_jnlfrmbw1ymymbn483etn82la FOREIGN KEY (distribution_id)
      REFERENCES distribution_area (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_l3nma56sxsi0p8w2bk3nslqft FOREIGN KEY (cover_map_id)
      REFERENCES map (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_mhnxxpnb97fpq8ornm3gfxyo3 FOREIGN KEY (natural_history_id)
      REFERENCES natural_history (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_sf5aewp4mvxrrxhla9cn1b4iy FOREIGN KEY (threat_id)
      REFERENCES threat (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE species
  OWNER TO postgres;


END;