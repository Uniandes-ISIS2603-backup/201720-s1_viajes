/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.GuiaDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.GuiaLogic;
import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
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
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.WebApplicationException;
/**
 *
 * @author Juan
 */
@Path("/guias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class GuiaResource 
{
    @Inject
    private GuiaLogic guialogic;
    
  
    private List<GuiaDetailDTO> listEntity2DTO(List<GuiaEntity> entityList) {
        List<GuiaDetailDTO> list = new ArrayList<>();
        for (GuiaEntity entity : entityList) {
            list.add(new GuiaDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Obtiene los datos de una instancia de Guia a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de GuiaDetailDTO con los datos del Guia consultado
     * 
     */
    @GET
    @Path("{id: \\d+}")
    public GuiaDetailDTO getGuia(@PathParam("id") Long id) {
        GuiaEntity entity = guialogic.getGuia(id);
        if (entity == null) {
            throw new WebApplicationException("El Guia no existe", 404);
        }
        return new GuiaDetailDTO(entity);
    }

    /**
     * Se encarga de crear un Guia en la base de datos
     *
     * @param dto Objeto de GuiaDetailDTO con los datos nuevos
     * @return Objeto de GuiaDetailDTO los datos nuevos y su ID
     * 
     */
    @POST
    public GuiaDetailDTO createGuia(GuiaDetailDTO dto) {
        return new GuiaDetailDTO(guialogic.createGuia(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Guia
     *
     * @param id Identificador de la instancia de Guia a modificar
     * @param dto Instancia de GuiaDetailDTO con los nuevos datos
     * @return Instancia de GuiaDetailDTO con los datos actualizados
     * 
     */
    @PUT
    @Path("{id: \\d+}")
    public GuiaDetailDTO updateGuia(@PathParam("id") Long id, GuiaDetailDTO dto) {
        GuiaEntity entity = dto.toEntity();
        entity.setId(id);
        GuiaEntity oldEntity = guialogic.getGuia(id);
        if (oldEntity == null) {
            throw new WebApplicationException("El guia no existe", 404);
        }
        entity.setCompania(oldEntity.getCompania());
        return new GuiaDetailDTO(guialogic.updateGuia(entity));
    }

    /**
     * Elimina una instancia de Guia de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteGuia(@PathParam("id") Long id) {
        GuiaEntity entity = guialogic.getGuia(id);
        if (entity == null) {
            throw new WebApplicationException("El author no existe", 404);
        }
       guialogic.deleteGuia(id);
    }
    
    
}
