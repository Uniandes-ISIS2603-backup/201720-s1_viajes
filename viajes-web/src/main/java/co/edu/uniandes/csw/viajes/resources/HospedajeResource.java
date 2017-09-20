/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.HospedajeDTO;
import co.edu.uniandes.csw.viajes.ejb.HospedajeLogic;
import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
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
 * @author ma.forero11
 */
public class HospedajeResource {
    
    @Inject
    HospedajeLogic hospedajeLogic;
    
    @GET
    @Path("{id: \\d+}")
    public HospedajeDTO getHospedaje(@PathParam("id") Long id) throws HTTPException {
        HospedajeEntity toGet = hospedajeLogic.getHospedaje(id);
        if(toGet==null) throw new HTTPException(404);
        return new HospedajeDTO(toGet);
    }
    
    @POST
    public HospedajeDTO createHospedaje(HospedajeDTO itinerarioDTO){
        HospedajeEntity itinerario = itinerarioDTO.toEntity();
        HospedajeEntity entity = hospedajeLogic.createHospedaje(itinerario);  
        return new HospedajeDTO(entity);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public HospedajeDTO updateHospedaje(@PathParam("id") Long id, HospedajeDTO dto) {
       HospedajeEntity entity = dto.toEntity();
       entity.setId(id);
       return new HospedajeDTO(hospedajeLogic.updateHospedaje(entity)); 
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteHospedaje(@PathParam("id") Long id) {
       hospedajeLogic.deleteHospedaje(id);
    }
   
}