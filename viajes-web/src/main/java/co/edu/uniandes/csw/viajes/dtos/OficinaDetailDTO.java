/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.OficinaEntity;

/**
 *
 * @author m.rodriguez21
 */
public class OficinaDetailDTO extends OficinaDTO {
    
    /**
     * Constructor por defecto
     */
    public OficinaDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public OficinaDetailDTO(OficinaEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public OficinaEntity toEntity() {
        OficinaEntity oficinaE = super.toEntity();
        return oficinaE;
    }
    
    
}
