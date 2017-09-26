/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  js.beltran14
 * Created: 19/09/2017
 */

delete from ServicioEntity;
delete from ItinerarioEntity;


insert into ItinerarioEntity (ID, FECHAINICIAL, FECHAFINAL, COSTOTOTAL, NUMEROVISITANTES) values (1,'01/01/17','02/02/17',1000,1);
insert into ItinerarioEntity (ID, FECHAINICIAL, FECHAFINAL, COSTOTOTAL, NUMEROVISITANTES) values (2,'02/02/17','03/03/17',2000,2);


insert into ServicioEntity (ID, CALIFICACION, COMENTARIOS, DESCRIPCION, FECHAFINAL, FECHAINICIO, NOMBRE, VALOR, ITINERARIO_ID) 
values (1,5,'HOLA','HOLA','02/02/17','01/01/17','HOTEL',1000,1);
