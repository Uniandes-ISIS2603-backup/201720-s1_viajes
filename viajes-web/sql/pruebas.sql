/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  m.rodriguez21
 * Created: 19/09/2017
 */

delete from BlogEntity;

<<<<<<< HEAD
insert into BlogEntity (id, titulo, comentario) values (100,'Mi primer blog', 'No se que escribir');
insert into BlogEntity (id, titulo, comentario) values (200,'Hello world!', 'I wanna be the very best');
=======
insert into BlogEntity (id, titulo, comentario) values (1,'Mi primer blog', 'No se que escribir');
insert into BlogEntity (id, titulo, comentario) values (2,'Hello world!', 'I wanna be the very best');
>>>>>>> m.rodriguez21

delete from OficinaEntity;

insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (1,'Oficina Avianca Chapinero', 'Alfonso Lopez');
insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (2,'Edificio Sotomayor SATENA', 'Gonzalo Jimenez');

delete from EntretenimientoEntity;

<<<<<<< HEAD
insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion) values (100, 'Concierto Green Day', '17/11/2017 16:30', '17/11/2017 22:30', 395, null, '', 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)');
insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion) values (200, 'Concierto Green Day', '17/11/2017 16:30', '17/11/2017 22:30', 395, null, '', 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)');
=======
insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (1, 'Concierto Green Day', '17/11/2017 16:30', '17/11/2017 22:30', 395, null, null, 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)');
insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (2, 'Concierto Green Day', '17/11/2017 16:30', '17/11/2017 22:30', 395, null, null, 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)');
>>>>>>> m.rodriguez21

