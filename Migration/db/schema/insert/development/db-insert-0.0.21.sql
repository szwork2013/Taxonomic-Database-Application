BEGIN;

-- Permission data
INSERT INTO permission(id, name) VALUES (1, 'PERM_UPDATE_PERSONAL_INFO');
INSERT INTO permission(id, name) VALUES (2, 'PERM_CHANGE_PASSWORD');
INSERT INTO permission(id, name) VALUES (3, 'PERM_REQUEST_NEW_PASSWORD');
INSERT INTO permission(id, name) VALUES (4, 'PERM_CHANGE_LANGUAGE');
INSERT INTO permission(id, name) VALUES (5, 'PERM_CHANGE_USER_ROLE');
INSERT INTO permission(id, name) VALUES (6, 'PERM_ASSIGN_ROLE');
INSERT INTO permission(id, name) VALUES (7, 'PERM_DEACTIVATE_USER');
INSERT INTO permission(id, name) VALUES (8, 'PERM_ACTIVATE_USER');

END;
