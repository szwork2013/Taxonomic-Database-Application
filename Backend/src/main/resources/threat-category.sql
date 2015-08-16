-- Threats data
INSERT INTO threat_category (id, description, code) VALUES (1, 'No Threat','NOT');
INSERT INTO threat_category (id, description, code) VALUES (2, 'Agricultural','AGR');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (3, 'Agriculture rotation',2,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (4, 'Small farms',2,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (5, 'Agro-industrial agriculture',2,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (6, 'Planting for logging on a small scale',2,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (7, 'Planting for logging on a large scale',2,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (8, 'Nomadic livestock',2,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (9, 'Farming Small Properties',2,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (10, 'Agro-industry Livestock',2,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (11, 'marine aquaculture',2,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (12, 'Freshwater Aquaculture',2,'NONE');

INSERT INTO threat_category (id, description, code) VALUES (13, 'Mining','MIN');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (14, 'Pebble extraction / stone',13,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (15, 'Mineral extraction - underground',13,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (16, 'Mineral extraction - mining',13,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (17, 'Extraction of oil / oil',13,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (18, 'Natural gas extraction',13,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (19, 'Groundwater extraction',13,'NONE');

INSERT INTO threat_category (id, description, code) VALUES (20, 'Forest Extraction','FOR');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (21, 'Logging Subsistence / small scale',20,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (22, 'Wood selective logging extraction',20,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (23, 'Logging / deforestation',20,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (24, 'Extraction of timber / wood for charcoal',20,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (25, 'Not woody vegetation collection',20,'NONE');

INSERT INTO threat_category (id, description, code) VALUES (26, 'Other Economic Activities','OTH');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (27, 'Industrial',26,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (28, 'Industry Installation',27,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (29, 'Working Industry',27,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (30, 'Transport',26,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (31, 'Installation and operation of roads',30,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (32, 'Installation and operation of railways',30,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (33, 'Installation and operation of airports',30,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (34, 'Installation and operation of ports and waterways',30,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (35, 'Energy',26,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (36, 'Hydroelectric Power Plant (HPP)',35,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (37, 'Small Hydroelectric Plant (SHP)',35,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (38, 'Power lines installation',35,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (39, 'Central Hydroelectric Generation (CGH)',35,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (40, 'Wind Farm',35,'NONE');
    INSERT INTO threat_category (id, description, parent_id, code) VALUES (41, 'Nuclear Plant',35,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (42, 'Infrastructure installation Tourism / recreation',26,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (43, 'Telecommunications infrastructure installation',26,'NONE');
  INSERT INTO threat_category (id, description, parent_id, code) VALUES (44, 'Construction of dams / reservoirs to supply',26,'NONE');

  INSERT INTO threat_category (id, description, code) VALUES (45, 'Human Settlement','HUM');
   INSERT INTO threat_category (id, description,parent_id) VALUES (46, 'Rural settlements',45,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (47, 'Boom towns',45,'NONE');

  INSERT INTO threat_category (id, description, code) VALUES (48, 'Fires','FIR');
   INSERT INTO threat_category (id, description,parent_id) VALUES (49, 'Burned',48,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (50, ' Natural origin of fire',48,'NONE');

  INSERT INTO threat_category (id, description, code) VALUES (51, 'Alien Species','ALI');
   INSERT INTO threat_category (id, description,parent_id) VALUES (52, 'Introduction of exotic species (direct impact on the habitat)',51,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (53, ' Competitors',51,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (54, ' Predators',51,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (55, ' Hybridization',51,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (56, ' Pathogens / parasites',51,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (57, ' Contact domestic species',51,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (58, ' Other;abrir um campo texto de 100 caracteres',51,'NONE');

  INSERT INTO threat_category (id, description, code) VALUES (59, 'direct extraction (hunting)','DIR');
   INSERT INTO threat_category (id, description,parent_id) VALUES (60, 'Use subsistence / local barter',59,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (61, ' Sports',59,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (62, ' Commercial',59,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (63, ' Scientific collection',59,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (64, ' Pest control',59,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (65, ' Coral removal',59,'NONE');
   INSERT INTO threat_category (id, description,parent_id) VALUES (66, ' Other',59,'NONE');


