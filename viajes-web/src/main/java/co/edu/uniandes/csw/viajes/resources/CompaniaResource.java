/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.CompaniaDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.CompaniaLogic;
import co.edu.uniandes.csw.viajes.entities.CompaniaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Juan
 */
@Path("/companias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class CompaniaResource
{
    @Inject
    private CompaniaLogic companialogic;
            
    private List<CompaniaDetailDTO> listEntity2DTO(List<CompaniaEntity> entityList) {
        List<CompaniaDetailDTO> list = new ArrayList<>();
        for (CompaniaEntity entity : entityList) {
            list.add(new CompaniaDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Obtiene los datos de una instancia de Compania a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CompaniaDetailDTO con los datos del Author consultado
     * 
     */
    @GET
    @Path("{id: \\d+}")
    public CompaniaDetailDTO getCompania(@PathParam("id") Long id) {
        CompaniaEntity entity = companialogic.getCompania(id);
        if (entity == null) {
            throw new WebApplicationException("El Guia no existe", 404);
        }
        return new CompaniaDetailDTO(entity);
    }

    /**
     * Se encarga de crear un Compania en la base de datos
     *
     * @param dto Objeto de CompaniaDetailDTO con los datos nuevos
     * @return Objeto de CompaniaDetailDTO los datos nuevos y su ID
     * 
     */
    @POST
    public CompaniaDetailDTO createCompania(CompaniaDetailDTO dto) {
        return new CompaniaDetailDTO(companialogic.createCompania(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Compania
     *
     * @param id Identificador de la instancia de Compania a modificar
     * @param dto Instancia de CompaniaDetailDTO con los nuevos datos
     * @return Instancia de CompaniaDetailDTO con los datos actualizados
     * 
     */
    @PUT
    @Path("{id: \\d+}")
    public CompaniaDetailDTO updateCompania(@PathParam("id") Long id, CompaniaDetailDTO dto) {
        CompaniaEntity entity = dto.toEntity();
        entity.setId(id);
        CompaniaEntity oldEntity = companialogic.getCompania(id);
        if (oldEntity == null) {
            throw new WebApplicationException("El guia no existe", 404);
        }
        //entity.setOficinas(oldEntity.getOficinas());
        return new CompaniaDetailDTO(companialogic.updateCompania(entity));
    }

    /**
     * Elimina una instancia de Compania de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCompania(@PathParam("id") Long id) {
        CompaniaEntity entity = companialogic.getCompania(id);
        if (entity == null) {
            throw new WebApplicationException("El author no existe", 404);
        }
       companialogic.deleteCompania(id);
    }    
    
}
