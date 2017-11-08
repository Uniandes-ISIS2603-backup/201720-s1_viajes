/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.PagoDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.viajes.entities.PagoEntity;
import java.util.ArrayList;
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

/**
 *
 * @author Vanessa Huertas <tv.huertas10>
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TarjetaCreditoPagosResource {
    
    @Inject
    private TarjetaCreditoLogic tarjetaCreditoLogic;
    
     /**
     * Convierte una lista de PagoEntity a una lista de PagoDetailDTO.
     *
     * @param entityList Lista de PagoEntity a convertir.
     * @return Lista de PagoDetailDTO convertida.
     * 
     */
    private List<PagoDetailDTO> pagosListEntity2DTO(List<PagoEntity> entityList) {
        List<PagoDetailDTO> list = new ArrayList<>();
        for (PagoEntity entity : entityList) {
            list.add(new PagoDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de PagoDetailDTO a una lista de PagoEntity.
     *
     * @param dtos Lista de PagoDetailDTO a convertir.
     * @return Lista de PagoEntity convertida.
     * 
     */
    private List<PagoEntity> pagosListDTO2Entity(List<PagoDetailDTO> dtos) {
        List<PagoEntity> list = new ArrayList<>();
        for (PagoDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de PagoDetailDTO asociadas a una
     * instancia de TarjetaCredito
     *
     * @param tarjetasId Identificador de la instancia de TarjetaCredito
     * @return Colección de instancias de PagoDetailDTO asociadas a la
     * instancia de TarjetaCredito
     * 
     */
    @GET
    public List<PagoDetailDTO> listPagos(@PathParam("tarjetasId") Long tarjetasId) {
        return pagosListEntity2DTO(tarjetaCreditoLogic.getPagos(tarjetasId));
    }

    /**
     * Obtiene una instancia de Pago asociada a una instancia de TarjetaCredito
     *
     * @param tarjetasId Identificador de la instancia de TarjetaCredito
     * @param pagosId Identificador de la instancia de Pago
     * @return 
     * 
     */
    @GET
    @Path("{pagosId: \\d+}")
    public PagoDetailDTO getPago(@PathParam("tarjetasId") Long tarjetasId, @PathParam("pagosId") Long pagosId) {
        return new PagoDetailDTO(tarjetaCreditoLogic.getPago(tarjetasId, pagosId));
    }

    /**
     * Asocia un Pago existente a una TarjetaCredito
     *
     * @param tarjetasId Identificador de la instancia de TarjetaCredito
     * @param pagosId Identificador de la instancia de Pago
     * @return Instancia de PagoDetailDTO que fue asociada a TarjetaCredito
     * 
     */
    @POST
    @Path("{pagosId: \\d+}")
    public PagoDetailDTO addPago(@PathParam("tarjetasId") Long tarjetasId, @PathParam("pagosId") Long pagosId) {
        return new PagoDetailDTO(tarjetaCreditoLogic.addPago(tarjetasId, pagosId));
    }

    /**
     * Remplaza las instancias de Pago asociadas a una instancia de Tarjetacredito
     *
     * @param tarjetasId Identificador de la instancia de TarjetaCredito
     * @param pagos Colección de instancias de PagoDTO a asociar a instancia
     * de TarjetaCredito
     * @return Nueva colección de PagoDTO asociada a la instancia de TarjetaCredito
     * 
     */
    @PUT
    public List<PagoDetailDTO> replacePagos(@PathParam("tarjetasId") Long tarjetasId, List<PagoDetailDTO> pagos) {
        return pagosListEntity2DTO(tarjetaCreditoLogic.replacePago(tarjetasId, pagosListDTO2Entity(pagos)));
    }

    /**
     * Desasocia un Pago existente de una TarjetaCredito existente
     *
     * @param tarjetasId Identificador de la instancia de TarjetaCredito
     * @param pagosId Identificador de la instancia de Pago
     * 
     */
    @DELETE
    @Path("{pagosId: \\d+}")
    public void removePagos(@PathParam("tarjetasId") Long tarjetasId, @PathParam("pagosId") Long pagosId) {
        tarjetaCreditoLogic.removePago(tarjetasId, pagosId);
    }    
}
