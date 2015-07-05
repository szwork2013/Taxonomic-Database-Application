BEGIN;

-- User data
INSERT INTO users(id, address, email, enabled, first_name, last_name, password, phone_number, username, user_role_id) VALUES (1, NULL, 'superuser@fichasdeespecie.com', true, NULL, NULL,  'super',   NULL, 'super',   1);
INSERT INTO users(id, address, email, enabled, first_name, last_name, password, phone_number, username, user_role_id) VALUES (2, NULL, 'admin@fichasdeespecie.com',     true, NULL, NULL,  'admin',   NULL, 'admin',   2);
INSERT INTO users(id, address, email, enabled, first_name, last_name, password, phone_number, username, user_role_id) VALUES (3, NULL, 'expert@fichasdeespecie.com',    true, NULL, NULL,  'expert',  NULL, 'expert',  3);
INSERT INTO users(id, address, email, enabled, first_name, last_name, password, phone_number, username, user_role_id) VALUES (4, NULL, 'expert2@fichasdeespecie.com',   false, NULL, NULL, 'expert2', NULL, 'expert2', 3);
INSERT INTO users(id, address, email, enabled, first_name, last_name, password, phone_number, username, user_role_id) VALUES (5, NULL, 'public@fichasdeespecie.com',    false, NULL, NULL, 'public',  NULL, 'public',  4);
INSERT INTO users(id, address, email, enabled, first_name, last_name, password, phone_number, username, user_role_id) VALUES (6, NULL, 'public2@fichasdeespecie.com',   false, NULL, NULL, 'public2', NULL, 'public2', 4);

END;
