DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS departamento;

CREATE TABLE departamento(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre varchar(100),
    presupuesto int
);

CREATE TABLE empleado(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100),
    apellidos varchar(255),
    departamento int,
    FOREIGN KEY (departamento) REFERENCES departamento(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO departamento (nombre, presupuesto) VALUES ('I+D', 400);
INSERT INTO empleado (nombre, apellidos, departamento) VALUES ('facundo', 'silva castillo', 1);