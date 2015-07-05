BEGIN;

-- UserRole data
INSERT INTO user_role(id, role, name) VALUES (1, 'ROLE_SUPER_USER', 'super');
INSERT INTO user_role(id, role, name) VALUES (2, 'ROLE_ADMIN', 'admin');
INSERT INTO user_role(id, role, name) VALUES (3, 'ROLE_EXPERT', 'expert');
INSERT INTO user_role(id, role, name) VALUES (4, 'ROLE_PUBLIC', 'public');

END;
