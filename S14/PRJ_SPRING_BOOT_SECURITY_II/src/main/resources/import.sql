INSERT INTO cursos (nombre, creditos) VALUES ('Programmer', 3);
INSERT INTO cursos (nombre, creditos) VALUES ('Developer', 5);
INSERT INTO cursos (nombre, creditos) VALUES ('Expert', 5);

INSERT INTO users (username, password, enabled) VALUES ('fhuaytalla', '$2a$10$4Q28v/yMUDdJqWIW.K6ugOoB1zCeSd6cdvKS41TfDtBJMan8PK736', true);
INSERT INTO users (username, password, enabled) VALUES ('admin',    '$2a$10$pSCD1xwu4T9QN10QT.MOqOq96w36bhtpvFekmGYrt4FK2oD6BP1ZW', true);

INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_USER');