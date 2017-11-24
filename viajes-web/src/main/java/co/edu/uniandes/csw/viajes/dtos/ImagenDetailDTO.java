/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.ImagenEntity;

/**
 *
 * @author js.beltran14
 */
public class ImagenDetailDTO extends ImagenDTO{
    
    public ImagenDetailDTO(){
        super();
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public ImagenDetailDTO(ImagenEntity entity){
        super(entity);
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public ImagenEntity toEntity(){
        return super.toEntity();
        
    }
    
}
