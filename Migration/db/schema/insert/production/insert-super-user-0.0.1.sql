BEGIN;

-- UserRole data
INSERT INTO user_role(id, role, name) VALUES (1, 'ROLE_SUPER_USER', 'super');
INSERT INTO user_role(id, role, name) VALUES (2, 'ROLE_ADMIN', 'admin');
INSERT INTO user_role(id, role, name) VALUES (3, 'ROLE_EXPERT', 'expert');
INSERT INTO user_role(id, role, name) VALUES (4, 'ROLE_PUBLIC', 'public');

-- Permission data
INSERT INTO permission(id, name) VALUES (1, 'PERM_UPDATE_PERSONAL_INFO');
INSERT INTO permission(id, name) VALUES (2, 'PERM_CHANGE_PASSWORD');
INSERT INTO permission(id, name) VALUES (3, 'PERM_REQUEST_NEW_PASSWORD');
INSERT INTO permission(id, name) VALUES (4, 'PERM_CHANGE_LANGUAGE');
INSERT INTO permission(id, name) VALUES (5, 'PERM_CHANGE_USER_ROLE');
INSERT INTO permission(id, name) VALUES (6, 'PERM_ASSIGN_ROLE');
INSERT INTO permission(id, name) VALUES (7, 'PERM_DEACTIVATE_USER');
INSERT INTO permission(id, name) VALUES (8, 'PERM_ACTIVATE_USER');

-- Authority data
INSERT INTO authority(user_role_id, permission_id) VALUES (1, 1);
INSERT INTO authority(user_role_id, permission_id) VALUES (1, 2);
INSERT INTO authority(user_role_id, permission_id) VALUES (1, 3);
INSERT INTO authority(user_role_id, permission_id) VALUES (1, 4);
INSERT INTO authority(user_role_id, permission_id) VALUES (1, 5);
INSERT INTO authority(user_role_id, permission_id) VALUES (1, 6);
INSERT INTO authority(user_role_id, permission_id) VALUES (1, 7);
INSERT INTO authority(user_role_id, permission_id) VALUES (1, 8);

-- User data
INSERT INTO users(id, address, email, enabled, first_name, last_name, password, phone_number, username, user_role_id) VALUES (1, NULL, 'superuser@fichasdeespecie.com', true, NULL, NULL,  'super',   NULL, 'super',   1);

END;