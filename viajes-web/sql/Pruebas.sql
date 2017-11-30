/*   
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  js.beltran14
 * Created: 19/09/2017
 */
delete from ITINERARIOENTITY_GUIAENTITY;
delete from ITINERARIOENTITY_ENTRETENIMIENTOENTITY;
delete from ITINERARIOENTITY_HOSPEDAJEENTITY;
delete from ITINERARIOENTITY_TRANSPORTEENTITY;
DELETE from companiaentity_oficinaentity;
delete from GuiaEntity;
delete from CompaniaEntity;
delete from HospedajeEntity_ImagenEntity;
delete from TransporteEntity_ImagenEntity;
delete from BlogEntity_ImagenEntity;
delete from EntretenimientoEntity_ImagenEntity;
delete from ImagenEntity;
delete from PagoEntity;
delete from TarjetaCreditoEntity;
delete from TransporteEntity;
delete from HospedajeEntity;
delete from EntretenimientoEntity;
delete from UsuarioEntity;
delete from BlogEntity;
delete from OficinaEntity;
delete from GuiaEntity;
delete from ItinerarioEntity;
delete from UbicacionEntity;

insert into BlogEntity (id, titulo, comentario) values (100,'Mi experiencia Green Day', 'La experiencia de ver a Green Day en vivo no se limita únicamente al mega show que dieron el pasado viernes 8 de octubre en las instalaciones de la Universidad Simón Bolivar.');

insert into BlogEntity (id, titulo, comentario) values (200,'Hello world!', 'Amo HTML, CSS, Angular y Bootstrap (not really)');

insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (100,'Oficina Avianca Chapinero', 'Alfonso Lopez');
insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (400,'Edificio Sotomayor SATENA', 'Gonzalo Jimenez');

insert into ImagenEntity (ID, COMENTARIO, RUTA) values (16,'El lago de los cisnes','resources/images/ballet.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (17,'Revolution radio poster','resources/images/greenday1.jpeg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (18,'Una experiencia inolvidable!','resources/images/greenday1.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (19,'G R E E N  D A Y','resources/images/greenday2.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (20,'El escenario','resources/images/greenday3.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (21,'Museo nacional','resources/images/museo.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (22,'Tigre de bengala - Zoologico','resources/images/zoo.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (23,'Hotel Rosas','resources/images/carr1.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (24,'Hotel Hard Rock - vista frontal','resources/images/carr2.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (25,'Habitación del hotel','resources/images/carr3.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (31,'Destino 1','resources/images/location-1.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (32,'Destino 2','resources/images/location-2.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (33,'Destino 3','resources/images/location-3.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (34,'Destino 4','resources/images/location-4.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (35,'Destino 5','resources/images/location-5.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (36,'Destino 6','resources/images/location-6.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (37,'Destino 7','resources/images/location-7.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (38,'Destino 8','resources/images/location-8.jpg');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (39,'Destino 9','resources/images/location-9.jpg');

insert into blogentity_imagenentity (blogentity_id, imagenes_id) values (100, 17);
insert into blogentity_imagenentity (blogentity_id, imagenes_id) values (100, 18);
insert into blogentity_imagenentity (blogentity_id, imagenes_id) values (100, 19);
insert into blogentity_imagenentity (blogentity_id, imagenes_id) values (100, 20);

insert into BlogEntity (id, titulo, comentario) values (7,'Mi primer blog', 'No se que escribir');
insert into BlogEntity (id, titulo, comentario) values (8,'Hello world!', 'I wanna be the very best');

insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (900,'Oficina Avianca Chapinero', 'Alfonso Lopez');
insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (10,'Edificio Sotomayor SATENA', 'Gonzalo Jimenez');

insert into UsuarioEntity (id, nombre)
values (413, 'Sergio Silva');

insert into UsuarioEntity (id, nombre)
values (414, 'Marlon Forero');

insert into UsuarioEntity (id, nombre)
values (415, 'Tatiana Huertas');

insert into UsuarioEntity (id, nombre)
values (416, 'Mariana Rodriguez');

insert into UsuarioEntity (id, nombre)
values (417, 'Sebastian Beltran');

insert into UsuarioEntity (id, nombre)
values (418, 'Juan Camilo Sanchez');

insert into UbicacionEntity (ID, LONGITUD, LATITUD, NOMBRE, DIRECCION, CIUDAD, PAIS)
 values (2, 12.0, 13.0, 'Hola', 'Calle', 'Bogota', 'Colombia');
insert into UbicacionEntity (ID, LONGITUD, LATITUD, NOMBRE, DIRECCION, CIUDAD, PAIS)
 values (1, 15.0, 16.0, 'Quiai', 'Avenida', 'Medellín', 'Colombia');

insert into TransporteEntity (ID, NOMBRE, VALOR, calificacion, descripcion, comentarios, fechafinal, fechainicio, tipo) values 
(100, 'Visita la capital del entretenimiento', 300000, 9.9, 'Una experiencia inolvidable. Ideal para familias', 'Sin comentarios','17/11/2017 16:30','17/11/2017 18:30',1);
insert into TransporteEntity (ID, NOMBRE, VALOR, calificacion, descripcion, comentarios, fechafinal, fechainicio, tipo) values 
(500, 'Tiquete a Venecia', 30000, 7.0, 'Una experiencia inolvidable. Ideal para familias', '17/11/2017 16:30','Sin comentarios','17/11/2017 18:30',1);
insert into TransporteEntity (ID, NOMBRE, VALOR, calificacion, descripcion, comentarios, fechafinal, fechainicio, tipo) values 
(200, 'Crucero por las Bahamas', 300000, 8.1, 'Una experiencia inolvidable. Ideal para familias', 'Sin comentarios','25/11/2017 10:30','30/11/2017 18:30',3);

insert into transporteentity_imagenentity (transporteentity_id, imagenes_id) values (100, 35);
insert into transporteentity_imagenentity (transporteentity_id, imagenes_id) values (100, 36);
insert into transporteentity_imagenentity (transporteentity_id, imagenes_id) values (100, 38);
insert into transporteentity_imagenentity (transporteentity_id, imagenes_id) values (100, 39);
insert into transporteentity_imagenentity (transporteentity_id, imagenes_id) values (500, 33);
insert into transporteentity_imagenentity (transporteentity_id, imagenes_id) values (500, 32);

insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion, ubicacion_id)
values (12, 'Fiesta en la casa de tatiana', '17/11/2017 16:30', '17/11/2017 22:30', 395, null, null, 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)', 2);
insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion, ubicacion_id)
values (100, 'Concierto Green Day', '17/11/2017 16:30', '17/11/2017 22:30', 395000, null, null, 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)', 1);
insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion, ubicacion_id)
values (600, 'Museo nacional', '17/11/2017 8:30', '17/11/2017 22:30', 20000, null, null, 'Exposicion por tiempo limitado', 2);
insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion, ubicacion_id)
values (700, 'Ballet El lago de los cisnes', '31/10/17 20:00', '31/10/17 22:00', 60000, 5, 'Lo disfrute de principio a fin', 'El Lago de los cisnes es uno de los ballets clásicos tradicionales más conocidos en todo el mundo.', 2);
insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion, ubicacion_id)
values (800, 'Zoologico ^_^', '31/10/17 20:00', '25/11/17 14:00', 20000,null, null, 'El mejor lugar para disfrutar de la fauna local. Tratamos a nuestros animales con el mejor cariño.', 2);

insert into entretenimientoentity_imagenentity (entretenimientoentity_id, imagenes_id) values (100, 17);
insert into entretenimientoentity_imagenentity (entretenimientoentity_id, imagenes_id) values (100, 18);
insert into entretenimientoentity_imagenentity (entretenimientoentity_id, imagenes_id) values (100, 19);
insert into entretenimientoentity_imagenentity (entretenimientoentity_id, imagenes_id) values (100, 20);
insert into entretenimientoentity_imagenentity (entretenimientoentity_id, imagenes_id) values (700, 16);
insert into entretenimientoentity_imagenentity (entretenimientoentity_id, imagenes_id) values (600, 21);
insert into entretenimientoentity_imagenentity (entretenimientoentity_id, imagenes_id) values (800, 22);

insert into TarjetaCreditoEntity (id, numero, fondos)
values (405, 1073175780, 900000000);
insert into TarjetaCreditoEntity (id, numero, fondos)
values (406, 1073175780, 900000000);

insert into PagoEntity (id, nombre, fecha, valor)
values (400, 'Fernando Huertas', '17/11/2017 16:30',600);

insert into PagoEntity (id, nombre, fecha, valor)
values (401, 'Jenny bolaños', '20/12/2017 17:30',500);

insert into CompaniaEntity (ID, EMAIL, TELEFONO, NOMBRE) values (12,'Desarrollo2017@uniandes.edu.co',9833219,'CesarInc');
insert into CompaniaEntity (ID, EMAIL, TELEFONO, NOMBRE) values (13,'quesoConBocadillo@uniandes.edu.co',342152,'JuanLtda');
insert into CompaniaEntity (ID, EMAIL, TELEFONO, NOMBRE) values (14,'avionesDisparatados@uniandes.edu.co',6421697,'DavidSAS');
insert into CompaniaEntity (ID, EMAIL, TELEFONO, NOMBRE) values (15,'jenjibreConUvasPasas@uniandes.edu.co',045602782,'ÓscarHnos');
insert into CompaniaEntity (ID, EMAIL, TELEFONO, NOMBRE) values (16,'habiaUnaVezUnaVentana@uniandes.edu.co',89156721,'Victor Manuel & Asociados');

insert into GuiaEntity (ID, LENGUAJE, VALOR, CONTRATOHORA, FECHAINICIO, FECHAFINAL, NOMBRE, CALIFICACION) values (14,'INGLES',20000,9000,'25/09/17','16/05/18', 'Juan', 5.0);
insert into GuiaEntity (ID, LENGUAJE, VALOR, CONTRATOHORA, FECHAINICIO, FECHAFINAL, NOMBRE, CALIFICACION) values (15,'FRANCES',75000,10000,'26/09/17','23/09/19', 'Tatiana', 4.5);
insert into GuiaEntity (ID, LENGUAJE, VALOR, CONTRATOHORA, FECHAINICIO, FECHAFINAL, NOMBRE, CALIFICACION) values (16,'INDÚ',94000,9000,'01/03/17','11/09/18', 'Carlos', 2.8);
insert into GuiaEntity (ID, LENGUAJE, VALOR, CONTRATOHORA, FECHAINICIO, FECHAFINAL, NOMBRE, CALIFICACION) values (17,'ÁRABE',12000,5000,'05/12/17','23/12/17', 'Alberto', 3.2);
insert into GuiaEntity (ID, LENGUAJE, VALOR, CONTRATOHORA, FECHAINICIO, FECHAFINAL, NOMBRE, CALIFICACION) values (18,'LATÍN',44000,8000,'12/11/17','12/12/17', 'Eustaquio', 4.6);

insert into HospedajeEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (100, 'Hotel Hard Rock', '12/01/2018 06:30', '30/02/2018 20:30', 1500000, 9.9, 'Impresionante, espectacular, increíble', 'Random descripción xd');
insert into HospedajeEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion, ubicacion_id)
values (200, 'Hotel Petunias', '17/11/2017 16:30', '17/11/2017 22:30', 500000, 7, 'Muy malo', 'Wifi gratis', 1);
insert into HospedajeEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion, ubicacion_id)
values (300, 'Hotel Margaritas', '12/12/2017 10:30', '20/12/2017 22:30', 1395000, 9.45, 'Espectacular', 'Buffet', 2);
insert into HospedajeEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (400, 'Hotel Rosas', '17/11/2017 16:30', '17/11/2017 22:30', 395000, 7.5, 'Muy bueno', 'Cerca de la playa');

insert into hospedajeentity_imagenentity (hospedajeentity_id, imagenes_id) values (400, 23);
insert into hospedajeentity_imagenentity (hospedajeentity_id, imagenes_id) values (100, 24);
insert into hospedajeentity_imagenentity (hospedajeentity_id, imagenes_id) values (100, 25);

insert into ItinerarioEntity (ID, FECHAINICIAL, FECHAFINAL, COSTOTOTAL, NUMEROVISITANTES) values (100,'01/01/17','02/02/17',1000,1);
insert into ItinerarioEntity (ID, FECHAINICIAL, FECHAFINAL, COSTOTOTAL, NUMEROVISITANTES) values (200,'02/02/17','03/03/17',2000,2);

insert into companiaentity_oficinaentity (companiaentity_id, oficinas_id) values (12, 10); 

insert into ITINERARIOENTITY_GUIAENTITY (ITINERARIOENTITY_ID, GUIAS_ID) values (100, 14);
insert into ITINERARIOENTITY_GUIAENTITY (ITINERARIOENTITY_ID, GUIAS_ID) values (100, 15);

insert into ITINERARIOENTITY_ENTRETENIMIENTOENTITY (ITINERARIOENTITY_ID, ENTRETENIMIENTOS_ID) values (100, 600);
insert into ITINERARIOENTITY_ENTRETENIMIENTOENTITY (ITINERARIOENTITY_ID, ENTRETENIMIENTOS_ID) values (100, 100);

insert into ITINERARIOENTITY_HOSPEDAJEENTITY (ITINERARIOENTITY_ID, HOSPEDAJES_ID) values (100, 100);
insert into ITINERARIOENTITY_HOSPEDAJEENTITY (ITINERARIOENTITY_ID, HOSPEDAJES_ID) values (100, 200);

insert into ITINERARIOENTITY_TRANSPORTEENTITY (ITINERARIOENTITY_ID, TRANSPORTES_ID) values (100, 100);
insert into ITINERARIOENTITY_TRANSPORTEENTITY (ITINERARIOENTITY_ID, TRANSPORTES_ID) values (100, 200);