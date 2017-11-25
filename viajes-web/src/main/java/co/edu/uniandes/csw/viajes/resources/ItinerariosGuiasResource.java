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
    
    /**
     * Convierte una lista de GuiaEntity a una lista de GuiaDetailDTO.
     *
     * @param entityList Lista de GuiaEntity a convertir.
     * @return Lista de GuiaDetailDTO convertida.
     * 
     */
    private List<GuiaDetailDTO> guiasListEntity2DTO(List<GuiaEntity> entityList){
        List<GuiaDetailDTO> list = new ArrayList<>();
        for (GuiaEntity entity : entityList) {
            list.add(new GuiaDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Convierte una lista de GuiaDetailDTO a una lista de GuiaEntity.
     *
     * @param dtos Lista de GuiaDetailDTO a convertir.
     * @return Lista de GuiaEntity convertida.
     * 
     */
    private List<GuiaEntity> guiasListDTO2Entity(List<GuiaDetailDTO> dtos){
        List<GuiaEntity> list = new ArrayList<>();
        for (GuiaDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    /**
     * Obtiene una colección de instancias de GuiaDetailDTO asociadas a una
     * instancia de Itinerario
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @return Colección de instancias de GuiaDetailDTO asociadas a la
     * instancia de Itinerario
     * 
     */
    @GET
    public List<GuiaDetailDTO> listGuias(@PathParam("itinerariosId") Long itinerariosId) {
        return guiasListEntity2DTO(itinerarioLogic.listGuias(itinerariosId));
    }
    
    /**
     * Obtiene una instancia de Guia asociada a una instancia de Itinerario
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @param guiasId Identificador de la instancia de Guia
     * @return 
     * 
     */
    @GET
    @Path("{guiasId: \\d+}")
    public GuiaDetailDTO getGuias(@PathParam("itinerariosId") Long itinerariosId, @PathParam("guiasId") Long guiasId) throws WebApplicationException {
        return new GuiaDetailDTO(itinerarioLogic.getGuia(itinerariosId, guiasId));
    }
    
    /**
     * Asocia un Guia existente a un Itinerario
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @param guiaId Identificador de la instancia de Guia
     * @return Instancia de GuiaDetailDTO que fue asociada a Itinerario
     * 
     */
    @POST
    @Path("{guiaId: \\d+}")
    public GuiaDetailDTO addGuias(@PathParam("itinerariosId") Long itinerariosId, @PathParam("guiaId") Long guiaId) {
        return new GuiaDetailDTO(itinerarioLogic.addGuia(itinerariosId, guiaId));
    }

    /**
     * Desasocia un Guia existente de un Itinerario existente
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @param guiaId Identificador de la instancia de Guia
     * 
     */
    @DELETE
    @Path("{guiaId: \\d+}")
    public void removeGuias(@PathParam("itinerariosId") Long itinerariosId, @PathParam("guiaId") Long guiaId) {
        itinerarioLogic.removeGuia(itinerariosId, guiaId);
    }
}
