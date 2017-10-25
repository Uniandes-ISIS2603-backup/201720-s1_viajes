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
    
    @GET
    public List<EntretenimientoDetailDTO> listGuias(@PathParam("itinerariosId") Long itinerariosId) {
        return EntretenimientosListEntity2DTO(itinerarioLogic.listEntretenimientos(itinerariosId));
    }
    
    @GET
    @Path("{entretenimientosId: \\d+}")
    public EntretenimientoDetailDTO getEntretenimiento(@PathParam("itinerarioId") Long itinerarioId, @PathParam("entretenimientosId") Long entretenimientoId) throws WebApplicationException {
        return new EntretenimientoDetailDTO(itinerarioLogic.getEntretenimiento(itinerarioId, entretenimientoId));
    }
    
    @POST
    @Path("{entretenimientosId: \\d+}")
    public EntretenimientoDetailDTO addEntretenimiento(@PathParam("itinerarioId") Long itinerarioId, @PathParam("entretenimientosId") Long entretenimientoId) {
        return new EntretenimientoDetailDTO(itinerarioLogic.addEntretenimiento(itinerarioId, entretenimientoId));
    }
    
    @PUT
    public List<EntretenimientoDetailDTO> replaceEntretenimiento(@PathParam("itinerarioId") Long itinerarioId, List<EntretenimientoDetailDTO> entretenimientos) {
        return EntretenimientosListEntity2DTO(itinerarioLogic.replaceEntretenimientos(itinerarioId, entretenimientosListDTO2Entity(entretenimientos)));
    }
    
    @DELETE
    @Path("{entretenimientosId: \\d+}")
    public void removeEntretenimiento(@PathParam("itinerarioId") Long itinerarioId, @PathParam("entretenimientosId") Long entretenimientoId) {
        itinerarioLogic.removeEntretenimiento(itinerarioId, entretenimientoId);
    }
    
    
    
    
}
