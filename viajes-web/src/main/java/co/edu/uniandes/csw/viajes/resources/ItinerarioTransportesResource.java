/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.TransporteDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.ItinerarioLogic;
import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
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
public class ItinerarioTransportesResource {
    
    @Inject
    ItinerarioLogic itinerarioLogic;
    
    private List<TransporteDetailDTO> transportesListEntity2DTO(List<TransporteEntity> entityList){
        List<TransporteDetailDTO> list = new ArrayList<>();
        for (TransporteEntity entity : entityList) {
            list.add(new TransporteDetailDTO(entity));
        }
        return list;
    }
    
    private List<TransporteEntity> transportesListDTO2Entity(List<TransporteDetailDTO> dtos){
        List<TransporteEntity> list = new ArrayList<>();
        for (TransporteDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    @GET
    public List<TransporteDetailDTO> listTransportes(@PathParam("itinerariosId") Long itinerariosId) {
        return transportesListEntity2DTO(itinerarioLogic.listTransportes(itinerariosId));
    }
    
    @GET
    @Path("{transportesId: \\d+}")
    public TransporteDetailDTO getTransportes(@PathParam("itinerarioId") Long itinerarioId, @PathParam("transportesId") Long transportesId) throws WebApplicationException {
        return new TransporteDetailDTO(itinerarioLogic.getTransporte(itinerarioId, transportesId));
    }
    
    @POST
    @Path("{transportesId: \\d+}")
    public TransporteDetailDTO addTransportes(@PathParam("itinerarioId") Long itinerarioId, @PathParam("transportesId") Long transportesId) {
        return new TransporteDetailDTO(itinerarioLogic.addTransporte(itinerarioId, transportesId));
    }
    
    @PUT
    public List<TransporteDetailDTO> replaceTransportes(@PathParam("itinerarioId") Long itinerarioId, List<TransporteDetailDTO> transportes) {
        return transportesListEntity2DTO(itinerarioLogic.replaceTransportes(itinerarioId, transportesListDTO2Entity(transportes)));
    }
    
    @DELETE
    @Path("{transportesId: \\d+}")
    public void removeTransportes(@PathParam("itinerarioId") Long itinerarioId, @PathParam("transportesId") Long transportesId) {
        itinerarioLogic.removeTransporte(itinerarioId, transportesId);
    }
    
    
    
    
}