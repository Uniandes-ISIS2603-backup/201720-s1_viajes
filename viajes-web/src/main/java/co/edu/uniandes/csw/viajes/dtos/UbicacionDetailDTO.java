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
    
    public UbicacionDetailDTO(){
        super();
    }
    
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public UbicacionDetailDTO (UbicacionEntity entity){
        super(entity);
    }
}