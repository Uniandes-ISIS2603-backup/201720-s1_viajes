/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.ImagenDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.TransporteLogic;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
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
import javax.ws.rs.core.MediaType;

/**
 *URI: transportes/{transportesId: \\d+}/imagenes
 * @author sa.silva1
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransporteImagenesResource {

    @Inject
    TransporteLogic transporteLogic;

    private List<ImagenDetailDTO> imagenesListEntity2DTO(List<ImagenEntity> entityList) {
        List<ImagenDetailDTO> list = new ArrayList<>();
        for (ImagenEntity entity : entityList) {
            list.add(new ImagenDetailDTO(entity));
        }
        return list;
    }
    
    /*@GET
    public List<ImagenDetailDTO> listImagens(@PathParam("id") Long transportesId) {
        return imagenesListEntity2DTO(transporteLogic.listImagenes(transportesId));
    }*/

     private List<ImagenEntity> imagenesListDTO2Entity(List<ImagenDetailDTO> dtos) {
        List<ImagenEntity> list = new ArrayList<>();
        for (ImagenDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
    
    @GET
    public List<ImagenDetailDTO> listImagenes(@PathParam("transportesId") Long transportesId) {
        return imagenesListEntity2DTO(transporteLogic.listImagenes(transportesId));
    }
     
    
    /**
     * Obtiene una instancia de Imagen asociada a una instancia de Transporte
     *
     * @param tranporteId Identificador de la instancia de Transporte
     * @param imagenesId Identificador de la instancia de Imagen
     * @return 
     * 
     */
    @GET
    @Path("{imagenesId: \\d+}")
    public ImagenDetailDTO getImagens(@PathParam("transportesId") Long transportesId, @PathParam("imagenesId") Long imagenesId) {
       
        return new ImagenDetailDTO(transporteLogic.getImagen(transportesId, imagenesId));
    }
    
    
    /**
     * Asocia un Imagen existente a un Transporte
     *
     * @param transportesId Identificador de la instancia de Transporte
     * @param imagenesId Identificador de la instancia de Imagen
     * @return Instancia de ImagenDetailDTO que fue asociada a Transporte
     * 
     */
    @POST
    @Path("{imagenesId: \\d+}")
    public ImagenDetailDTO addImagens(@PathParam("transportesId") Long transportesId, @PathParam("imagenesId") Long imagenesId) {
        return new ImagenDetailDTO(transporteLogic.addImagen(transportesId, imagenesId));
    }
    
    /**
     * Remplaza las instancias de Imagen asociadas a una instancia de Transporte
     *
     * @param transportesId Identificador de la instancia de Transporte
     * @param imagenes Colección de instancias de ImagenDTO a asociar a instancia
     * de Transporte
     * @return Nueva colección de ImagenDTO asociada a la instancia de Transporte
     * 
     */
    @PUT
    public List<ImagenDetailDTO> replaceImagens(@PathParam("transportesId") Long transportesId, List<ImagenDetailDTO> imagenes) {
        return imagenesListEntity2DTO(transporteLogic.replaceImagenes(transportesId, imagenesListDTO2Entity(imagenes)));
    }

    /**
     * Desasocia un Imagen existente de un Transporte existente
     *
     * @param transportesId Identificador de la instancia de Transporte
     * @param imagenesId Identificador de la instancia de Imagen
     * 
     */
    @DELETE
    @Path("{imagenesId: \\d+}")
    public void removeImagenes(@PathParam("transportesId") Long transportesId, @PathParam("imagenesId") Long imagenesId) {
        transporteLogic.removeImagen(transportesId, imagenesId);
    }
    
}
