/* Creamos algunas regiones */
INSERT INTO region (nombre, create_at) VALUES ('Ciudad Real', NOW());
INSERT INTO region (nombre, create_at) VALUES ('Miguelturra', NOW());
INSERT INTO region (nombre, create_at) VALUES ('Puertollano', NOW());

/* Creamos algunos clientes */
INSERT INTO cliente (nombre, apellidos, email, telefono, create_at) VALUES ('Pepe', 'Vile Mes', 'pepe@gmail.com', '666666660', NOW());
INSERT INTO cliente (nombre, apellidos, email, telefono, create_at, id_region) VALUES ('Iván', 'Domínguez Villacreces', 'ivan@gmail.com', '666666661', NOW(), 1);
INSERT INTO cliente (nombre, apellidos, email, telefono, create_at, id_region) VALUES ('Laura', 'Torres', 'laura@gmail.com', '666666662', NOW(), 1);
INSERT INTO cliente (nombre, apellidos, email, telefono, create_at, id_region) VALUES ('Sergio', 'De la Torre', 'sergio@gmail.com', '666666663', NOW(), 1);
INSERT INTO cliente (nombre, apellidos, email, telefono, create_at, id_region) VALUES ('Silvia', 'Mayor Ecuda', 'silvia@gmail.com', '666666664', NOW(), 1);
INSERT INTO cliente (nombre, apellidos, email, telefono, create_at, id_region) VALUES ('Ana', 'Fernández Oliva', 'ana@gmail.com', '666666665', NOW(), 1);
INSERT INTO cliente (nombre, apellidos, email, telefono, create_at, id_region) VALUES ('Lucas', 'Casas', 'lucas@gmail.com', '666666666', NOW(), 1);
INSERT INTO cliente (nombre, apellidos, email, telefono, create_at, id_region) VALUES ('Roberto', 'Alto Crespo', 'roberto@gmail.com', '666666667', NOW(), 2);
INSERT INTO cliente (nombre, apellidos, email, telefono, create_at, id_region) VALUES ('Ruma', 'Bajo Mes', 'ruma@gmail.com', '666666668', NOW(), 2);
INSERT INTO cliente (nombre, apellidos, email, telefono, create_at, id_region) VALUES ('Lucia', 'Raton Pesto', 'lucia@gmail.com', '666666669', NOW(), 3);