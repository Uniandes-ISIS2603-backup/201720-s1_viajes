/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.ImagenDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.HospedajeLogic;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
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
 * URI: hospedajes/{hospedajeId: \\d+}/imagenes
 * @author ma.forero11
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HospedajeImagenesResource {
    
    @Inject
    private HospedajeLogic hospedajeLogic;
    
     /**
     * Convierte una lista de ImagenEntity a una lista de ImagenDetailDTO.
     *
     * @param entityList Lista de ImagenEntity a convertir.
     * @return Lista de ImagenDetailDTO convertida.
     * 
     */
    private List<ImagenDetailDTO> imagenesHospedajeListEntity2DTO(List<ImagenEntity> entityList) {
        List<ImagenDetailDTO> list = new ArrayList<>();
        for (ImagenEntity entity : entityList) {
            list.add(new ImagenDetailDTO(entity));
        }
        return list;
    }
    
    
    /**
     * Convierte una lista de ImagenDetailDTO a una lista de ImagenEntity.
     *
     * @param dtos Lista de ImagenDetailDTO a convertir.
     * @return Lista de ImagenEntity convertida.
     * 
     */
    private List<ImagenEntity> imagenesHospedajeListDTO2Entity(List<ImagenDetailDTO> dtos) {
        List<ImagenEntity> list = new ArrayList<>();
        for (ImagenDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    /**
     * Obtiene una colección de instancias de ImagenDetailDTO asociadas a una
     * instancia de Hospedaje
     *
     * @param hospedajeId Identificador de la instancia de Hospedaje
     * @return Colección de instancias de ImagenDetailDTO asociadas a la
     * instancia de Hospedaje
     * 
     */
    @GET
    public List<ImagenDetailDTO> listImagenesHospedaje(@PathParam("hospedajeId") Long hospedajeId) {
        return imagenesHospedajeListEntity2DTO(hospedajeLogic.listImagenes(hospedajeId));
    }
    
    /**
     * Obtiene una instancia de Imagen asociada a una instancia de Blog
     *
     * @param hospedajeId Identificador de la instancia de Blog
     * @param imagenesId Identificador de la instancia de Imagen
     * @return 
     * 
     */
    @GET
    @Path("{imagenesId: \\d+}")
    public ImagenDetailDTO getImagens(@PathParam("hospedajeId") Long hospedajeId, @PathParam("imagenesId") Long imagenesId) {
        return new ImagenDetailDTO(hospedajeLogic.getImagen(hospedajeId, imagenesId));
    }
    
    /**
     * Asocia un Imagen existente a un Hospedaje
     *
     * @param hospedajeId Identificador de la instancia de Hospedaje
     * @param imagenesId Identificador de la instancia de Imagen
     * @return Instancia de ImagenDetailDTO que fue asociada a Hospedaje
     * 
     */
    @POST
    @Path("{imagenesId: \\d+}")
    public ImagenDetailDTO addImagens(@PathParam("hospedajeId") Long hospedajeId, @PathParam("imagenesId") Long imagenesId) {
        return new ImagenDetailDTO(hospedajeLogic.addImagen(hospedajeId, imagenesId));
    }
    
    /**
     * Desasocia un Imagen existente de un Hospedaje existente
     *
     * @param hospedajeId Identificador de la instancia de Hospedaje
     * @param imagenesId Identificador de la instancia de Imagen
     * 
     */
    @DELETE
    @Path("{imagenesId: \\d+}")
    public void removeImagenes(@PathParam("hospedajeId") Long hospedajeId, @PathParam("imagenesId") Long imagenesId) {
        hospedajeLogic.removeImagen(hospedajeId, imagenesId);
    }
}
