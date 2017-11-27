/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.PagoDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.PagoLogic;
import co.edu.uniandes.csw.viajes.entities.PagoEntity;
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

/**
 *
 * @author Vanessa Huertas <tv.huertas10>
 */
@Path("pagos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PagoResource {
    
    /**
     * Acceso a la lógica de la aplicación
     */
    @Inject
    PagoLogic pagoLogic;
    
    /**
     * POST http://localhost:8080/viajesp-web/api/pagos Ejemplo
     * json: { "name":"Norma" }
     *
     * @param pago correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "pagoDetailDTO", "id": 1, "name": "Norma" }
     */
    @POST
    public PagoDetailDTO createPago(PagoDetailDTO pago)  {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        PagoEntity pagoEntity = pago.toEntity();
        // Invoca la lógica para crear el nuevo pago
        PagoEntity nuevoPago = pagoLogic.createPago(pagoEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new PagoDetailDTO(nuevoPago);
    }

    /**
     * GET para todos los pagoss.
     * http://localhost:8080/viajes-web/api/pagos
     *
     * @return la lista de todos los pagos en objetos json DTO.
     * @throws WebApplicationException
     */
    @GET
    public List<PagoDetailDTO> getPagos(){
        return listEntity2DetailDTO(pagoLogic.getPagos());
    }

    /**
     * GET para un pago
     * http://localhost:8080/viajesp-web/api/pagos/1
     *
     * @param id corresponde al id del pago buscado.
     * @return El pago encontrado. Ejemplo: { "type": "pagoDetailDTO",
     * "id": 1, "name": "Norma" }
     * En caso de no existir el id del pago buscado se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public PagoDetailDTO getPago(@PathParam("id") Long id){
        PagoEntity entity = pagoLogic.getPago(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /blogs/" + id + " no existe.", 404);
        }
        return new PagoDetailDTO(pagoLogic.getPago(id));
    }

    /**
     * PUT http://localhost:8080/viajesp-web/api/pagos/1 Ejemplo
     * json { "id": 1, "name": "cambio de nombre" }
     *
     * @param id corresponde al pago a actualizar.
     * @param pago corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return El pago actualizado.
     * En caso de no existir el id del pago a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public PagoDetailDTO updateBlog(@PathParam("id") Long id, PagoDetailDTO pago)  {
        pago.setId(id);
        PagoEntity entity = pagoLogic.getPago(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /pagos/" + id + " no existe.", 404);
        }
        return new PagoDetailDTO(pagoLogic.updatePago(pago.toEntity()));
    }

    /**
     * DELETE http://localhost:8080/viajesp-web/api/pagos/1
     *
     * @param id corresponde al pago a borrar.
     * En caso de no existir el id del pago a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBlog(@PathParam("id") Long id)  {
        PagoEntity entity = pagoLogic.getPago(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /pagos/" + id + " no existe.", 404);
        }
        pagoLogic.deletePago(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos PagoEntity a una lista de
     * objetos PagoDetailDTO (json)
     *
     * @param entityList corresponde a la lista de pagos de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de bloges en forma DTO (json)
     */
    private List<PagoDetailDTO> listEntity2DetailDTO(List<PagoEntity> entityList) {
        List<PagoDetailDTO> list = new ArrayList<>();
        for (PagoEntity entity : entityList) {
            list.add(new PagoDetailDTO(entity));
        }
        return list;
    }   
}
