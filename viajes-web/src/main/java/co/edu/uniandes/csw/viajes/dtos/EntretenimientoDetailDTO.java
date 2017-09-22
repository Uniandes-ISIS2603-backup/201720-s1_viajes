/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;

/**
 *
 * @author m.rodriguez21
 */
public class EntretenimientoDetailDTO extends EntretenimientoDTO{
    
    /**
     * Constructor por defecto
     */
    public EntretenimientoDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public EntretenimientoDetailDTO(EntretenimientoEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public EntretenimientoEntity toEntity() {
        EntretenimientoEntity entretenimientoE = super.toEntity();
        return entretenimientoE;
    }
    
}