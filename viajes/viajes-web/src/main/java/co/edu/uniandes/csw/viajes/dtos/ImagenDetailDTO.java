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
        
    }
    
    public ImagenDetailDTO(ImagenEntity entity){
        super(entity);
    }
    
    @Override
    public ImagenEntity toEntity(){
        ImagenEntity entity = super.toEntity();
        return entity;
    }
    
}
