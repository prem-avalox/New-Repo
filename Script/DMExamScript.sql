-- database: ../DataBase/MDDataBase.sqlite
DROP TABLE IF EXISTS DMLocacion;

DROP TABLE IF EXISTS DMAnimal;

DROP TABLE IF EXISTS DMCatalogo;

DROP TABLE IF EXISTS DMTipoCatalogo;

CREATE TABLE
    DMTipoCatalogo (
        idTipoCatalogo INTEGER PRIMARY KEY AUTOINCREMENT,
        nombreTipoCatalogo VARCHAR(50) NOT NULL,
        Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
        FechaCreacion DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica DATETIME
    );

CREATE TABLE
    DMCatalogo (
        idCatalogo INTEGER PRIMARY KEY AUTOINCREMENT,
        idTipo INTEGER NOT NULL REFERENCES DMTipoCatalogo (IdTipoCatalogo),
        nombreCatalogo VARCHAR(50) NOT NULL,
        Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
        FechaCreacion DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica DATETIME
    );

CREATE TABLE
    DMAnimal (
        idAnimal INTEGER PRIMARY KEY AUTOINCREMENT,
        Nombre VARCHAR (50) NOT NULL,
        NombreCientifico VARCHAR (50) NOT NULL,
        idCatalogoSexo INTEGER NOT NULL REFERENCES DMCatalogo (idCatalogo),
        idCatalogoClasificacion INTEGER NOT NULL REFERENCES DMCatalogo (idCatalogo),
        idCatalogoGenoAlimento INTEGER NOT NULL REFERENCES DMCatalogo (idCatalogo),
        Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
        FechaCreacion DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica DATETIME
    );

CREATE TABLE
    DMLocacion (
        idLocacion INTEGER PRIMARY KEY AUTOINCREMENT,
        Pais VARCHAR(20) NOT NULL,
        Region VARCHAR(20) NOT NULL ,
        Provincia VARCHAR(20) NOT NULL UNIQUE,
        Estado VARCHAR(1) NOT NULL DEFAULT ('A'),
        FechaCreacion DATETIME DEFAULT (datetime('now', 'localtime')),
        FechaModifica DATETIME
    );

INSERT INTO DMTipoCatalogo
(nombreTipoCatalogo )VALUES
('Sexo'),
('Clasificacion'),
('GenoAlimento');
INSERT INTO DMCatalogo
(idTipo, nombreCatalogo )VALUES
(1, 'Macho'),
(1, 'Hembra'),
(1, 'Asexual'),
(2, 'Ave'),
(2, 'Pez'),
(2, 'Mamifero'),
(3, 'AX'),
(3, 'AXX'),
(3, 'AXY');

INSERT INTO DMLocacion
(Pais, Region, Provincia)VALUES
('Ecuador', 'Costa', 'Esmeraldas'),
('Ecuador', 'Costa', 'Manabí'),
('Ecuador', 'Costa', 'Guayas'),
('Ecuador', 'Costa', 'Santa Elena'),
('Ecuador', 'Costa', 'Los Ríos'),
('Ecuador', 'Costa', 'El Oro'),
('Ecuador', 'Costa', 'Santo Domingo de los Tsáchilas'),
('Ecuador', 'Sierra', 'Carchi'),
('Ecuador', 'Sierra', 'Imbabura'),
('Ecuador', 'Sierra', 'Pichincha'),
('Ecuador', 'Sierra', 'Cotopaxi'),
('Ecuador', 'Sierra', 'Tungurahua'),
('Ecuador', 'Sierra', 'Chimborazo'),
('Ecuador', 'Sierra', 'Bolívar'),
('Ecuador', 'Sierra', 'Cañar'),
('Ecuador', 'Sierra', 'Azuay'),
('Ecuador', 'Sierra', 'Loja'),
('Ecuador', 'Oriente', 'Sucumbíos'),
('Ecuador', 'Oriente', 'Napo'),
('Ecuador', 'Oriente', 'Orellana'),
('Ecuador', 'Oriente', 'Pastaza'),
('Ecuador', 'Oriente', 'Morona Santiago'),
('Ecuador', 'Oriente', 'Zamora Chinchipe'),
('Ecuador', 'Insular', 'Galápagos');

INSERT INTO DMAnimal
(Nombre, NombreCientifico, idCatalogoSexo, idCatalogoClasificacion, idCatalogoGenoAlimento )VALUES
('Aguila', 'Aguilitus', 1, 4, 8),
('Toro', 'Bos', 2, 6, 9);
SELECT idAnimal, nombre, nombreCientifico, idCatalogoSexo, idCatalogoClasificacion, idCatalogoGenoAlimento, Estado, FechaCreacion, FechaModifica FROM DMAnimal WHERE Estado = 'A';







