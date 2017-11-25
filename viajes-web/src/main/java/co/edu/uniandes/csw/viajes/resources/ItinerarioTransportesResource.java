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
    
    /**
     * Convierte una lista de TransporteEntity a una lista de TransporteDetailDTO.
     *
     * @param entityList Lista de TransporteEntity a convertir.
     * @return Lista de TransporteDetailDTO convertida.
     * 
     */
    private List<TransporteDetailDTO> transportesListEntity2DTO(List<TransporteEntity> entityList){
        List<TransporteDetailDTO> list = new ArrayList<>();
        for (TransporteEntity entity : entityList) {
            list.add(new TransporteDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Convierte una lista de TransporteDetailDTO a una lista de TransporteEntity.
     *
     * @param dtos Lista de TransporteDetailDTO a convertir.
     * @return Lista de TransporteEntity convertida.
     * 
     */
    private List<TransporteEntity> transportesListDTO2Entity(List<TransporteDetailDTO> dtos){
        List<TransporteEntity> list = new ArrayList<>();
        for (TransporteDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    /**
     * Obtiene una colección de instancias de TransporteDetailDTO asociadas a una
     * instancia de Itinerario
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @return Colección de instancias de TransporteDetailDTO asociadas a la
     * instancia de Itinerario
     * 
     */
    @GET
    public List<TransporteDetailDTO> listTransportes(@PathParam("itinerariosId") Long itinerariosId) {
        return transportesListEntity2DTO(itinerarioLogic.listTransportes(itinerariosId));
    }
    
    /**
     * Obtiene una instancia de Transporte asociada a una instancia de Itinerario
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @param transportesId Identificador de la instancia de Transporte
     * @return 
     * 
     */
    @GET
    @Path("{transportesId: \\d+}")
    public TransporteDetailDTO getTransportes(@PathParam("itinerariosId") Long itinerariosId, @PathParam("transportesId") Long transportesId) throws WebApplicationException {
        return new TransporteDetailDTO(itinerarioLogic.getTransporte(itinerariosId, transportesId));
    }
    
    /**
     * Asocia un Transporte existente a un Itinerario
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @param transportesId Identificador de la instancia de Transporte
     * @return Instancia de TransporteDetailDTO que fue asociada a Itinerario
     * 
     */
    @POST
    @Path("{transportesId: \\d+}")
    public TransporteDetailDTO addTransportes(@PathParam("itinerariosId") Long itinerariosId, @PathParam("transportesId") Long transportesId) {
        return new TransporteDetailDTO(itinerarioLogic.addTransporte(itinerariosId, transportesId));
    }
        
    /**
     * Desasocia un Transporte existente de un Itinerario existente
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @param transportesId Identificador de la instancia de Transporte
     * 
     */
    @DELETE
    @Path("{transportesId: \\d+}")
    public void removeTransportes(@PathParam("itinerariosId") Long itinerariosId, @PathParam("transportesId") Long transportesId) {
        itinerarioLogic.removeTransporte(itinerariosId, transportesId);
    }   
    
    
}
