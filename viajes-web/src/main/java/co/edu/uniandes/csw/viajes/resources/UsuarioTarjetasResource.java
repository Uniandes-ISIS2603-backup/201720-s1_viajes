/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.TarjetaCreditoDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.UsuarioLogic;
import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
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
public class UsuarioTarjetasResource {
    
    @Inject
    private UsuarioLogic usuarioLogic;

    /**
     * Convierte una lista de TarjetaCreditoEntity a una lista de TarjetaCreditoDetailDTO.
     *
     * @param entityList Lista de TarjetaCreditoEntity a convertir.
     * @return Lista de TarjetaCreditoDetailDTO convertida.
     * 
     */
    private List<TarjetaCreditoDetailDTO> tarjetasListEntity2DTO(List<TarjetaCreditoEntity> entityList) {
        List<TarjetaCreditoDetailDTO> list = new ArrayList<>();
        for (TarjetaCreditoEntity entity : entityList) {
            list.add(new TarjetaCreditoDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de TarjetaCreditoDetailDTO a una lista de TarjetaCreditoEntity.
     *
     * @param dtos Lista de TarjetaCreditoDetailDTO a convertir.
     * @return Lista de TarjetaCreditoEntity convertida.
     * 
     */
    private List<TarjetaCreditoEntity> tarjetasListDTO2Entity(List<TarjetaCreditoDetailDTO> dtos) {
        List<TarjetaCreditoEntity> list = new ArrayList<>();
        for (TarjetaCreditoDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de TarjetaCreditoDetailDTO asociadas a una
     * instancia de Usuario
     *
     * @param usuariosId Identificador de la instancia de Usuario
     * @return Colección de instancias de TarjetaCreditoDetailDTO asociadas a la
     * instancia de Usuario
     * 
     */
    @GET
    public List<TarjetaCreditoDetailDTO> listItinerarios(@PathParam("usuariosId") Long usuariosId) {
        return tarjetasListEntity2DTO(usuarioLogic.getTarjetasCredito(usuariosId));
    }

    /**
     * Obtiene una instancia de TarjetaCredito asociada a una instancia de Usuario
     *
     * @param usuariosId Identificador de la instancia de Usuario
     * @param tarjetasId Identificador de la instancia de TarjetaCredito
     * @return 
     * 
     */
    @GET
    @Path("{tarjetasId: \\d+}")
    public TarjetaCreditoDetailDTO getTarjeta(@PathParam("usuariosId") Long usuariosId, @PathParam("tarjetasId") Long tarjetasId) {
        return new TarjetaCreditoDetailDTO(usuarioLogic.getTarjeta(usuariosId, tarjetasId));
    }

    /**
     * Asocia una TarjetaCredito existente a un Usuario
     *
     * @param usuariosId Identificador de la instancia de Usuario
     * @param tarjetasId Identificador de la instancia de TarjetaCredito
     * @return Instancia de TarjetaCreditoDetailDTO que fue asociada a Usuario
     * 
     */
    @POST
    @Path("{tarjetasId: \\d+}")
    public TarjetaCreditoDetailDTO addTarjeta(@PathParam("usuariosId") Long usuariosId, @PathParam("tarjetasId") Long tarjetasId) {
        return new TarjetaCreditoDetailDTO(usuarioLogic.addTarjeta(usuariosId, tarjetasId));
    }

    /**
     * Remplaza las instancias de TarjetaCredito asociadas a una instancia de Usuario
     *
     * @param usuariosId Identificador de la instancia de Usuario
     * @param tarjetas Colección de instancias de TarjetaCreditoDTO a asociar a instancia
     * de Usuario
     * @return Nueva colección de TarjetaCreditoDTO asociada a la instancia de Usuario
     * 
     */
    @PUT
    public List<TarjetaCreditoDetailDTO> replaceTarjetaCredito(@PathParam("usuariosId") Long usuariosId, List<TarjetaCreditoDetailDTO> tarjetas) {
        return tarjetasListEntity2DTO(usuarioLogic.replaceTarjetaCredito(usuariosId, tarjetasListDTO2Entity(tarjetas)));
    }

    /**
     * Desasocia una TarjetaCredito existente de un Usuario existente
     *
     * @param usuariosId Identificador de la instancia de Usuario
     * @param tarjetasId Identificador de la instancia de TarjetaCredito
     * 
     */
    @DELETE
    @Path("{tarjetasId: \\d+}")
    public void removeTarjetaCredito(@PathParam("usuariosId") Long usuariosId, @PathParam("tarjetasId") Long tarjetasId) {
        usuarioLogic.removeTarjetaCredito(usuariosId, tarjetasId);
    }
}
