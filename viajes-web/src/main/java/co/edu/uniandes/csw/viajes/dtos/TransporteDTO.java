/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import co.edu.uniandes.csw.viajes.entities.TransporteEntity.TipoTransporte;

/**
 *
 * @author sa.silva1
 */
public class TransporteDTO extends ServicioDTO{
    
    private TipoTransporte tipo;

    public TransporteDTO() {
    }
    
    public TransporteDTO(TransporteEntity entity){
        super(entity);
        this.tipo = entity.getTipo();
    }

    public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
    
    public TransporteEntity toEntity(){
        TransporteEntity entity = new TransporteEntity();
        
        entity.setTipo(this.tipo);
        return entity;
    }
    
}
