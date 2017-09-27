/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  ma.forero11
 * Created: 19/09/2017
 */

delete from HospedajeEntity;

insert into HospedajeEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (100, 'Hotel Rosas', '17/11/2017 16:30', '17/11/2017 22:30', 395, 10, 'Muy bueno', 'Cama doble');

insert into HospedajeEntity (id, nombre, fechaInicio, fechaFinal, valor, calificacion, comentarios, descripcion)
values (200, 'Hotel Petunias', '17/11/2017 16:30', '17/11/2017 22:30', 500, 7, 'Muy malo', 'Cama triple');
