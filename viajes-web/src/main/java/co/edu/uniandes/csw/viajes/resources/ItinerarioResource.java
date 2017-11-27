/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.ItinerarioDTO;
import co.edu.uniandes.csw.viajes.dtos.ItinerarioDetailDTO;
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
import javax.ws.rs.WebApplicationException;
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
    
    /**
     *
     * @return devuelve los itinerarios en la base de datos.
     */
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
    
    /**
     * Busca si hay algun itinerario con el id que se envía de argumento
     * @exception HTTPException si el dto es nulo
     * @param id: id de la imagen que se está buscando
     * @return Si existe alguna devuelve la primera.
     */
    @GET
    @Path("{id: \\d+}")
    public ItinerarioDetailDTO getItinerario(@PathParam("id") Long id) throws HTTPException {
        ItinerarioEntity toGet = itinerarioLogic.getItinerario(id);
        if(toGet==null) throw new HTTPException(404);
        return new ItinerarioDetailDTO(toGet);
    }
    
    /**
     *
     * @param itinerarioDTO  dto itinerario que se creará en la base de datos
     * @return devuelve el dto creada con un id dado por la base de datos.
     */
    @POST
    public ItinerarioDetailDTO createItinerario(ItinerarioDTO itinerarioDTO){
        ItinerarioEntity itinerario = itinerarioDTO.toEntity();
        ItinerarioEntity entity = itinerarioLogic.createItinerario(itinerario);  
        return new ItinerarioDetailDTO(entity);
    }
    
    /**
     * @param id identificador del dto
     * @param dto dto itinerario que se cambiara en la base de datos
     * @return devuelve el dto cambiada.
     */
    @PUT
    @Path("{id: \\d+}")
    public ItinerarioDetailDTO updateImagen(@PathParam("id") Long id, ItinerarioDTO dto) {
       ItinerarioEntity entity = dto.toEntity();
       entity.setId(id);
       return new ItinerarioDetailDTO(itinerarioLogic.updateItinerario(entity)); 
    }
    
    /**
     *
     * @param id del dto itinerario que se borrara de la base de datos
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteImagen(@PathParam("id") Long id) {
       itinerarioLogic.deleteItinerario(id);
    }
    
    /**
     * Retorna el subrecurso Guias
     * 
     * @param itinerariosId el itinerario del que se quieren obtener los guias
     * @return ItinerariosGuiasResource
     */
    @Path("{itinerariosId: \\d+}/guias")
    public Class<ItinerariosGuiasResource> getItinerariosGuiasResource(@PathParam("itinerariosId") Long itinerariosId){
        ItinerarioEntity entity = itinerarioLogic.getItinerario(itinerariosId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /editorials/" + itinerariosId + " no existe.", 404);
        }
        return ItinerariosGuiasResource.class;
    }
    
    @Path("{itinerariosId: \\d+}/entretenimientos")
    public Class<ItinerarioEntretenimientosResource> getItinerariosEntretenimientosResource(@PathParam("itinerariosId") Long itinerariosId){
        ItinerarioEntity entity = itinerarioLogic.getItinerario(itinerariosId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /editorials/" + itinerariosId + " no existe.", 404);
        }
        return ItinerarioEntretenimientosResource.class;
    }
    
    @Path("{itinerariosId: \\d+}/hospedajes")
    public Class<ItinerarioHospedajesResource> getItinerariosHospedajesResource(@PathParam("itinerariosId") Long itinerariosId){
        ItinerarioEntity entity = itinerarioLogic.getItinerario(itinerariosId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /editorials/" + itinerariosId + " no existe.", 404);
        }
        return ItinerarioHospedajesResource.class;
    }
    
    @Path("{itinerariosId: \\d+}/transportes")
    public Class<ItinerarioTransportesResource> getItinerariosTransportesResource(@PathParam("itinerariosId") Long itinerariosId){
        ItinerarioEntity entity = itinerarioLogic.getItinerario(itinerariosId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /editorials/" + itinerariosId + " no existe.", 404);
        }
        return ItinerarioTransportesResource.class;
    }
    
}
