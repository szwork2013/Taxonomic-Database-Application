-- Threats data

INSERT INTO threat_category (id, description) VALUES (2, 'Agricultural');
  INSERT INTO threat_category (id, description, parent_id) VALUES (3, 'Agriculture rotation',2);
  INSERT INTO threat_category (id, description, parent_id) VALUES (4, 'Small farms',2);
  INSERT INTO threat_category (id, description, parent_id) VALUES (5, 'Agro-industrial agriculture',2);
  INSERT INTO threat_category (id, description, parent_id) VALUES (6, 'Planting for logging on a small scale',2);
  INSERT INTO threat_category (id, description, parent_id) VALUES (7, 'Planting for logging on a large scale',2);
  INSERT INTO threat_category (id, description, parent_id) VALUES (8, 'Nomadic livestock',2);
  INSERT INTO threat_category (id, description, parent_id) VALUES (9, 'Farming Small Properties',2);
  INSERT INTO threat_category (id, description, parent_id) VALUES (10, 'Agro-industry Livestock',2);
  INSERT INTO threat_category (id, description, parent_id) VALUES (11, 'marine aquaculture',2);
  INSERT INTO threat_category (id, description, parent_id) VALUES (12, 'Freshwater Aquaculture',2);

INSERT INTO threat_category (id, description) VALUES (13, 'Mining');
  INSERT INTO threat_category (id, description, parent_id) VALUES (14, 'Pebble extraction / stone',13);
  INSERT INTO threat_category (id, description, parent_id) VALUES (15, 'Mineral extraction - underground',13);
  INSERT INTO threat_category (id, description, parent_id) VALUES (16, 'Mineral extraction - mining',13);
  INSERT INTO threat_category (id, description, parent_id) VALUES (17, 'Extraction of oil / oil',13);
  INSERT INTO threat_category (id, description, parent_id) VALUES (18, 'Natural gas extraction',13);
  INSERT INTO threat_category (id, description, parent_id) VALUES (19, 'Groundwater extraction',13);

INSERT INTO threat_category (id, description) VALUES (20, 'Forest Extraction');
  INSERT INTO threat_category (id, description, parent_id) VALUES (21, 'Logging Subsistence / small scale',20);
  INSERT INTO threat_category (id, description, parent_id) VALUES (22, 'Wood selective logging extraction',20);
  INSERT INTO threat_category (id, description, parent_id) VALUES (23, 'Logging / deforestation',20);
  INSERT INTO threat_category (id, description, parent_id) VALUES (24, 'Extraction of timber / wood for charcoal',20);
  INSERT INTO threat_category (id, description, parent_id) VALUES (25, 'Not woody vegetation collection',20);

INSERT INTO threat_category (id, description) VALUES (26, 'Other Economic Activities');
  INSERT INTO threat_category (id, description, parent_id) VALUES (27, 'Industrial',26);
    INSERT INTO threat_category (id, description, parent_id) VALUES (28, 'Industry Installation',27);
    INSERT INTO threat_category (id, description, parent_id) VALUES (29, 'Working Industry',27);
  INSERT INTO threat_category (id, description, parent_id) VALUES (30, 'Transport',26);
    INSERT INTO threat_category (id, description, parent_id) VALUES (31, 'Installation and operation of roads',30);
    INSERT INTO threat_category (id, description, parent_id) VALUES (32, 'Installation and operation of railways',30);
    INSERT INTO threat_category (id, description, parent_id) VALUES (33, 'Installation and operation of airports',30);
    INSERT INTO threat_category (id, description, parent_id) VALUES (34, 'Installation and operation of ports and waterways',30);
  INSERT INTO threat_category (id, description, parent_id) VALUES (35, 'Energy',26);
    INSERT INTO threat_category (id, description, parent_id) VALUES (36, 'Hydroelectric Power Plant (HPP)',35);
    INSERT INTO threat_category (id, description, parent_id) VALUES (37, 'Small Hydroelectric Plant (SHP)',35);
    INSERT INTO threat_category (id, description, parent_id) VALUES (38, 'Power lines installation',35);
    INSERT INTO threat_category (id, description, parent_id) VALUES (39, 'Central Hydroelectric Generation (CGH)',35);
    INSERT INTO threat_category (id, description, parent_id) VALUES (40, 'Wind Farm',35);
    INSERT INTO threat_category (id, description, parent_id) VALUES (41, 'Nuclear Plant',35);
  INSERT INTO threat_category (id, description, parent_id) VALUES (42, 'Infrastructure installation Tourism / recreation',26);
  INSERT INTO threat_category (id, description, parent_id) VALUES (43, 'Telecommunications infrastructure installation',26);
  INSERT INTO threat_category (id, description, parent_id) VALUES (44, 'Construction of dams / reservoirs to supply',26);

  INSERT INTO threat_category (id, description) VALUES (45, 'Human Settlement');
   INSERT INTO threat_category (id, description,parent_id) VALUES (46, 'Rural settlements',45);
   INSERT INTO threat_category (id, description,parent_id) VALUES (47, 'Boom towns',45);

  INSERT INTO threat_category (id, description) VALUES (48, 'Fires');
   INSERT INTO threat_category (id, description,parent_id) VALUES (49, 'Burned',48);
   INSERT INTO threat_category (id, description,parent_id) VALUES (50, ' Natural origin of fire',48);

  INSERT INTO threat_category (id, description) VALUES (51, 'Alien Species');
   INSERT INTO threat_category (id, description,parent_id) VALUES (52, 'Introduction of exotic species (direct impact on the habitat)',51);
   INSERT INTO threat_category (id, description,parent_id) VALUES (53, ' Competitors',51);
   INSERT INTO threat_category (id, description,parent_id) VALUES (54, ' Predators',51);
   INSERT INTO threat_category (id, description,parent_id) VALUES (55, ' Hybridization',51);
   INSERT INTO threat_category (id, description,parent_id) VALUES (56, ' Pathogens / parasites',51);
   INSERT INTO threat_category (id, description,parent_id) VALUES (57, ' Contact domestic species',51);
   INSERT INTO threat_category (id, description,parent_id) VALUES (58, ' Other;abrir um campo texto de 100 caracteres',51);

  INSERT INTO threat_category (id, description) VALUES (59, 'direct extraction (hunting)');
   INSERT INTO threat_category (id, description,parent_id) VALUES (60, 'Use subsistence / local barter',59);
   INSERT INTO threat_category (id, description,parent_id) VALUES (61, ' Sports',59);
   INSERT INTO threat_category (id, description,parent_id) VALUES (62, ' Commercial',59);
   INSERT INTO threat_category (id, description,parent_id) VALUES (63, ' Scientific collection',59);
   INSERT INTO threat_category (id, description,parent_id) VALUES (64, ' Pest control',59);
   INSERT INTO threat_category (id, description,parent_id) VALUES (65, ' Coral removal',59);
   INSERT INTO threat_category (id, description,parent_id) VALUES (66, ' Other',59);


