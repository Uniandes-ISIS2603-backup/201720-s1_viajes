/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.ImagenDetailDTO;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.viajes.ejb.EntretenimientoLogic;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
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
 * URI: entretenimiento/{entretenimientoId: \\d+}/imagenes
 *
 * @author m.rodriguez21
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EntretenimientoImagenesResource {

    @Inject
    private EntretenimientoLogic entretenimientoLogic;

    /**
     * Convierte una lista de ImagenEntity a una lista de ImagenDetailDTO.
     *
     * @param entityList Lista de ImagenEntity a convertir.
     * @return Lista de ImagenDetailDTO convertida.
     * 
     */
    private List<ImagenDetailDTO> imagenesEntretenimientoListEntity2DTO(List<ImagenEntity> entityList) {
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
    private List<ImagenEntity> imagenesEntretenimientoListDTO2Entity(List<ImagenDetailDTO> dtos) {
        List<ImagenEntity> list = new ArrayList<>();
        for (ImagenDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de ImagenDetailDTO asociadas a una
     * instancia de Entretetenimiento
     *
     * @param entretenimientoId Identificador de la instancia de Entretetenimiento
     * @return Colección de instancias de ImagenDetailDTO asociadas a la
     * instancia de Entretetenimiento
     * 
     */
    @GET
    public List<ImagenDetailDTO> listImagenesEntretenimiento(@PathParam("entretenimientoId") Long entretenimientoId) {
        return imagenesEntretenimientoListEntity2DTO(entretenimientoLogic.listImagenes(entretenimientoId));
    }

    /**
     * Obtiene una instancia de Imagen asociada a una instancia de Entretetenimiento
     *
     * @param entretenimientoId Identificador de la instancia de Entretetenimiento
     * @param imagenesId Identificador de la instancia de Imagen
     * @return 
     * 
     */
    @GET
    @Path("{imagenesId: \\d+}")
    public ImagenDetailDTO getImagens(@PathParam("entretenimientoId") Long entretenimientoId, @PathParam("imagenesId") Long imagenesId) {
       
        return new ImagenDetailDTO(entretenimientoLogic.getImagen(entretenimientoId, imagenesId));
    }

    /**
     * Asocia un Imagen existente a un Entretetenimiento
     *
     * @param entretenimientoId Identificador de la instancia de Entretetenimiento
     * @param imagenesId Identificador de la instancia de Imagen
     * @return Instancia de ImagenDetailDTO que fue asociada a Entretetenimiento
     * 
     */
    @POST
    @Path("{imagenesId: \\d+}")
    public ImagenDetailDTO addImagens(@PathParam("entretenimientoId") Long entretenimientoId, @PathParam("imagenesId") Long imagenesId) {
        return new ImagenDetailDTO(entretenimientoLogic.addImagen(entretenimientoId, imagenesId));
    }

    /**
     * Remplaza las instancias de Imagen asociadas a una instancia de Entretetenimiento
     *
     * @param entretenimientoId Identificador de la instancia de Entretetenimiento
     * @param imagenes Colección de instancias de ImagenDTO a asociar a instancia
     * de Entretetenimiento
     * @return Nueva colección de ImagenDTO asociada a la instancia de Entretetenimiento
     * 
     */
    @PUT
    public List<ImagenDetailDTO> replaceImagens(@PathParam("entretenimientoId") Long entretenimientoId, List<ImagenDetailDTO> imagenes) {
        return imagenesEntretenimientoListEntity2DTO(entretenimientoLogic.replaceImagenes(entretenimientoId, imagenesEntretenimientoListDTO2Entity(imagenes)));
    }

    /**
     * Desasocia un Imagen existente de un Entretetenimiento existente
     *
     * @param entretenimientoId Identificador de la instancia de Entretetenimiento
     * @param imagenesId Identificador de la instancia de Imagen
     * 
     */
    @DELETE
    @Path("{imagenesId: \\d+}")
    public void removeImagenes(@PathParam("entretenimientoId") Long entretenimientoId, @PathParam("imagenesId") Long imagenesId) {
        entretenimientoLogic.removeImagen(entretenimientoId, imagenesId);
    }
}