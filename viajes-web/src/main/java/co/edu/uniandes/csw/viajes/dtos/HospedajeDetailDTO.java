
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;

/**
 *
 * @author ma.forero11
 */
public class HospedajeDetailDTO extends HospedajeDTO {
    
    public HospedajeDetailDTO (HospedajeEntity entity){
        super(entity);
    }
    
    @Override
    public HospedajeEntity toEntity(){
        HospedajeEntity entity = super.toEntity();
        return entity;
    }
}