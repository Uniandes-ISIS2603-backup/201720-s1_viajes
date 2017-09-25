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

insert into BlogEntity (id, titulo, comentario) values (100,'Mi primer blog', 'No se que escribir');
insert into BlogEntity (id, titulo, comentario) values (200,'Hello world!', 'I wanna be the very best');

delete from OficinaEntity;

insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (100,'Oficina Avianca Chapinero', 'Alfonso Lopez');
insert into OficinaEntity (id, nombreLugar, nombreEncargado) values (200,'Edificio Sotomayor SATENA', 'Gonzalo Jimenez');

delete from EntretenimientoEntity;

insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion) values (100, 'Concierto Green Day', '17/11/2017 16:30', '17/11/2017 22:30', 395, null, '', 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)');
insert into EntretenimientoEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion) values (200, 'Concierto Green Day', '17/11/2017 16:30', '17/11/2017 22:30', 395, null, '', 'Al aire libre, sin asiento fijo. Localidad: Revolution (VIP)');

