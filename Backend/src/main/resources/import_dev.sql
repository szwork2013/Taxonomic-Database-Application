BEGIN;

-- ExtinctionRiskConfiguration data
INSERT INTO extinction_risk_configuration (id, category, b2a_number_of_locations, c_number_of_mature_individuals, d_number_of_mature_individuals, c2a_number_of_mature_individuals_in_sub, b2_area_of_ocuppancy, b1_extent_of_occurrence, c2a_perc_mature_individuals_one_sub, a1_perc_population_decline, a2_perc_population_decline, e_prob_extinction_in_the_wild) VALUES (1, 'CRITICALLY_ENDANGERED', 1, 250, 50, 50, 10, 100, 90, 90.0, 80.0, 50.0);

-- Kingdom data
INSERT INTO kingdom (id, name) VALUES (1, 'Animalia');

-- Phylum data
INSERT INTO phylum (id, phylum) VALUES (1, 'Annelida');

-- HierarchyClass data
INSERT INTO hierarchy_class (id, class) VALUES (1, 'Oligochaeta');

-- HierarchyOrder data
INSERT INTO hierarchy_order (id, name) VALUES (1, 'Haplotaxida');

-- Family data
INSERT INTO family (id, family) VALUES (1, 'Glossoscolecidae');

-- Gender data
INSERT INTO gender (id, gender) VALUES (1, 'Fimoscolex');

-- Country data
INSERT INTO country (id, name) VALUES (1, 'Brazil');

-- Taxonomy data
INSERT INTO taxonomy(id, species, subspecies, limitations_for_assessment, family_id, gender_id, class_id, kingdom_id, order_id, phylum_id) VALUES (1, 'Fimoscolex sporadochaetus', '', true, 1, 1, 1, 1, 1, 1);

-- State data
INSERT INTO state (id, name, country_id, code) VALUES (1, 'Acre', 1, 'AC');
INSERT INTO state (id, name, country_id, code) VALUES (2, 'Alagoas', 1, 'AL');
INSERT INTO state (id, name, country_id, code) VALUES (3, 'Amapá', 1, 'AP');
INSERT INTO state (id, name, country_id, code) VALUES (4, 'Amazonas', 1, 'AM');
INSERT INTO state (id, name, country_id, code) VALUES (5, 'Bahia', 1, 'BA');
INSERT INTO state (id, name, country_id, code) VALUES (6, 'Ceará', 1, 'CE');
INSERT INTO state (id, name, country_id, code) VALUES (7, 'Distrito Federal', 1, 'DF');
INSERT INTO state (id, name, country_id, code) VALUES (8, 'Espírito Santo', 1, 'ES');
INSERT INTO state (id, name, country_id, code) VALUES (9, 'Goiás', 1, 'GO');
INSERT INTO state (id, name, country_id, code) VALUES (10, 'Maranhão', 1, 'MA');
INSERT INTO state (id, name, country_id, code) VALUES (11, 'Mato Grosso', 1, 'MT');
INSERT INTO state (id, name, country_id, code) VALUES (12, 'Mato Grosso do Sul', 1, 'MS');
INSERT INTO state (id, name, country_id, code) VALUES (13, 'Minas Gerais', 1, 'MG');
INSERT INTO state (id, name, country_id, code) VALUES (14, 'Pará', 1, 'PA');
INSERT INTO state (id, name, country_id, code) VALUES (15, 'Paraíba', 1, 'PB');
INSERT INTO state (id, name, country_id, code) VALUES (16, 'Paraná', 1, 'PR');
INSERT INTO state (id, name, country_id, code) VALUES (17, 'Pernambuco', 1, 'PE');
INSERT INTO state (id, name, country_id, code) VALUES (18, 'Piauí', 1, 'PI');
INSERT INTO state (id, name, country_id, code) VALUES (19, 'Rio de Janeiro', 1, 'RJ');
INSERT INTO state (id, name, country_id, code) VALUES (20, 'Rio Grande do Norte', 1, 'RN');
INSERT INTO state (id, name, country_id, code) VALUES (21, 'Rio Grande do Sul', 1, 'RS');
INSERT INTO state (id, name, country_id, code) VALUES (22, 'Rondônia', 1, 'RO');
INSERT INTO state (id, name, country_id, code) VALUES (23, 'Roraima', 1, 'RR');
INSERT INTO state (id, name, country_id, code) VALUES (24, 'Santa Catarina', 1, 'SC');
INSERT INTO state (id, name, country_id, code) VALUES (25, 'São Paulo', 1, 'SP');
INSERT INTO state (id, name, country_id, code) VALUES (26, 'Sergipe', 1, 'SE');
INSERT INTO state (id, name, country_id, code) VALUES (27, 'Tocantins', 1, 'TO');

-- Threats data
INSERT INTO threat_category (id, description) VALUES (1, '0. No threat');
INSERT INTO threat_category (id, description) VALUES (2, '1.1. Agriculture rotation');
INSERT INTO threat_category (id, description) VALUES (3, '1.2. Small farms');
INSERT INTO threat_category (id, description) VALUES (4, '1.3. Agro-industrial agriculture');
INSERT INTO threat_category (id, description) VALUES (5, '1.4. Planting for logging on a small scale');
INSERT INTO threat_category (id, description) VALUES (6, '1.5. Planting for logging on a large scale');
INSERT INTO threat_category (id, description) VALUES (7, '1.6. Nomadic livestock');
INSERT INTO threat_category (id, description) VALUES (8, '1.7. Farming Small Properties');
INSERT INTO threat_category (id, description) VALUES (9, '1.8. Agro-industry Livestock');
INSERT INTO threat_category (id, description) VALUES (10, '1.9. marine aquaculture');
INSERT INTO threat_category (id, description) VALUES (11, '1.10. Freshwater Aquaculture');
INSERT INTO threat_category (id, description) VALUES (12, '2.1. Sand extraction');
INSERT INTO threat_category (id, description) VALUES (13, '2.2. Pebble extraction / stone');
INSERT INTO threat_category (id, description) VALUES (14, '2.3. Mineral extraction - underground');
INSERT INTO threat_category (id, description) VALUES (15, '2.4. Mineral extraction - mining');
INSERT INTO threat_category (id, description) VALUES (16, '2.5. Extraction of oil / oil');
INSERT INTO threat_category (id, description) VALUES (17, '2.6. Natural gas extraction');
INSERT INTO threat_category (id, description) VALUES (18, '2.7. Groundwater extraction');
INSERT INTO threat_category (id, description) VALUES (19, '3.1. Logging Subsistence / small scale');
INSERT INTO threat_category (id, description) VALUES (20, '3.2. Wood selective logging extraction');
INSERT INTO threat_category (id, description) VALUES (21, '3.3. Logging / deforestation');
INSERT INTO threat_category (id, description) VALUES (22, '3.4. Extraction of timber / wood for charcoal');
INSERT INTO threat_category (id, description) VALUES (23, '3.5. Not woody vegetation collection');
INSERT INTO threat_category (id, description) VALUES (24, '4.1.1. Industry Installation');
INSERT INTO threat_category (id, description) VALUES (25, '4.1.2. Working Industry');
INSERT INTO threat_category (id, description) VALUES (26, '4.2.1. Installation and operation of roads');
INSERT INTO threat_category (id, description) VALUES (27, '4.2.2. Installation and operation of railways');
INSERT INTO threat_category (id, description) VALUES (28, '4.2.3. Installation and operation of airports');
INSERT INTO threat_category (id, description) VALUES (29, '4.2.4. Installation and operation of ports and waterways');
INSERT INTO threat_category (id, description) VALUES (30, '4.3.1. Hydroelectric Power Plant (HPP)');
INSERT INTO threat_category (id, description) VALUES (31, '4.3.2. Small Hydroelectric Plant (SHP)');
INSERT INTO threat_category (id, description) VALUES (32, '4.3.3. Central Hydroelectric Generation (CGH)');
INSERT INTO threat_category (id, description) VALUES (33, '4.3.4. wind farm');
INSERT INTO threat_category (id, description) VALUES (34, '4.3.5. nuclear plant');
INSERT INTO threat_category (id, description) VALUES (35, '4.3.6. Power lines installation');
INSERT INTO threat_category (id, description) VALUES (36, '4.4. Infrastructure installation Tourism / recreation');
INSERT INTO threat_category (id, description) VALUES (37, '4.5. Telecommunications infrastructure installation');
INSERT INTO threat_category (id, description) VALUES (38, '4.6. Construction of dams / reservoirs to supply');
INSERT INTO threat_category (id, description) VALUES (39, '5.1. Rural settlements');
INSERT INTO threat_category (id, description) VALUES (40, '5.2. Boom towns');
INSERT INTO threat_category (id, description) VALUES (41, '6.1. Burned');
INSERT INTO threat_category (id, description) VALUES (42, '6.2. Natural origin of fire');
INSERT INTO threat_category (id, description) VALUES (43, '7.1. Introduction of exotic species (direct impact on the habitat)');
INSERT INTO threat_category (id, description) VALUES (44, '7.2. Competitors');
INSERT INTO threat_category (id, description) VALUES (45, '7.3. Predators');
INSERT INTO threat_category (id, description) VALUES (46, '7.4. Hybridization');
INSERT INTO threat_category (id, description) VALUES (47, '7.5. Pathogens / parasites');
INSERT INTO threat_category (id, description) VALUES (48, '7.6. Contact domestic species');
INSERT INTO threat_category (id, description) VALUES (49, '7.7. Other');
INSERT INTO threat_category (id, description) VALUES (50, '8.1. Use subsistence / local barter');
INSERT INTO threat_category (id, description) VALUES (51, '8.2. Sports');
INSERT INTO threat_category (id, description) VALUES (52, '8.3. Commercial');
INSERT INTO threat_category (id, description) VALUES (53, '8.4. Scientific collection');
INSERT INTO threat_category (id, description) VALUES (54, '8.5. Pest control');
INSERT INTO threat_category (id, description) VALUES (55, '8.6. Coral removal');
INSERT INTO threat_category (id, description) VALUES (56, '8.7. Other');
INSERT INTO threat_category (id, description) VALUES (57, '9.1. Running over');
INSERT INTO threat_category (id, description) VALUES (58, '9.2. Collisions Torres and Buildings');
INSERT INTO threat_category (id, description) VALUES (59, '9.3. Poisoning');
INSERT INTO threat_category (id, description) VALUES (60, '9.4. Other');
INSERT INTO threat_category (id, description) VALUES (61, '10.1. Global / ocean warming');
INSERT INTO threat_category (id, description) VALUES (62, '10.2. Acid rain');
INSERT INTO threat_category (id, description) VALUES (63, '10.3. Effects of the holes in the ozone layer');
INSERT INTO threat_category (id, description) VALUES (64, '10.4. Smoke');
INSERT INTO threat_category (id, description) VALUES (65, '10.5. Soil pollution - origin in agriculture');
INSERT INTO threat_category (id, description) VALUES (66, '10.6. Soil pollution - domestic origin');
INSERT INTO threat_category (id, description) VALUES (67, '10.7. Soil pollution - Source Commercial / Industrial');
INSERT INTO threat_category (id, description) VALUES (68, '10.8. Light pollution');
INSERT INTO threat_category (id, description) VALUES (69, '10.9. Noise pollution');
INSERT INTO threat_category (id, description) VALUES (70, '10.10. Water pollution - agricultural sources');
INSERT INTO threat_category (id, description) VALUES (71, '10:11. Water pollution - domestic origin');
INSERT INTO threat_category (id, description) VALUES (72, '10:12. Water pollution - commercial origin / Industrial');
INSERT INTO threat_category (id, description) VALUES (73, '10:13. Thermal pollution');
INSERT INTO threat_category (id, description) VALUES (74, '10:14. Oil spill');
INSERT INTO threat_category (id, description) VALUES (75, '10:15. Siltation');
INSERT INTO threat_category (id, description) VALUES (76, '10:16. Dump waste / sewage - source in the city');
INSERT INTO threat_category (id, description) VALUES (77, '10:16. Dump waste / sewage - source in the industry');
INSERT INTO threat_category (id, description) VALUES (78, '10:17. Disposal of solid waste - originated in the city');
INSERT INTO threat_category (id, description) VALUES (79, '10:17. Disposal of solid waste - source in the industry');
INSERT INTO threat_category (id, description) VALUES (80, '10:18. Noise pollution of waters');
INSERT INTO threat_category (id, description) VALUES (81, '10:19. Other');
INSERT INTO threat_category (id, description) VALUES (82, '11.1. Drought');
INSERT INTO threat_category (id, description) VALUES (83, '11.2. Storms / floods');
INSERT INTO threat_category (id, description) VALUES (84, '11.3. Thermal extremes');
INSERT INTO threat_category (id, description) VALUES (85, '11.4. Landslides');
INSERT INTO threat_category (id, description) VALUES (86, '11.5. Other');
INSERT INTO threat_category (id, description) VALUES (87, '12.1. Competitors');
INSERT INTO threat_category (id, description) VALUES (88, '12.2. Predators');
INSERT INTO threat_category (id, description) VALUES (89, '12.3. Prey / food base');
INSERT INTO threat_category (id, description) VALUES (90, '12.4. Hybridization');
INSERT INTO threat_category (id, description) VALUES (91, '12.5. Pathogens / parasites');
INSERT INTO threat_category (id, description) VALUES (92, '12.6. Other');
INSERT INTO threat_category (id, description) VALUES (93, '13.1.1. Surface longline');
INSERT INTO threat_category (id, description) VALUES (94, '13.1.2. Bottom longline');
INSERT INTO threat_category (id, description) VALUES (95, '13.1.3. Hand line');
INSERT INTO threat_category (id, description) VALUES (96, '13.1.4. Coastal gill surface');
INSERT INTO threat_category (id, description) VALUES (97, '13.1.5. Coastal gill background');
INSERT INTO threat_category (id, description) VALUES (98, '13.1.6. Oceanic gill surface');
INSERT INTO threat_category (id, description) VALUES (99, '13.1.7. Oceanic driftnet background');
INSERT INTO threat_category (id, description) VALUES (100, '13.1.8. Bottom trawling');
INSERT INTO threat_category (id, description) VALUES (101, '13.1.9. Coastal trawl double bottom');
INSERT INTO threat_category (id, description) VALUES (102, '13.1.10. Ocean trawl background (single and double)');
INSERT INTO threat_category (id, description) VALUES (103, '01.13.11. Drag (half water)');
INSERT INTO threat_category (id, description) VALUES (104, '01.13.12. siege');
INSERT INTO threat_category (id, description) VALUES (105, '13.1.13. creels');
INSERT INTO threat_category (id, description) VALUES (106, '13.01.14. puçá');
INSERT INTO threat_category (id, description) VALUES (107, '13.1.15. Underwater manual collection');
INSERT INTO threat_category (id, description) VALUES (108, '13.01.16. other');
INSERT INTO threat_category (id, description) VALUES (109, '13.2.1. single line');
INSERT INTO threat_category (id, description) VALUES (110, '13.2.2. paternoster');
INSERT INTO threat_category (id, description) VALUES (111, '13.2.3. Seine');
INSERT INTO threat_category (id, description) VALUES (112, '13.2.4. Drift Network');
INSERT INTO threat_category (id, description) VALUES (113, '13.2.5. Gill net (gillnets)');
INSERT INTO threat_category (id, description) VALUES (114, '13.2.6. drag');
INSERT INTO threat_category (id, description) VALUES (115, '13.2.7. flue');
INSERT INTO threat_category (id, description) VALUES (116, '13.2.8. hook');
INSERT INTO threat_category (id, description) VALUES (117, '13.2.9. harpoon');
INSERT INTO threat_category (id, description) VALUES (118, '13.2.10. corral');
INSERT INTO threat_category (id, description) VALUES (119, '13.2.11. Archery');
INSERT INTO threat_category (id, description) VALUES (120, '13.2.12. Puça');
INSERT INTO threat_category (id, description) VALUES (121, '13.2.13. underwater');
INSERT INTO threat_category (id, description) VALUES (122, '13.02.14. of Trolling');
INSERT INTO threat_category (id, description) VALUES (123, '13.02.15. Barranco');
INSERT INTO threat_category (id, description) VALUES (124, '13.2.16. with Fly');
INSERT INTO threat_category (id, description) VALUES (125, '13.2.17. Beach');
INSERT INTO threat_category (id, description) VALUES (126, '13.2.18. Round');
INSERT INTO threat_category (id, description) VALUES (127, '13.2.19. other');
INSERT INTO threat_category (id, description) VALUES (128, '13.3. Industrial fishing');
INSERT INTO threat_category (id, description) VALUES (129, '13.4. Small-scale fishing');
INSERT INTO threat_category (id, description) VALUES (130, '13.5. Pump or substance producing a similar effect');
INSERT INTO threat_category (id, description) VALUES (131, '13.6. chemicals');
INSERT INTO threat_category (id, description) VALUES (132, '13.7. sports');
INSERT INTO threat_category (id, description) VALUES (133, '13.8. other');
INSERT INTO threat_category (id, description) VALUES (134, '14. Other');
INSERT INTO threat_category (id, description) VALUES (135, '15. Unknown threat');

-- Conservation Actions data
INSERT INTO conservation_action_type (id, description) VALUES (1, '0. No Action');

-- HabitatType data
INSERT INTO habitat_type (id, name) VALUES (1, 'Amazonia - Rain Forest Alluvial');

-- Specie data 
INSERT INTO specie(id, common_name, extinction_risk_category, scientific_name, conservation_id, cover_map_id, cover_photo_id, distribution_id, natural_history_id, taxonomy_id, threat_id) VALUES (1, 'specie-test-1', 0, 'specie-test-1', NULL, NULL, NULL, NULL, NULL, 1, NULL);

COMMIT;
