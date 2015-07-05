BEGIN;

-- Map data
INSERT INTO map(id, author, caption, date, description, file, set_as_cover, projection, type) VALUES (1, 'Brazil', 'Brazil', '2015-01-01', 'Brazil Map', NULL, true, 'National', 'Map');
INSERT INTO map(id, author, caption, date, description, file, set_as_cover, projection, type) VALUES (2, 'Eua', 'Eua', '2015-01-01', 'Eua Map', NULL, true, 'National', 'Map');
INSERT INTO map(id, author, caption, date, description, file, set_as_cover, projection, type) VALUES (3, 'England', 'England', '2015-01-01', 'England Map', NULL, true, 'National', 'Map');

END;
