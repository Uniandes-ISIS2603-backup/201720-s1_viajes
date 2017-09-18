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
@Stateless
public class ImagenResource {
    
    @Inject
    ImagenLogic imagenLogic;
    
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
    
    @GET
    @Path("{id: \\d+}")
    public ImagenDTO getImagen(@PathParam("id") Long id) throws HTTPException {
        ImagenEntity toGet = imagenLogic.getImagen(id);
        if(toGet==null) throw new HTTPException(404);
        return new ImagenDTO(toGet);
    }
    
    @POST
    public ImagenDTO createImagen(ImagenDTO imagenDTO){
        ImagenEntity imagen = imagenDTO.toEntity();
        ImagenEntity entity = imagenLogic.createImagen(imagen);  
        return new ImagenDTO(entity);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ImagenDTO updateImagen(@PathParam("id") Long id, ImagenDTO dto) {
       ImagenEntity entity = dto.toEntity();
       entity.setId(id);
       return new ImagenDTO(imagenLogic.updateImagen(entity)); 
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteImagen(@PathParam("id") Long id) {
       imagenLogic.deleteImagen(id);
    }
}
