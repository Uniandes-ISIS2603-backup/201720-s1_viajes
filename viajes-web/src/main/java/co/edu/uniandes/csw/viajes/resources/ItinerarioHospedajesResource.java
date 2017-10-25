/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.HospedajeDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.ItinerarioLogic;
import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
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
public class ItinerarioHospedajesResource {
    
    @Inject
    ItinerarioLogic itinerarioLogic;
    
    private List<HospedajeDetailDTO> hospedajesListEntity2DTO(List<HospedajeEntity> entityList){
        List<HospedajeDetailDTO> list = new ArrayList<>();
        for (HospedajeEntity entity : entityList) {
            list.add(new HospedajeDetailDTO(entity));
        }
        return list;
    }
    
    private List<HospedajeEntity> hospedajesListDTO2Entity(List<HospedajeDetailDTO> dtos){
        List<HospedajeEntity> list = new ArrayList<>();
        for (HospedajeDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    @GET
    public List<HospedajeDetailDTO> listHospedajes(@PathParam("itinerariosId") Long itinerariosId) {
        return hospedajesListEntity2DTO(itinerarioLogic.listHospedajes(itinerariosId));
    }
    
    @GET
    @Path("{hospedajesId: \\d+}")
    public HospedajeDetailDTO getHospedajes(@PathParam("itinerarioId") Long itinerarioId, @PathParam("hospedajesId") Long hospedajesId) throws WebApplicationException {
        return new HospedajeDetailDTO(itinerarioLogic.getHospedaje(itinerarioId, hospedajesId));
    }
    
    @POST
    @Path("{hospedajesId: \\d+}")
    public HospedajeDetailDTO addHospedajes(@PathParam("itinerarioId") Long itinerarioId, @PathParam("hospedajeId") Long hospedajesId) {
        return new HospedajeDetailDTO(itinerarioLogic.addHospedaje(itinerarioId, hospedajesId));
    }
    
    @PUT
    public List<HospedajeDetailDTO> replaceHospedajes(@PathParam("itinerarioId") Long itinerarioId, List<HospedajeDetailDTO> hospedajes) {
        return hospedajesListEntity2DTO(itinerarioLogic.replaceHospedaje(itinerarioId, hospedajesListDTO2Entity(hospedajes)));
    }
    
    @DELETE
    @Path("{hospedajesId: \\d+}")
    public void removeHospedajes(@PathParam("itinerarioId") Long itinerarioId, @PathParam("hospedajesId") Long hospedajesId) {
        itinerarioLogic.removeHospedaje(itinerarioId, hospedajesId);
    
    }
}
