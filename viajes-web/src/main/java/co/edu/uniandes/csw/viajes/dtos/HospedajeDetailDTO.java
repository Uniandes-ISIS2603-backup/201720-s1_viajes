
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ma.forero11
 */
public class HospedajeDetailDTO extends HospedajeDTO {
    
    private List<ImagenDTO> imagenes;
    
    public HospedajeDetailDTO(){
        super();
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public HospedajeDetailDTO (HospedajeEntity entity){
        super(entity);
        
        if(entity.getImagenes()!=null){
            imagenes = new ArrayList<>();
            for(ImagenEntity entityImage : entity.getImagenes())
                imagenes.add(new ImagenDTO(entityImage));
        }
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public HospedajeEntity toEntity(){
        HospedajeEntity entity = super.toEntity();
        
        if(this.getImagenes()!=null){
            List<ImagenEntity> imagenesEntity = new ArrayList<>();
            for (ImagenDTO dtoImagen : getImagenes()) {
                imagenesEntity.add(dtoImagen.toEntity());
            }
            entity.setImagenes(imagenesEntity);
        }
        return entity;
    }
    
    /**
     * @return the imagenes
     */
    public List<ImagenDTO> getImagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setImagens(List<ImagenDTO> imagenes) {
        this.imagenes = imagenes;
    }

}