BEGIN;

-- Table: taxonomy

DROP TABLE IF EXISTS taxonomy;

CREATE TABLE taxonomy
(
  id bigserial NOT NULL,
  species character varying(255),
  subspecies character varying(255),
  limitations_for_assessment boolean,
  family_id bigint,
  genus_id bigint,
  class_id bigint,
  kingdom_id bigint,
  order_id bigint,
  phylum_id bigint,
  CONSTRAINT taxonomy_pkey PRIMARY KEY (id),
  CONSTRAINT fk_2epk0jnwu58hl9g8879rxi4uj FOREIGN KEY (phylum_id)
      REFERENCES phylum (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_2u23lsh4bj5keaqlnt7t0ol78 FOREIGN KEY (genus_id)
      REFERENCES genus (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_87neth321kivwba8iuriqsea0 FOREIGN KEY (order_id)
      REFERENCES hierarchy_order (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_9a8t8yxqvenxtulh6kkakou49 FOREIGN KEY (family_id)
      REFERENCES family (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_btj3a7higsxkgmv0nhxkvxres FOREIGN KEY (kingdom_id)
      REFERENCES kingdom (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_laye92jgnb3lcc2iua1n3bxc0 FOREIGN KEY (class_id)
      REFERENCES hierarchy_class (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE taxonomy
  OWNER TO postgres;

END;