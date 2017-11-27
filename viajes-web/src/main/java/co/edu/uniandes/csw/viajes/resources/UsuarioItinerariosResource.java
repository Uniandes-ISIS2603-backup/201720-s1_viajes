/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.ItinerarioDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.UsuarioLogic;
import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Vanessa Huertas <tv.huertas10>
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioItinerariosResource {
   
    @Inject
    private UsuarioLogic usuarioLogic;

    /**
     * Convierte una lista de ItinerarioEntity a una lista de ItinerarioDetailDTO.
     *
     * @param entityList Lista de ItinerarioEntity a convertir.
     * @return Lista de ItinerarioDetailDTO convertida.
     * 
     */
    private List<ItinerarioDetailDTO> itinerariosListEntity2DTO(List<ItinerarioEntity> entityList) {
        List<ItinerarioDetailDTO> list = new ArrayList<>();
        for (ItinerarioEntity entity : entityList) {
            list.add(new ItinerarioDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de ItinerarioDetailDTO a una lista de ItinerarioEntity.
     *
     * @param dtos Lista de ItinerarioDetailDTO a convertir.
     * @return Lista de ItinerarioEntity convertida.
     * 
     */
    private List<ItinerarioEntity> itinerariosListDTO2Entity(List<ItinerarioDetailDTO> dtos) {
        List<ItinerarioEntity> list = new ArrayList<>();
        for (ItinerarioDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de ItinerarioDetailDTO asociadas a una
     * instancia de Usuario
     *
     * @param usuariosId Identificador de la instancia de Usuario
     * @return Colección de instancias de ItinerarioDetailDTO asociadas a la
     * instancia de Usuario
     * 
     */
    @GET
    public List<ItinerarioDetailDTO> listItinerarios(@PathParam("usuariosId") Long usuariosId) {
        return itinerariosListEntity2DTO(usuarioLogic.getItinerarios(usuariosId));
    }

    /**
     * Obtiene una instancia de Itinerario asociada a una instancia de Usuario
     *
     * @param usuariosId Identificador de la instancia de Usuario
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @return 
     * 
     */
    @GET
    @Path("{itinerariosId: \\d+}")
    public ItinerarioDetailDTO getItinerario(@PathParam("usuariosId") Long usuariosId, @PathParam("itinerariosId") Long itinerariosId) {
        return new ItinerarioDetailDTO(usuarioLogic.getItinerario(usuariosId, itinerariosId));
    }

    /**
     * Asocia un Itinerario existente a un Usuario
     *
     * @param usuariosId Identificador de la instancia de Usuario
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @return Instancia de ItinerarioDetailDTO que fue asociada a Usuario
     * 
     */
    @POST
    @Path("{itinerariosId: \\d+}")
    public ItinerarioDetailDTO addItinerario(@PathParam("usuariosId") Long usuariosId, @PathParam("itinerariosId") Long itinerariosId) {
        return new ItinerarioDetailDTO(usuarioLogic.addItinerario(usuariosId, itinerariosId));
    }

    /**
     * Remplaza las instancias de Itinerario asociadas a una instancia de Usuario
     *
     * @param usuariosId Identificador de la instancia de Usuario
     * @param itinerarios Colección de instancias de ItinerarioDTO a asociar a instancia
     * de Usuario
     * @return Nueva colección de ItinerarioDTO asociada a la instancia de Usuario
     * 
     */
    @PUT
    public List<ItinerarioDetailDTO> replaceItinerarios(@PathParam("usuariosId") Long usuariosId, List<ItinerarioDetailDTO> itinerarios) {
        return itinerariosListEntity2DTO(usuarioLogic.replaceItinerarios(usuariosId, itinerariosListDTO2Entity(itinerarios)));
    }

    /**
     * Desasocia un Itinerario existente de un Usuario existente
     *
     * @param usuariosId Identificador de la instancia de Usuario
     * @param itinerariosId Identificador de la instancia de Itinerario
     * 
     */
    @DELETE
    @Path("{itinerariosId: \\d+}")
    public void removeItinerarios(@PathParam("usuariosId") Long usuariosId, @PathParam("itinerariosId") Long itinerariosId) {
        usuarioLogic.removeItinerario(usuariosId, itinerariosId);
    }
}
