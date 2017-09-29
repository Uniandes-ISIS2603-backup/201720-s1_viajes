/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.CompaniaDTO;
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
@Path("companias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class CompaniaResource {
    
    @Inject
    private CompaniaLogic companialogic;
  
    /**
     * 
     * @param entityList
     * @return list 
     */    
    private List<CompaniaDetailDTO> listEntity2DTO(List<CompaniaEntity> entityList)
    {
        List<CompaniaDetailDTO> list= new ArrayList<>();
        for(CompaniaEntity entity : entityList)
        {
            list.add(new CompaniaDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    @GET
    @Path("{id : \\d+}")
    public CompaniaDetailDTO getCompania(@PathParam("id") Long id)
    {
        CompaniaEntity entity= companialogic.getCompania(id);
        if (entity==null) {
            throw new  WebApplicationException("La compania no existe", 404);    
        }
        return new CompaniaDetailDTO(entity);
    }
    
    /**
     *
     * @return devuelve los companias en la base de datos.
     */
    @GET
    public List<CompaniaDTO> getGuia(){
        List<CompaniaDTO> CompaniasDTOS = new ArrayList<>();

        List<CompaniaEntity> guias = companialogic.getCompanias();
        for(CompaniaEntity guia : guias){
            CompaniaDTO dto = new CompaniaDTO(guia);
            CompaniasDTOS.add(dto);
        }
        return CompaniasDTOS;
    }
    
    
    /**
     * 
     * @param dto
     * @return 
     */
    @POST
    public CompaniaDetailDTO createCompania(CompaniaDetailDTO dto)
    {
        return new  CompaniaDetailDTO(companialogic.createCompania(dto.toEntity()));
    }

    /**
     *
     * @param id
     * @return
     */
    @PUT
    @Path("{id : \\d+}")
    public CompaniaDetailDTO getCompania(@PathParam("id") Long id, CompaniaDetailDTO dto)
    {
        CompaniaEntity entity= dto.toEntity();
        entity.setId(id);
        CompaniaEntity oldEntity = companialogic.getCompania(id);
        if (oldEntity==null) {
            throw new  WebApplicationException("La compania no existe", 404); 
        }
        entity.setOficinas(oldEntity.getOficinas());
        return new CompaniaDetailDTO(companialogic.updateCompania(entity));
    }

    @DELETE
    @Path("{id : \\d+}")
    public void deleteCompania(@PathParam("id") Long id)
    {
     CompaniaEntity entity= companialogic.getCompania(id);
         if (entity==null) {
            throw new  WebApplicationException("La compania no existe", 404); 
        }
       companialogic.deleteCompania(id);
    }
}
