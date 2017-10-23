/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.EntretenimientoDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.EntretenimientoLogic;
import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
import co.edu.uniandes.csw.viajes.persistence.EntretenimientoPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author m.rodriguez21
 */
@Path("entretenimientos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EntretenimientoResource {
    
    @Inject
    EntretenimientoLogic entretenimientoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(EntretenimientoPersistence.class.getName());

    /**
     * POST http://localhost:8080/viajesp-web/api/entretenimientos Ejemplo
     * json: { "name":"Norma" }
     *
     * @param entretenimiento correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "entretenimientoDetailDTO", "id": 1, "name": "Norma" }
     */
    @POST
    public EntretenimientoDetailDTO createEntretenimiento(EntretenimientoDetailDTO entretenimiento)  {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        EntretenimientoEntity entretenimientoEntity = entretenimiento.toEntity();
        // Invoca la lógica para crear la entretenimiento nueva
        EntretenimientoEntity nuevoEntretenimiento = entretenimientoLogic.createEntretenimiento(entretenimientoEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new EntretenimientoDetailDTO(nuevoEntretenimiento);
    }

    /**
     * GET para todas las entretenimientoes.
     * http://localhost:8080/viajes-web/api/entretenimientos
     *
     * @return la lista de todas las entretenimientoes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<EntretenimientoDetailDTO> getEntretenimientos(){
        return listEntity2DetailDTO(entretenimientoLogic.getEntretenimientos());
    }

    /**
     * GET para una entretenimiento
     * http://localhost:8080/viajesp-web/api/entretenimientos/1
     *
     * @param id corresponde al id de la entretenimiento buscada.
     * @return La entretenimiento encontrada. Ejemplo: { "type": "entretenimientoDetailDTO",
     * "id": 1, "name": "Norma" }
     * En caso de no existir el id de la entretenimiento buscada se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public EntretenimientoDetailDTO getEntretenimiento(@PathParam("id") Long id){
        EntretenimientoEntity entity = entretenimientoLogic.getEntretenimiento(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /entretenimientos/" + id + " no existe.", 404);
        }
        return new EntretenimientoDetailDTO(entretenimientoLogic.getEntretenimiento(id));
    }

    /**
     * PUT http://localhost:8080/viajesp-web/api/entretenimientos/1 Ejemplo
     * json { "id": 1, "name": "cambio de nombre" }
     *
     * @param id corresponde a la entretenimiento a actualizar.
     * @param entretenimiento corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La entretenimiento actualizada.
     * En caso de no existir el id de la entretenimiento a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public EntretenimientoDetailDTO updateEntretenimiento(@PathParam("id") Long id, EntretenimientoDetailDTO entretenimiento)  {
        entretenimiento.setId(id);
        EntretenimientoEntity entity = entretenimientoLogic.getEntretenimiento(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /entretenimientos/" + id + " no existe.", 404);
        }
        return new EntretenimientoDetailDTO(entretenimientoLogic.updateEntretenimiento(id, entretenimiento.toEntity()));
    }

    /**
     * DELETE http://localhost:8080/viajesp-web/api/entretenimientos/1
     *
     * @param id corresponde a la entretenimiento a borrar.
     * En caso de no existir el id de la entretenimiento a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEntretenimiento(@PathParam("id") Long id)  {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una entretenimiento con id {0}", id);
        EntretenimientoEntity entity = entretenimientoLogic.getEntretenimiento(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /entretenimientos/" + id + " no existe.", 404);
        }
        entretenimientoLogic.deleteEntretenimiento(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos EntretenimientoEntity a una lista de
     * objetos EntretenimientoDetailDTO (json)
     *
     * @param entityList corresponde a la lista de entretenimientoes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de entretenimientoes en forma DTO (json)
     */
    private List<EntretenimientoDetailDTO> listEntity2DetailDTO(List<EntretenimientoEntity> entityList) {
        List<EntretenimientoDetailDTO> list = new ArrayList<>();
        for (EntretenimientoEntity entity : entityList) {
            list.add(new EntretenimientoDetailDTO(entity));
        }
        return list;
    }    
}
