/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.ItinerarioDTO;
import co.edu.uniandes.csw.viajes.ejb.ItinerarioLogic;
import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author js.beltran14
 */
@Path("itinerarios")
@Produces("application/json")
@Stateless
public class ItinerarioResource {
    
    @Inject
    ItinerarioLogic itinerarioLogic;
    
    @GET
    public List<ItinerarioDTO> getItinerario(){
        List<ItinerarioDTO> ItinerarioDTOs = new ArrayList<>();

        List<ItinerarioEntity> itinerarios = itinerarioLogic.getItinerarios();
        for(ItinerarioEntity itinerario : itinerarios){
            ItinerarioDTO dto = new ItinerarioDTO(itinerario);
            ItinerarioDTOs.add(dto);
        }
        return ItinerarioDTOs;
    }
    
    @GET
    @Path("{id: \\d+}")
    public ItinerarioDTO getItinerario(@PathParam("id") Long id) throws HTTPException {
        ItinerarioEntity toGet = itinerarioLogic.getItinerario(id);
        if(toGet==null) throw new HTTPException(404);
        return new ItinerarioDTO(toGet);
    }
    
    @POST
    public ItinerarioDTO createItinerario(ItinerarioDTO itinerarioDTO){
        ItinerarioEntity itinerario = itinerarioDTO.toEntity();
        ItinerarioEntity entity = itinerarioLogic.createItinrario(itinerario);  
        return new ItinerarioDTO(entity);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ItinerarioDTO updateImagen(@PathParam("id") Long id, ItinerarioDTO dto) {
       ItinerarioEntity entity = dto.toEntity();
       entity.setId(id);
       return new ItinerarioDTO(itinerarioLogic.updateItinerario(entity)); 
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteImagen(@PathParam("id") Long id) {
       itinerarioLogic.deleteItinerario(id);
    }
    
}
