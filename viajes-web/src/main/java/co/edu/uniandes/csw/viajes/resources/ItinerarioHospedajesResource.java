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
    
    /**
     * Convierte una lista de HospedajeEntity a una lista de HospedajeDetailDTO.
     *
     * @param entityList Lista de HospedajeEntity a convertir.
     * @return Lista de HospedajeDetailDTO convertida.
     * 
     */
    private List<HospedajeDetailDTO> hospedajesListEntity2DTO(List<HospedajeEntity> entityList){
        List<HospedajeDetailDTO> list = new ArrayList<>();
        for (HospedajeEntity entity : entityList) {
            list.add(new HospedajeDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Convierte una lista de HospedajeDetailDTO a una lista de HospedajeEntity.
     *
     * @param dtos Lista de HospedajeDetailDTO a convertir.
     * @return Lista de HospedajeEntity convertida.
     * 
     */
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
    
    /**
     * Obtiene una colección de instancias de HospedajeDetailDTO asociadas a una
     * instancia de Itinerario
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @return Colección de instancias de HospedajeDetailDTO asociadas a la
     * instancia de Itinerario
     * 
     */
    @GET
    @Path("{hospedajesId: \\d+}")
    public HospedajeDetailDTO getHospedajes(@PathParam("itinerariosId") Long itinerariosId, @PathParam("hospedajesId") Long hospedajesId) throws WebApplicationException {
        return new HospedajeDetailDTO(itinerarioLogic.getHospedaje(itinerariosId, hospedajesId));
    }
    
    /**
     * Asocia un Hospedaje existente a un Itinerario
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @param hospedajesId Identificador de la instancia de Hospedaje
     * @return Instancia de HospedajeDetailDTO que fue asociada a Itinerario
     * 
     */
    @POST
    @Path("{hospedajesId: \\d+}")
    public HospedajeDetailDTO addHospedajes(@PathParam("itinerariosId") Long itinerariosId, @PathParam("hospedajeId") Long hospedajesId) {
        return new HospedajeDetailDTO(itinerarioLogic.addHospedaje(itinerariosId, hospedajesId));
    }
    
    /**
     * Remplaza las instancias de Hospedaje asociadas a una instancia de Itinerario
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @param hospedajes Colección de instancias de HospedajeDTO a asociar a instancia
     * de Itinerario
     * @return Nueva colección de HospedajeDTO asociada a la instancia de Itinerario
     * 
     */
    @PUT
    public List<HospedajeDetailDTO> replaceHospedajes(@PathParam("itinerariosId") Long itinerariosId, List<HospedajeDetailDTO> hospedajes) {
        return hospedajesListEntity2DTO(itinerarioLogic.replaceHospedaje(itinerariosId, hospedajesListDTO2Entity(hospedajes)));
    }
    
    /**
     * Desasocia un Hospedaje existente de un Itinerario existente
     *
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @param hospedajesId Identificador de la instancia de Hospedaje
     * 
     */
    @DELETE
    @Path("{hospedajesId: \\d+}")
    public void removeHospedajes(@PathParam("itinerariosId") Long itinerariosId, @PathParam("hospedajesId") Long hospedajesId) {
        itinerarioLogic.removeHospedaje(itinerariosId, hospedajesId);
    
    }
}
