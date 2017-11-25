/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.EntretenimientoDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.ItinerarioLogic;
import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
import java.util.ArrayList;
import java.util.List;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author js.beltran14
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItinerarioEntretenimientosResource {
    
    @Inject
    ItinerarioLogic itinerarioLogic;
    
    /**
     * Convierte una lista de EntretenimientoEntity a una lista de EntretenimientoDetailDTO.
     *
     * @param entityList Lista de EntretenimientoEntity a convertir.
     * @return Lista de EntretenimientoDetailDTO convertida.
     * 
     */
    private List<EntretenimientoDetailDTO> EntretenimientosListEntity2DTO(List<EntretenimientoEntity> entityList){
       List<EntretenimientoDetailDTO> list = new ArrayList<>();
       for(EntretenimientoEntity entity : entityList){
           list.add(new EntretenimientoDetailDTO(entity));
       }
       return list;
    }
    
    /**
     * Convierte una lista de EntretenimientoDetailDTO a una lista de EntretenimientoEntity.
     *
     * @param dtos Lista de EntretenimientoDetailDTO a convertir.
     * @return Lista de EntretenimientoEntity convertida.
     * 
     */
    private List<EntretenimientoEntity> entretenimientosListDTO2Entity(List<EntretenimientoDetailDTO> dtos){
        List<EntretenimientoEntity> list = new ArrayList<>();
        for (EntretenimientoDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    /**
     * Obtiene una colección de instancias de EntretenimientoDetailDTO asociadas a una
     * instancia de Entretetenimiento
     *
     * @param itinerarioId Identificador de la instancia de Entretetenimiento
     * @return Colección de instancias de EntretenimientoDetailDTO asociadas a la
     * instancia de Entretetenimiento
     * 
     */
    @GET
    public List<EntretenimientoDetailDTO> listGuias(@PathParam("itinerarioId") Long itinerarioId) {
        return EntretenimientosListEntity2DTO(itinerarioLogic.listEntretenimientos(itinerarioId));
    }
    
    /**
     * Obtiene una instancia de Entretenimiento asociada a una instancia de Entretetenimiento
     *
     * @param itinerarioId Identificador de la instancia de Entretetenimiento
     * @param entretenimientoId Identificador de la instancia de Entretenimiento
     * @return 
     * 
     */
    @GET
    @Path("{entretenimientosId: \\d+}")
    public EntretenimientoDetailDTO getEntretenimiento(@PathParam("itinerarioId") Long itinerarioId, @PathParam("entretenimientosId") Long entretenimientoId) throws WebApplicationException {
        return new EntretenimientoDetailDTO(itinerarioLogic.getEntretenimiento(itinerarioId, entretenimientoId));
    }
    
    /**
     * Asocia un Entretenimiento existente a un Entretetenimiento
     *
     * @param itinerarioId Identificador de la instancia de Entretetenimiento
     * @param entretenimientoId Identificador de la instancia de Entretenimiento
     * @return Instancia de EntretenimientoDetailDTO que fue asociada a Entretetenimiento
     * 
     */
    @POST
    @Path("{entretenimientosId: \\d+}")
    public EntretenimientoDetailDTO addEntretenimiento(@PathParam("itinerarioId") Long itinerarioId, @PathParam("entretenimientosId") Long entretenimientoId) {
        return new EntretenimientoDetailDTO(itinerarioLogic.addEntretenimiento(itinerarioId, entretenimientoId));
    }
    
    /**
     * Remplaza las instancias de Entretenimiento asociadas a una instancia de Entretetenimiento
     *
     * @param eitinerarioId Identificador de la instancia de Entretetenimiento
     * @param entretenimientos Colección de instancias de EntretenimientoDTO a asociar a instancia
     * de Entretetenimiento
     * @return Nueva colección de EntretenimientoDTO asociada a la instancia de Entretetenimiento
     * 
     */
    @PUT
    public List<EntretenimientoDetailDTO> replaceEntretenimiento(@PathParam("itinerarioId") Long itinerarioId, List<EntretenimientoDetailDTO> entretenimientos) {
        return EntretenimientosListEntity2DTO(itinerarioLogic.replaceEntretenimientos(itinerarioId, entretenimientosListDTO2Entity(entretenimientos)));
    }
    
    /**
     * Desasocia un Entretenimiento existente de un Entretetenimiento existente
     *
     * @param itinerarioId Identificador de la instancia de Entretetenimiento
     * @param entretenimientoId Identificador de la instancia de Entretenimiento
     * 
     */
    @DELETE
    @Path("{entretenimientoId: \\d+}")
    public void removeEntretenimiento(@PathParam("itinerarioId") Long itinerarioId, @PathParam("entretenimientoId") Long entretenimientoId) {
        itinerarioLogic.removeEntretenimiento(itinerarioId, entretenimientoId);
    }
    
    
    
    
}
