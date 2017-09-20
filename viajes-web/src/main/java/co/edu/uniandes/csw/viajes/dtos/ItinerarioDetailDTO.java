/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;

/**
 *
 * @author js.beltran14
 */
public class ItinerarioDetailDTO extends ItinerarioDTO{
    
    public ItinerarioDetailDTO(){
        
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public ItinerarioDetailDTO(ItinerarioEntity entity){
        super(entity);
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public ItinerarioEntity toEntity(){
        ItinerarioEntity entity = super.toEntity();
        return entity;
    }
    
}
