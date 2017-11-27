/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.ImagenDetailDTO;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.csw.viajes.ejb.BlogLogic;
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
 * URI: blogs/{blogsId: \\d+}/imagenes
 *
 * @author m.rodriguez21
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BlogImagenesResource {

    @Inject
    private BlogLogic blogLogic;

    /**
     * Convierte una lista de ImagenEntity a una lista de ImagenDetailDTO.
     *
     * @param entityList Lista de ImagenEntity a convertir.
     * @return Lista de ImagenDetailDTO convertida.
     * 
     */
    private List<ImagenDetailDTO> imagenesBlogListEntity2DTO(List<ImagenEntity> entityList) {
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
    private List<ImagenEntity> imagenesBlogListDTO2Entity(List<ImagenDetailDTO> dtos) {
        List<ImagenEntity> list = new ArrayList<>();
        for (ImagenDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de ImagenDetailDTO asociadas a una
     * instancia de Blog
     *
     * @param blogsId Identificador de la instancia de Blog
     * @return Colección de instancias de ImagenDetailDTO asociadas a la
     * instancia de Blog
     * 
     */
    @GET
    public List<ImagenDetailDTO> listImagenesBlog(@PathParam("blogsId") Long blogsId) {
        return imagenesBlogListEntity2DTO(blogLogic.listImagenes(blogsId));
    }

    /**
     * Obtiene una instancia de Imagen asociada a una instancia de Blog
     *
     * @param blogsId Identificador de la instancia de Blog
     * @param imagenesId Identificador de la instancia de Imagen
     * @return 
     * 
     */
    @GET
    @Path("{imagenesId: \\d+}")
    public ImagenDetailDTO getImagens(@PathParam("blogsId") Long blogsId, @PathParam("imagenesId") Long imagenesId) {
        return new ImagenDetailDTO(blogLogic.getImagen(blogsId, imagenesId));
    }

    /**
     * Asocia un Imagen existente a un Blog
     *
     * @param blogsId Identificador de la instancia de Blog
     * @param imagenesId Identificador de la instancia de Imagen
     * @return Instancia de ImagenDetailDTO que fue asociada a Blog
     * 
     */
    @POST
    @Path("{imagenesId: \\d+}")
    public ImagenDetailDTO addImagens(@PathParam("blogsId") Long blogsId, @PathParam("imagenesId") Long imagenesId) {
        return new ImagenDetailDTO(blogLogic.addImagen(blogsId, imagenesId));
    }

    /**
     * Remplaza las instancias de Imagen asociadas a una instancia de Blog
     *
     * @param blogsId Identificador de la instancia de Blog
     * @param imagenes Colección de instancias de ImagenDTO a asociar a instancia
     * de Blog
     * @return Nueva colección de ImagenDTO asociada a la instancia de Blog
     * 
     */
    @PUT
    public List<ImagenDetailDTO> replaceImagens(@PathParam("blogsId") Long blogsId, List<ImagenDetailDTO> imagenes) {
        return imagenesBlogListEntity2DTO(blogLogic.replaceImagenes(blogsId, imagenesBlogListDTO2Entity(imagenes)));
    }

    /**
     * Desasocia un Imagen existente de un Blog existente
     *
     * @param blogsId Identificador de la instancia de Blog
     * @param imagenesId Identificador de la instancia de Imagen
     * 
     */
    @DELETE
    @Path("{imagenesId: \\d+}")
    public void removeImagenes(@PathParam("blogsId") Long blogsId, @PathParam("imagenesId") Long imagenesId) {
        blogLogic.removeImagen(blogsId, imagenesId);
    }
}