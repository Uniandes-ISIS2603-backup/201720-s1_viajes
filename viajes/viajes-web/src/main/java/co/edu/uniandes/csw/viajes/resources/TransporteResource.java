/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.TransporteDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.TransporteLogic;
import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import co.edu.uniandes.csw.viajes.persistence.TransportePersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 *
 * @author sa.silva1
 */

@Path("transportes")
@Produces("application/json")
@Consumes("application/json")
public class TransporteResource {
    
    @Inject
    TransporteLogic transporteLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    private static final Logger LOGGER = Logger.getLogger(TransportePersistence.class.getName());
    
    @POST
    public TransporteDetailDTO createTransporte(TransporteDetailDTO transporte) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        TransporteEntity transporteEntity = transporte.toEntity();
        // Invoca la lógica para crear lel transporte nuevo
        TransporteEntity nuevoTransporte = transporteLogic.createTransporte(transporteEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new TransporteDetailDTO(nuevoTransporte);
    }

    @GET
    public List<TransporteDetailDTO> getTransportes() throws BusinessLogicException {
        return listEntity2DetailDTO(transporteLogic.getTransportes());
    }
    
     private List<TransporteDetailDTO> listEntity2DetailDTO(List<TransporteEntity> entityList) {
        List<TransporteDetailDTO> list = new ArrayList<>();
        for (TransporteEntity entity : entityList) {
            list.add(new TransporteDetailDTO(entity));
        }
        return list;
    }
     
     @GET
    @Path("{id: \\d+}")
    public TransporteDetailDTO getTransporte(@PathParam("id") Long id) throws BusinessLogicException {
        TransporteEntity entity = transporteLogic.getTransporte(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /transportes/" + id + " no existe.", 404);
        }
        return new TransporteDetailDTO(transporteLogic.getTransporte(id));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public TransporteDetailDTO updateTransporte(@PathParam("id") Long id, TransporteDetailDTO transporte) throws BusinessLogicException {
        //transporte.setId();
        TransporteEntity entity = transporteLogic.getTransporte(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /transportes/" + id + " no existe.", 404);
        }
        return new TransporteDetailDTO(transporteLogic.updateTransporte(id, transporte.toEntity()));
    }
    
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTransporte(@PathParam("id") Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un transporte con id {0}", id);
        TransporteEntity entity = transporteLogic.getTransporte(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /transportes/" + id + " no existe.", 404);
        }
        transporteLogic.deleteTransporte(id);
    }
    
    
}
