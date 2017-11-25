/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.OficinaDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.OficinaLogic;
import co.edu.uniandes.csw.viajes.entities.OficinaEntity;
import co.edu.uniandes.csw.viajes.persistence.OficinaPersistence;
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
@Path("oficinas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class OficinaResource {
    
    @Inject
    OficinaLogic oficinaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(OficinaPersistence.class.getName());

    /**
     * POST http://localhost:8080/viajesp-web/api/oficinas Ejemplo
     * json: { "name":"Norma" }
     *
     * @param oficina correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "oficinaDetailDTO", "id": 1, "name": "Norma" }
     */
    @POST
    public OficinaDetailDTO createOficina(OficinaDetailDTO oficina)  {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        OficinaEntity oficinaEntity = oficina.toEntity();
        // Invoca la lógica para crear la oficina nueva
        OficinaEntity nuevoOficina = oficinaLogic.createOficina(oficinaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new OficinaDetailDTO(nuevoOficina);
    }

    /**
     * GET para todas las oficinaes.
     * http://localhost:8080/viajes-web/api/oficinas
     *
     * @return la lista de todas las oficinaes en objetos json DTO.
     */
    @GET
    public List<OficinaDetailDTO> getOficinas(){
        return listEntity2DetailDTO(oficinaLogic.getOficinas());
    }

    /**
     * GET para una oficina
     * http://localhost:8080/viajesp-web/api/oficinas/1
     *
     * @param id corresponde al id de la oficina buscada.
     * @return La oficina encontrada. Ejemplo: { "type": "oficinaDetailDTO",
     * "id": 1, "name": "Norma" }
     * En caso de no existir el id de la oficina buscada se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public OficinaDetailDTO getOficina(@PathParam("id") Long id){
        OficinaEntity entity = oficinaLogic.getOficina(id);
        if (entity == null) {
            throw new WebApplicationException(mensajeError(id), 404);
        }
        return new OficinaDetailDTO(oficinaLogic.getOficina(id));
    }

    /**
     * PUT http://localhost:8080/viajesp-web/api/oficinas/1 Ejemplo
     * json { "id": 1, "name": "cambio de nombre" }
     *
     * @param id corresponde a la oficina a actualizar.
     * @param oficina corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La oficina actualizada.
     * En caso de no existir el id de la oficina a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public OficinaDetailDTO updateOficina(@PathParam("id") Long id, OficinaDetailDTO oficina)  {
        oficina.setId(id);
        OficinaEntity entity = oficinaLogic.getOficina(id);
        if (entity == null) {
            throw new WebApplicationException(mensajeError(id), 404);
        }
        return new OficinaDetailDTO(oficinaLogic.updateOficina(id, oficina.toEntity()));
    }

    /**
     * DELETE http://localhost:8080/viajesp-web/api/oficinas/1
     *
     * @param id corresponde a la oficina a borrar.
     * En caso de no existir el id de la oficina a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteOficina(@PathParam("id") Long id)  {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una oficina con id {0}", id);
        OficinaEntity entity = oficinaLogic.getOficina(id);
        if (entity == null) {
            throw new WebApplicationException(mensajeError(id), 404);
        }
        oficinaLogic.deleteOficina(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos OficinaEntity a una lista de
     * objetos OficinaDetailDTO (json)
     *
     * @param entityList corresponde a la lista de oficinaes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de oficinaes en forma DTO (json)
     */
    private List<OficinaDetailDTO> listEntity2DetailDTO(List<OficinaEntity> entityList) {
        List<OficinaDetailDTO> list = new ArrayList<>();
        for (OficinaEntity entity : entityList) {
            list.add(new OficinaDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Retorna un mensaje de error
     *
     * @param oficinaId el id del blog que no se encontro
     * @return lmensaje de error
     */
    private String mensajeError(Long oficinaId)
    {
        return "El recurso /oficinas/"+oficinaId+" no existe.";
    }
}
