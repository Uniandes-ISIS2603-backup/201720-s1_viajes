/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.GuiaDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.ItinerarioLogic;
import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
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
public class ItinerariosGuiasResource {
    
    @Inject
    ItinerarioLogic itinerarioLogic;
    
    private List<GuiaDetailDTO> guiasListEntity2DTO(List<GuiaEntity> entityList){
        List<GuiaDetailDTO> list = new ArrayList<>();
        for (GuiaEntity entity : entityList) {
            list.add(new GuiaDetailDTO(entity));
        }
        return list;
    }
    
    private List<GuiaEntity> guiasListDTO2Entity(List<GuiaDetailDTO> dtos){
        List<GuiaEntity> list = new ArrayList<>();
        for (GuiaDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    @GET
    public List<GuiaDetailDTO> listGuias(@PathParam("itinerariosId") Long itinerariosId) {
        return guiasListEntity2DTO(itinerarioLogic.listGuias(itinerariosId));
    }
    
    @GET
    @Path("{guiasId: \\d+}")
    public GuiaDetailDTO getGuias(@PathParam("itinerarioId") Long itinerarioId, @PathParam("guiasId") Long guiasId) throws WebApplicationException {
        return new GuiaDetailDTO(itinerarioLogic.getGuia(itinerarioId, guiasId));
    }
    
    @POST
    @Path("{guiaId: \\d+}")
    public GuiaDetailDTO addGuias(@PathParam("itinerarioId") Long itinerarioId, @PathParam("guiaId") Long guiaId) {
        return new GuiaDetailDTO(itinerarioLogic.addGuia(itinerarioId, guiaId));
    }
    
    @PUT
    public List<GuiaDetailDTO> replaceGuias(@PathParam("itinerarioId") Long itinerarioId, List<GuiaDetailDTO> guias) {
        return guiasListEntity2DTO(itinerarioLogic.replaceGuias(itinerarioId, guiasListDTO2Entity(guias)));
    }
    
    @DELETE
    @Path("{guiaId: \\d+}")
    public void removeGuias(@PathParam("itinerarioId") Long itinerarioId, @PathParam("guiaId") Long guiaId) {
        itinerarioLogic.removeGuia(itinerarioId, guiaId);
    }
}
