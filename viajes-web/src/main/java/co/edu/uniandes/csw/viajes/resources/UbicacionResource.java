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
import co.edu.uniandes.csw.viajes.ejb.UbicacionLogic;
import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;
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

public class UbicacionResource {
    
    
    @Inject
    UbicacionLogic ubicacionLogic;
    
    @GET
    @Path("{id: \\d+}")
    public UbicacionDTO getUbicacion(@PathParam("id") Long id) throws HTTPException {
        UbicacionEntity toGet = ubicacionLogic.getUbicacion(id);
        if(toGet==null) throw new HTTPException(404);
        return new UbicacionDTO(toGet);
    }
    
    @POST
    public UbicacionDTO createUbicacion(UbicacionDTO itinerarioDTO){
        UbicacionEntity itinerario = itinerarioDTO.toEntity();
        UbicacionEntity entity = ubicacionLogic.createUbicacion(itinerario);  
        return new UbicacionDTO(entity);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public UbicacionDTO updateUbicacion(@PathParam("id") Long id, UbicacionDTO dto) {
       UbicacionEntity entity = dto.toEntity();
       entity.setId(id);
       return new UbicacionDTO(ubicacionLogic.updateUbicacion(entity)); 
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteUbicacion(@PathParam("id") Long id) {
       ubicacionLogic.deleteUbicacion(id);
    }
}