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
 * Clase que representa el recurso de Transporte
 * @author sa.silva1
 */

@Path("transportes")
@Produces("application/json")
@Consumes("application/json")
public class TransporteResource {
    
    /**
     * Logica de transporte
     */
    @Inject
    TransporteLogic transporteLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    /**
     * Logger de la clase, se encarga de imprimir en consola informando lo que va sucediendo
     */
    private static final Logger LOGGER = Logger.getLogger(TransportePersistence.class.getName());
    
    /**
     * POST http://localhost:8080/viajesp-web/api/transportes Ejemplo
     * json: { "name":"Santa fe es muy malo" }
     *
     * @param transporte correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "transporteDetailDTO", "id": 1, "name": "Santa fe es pero muy malo" }
     */
    @POST
    public TransporteDetailDTO createTransporte(TransporteDetailDTO transporte) {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        TransporteEntity transporteEntity = transporte.toEntity();
        // Invoca la lógica para crear lel transporte nuevo
        TransporteEntity nuevoTransporte = transporteLogic.createTransporte(transporteEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new TransporteDetailDTO(nuevoTransporte);
    }

    /**
     * GET para todas los transportes.
     * http://localhost:8080/viajes-web/api/transportes
     *
     * @return la lista de todas los transportes en objetos json DTO.
     */
    @GET
    public List<TransporteDetailDTO> getTransportes(){
        return listEntity2DetailDTO(transporteLogic.getTransportes());
    }
    
    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos TransporteEntity a una lista de
     * objetos TransporteDetailDTO (json)
     *
     * @param entityList corresponde a la lista de transportes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de transportes en forma DTO (json)
     */
    private List<TransporteDetailDTO> listEntity2DetailDTO(List<TransporteEntity> entityList) {
        List<TransporteDetailDTO> list = new ArrayList<>();
        for (TransporteEntity entity : entityList) {
            list.add(new TransporteDetailDTO(entity));
        }
        return list;
    }
     
    /**
     * GET para un transporte
     * http://localhost:8080/viajesp-web/api/transportes/1
     *
     * @param id corresponde al id del transporte buscado.
     * @return El transporte encontrado. Ejemplo: { "type": "transporteDetailDTO",
     * "id": 1, "name": "Santa fe es muy muy malo" }
     * En caso de no existir el id del transporte buscado se retorna un 404 con
     * el mensaje.
     */

    @GET
    @Path("{id: \\d+}")
    public TransporteDetailDTO getTransporte(@PathParam("id") Long id){
        TransporteEntity entity = transporteLogic.getTransporte(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /transportes/" + id + " no existe.", 404);
        }
        return new TransporteDetailDTO(transporteLogic.getTransporte(id));
    }
    
    /**
     * PUT http://localhost:8080/viajesp-web/api/transportes/1 Ejemplo
     * json { "id": 1, "name": "Santa fe sigue siendo muy malo" }
     *
     * @param id corresponde al transporte a actualizar.
     * @param transporte corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return El transporte actualizado.
     * En caso de no existir el id del transporte a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public TransporteDetailDTO updateTransporte(@PathParam("id") Long id, TransporteDetailDTO transporte){
        transporte.setIdTransporte(id);
        TransporteEntity entity = transporteLogic.getTransporte(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /transportes/" + id + " no existe.", 404);
        }
        return new TransporteDetailDTO(transporteLogic.updateTransporte(transporte.toEntity()));
    }

    
    /**
     * DELETE http://localhost:8080/viajesp-web/api/transportes/1
     *
     * @param id corresponde al transporte a borrar.
     * En caso de no existir el id del transporte a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTransporte(@PathParam("id") Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un transporte con id {0}", id);
        TransporteEntity entity = transporteLogic.getTransporte(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /transportes/" + id + " no existe.", 404);
        }
        transporteLogic.deleteTransporte(id);
    }

}
