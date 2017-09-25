/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.HospedajeDTO;
import co.edu.uniandes.csw.viajes.dtos.HospedajeDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.HospedajeLogic;
import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
import co.edu.uniandes.csw.viajes.excpetions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
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
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author ma.forero11
 */
@Path("hospedajes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class HospedajeResource {
    
    @Inject
    HospedajeLogic hospedajeLogic;
    
    /**
     * GET para todas los hospedajes.
     * http://localhost:8080/viajes-web/api/hospedajes
     *
     * @return la lista de todas las hospedajes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<HospedajeDetailDTO> getHospedajes() throws BusinessLogicException{
        return listEntity2DetailDTO(hospedajeLogic.getHospedajes());
    }
    
    @GET
    @Path("{id: \\d+}")
    public HospedajeDetailDTO getHospedaje(@PathParam("id") Long id) throws BusinessLogicException {
        HospedajeEntity toGet = hospedajeLogic.getHospedaje(id);
        if(toGet==null){
            throw new WebApplicationException("El recurso /hospedajes/" + id + " no existe.", 404);
        }
        return new HospedajeDetailDTO(toGet);
    }
    
    @POST
    public HospedajeDTO createHospedaje(HospedajeDTO itinerarioDTO)throws BusinessLogicException{
        HospedajeEntity itinerario = itinerarioDTO.toEntity();
        HospedajeEntity entity = hospedajeLogic.createHospedaje(itinerario);  
        return new HospedajeDTO(entity);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public HospedajeDTO updateHospedaje(@PathParam("id") Long id, HospedajeDTO dto)throws BusinessLogicException {
       HospedajeEntity entity = dto.toEntity();
       entity.setId(id);
       return new HospedajeDTO(hospedajeLogic.updateHospedaje(entity)); 
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteHospedaje(@PathParam("id") Long id)throws BusinessLogicException {
       hospedajeLogic.deleteHospedaje(id);
    }
    
    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos HospedajeEntity a una lista de
     * objetos HospedajeDetailDTO (json)
     *
     * @param entityList corresponde a la lista de hospedajes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de hospedaje en forma DTO (json)
     */
    private List<HospedajeDetailDTO> listEntity2DetailDTO(List<HospedajeEntity> entityList) {
        List<HospedajeDetailDTO> list = new ArrayList<>();
        for (HospedajeEntity entity : entityList) {
            list.add(new HospedajeDetailDTO(entity));
        }
        return list;
    }
}