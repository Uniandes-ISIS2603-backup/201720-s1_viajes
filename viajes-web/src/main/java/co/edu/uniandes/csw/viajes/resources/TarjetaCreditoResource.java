/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.EntretenimientoDetailDTO;
import co.edu.uniandes.csw.viajes.dtos.TarjetaCreditoDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Vanessa Huertas <tv.huertas10>
 */
@Path("tarjetas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class TarjetaCreditoResource {
    
    /**
     * Acceso a la lógica de la aplicación
     */
    @Inject
    TarjetaCreditoLogic tarjetaLogic;
    
    /**
     * POST http://localhost:8080/viajesp-web/api/tarjetas Ejemplo
     * json: { "name":"Norma" }
     *
     * @param tarjeta correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "tarjetaDetailDTO", "id": 1, "name": "Norma" }
     */
    @POST
    public TarjetaCreditoDetailDTO createTarjeta(TarjetaCreditoDetailDTO tarjeta)  {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        TarjetaCreditoEntity tarjetaEntity = tarjeta.toEntity();
        // Invoca la lógica para crear la tarjeta nueva
        TarjetaCreditoEntity nuevaTarjeta = tarjetaLogic.createTarjetaCredito(tarjetaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new TarjetaCreditoDetailDTO(nuevaTarjeta);
    }

    /**
     * GET para todas las tarjetas.
     * http://localhost:8080/viajes-web/api/tarjetas
     *
     * @return la lista de todas las tarjetas en objetos json DTO.
     * @throws WebApplicationException
     */
    @GET
    public List<TarjetaCreditoDetailDTO> getTarjetas(){
        return listEntity2DetailDTO(tarjetaLogic.getTarjetasCredito());
    }

    /**
     * GET para una tarjeta
     * http://localhost:8080/viajesp-web/api/tarjetas/1
     *
     * @param id corresponde al id de la tarjeta buscada.
     * @return La tarjeta encontrada. Ejemplo: { "type": "tarjetaDetailDTO",
     * "id": 1, "name": "Norma" }
     * En caso de no existir el id de la tarjeta buscada se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public TarjetaCreditoDetailDTO getTarjeta(@PathParam("id") Long id){
        TarjetaCreditoEntity entity = tarjetaLogic.getTarjetaCredito(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /tarjetas/" + id + " no existe.", 404);
        }
        return new TarjetaCreditoDetailDTO(tarjetaLogic.getTarjetaCredito(id));
    }

    /**
     * PUT http://localhost:8080/viajesp-web/api/tarjetas/1 Ejemplo
     * json { "id": 1, "name": "cambio de nombre" }
     *
     * @param id corresponde a la tarjeta a actualizar.
     * @param tarjeta corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La tarjeta actualizada.
     * En caso de no existir el id de la tarjeta a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public TarjetaCreditoDetailDTO updateTarjeta(@PathParam("id") Long id, TarjetaCreditoDetailDTO tarjeta)  {
        tarjeta.setId(id);
        TarjetaCreditoEntity entity = tarjetaLogic.getTarjetaCredito(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /tarjetas/" + id + " no existe.", 404);
        }
        return new TarjetaCreditoDetailDTO(tarjetaLogic.updateTarjetaCredito(id, tarjeta.toEntity()));
    }

    /**
     * DELETE http://localhost:8080/viajesp-web/api/tarjetas/1
     *
     * @param id corresponde a la tarjeta a borrar.
     * En caso de no existir el id de la tarjeta a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTarjeta(@PathParam("id") Long id)  {
        TarjetaCreditoEntity entity = tarjetaLogic.getTarjetaCredito(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /tarjetas/" + id + " no existe.", 404);
        }
        tarjetaLogic.deleteTarjetaCredito(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos TarjetaCreditoEntity a una lista de
     * objetos TarjetaCreditoDetailDTO (json)
     *
     * @param entityList corresponde a la lista de tarjetas de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de tarjetas en forma DTO (json)
     */
    private List<TarjetaCreditoDetailDTO> listEntity2DetailDTO(List<TarjetaCreditoEntity> entityList) {
        List<TarjetaCreditoDetailDTO> list = new ArrayList<>();
        for (TarjetaCreditoEntity entity : entityList) {
            list.add(new TarjetaCreditoDetailDTO(entity));
        }
        return list;
    }
}
