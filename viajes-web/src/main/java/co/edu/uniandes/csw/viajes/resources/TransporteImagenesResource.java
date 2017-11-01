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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
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
    public List<ImagenDetailDTO> listImagens(@PathParam("id") Long entretenimientosId) {
        return imagenesListEntity2DTO(transporteLogic.listImagenes(entretenimientosId));
    }*/

    @GET
    @Path("{id: \\d+}")
    public List<ImagenDetailDTO> getImagenes(@PathParam("id") Long id) {
        TransporteEntity entity = transporteLogic.getTransporte(id);
        List<ImagenDetailDTO> resp = new ArrayList<>();
        if (entity == null) {
            throw new WebApplicationException("El recurso /transportes/" + id + " no existe.", 404);
        } else if (entity.getImagenes() == null) {
            throw new WebApplicationException("Las imagenes del recurso /transportes/" + id + " no existen.", 404);
        } else {
            for (ImagenEntity img : entity.getImagenes()) {
                resp.add(new ImagenDetailDTO(img));
            }
        }
        return resp;
    }

}
