
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
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public HospedajeDetailDTO (HospedajeEntity entity){
        super(entity);
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public HospedajeEntity toEntity(){
        HospedajeEntity entity = super.toEntity();
        return entity;
    }
}