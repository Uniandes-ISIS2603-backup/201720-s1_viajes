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
    
    /*
    * Relación a una ubicacion
    */
    private UbicacionDTO ubicacion;
    
    /**
     * Constructor por defecto
     */
    public OficinaDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public OficinaDetailDTO(OficinaEntity entity) {
        super(entity);
        
        if (entity.getUbicacion() != null) {
            this.ubicacion = new UbicacionDTO(entity.getUbicacion());
        } else {
            entity.setUbicacion(null);
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public OficinaEntity toEntity() {
        OficinaEntity oficinaE = super.toEntity();
        if (this.getUbicacion() != null) {
            oficinaE.setUbicacion(this.getUbicacion().toEntity());
        }
        return oficinaE;
    }
    
    public void setUbicacion(UbicacionDTO ubicacion) {
        this.ubicacion = ubicacion;
    }

    public UbicacionDTO getUbicacion() {
        return ubicacion;
    }
    
}
