show tables;

CREATE DATABASE bd_phone_store;

/*Crear tabla*/
CREATE TABLE CELULARES (

	id int,
	marca varchar(100),
	modelo varchar(100),
	procesador varchar(50),
	memoria varchar(50),
	almacenamiento varchar(50),
	descripcion text,
	precio varchar(50),
	estado  int
);

/* Añadimos id como primary Key*/
ALTER TABLE CELULARES ADD PRIMARY KEY (id) ;

/* Hacemos el campo id autoincremental y que no permita registros null*/
ALTER TABLE CELULARES MODIFY COLUMN id int auto_increment NOT NULL;


/*Insertar*/
INSERT INTO CELULARES (marca,modelo,procesador,memoria,almacenamiento,descripcion,precio,estado)
VALUES ('Motorola','Moto EDGE 20 Lite','MediaTek 720','6GB','128GB','Este celular inteligente tiene un diseño elegante fácilmente perceptible.','2269.00',1);

INSERT INTO CELULARES (marca,modelo,procesador,memoria,almacenamiento,descripcion,precio,estado)
VALUES ('Apple','iPhone 13 Midnight Negocios','Chip A15 Bionic','8GB','256GB','Apple ya nos tiene acostumbrado a este concepto desde sus predecesores.','7120.00',1);

INSERT INTO CELULARES (marca,modelo,procesador,memoria,almacenamiento,descripcion,precio,estado)
VALUES ('Xiaomi','Redmi 10C','Snapdragon 680','4GB','64GB','Un nuevo modelo por el diseño de un módulo cuadrado en la cual se encuentran las cámaras doble.','819.00',1);

INSERT INTO CELULARES (marca,modelo,procesador,memoria,almacenamiento,descripcion,precio,estado)
VALUES ('Samsung','Galaxy S22','Snapdragon 8 Gen 1','8GB','128GB','Es un dispositivo que integra el procesador Snapdragon 8 Gen 1 de ocho núcleos con velocidad de procesamiento.','3720.00',1);

INSERT INTO CELULARES (marca,modelo,procesador,memoria,almacenamiento,descripcion,precio,estado)
VALUES ('Apple','iPhone 11','Chip A13 Bionic','4GB','64GB','Su cámara angular incluye tecnología 100% Focus Pixeles.','3800.00',1);

/*Actualizar*/
UPDATE celulares SET precio = '3800.00' WHERE id = 5;

/*Consultar*/
SELECT * FROM CELULARES;


/*Procedimiento almacenado para registrar nuevo celular*/
DELIMITER //
CREATE PROCEDURE ingresarCelular(IN p_marca varchar(100), IN p_modelo varchar(100),
 IN p_procesador varchar(50), IN p_memoria varchar(50), IN p_almacenamiento varchar(50),
 IN p_descripcion text, IN p_precio varchar(50), IN p_estado INT,
 OUT resultado_antes INT, OUT resultado_despues INT)
BEGIN
	SELECT COUNT(*) INTO resultado_antes FROM CELULARES
    INSERT INTO CELULARES (marca, modelo, procesador, memoria, almacenamiento, descripcion, precio, estado)
	VALUES (p_marca, p_modelo, p_procesador, p_memoria, p_almacenamiento, p_descripcion, p_precio, p_estado);
	SELECT COUNT(*) INTO resultado_despues FROM CELULARES
END;
delimiter ;

CALL ingresarCelular('Marca prueba','Modelo prueba','Procesador prueba','Memoria prueba',
'Almacenamiento prueba','Descripción prueba','Precio prueba',1, @outResultAntes, @outResultDespues);
SELECT @outResultAntes as "Registros Antes", @outResultDespues as "Registros despues";


/*Procedimiento almacenado para eliminar un registro*/
DELIMITER //
CREATE PROCEDURE eliminarCelular(IN p_id INT, OUT resultado_antes INT, OUT resultado_despues INT)
BEGIN
	SELECT COUNT(*) INTO resultado_antes FROM CELULARES;
	DELETE FROM CELULARES
	WHERE id = p_id;
	SELECT COUNT(*) INTO resultado_despues FROM CELULARES;
END;
delimiter ;

CALL eliminarCelular(4, @outResultAntes, @outResultDespues);
SELECT @outResultAntes as "Registros Antes", @outResultDespues as "Registros despues";

SELECT * FROM CELULARES ORDER BY id DESC LIMIT 1;