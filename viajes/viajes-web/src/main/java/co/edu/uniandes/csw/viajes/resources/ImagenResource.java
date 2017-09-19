/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.ImagenDTO;
import co.edu.uniandes.csw.viajes.ejb.ImagenLogic;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author js.beltran14
 */
@Path("imagenes")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ImagenResource {
    
    @Inject
    ImagenLogic imagenLogic;
    
    /**
     *
     * @return devuelve las imagenes en la base de datos.
     */
    @GET
    public List<ImagenDTO> getImagen(){
        List<ImagenDTO> imagenDTOs = new ArrayList<>();

        List<ImagenEntity> imagenes = imagenLogic.getImagenes();
        for(ImagenEntity imagen : imagenes){
            ImagenDTO dto = new ImagenDTO(imagen);
            imagenDTOs.add(dto);
        }
        return imagenDTOs;
    }
    
    /**
     * Busca si hay algun dto con el id que se envía de argumento
     * @exception HTTPException si es nulo el dto 
     * @param id: id del dto que se está buscando
     * @return Si existe alguna devuelve la primera.
     */
    @GET
    @Path("{id: \\d+}")
    public ImagenDTO getImagen(@PathParam("id") Long id) throws HTTPException {
        ImagenEntity toGet = imagenLogic.getImagen(id);
        if(toGet==null) throw new HTTPException(404);
        return new ImagenDTO(toGet);
    }
    
    /**
     *
     * @param imagenDTO: objeto imagen que se creará en la base de datos
     * @return devuelve el DTO creado con un id dado por la base de datos.
     */
    @POST
    public ImagenDTO createImagen(ImagenDTO imagenDTO){
        ImagenEntity imagen = imagenDTO.toEntity();
        ImagenEntity entity = imagenLogic.createImagen(imagen);  
        return new ImagenDTO(entity);
    }
    
    /**
     *
     * @param dto objeto imagen que se cambiara en la base de datos
     * @param id id del dto
     * @return devuelve el dto cambiado.
     */
    @PUT
    @Path("{id: \\d+}")
    public ImagenDTO updateImagen(@PathParam("id") Long id, ImagenDTO dto) {
       ImagenEntity entity = dto.toEntity();
       entity.setId(id);
       return new ImagenDTO(imagenLogic.updateImagen(entity)); 
    }
    
    /**
     *
     * @param id dto imagen que se borrara de la base de datos
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteImagen(@PathParam("id") Long id) {
       imagenLogic.deleteImagen(id);
    }
}
