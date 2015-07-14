BEGIN;

-- Table: conservation

DROP TABLE IF EXISTS conservation;

CREATE TABLE conservation
(
  id bigserial NOT NULL,
  benefited_from_action_plan character varying(255),
  convention character varying(255),
  convention_other_relevant_data character varying(255),
  ex_situ_management character varying(255),
  other_actions_protect_species character varying(255),
  action_plans character varying(255),
  change_reasons character varying(255),
  in_national_endangered_fauna boolean,
  national_evaluation_elegible boolean,
  necessary_research_for_conservation character varying(255),
  previous_national_assessment character varying(255),
  research_in_progress character varying(255),
  specific_actions_in_protected_areas character varying(255),
  type_id bigint,
  CONSTRAINT conservation_pkey PRIMARY KEY (id),
  CONSTRAINT fk_ay2921m02mn6130w26bjqklct FOREIGN KEY (type_id)
      REFERENCES conservation_action_type (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE conservation
  OWNER TO postgres;


END;