/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;
import co.edu.uniandes.csw.viajes.entities.PagoEntity;
import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vanessa Huertas <tv.huertas10>
 */
public class TarjetaCreditoDetailDTO extends TarjetaCreditoDTO
{

    /**
     * Pagos realizados con la tarjeta
     */
    private List<PagoDTO> pagos;
    
    /**
     * Usuario al que le pertenece la tarjeta
     */
    private UsuarioDTO usuario;
    
    /**
     * Constructor por defecto
     */
    public TarjetaCreditoDetailDTO()
    {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public TarjetaCreditoDetailDTO(TarjetaCreditoEntity entity) {
        super(entity);
        
        if (entity.getPagos() != null) {
            pagos = new ArrayList<>();
            for (PagoEntity entityPago : entity.getPagos()) {
                pagos.add(new PagoDTO(entityPago));
            }
        }
        if (entity.getUsuario() != null) {
            this.usuario = new UsuarioDTO(entity.getUsuario());
        } else {
            entity.setUsuario(null);
        }
    } 
   
    /**
     * Lista de pagos realizados con la tarjeta
     * @return pagos
     */    
    public List<PagoDTO> getPagos() {
        return pagos;
    }

    /**
     * Usuario al que le pertenece la tarjeta
     * @return usuario
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * Agrega los pagos hechos con la tarjeta
     * @param pagos 
     */
    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    /**
     * Asigna un nuevo usuario a la tarjeta   
     * @param usuario 
     */
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public TarjetaCreditoEntity toEntity() {
        TarjetaCreditoEntity tarjetaE = super.toEntity();
        
        if (this.getPagos() != null) {
            List<PagoEntity> pagosEntity = new ArrayList<>();
            for (PagoDTO dtoPago : getPagos()) {
                pagosEntity.add(dtoPago.toEntity());
            }
            tarjetaE.setPagos(pagosEntity);
        }
        
        if (this.getUsuario() != null) {
            tarjetaE.setUsuario(this.getUsuario().toEntity());
        }
        return tarjetaE;
    }
}
