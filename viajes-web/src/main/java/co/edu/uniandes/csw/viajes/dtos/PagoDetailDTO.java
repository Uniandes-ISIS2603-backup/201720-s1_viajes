/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.PagoEntity;

/**
 *
 * @author Vanessa Huertas <tv.huertas10>
 */
public class PagoDetailDTO extends PagoDTO
{
    
    /**
     * Tarjeta de credito con la que se realizó el pago
     */
    private TarjetaCreditoDTO tarjeta;
    
    /**
     * Constructor por defecto
     */
    public PagoDetailDTO() {
        super();
    }

     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public PagoDetailDTO(PagoEntity entity) {
        super(entity);
        
        if (entity.getTarjeta() != null) {
            this.tarjeta = new TarjetaCreditoDTO(entity.getTarjeta());
        } else {
            entity.setTarjeta(null);
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public PagoEntity toEntity()
    {
        PagoEntity pago = super.toEntity();
        if (this.getTarjeta()!= null) {
            pago.setTarjeta(this.getTarjeta().toEntity());
        }
        
        return pago;
    }
    
    /**
     * @return tarjeta
     */
    public TarjetaCreditoDTO getTarjeta() {
        return tarjeta;
    }

    /**
     * @param tarjeta the tarjeta to set
     */
    public void setTarjeta(TarjetaCreditoDTO tarjeta) {
        this.tarjeta = tarjeta;
    }  
    
    }
