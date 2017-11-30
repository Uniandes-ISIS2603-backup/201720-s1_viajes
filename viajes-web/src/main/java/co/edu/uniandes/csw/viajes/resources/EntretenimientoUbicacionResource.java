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

import co.edu.uniandes.csw.viajes.dtos.UbicacionDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.EntretenimientoLogic;
import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 * URI: entretenimientos/{entretenimientoId: \\d+}/ubicacion
 * @author ma.forero11
 */
public class EntretenimientoUbicacionResource {
    
    @Inject
    private EntretenimientoLogic entretenimientoLogic;
    
    /**
     * Convierte una UbicacionEntity a una UbicacionDetailDTO.
     *
     * @param entity UbicacionEntity a convertir.
     * @return UbicacionDetailDTO convertida.
     * 
     */
    private UbicacionDetailDTO ubicacionEntretenimientoEntity2DTO(UbicacionEntity entity) {
        return (new UbicacionDetailDTO(entity));
    }
    
    /**
     * Convierte una UbicacionDetailDTO a una UbicacionEntity.
     *
     * @param dtos UbicacionDetailDTO a convertir.
     * @return UbicacionEntity convertida.
     * 
     */
    private UbicacionEntity ubicacionEntretenimientoDTO2Entity(UbicacionDetailDTO dto) {
        return dto.toEntity();
    }
    
    /**
     * Obtiene una ubicación asociada a un hospedaje
     *
     * @param hospedajeId Identificador de la instancia de Hospedaje
     * @return Instancia de UbicacionDetailDTO asociada a la
     * instancia de Hospedaje
     */
    @GET
    public UbicacionDetailDTO ubicacionEntretenimiento(@PathParam("entretenimientoId") Long entretenimientoId) {
        return ubicacionEntretenimientoEntity2DTO(entretenimientoLogic.getUbicacion(entretenimientoId));
    }
    
//    /**
//     * 
//     */
//    @POST
//    @Path("{hospedajeId: \\d+}")
//    public UbicacionDetailDTO addUbicacion(@PathParam("hospedajeId") Long hospedajeId, @PathParam("imagenesId") Long imagenesId) {
//        return new UbicacionDetailDTO(hospedajeLogic.addImagen(hospedajeId, imagenesId));
//    }
}