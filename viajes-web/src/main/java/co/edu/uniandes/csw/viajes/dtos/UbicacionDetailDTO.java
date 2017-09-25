/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;

/**
 *
 * @author ma.forero11
 */
public class UbicacionDetailDTO extends UbicacionDTO{
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public UbicacionDetailDTO (UbicacionEntity entity){
        super(entity);
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public UbicacionEntity toEntity(){
        UbicacionEntity entity = super.toEntity();
        return entity;
    }
}