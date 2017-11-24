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
    public List<TransporteDetailDTO> listTransportes(@PathParam("itinerariosId") Long itinerariosId) {
        return transportesListEntity2DTO(itinerarioLogic.listTransportes(itinerariosId));
    }
    
    /**
     * Obtiene una instancia de transporte asociada a una instancia de itinerario
     *
     * @param itinerarioId  Identificador de la instancia de itinerario
     * @param transportesId  Identificador de la instancia de transporte
     * @return 
     * 
     */
    @GET
    @Path("{transportesId: \\d+}")
    public TransporteDetailDTO getTransportes(@PathParam("itinerarioId") Long itinerarioId, @PathParam("transportesId") Long transportesId) throws WebApplicationException {
        return new TransporteDetailDTO(itinerarioLogic.getTransporte(itinerarioId, transportesId));
    }
    
     /**
     * Asocia un transporte existente a un itinerario
     *
     * @param transportesId   Identificador de la instancia de transporte
     * @param itinerarioId  Identificador de la instancia de itinerario
     * @return Instancia de DetailDTO que fue asociada a itinerario
     * 
     */
    @POST
    @Path("{transportesId: \\d+}")
    public TransporteDetailDTO addTransportes(@PathParam("itinerarioId") Long itinerarioId, @PathParam("transportesId") Long transportesId) {
        return new TransporteDetailDTO(itinerarioLogic.addTransporte(itinerarioId, transportesId));
    }
    
    @PUT
    public List<TransporteDetailDTO> replaceTransportes(@PathParam("itinerarioId") Long itinerarioId, List<TransporteDetailDTO> transportes) {
        return transportesListEntity2DTO(itinerarioLogic.replaceTransportes(itinerarioId, transportesListDTO2Entity(transportes)));
    }
    
    /**
     * Desasocia un transporte existente de un Itinerario existente
     *
     * @param itinerarioId  Identificador de la instancia de itinerario
     * @param transportesId   Identificador de la instancia de transporte
     * 
     */
    @DELETE
    @Path("{transportesId: \\d+}")
    public void removeTransportes(@PathParam("itinerarioId") Long itinerarioId, @PathParam("transportesId") Long transportesId) {
        itinerarioLogic.removeTransporte(itinerarioId, transportesId);
    }
    
    
    
    
}
