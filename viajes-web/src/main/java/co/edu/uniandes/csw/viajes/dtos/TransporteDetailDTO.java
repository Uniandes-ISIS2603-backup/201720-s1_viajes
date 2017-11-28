/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.TransporteEntity;

/**
 * Clase del transporte DTO en detalle
 * @author sa.silva1
 */
public class TransporteDetailDTO extends TransporteDTO{
    
    /**
     * Constructor por defecto
     */
    public TransporteDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    
    public TransporteDetailDTO(TransporteEntity entity) {
        super(entity);
    }
}
