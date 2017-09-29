/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  js.beltran14
 * Created: 19/09/2017
 */
delete from GuiaEntity;
delete from CompaniaEntity;
delete from HospedajeEntity;
delete from ImagenEntity;
delete from PagoEntity;
delete from TarjetaCreditoEntity;
delete from TransporteEntity;
delete from UbicacionEntity;
delete from UsuarioEntity;
delete from BlogEntity;
delete from BlogEntity;
delete from EntretenimientoEntity;
delete from OficinaEntity;


insert into BlogEntity (id, titulo, comentario) values (1,'Mi primer blog', 'No se que escribir');
insert into BlogEntity (id, titulo, comentario) values (2,'Hello world!', 'I wanna be the very best');


insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (3,'Oficina Avianca Chapinero', 'Alfonso Lopez');
insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (4,'Edificio Sotomayor SATENA', 'Gonzalo Jimenez');

insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (5, 'Concierto Green Day', '17/11/2017 16:30', '17/11/2017 22:30', 395, null, null, 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)');
insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (6, 'Concierto Green Day', '17/11/2017 16:30', '17/11/2017 22:30', 395, null, null, 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)');


insert into BlogEntity (id, titulo, comentario) values (7,'Mi primer blog', 'No se que escribir');
insert into BlogEntity (id, titulo, comentario) values (8,'Hello world!', 'I wanna be the very best');

delete from OficinaEntity;

insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (9,'Oficina Avianca Chapinero', 'Alfonso Lopez');
insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (10,'Edificio Sotomayor SATENA', 'Gonzalo Jimenez');


insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (11, 'Concierto Green Day', '17/11/2017 16:30', '17/11/2017 22:30', 395, null, null, 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)');
insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (12, 'Fiesta en la casa de tatiana', '17/11/2017 16:30', '17/11/2017 22:30', 395, null, null, 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)');


insert into UsuarioEntity (id, nombre)
values (409, 'Tatiana Huertas');

insert into UsuarioEntity (id, nombre)
values (410, 'Mariana Rodriguez');

insert into UbicacionEntity (ID, LONGITUD, LATITUD, NOMBRE, DIRECCION, CIUDAD, PAIS)
 values (9, 12.0, 13.0, 'Hola', 'Calle', 'Bogota', 'Colombia');
insert into UbicacionEntity (ID, LONGITUD, LATITUD, NOMBRE, DIRECCION, CIUDAD, PAIS)
 values (12, 15.0, 16.0, 'Quiai', 'Avenida', 'Medellín', 'Colombia');


insert into TransporteEntity (ID, NOMBRE, VALOR) values (1, 'Santa fe es muy malo', 15000.158);
insert into TransporteEntity (ID, NOMBRE, VALOR) values (2, 'Eliminados de la sudamericana', 6550.56);

insert into TarjetaCreditoEntity (id, numero, fondos)
values (405, 1073175780, 900000000);

insert into TarjetaCreditoEntity (id, numero, fondos)
values (406, 1073175780, 900000000);

insert into PagoEntity (id, nombre, fecha, valor)
values (400, 'Fernando Huertas', '17/11/2017 16:30',600);

insert into PagoEntity (id, nombre, fecha, valor)
values (401, 'Jenny bolaños', '20/12/2017 17:30',500);

insert into CompaniaEntity (ID, EMAIL, TELEFONO, NOMBRE) values (12,'Desarrollo2017@uniandes.edu.co',9833219,'Cesar');
insert into CompaniaEntity (ID, EMAIL, TELEFONO, NOMBRE) values (13,'Jarjar@uniandes.edu.co',458434832,'Juan');

insert into GuiaEntity (ID, LENGUAJE, VALOR, CONTRATOHORA, FECHAINICIO, FECHAFINAL, NOMBRE, CALIFICACION) values (14,'INGLES',2000,9000,'25/09/17','25/09/17', 'Juan', 5.0);
insert into GuiaEntity (ID, LENGUAJE, VALOR, CONTRATOHORA, FECHAINICIO, FECHAFINAL, NOMBRE, CALIFICACION) values (15,'FRANCES',7000,10000,'26/09/17','26/09/17', 'Tatiana', 2.5);

insert into HospedajeEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (100, 'Hotel Rosas', '17/11/2017 16:30', '17/11/2017 22:30', 395, 10, 'Muy bueno', 'Cama doble');

insert into HospedajeEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (200, 'Hotel Petunias', '17/11/2017 16:30', '17/11/2017 22:30', 500, 7, 'Muy malo', 'Cama triple');

insert into ImagenEntity (ID, COMENTARIO, RUTA) values (16,'Hola 1','Ruta1');
insert into ImagenEntity (ID, COMENTARIO, RUTA) values (17,'Hola 2','Ruta2');