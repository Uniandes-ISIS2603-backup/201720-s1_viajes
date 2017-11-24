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
    
    private List<EntretenimientoDetailDTO> EntretenimientosListEntity2DTO(List<EntretenimientoEntity> entityList){
       List<EntretenimientoDetailDTO> list = new ArrayList<>();
       for(EntretenimientoEntity entity : entityList){
           list.add(new EntretenimientoDetailDTO(entity));
       }
       return list;
    }
    
    private List<EntretenimientoEntity> entretenimientosListDTO2Entity(List<EntretenimientoDetailDTO> dtos){
        List<EntretenimientoEntity> list = new ArrayList<>();
        for (EntretenimientoDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    /**
     * Obtiene una colección de instancias de DetailDTO asociadas a una
     * instancia de Itinerario
     *
     * @param itinerariosId  Identificador de la instancia de Itinerario
     * @return Colección de instancias de DetailDTO asociadas a la
     * instancia de Itinerario
     * 
     */
    @GET
    public List<EntretenimientoDetailDTO> listEntretenimientos(@PathParam("itinerariosId") Long itinerariosId) {
        return EntretenimientosListEntity2DTO(itinerarioLogic.listEntretenimientos(itinerariosId));
    }
    
    /**
     * Obtiene una instancia de entretenimiento asociada a una instancia de itinerario
     *
     * @param itinerarioId  Identificador de la instancia de itinerario
     * @param entretenimientoId  Identificador de la instancia de entretenimiento
     * @return 
     * 
     */
    @GET
    @Path("{entretenimientosId: \\d+}")
    public EntretenimientoDetailDTO getEntretenimiento(@PathParam("itinerarioId") Long itinerarioId, @PathParam("entretenimientosId") Long entretenimientoId) throws WebApplicationException {
        return new EntretenimientoDetailDTO(itinerarioLogic.getEntretenimiento(itinerarioId, entretenimientoId));
    }
    
    /**
     * Asocia un entretenimiento existente a un itinerario
     *
     * @param entretenimientoId  Identificador de la instancia de entretenimiento
     * @param itinerarioId  Identificador de la instancia de itinerario
     * @return Instancia de DetailDTO que fue asociada a itinerario
     * 
     */
    @POST
    @Path("{entretenimientosId: \\d+}")
    public EntretenimientoDetailDTO addEntretenimiento(@PathParam("itinerarioId") Long itinerarioId, @PathParam("entretenimientosId") Long entretenimientoId) {
        return new EntretenimientoDetailDTO(itinerarioLogic.addEntretenimiento(itinerarioId, entretenimientoId));
    }
    
    /**
     * Desasocia un entretenimiento existente de un Itinerario existente
     *
     * @param itinerarioId  Identificador de la instancia de itinerario
     * @param entretenimientoId  Identificador de la instancia de entretenimiento
     * 
     */
    @DELETE
    @Path("{entretenimientosId: \\d+}")
    public void removeEntretenimiento(@PathParam("itinerarioId") Long itinerarioId, @PathParam("entretenimientosId") Long entretenimientoId) {
        itinerarioLogic.removeEntretenimiento(itinerarioId, entretenimientoId);
    }
    
    
    
    
}
