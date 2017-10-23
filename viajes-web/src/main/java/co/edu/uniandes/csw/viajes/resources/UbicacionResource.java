/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

/**
 *
 * @author ma.forero11
 */

import co.edu.uniandes.csw.viajes.dtos.UbicacionDTO;
import co.edu.uniandes.csw.viajes.dtos.UbicacionDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.UbicacionLogic;
import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;
import java.util.ArrayList;
import java.util.List;
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

@Path("ubicaciones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class UbicacionResource {
    @Inject
    UbicacionLogic ubicacionLogic;
    
    /**
     * GET para todas las ubicaciones.
     * http://localhost:8080/viajes-web/api/ubicaciones
     *
     * @return la lista de todas las ubicaciones en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<UbicacionDetailDTO> getUbicaciones() throws WebApplicationException{
        return listEntity2DetailDTO(ubicacionLogic.getUbicaciones());
    }
    
    /**
     * GET para una Ubicacion
     * http://localhost:8080/viajesp-web/api/ubicaciones/1
     *
     * @param id corresponde al id de la Ubicacion buscada.
     * @return La Ubicacion encontrada.
     * En caso de no existir el id de la Ubicacion buscada se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public UbicacionDetailDTO getUbicacion(@PathParam("id") Long id) throws WebApplicationException {
        UbicacionEntity toGet = ubicacionLogic.getUbicacion(id);
        if(toGet==null){
        throw new WebApplicationException("El recurso /ubicaciones/" + id + " no existe.", 404);
        }
        return new UbicacionDetailDTO(toGet);
    }
    
    /**
     * POST http://localhost:8080/viajesp-web/api/ubicaciones
     *
     * @param Ubicacion correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java.
     */
    @POST
    public UbicacionDetailDTO createUbicacion(UbicacionDetailDTO itinerarioDTO)throws WebApplicationException{
        UbicacionEntity itinerario = itinerarioDTO.toEntity();
        UbicacionEntity entity = ubicacionLogic.createUbicacion(itinerario);  
        return new UbicacionDetailDTO(entity);
    }
    
    /**
     * PUT http://localhost:8080/viajesp-web/api/ubicaciones/1
     *
     * @param id corresponde a la ubicacion a actualizar.
     * @param ubicacion corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La Ubicacion actualizada.
     * En caso de no existir el id de la Ubicacion a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public UbicacionDTO updateUbicacion(@PathParam("id") Long id, UbicacionDTO dto)throws WebApplicationException {
       dto.setId(id);
        UbicacionEntity entity = ubicacionLogic.getUbicacion(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /ubicaciones/" + id + " no existe.", 404);
        }
        return new UbicacionDetailDTO(ubicacionLogic.updateUbicacion(dto.toEntity())); 
    }
    
    /**
     * DELETE http://localhost:8080/viajesp-web/api/ubicaciones/1
     *
     * @param id corresponde a la Ubicacion a borrar.
     * En caso de no existir el id de la Ubicacion a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteUbicacion(@PathParam("id") Long id) throws WebApplicationException{
       UbicacionEntity entity = ubicacionLogic.getUbicacion(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /ubicaciones/" + id + " no existe.", 404);
        }
        ubicacionLogic.deleteUbicacion(id);
    }
    
    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos UbicacionEntity a una lista de
     * objetos UbicacionDetailDTO (json)
     *
     * @param entityList corresponde a la lista de ubicaciones de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de ubicaciones en forma DTO (json)
     */
    private List<UbicacionDetailDTO> listEntity2DetailDTO(List<UbicacionEntity> entityList) {
        List<UbicacionDetailDTO> list = new ArrayList<>();
        for (UbicacionEntity entity : entityList) {
            list.add(new UbicacionDetailDTO(entity));
        }
        return list;
    }
}