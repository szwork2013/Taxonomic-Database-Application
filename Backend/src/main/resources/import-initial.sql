-- Biome data
INSERT INTO biome (id, name) VALUES (1, 'Amazônia');
INSERT INTO biome (id, name) VALUES (2, 'Caatinga');
INSERT INTO biome (id, name) VALUES (3, 'Cerrado');
INSERT INTO biome (id, name) VALUES (4, 'Mata Atlântica');
INSERT INTO biome (id, name) VALUES (5, 'Pampas');
INSERT INTO biome (id, name) VALUES (6, 'Pantanal');

-- IntegrationSource data
INSERT INTO integration_source (id, source, name) VALUES (1, 'FLORA', 'JBRJ IPT - Flora');
INSERT INTO integration_source (id, source, name) VALUES (2, 'SPECIES_PLUS', 'WCMC SP+');
INSERT INTO integration_source (id, source, name) VALUES (3, 'FAUNA', 'JBRJ IPT - Fauna');

-- Country data
INSERT INTO country (id, name) VALUES (1, 'Brazil');

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

-- Conservation Actions data
INSERT INTO conservation_action_type (id, description) VALUES (1, '0. No Action');
INSERT INTO conservation_action_type (id, description) VALUES (2, '1. Management Plans');
INSERT INTO conservation_action_type (id, description) VALUES (3, '2. Legislation');
INSERT INTO conservation_action_type (id, description) VALUES (4, '3.1. government bodies');
INSERT INTO conservation_action_type (id, description) VALUES (5, '3.2. Resource Management');
INSERT INTO conservation_action_type (id, description) VALUES (6, '3.3. Alternative livelihoods');
INSERT INTO conservation_action_type (id, description) VALUES (7, '4.1. Formal Education');
INSERT INTO conservation_action_type (id, description) VALUES (8, '4.2. awareness');
INSERT INTO conservation_action_type (id, description) VALUES (9, '4.3. Capacity building / training');
INSERT INTO conservation_action_type (id, description) VALUES (10, '4.4. other');
INSERT INTO conservation_action_type (id, description) VALUES (11, '5.1. Taxonomy');
INSERT INTO conservation_action_type (id, description) VALUES (12, '5.2. Population size and geographic distribution');
INSERT INTO conservation_action_type (id, description) VALUES (13, '5.3. Biology and ecology');
INSERT INTO conservation_action_type (id, description) VALUES (14, '5.4. State Habitat');
INSERT INTO conservation_action_type (id, description) VALUES (15, '5.5. threats');
INSERT INTO conservation_action_type (id, description) VALUES (16, '5.6. Use and exploitation');
INSERT INTO conservation_action_type (id, description) VALUES (17, '5.7. Cultural relevance');
INSERT INTO conservation_action_type (id, description) VALUES (18, '5.8. Conservation measures');
INSERT INTO conservation_action_type (id, description) VALUES (19, '5.9. Avalição trends / monitoring');
INSERT INTO conservation_action_type (id, description) VALUES (20, '5.10. other');
INSERT INTO conservation_action_type (id, description) VALUES (21, '6. Maintenance / habitat conservation');
INSERT INTO conservation_action_type (id, description) VALUES (22, '7. Habitat Restoration');
INSERT INTO conservation_action_type (id, description) VALUES (23, '8. Runners');
INSERT INTO conservation_action_type (id, description) VALUES (24, '9. Identification of new Protected Areas');
INSERT INTO conservation_action_type (id, description) VALUES (25, '10. Protected Areas Establishment');
INSERT INTO conservation_action_type (id, description) VALUES (26, '11. Management of Protected Areas');
INSERT INTO conservation_action_type (id, description) VALUES (27, '12. Expansion of Protected Areas');
INSERT INTO conservation_action_type (id, description) VALUES (28, '13. Re-introductions');
INSERT INTO conservation_action_type (id, description) VALUES (29, '14. benign Introductions');
INSERT INTO conservation_action_type (id, description) VALUES (30, '15. Management of hunting / chasing / collection');
INSERT INTO conservation_action_type (id, description) VALUES (31, '16. Trade Management');
INSERT INTO conservation_action_type (id, description) VALUES (32, '17. Restore Management');
INSERT INTO conservation_action_type (id, description) VALUES (33, '18. Management of diseases, pathogens and parasites');
INSERT INTO conservation_action_type (id, description) VALUES (34, '19. Limitation of population growth');
INSERT INTO conservation_action_type (id, description) VALUES (35, '20. Reproduction in captivity / artificial propagation');
INSERT INTO conservation_action_type (id, description) VALUES (36, '21. Genetic Bank');
INSERT INTO conservation_action_type (id, description) VALUES (37, '22. Other');

-- Biomes
insert into biome (name) values ('Aquatic');
insert into biome (name) values ('Deserts');
insert into biome (name) values ('Forest');
insert into biome (name) values ('Grasslands');
insert into biome (name) values ('Tundra');

-- River
insert into river_basin (name) values ('Tapajós');
insert into river_basin (name) values ('Juruena');
insert into river_basin (name) values ('Piratucu');
insert into river_basin (name) values ('Paracori');
insert into river_basin (name) values ('Acari');

-- Protected Areas
insert into protected_area (area) values ('Petrópolis Environmental');
insert into protected_area (area) values ('Piaçabuçu Environmental');
insert into protected_area (area) values ('Bacia do Rio São Bartolomeu Environmental');
insert into protected_area (area) values ('Bacia do Rio Descoberto Environmental');
insert into protected_area (area) values ('Cairuçu Environmental');
insert into protected_area (area) values ('Quapi-Mirim Environmental');
insert into protected_area (area) values ('Jericoacoara Environmental');
insert into protected_area (area) values ('Cananéia-Iguape e Peruíbe Environmental');
insert into protected_area (area) values ('Serra da Mantiqueira Environmental');
insert into protected_area (area) values ('Guaraqueçaba Environmental');
insert into protected_area (area) values ('Fernando de Noronha Environmental');
insert into protected_area (area) values ('Igarapé Gelado Environmental');
insert into protected_area (area) values ('Cavernas do Peruaçu Environmental');
insert into protected_area (area) values ('Carste de Lagoa Santa Environmental');
insert into protected_area (area) values ('Morro da Pedreira Environmental');
insert into protected_area (area) values ('Serra de Tabatinga Environmental');
insert into protected_area (area) values ('Ibirapuitã Environmental');
insert into protected_area (area) values ('Anhatomirim Environmental');
insert into protected_area (area) values ('Barra do Rio Mamanguape Environmental');

-- UserRole data
INSERT INTO user_role (id, name, role) VALUES (1, 'ADMIN', 'ADMIN');
INSERT INTO user_role (id, name, role) VALUES (2, 'EXPERT', 'EXPERT');
INSERT INTO user_role (id, name, role) VALUES (3, 'PUBLIC_USER', 'PUBLIC_USER');
INSERT INTO user_role (id, name, role) VALUES (4, 'ANONYMOUS', 'ANONYMOUS');
INSERT INTO user_role (id, name, role) VALUES (5, 'SUPERADMIN', 'SUPERADMIN');

-- Users data
INSERT INTO users (id, address, email, enabled, first_name, last_name, password, phone_number, username, user_role_id) VALUES (1, null, 'admin@email.com', true, 'Admin', 'Admin', 'admin123', null, 'admin', 1);
