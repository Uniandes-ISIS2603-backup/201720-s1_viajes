/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.BlogEntity;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.rodriguez21
 */
public class BlogDetailDTO extends BlogDTO {
    
    // relación  cero o muchos imagenes
    private List<ImagenDTO> imagenes;
    
    /**
     * Constructor por defecto
     */
    public BlogDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public BlogDetailDTO(BlogEntity entity) {
        super(entity);
        
        if (entity.getImagenes() != null) {
            imagenes = new ArrayList<>();
            for (ImagenEntity entityImagen : entity.getImagenes()) {
                imagenes.add(new ImagenDTO(entityImagen));
            }
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public BlogEntity toEntity() {
        BlogEntity blogE = super.toEntity();
        
        if (this.getImagenes()!= null) {
            List<ImagenEntity> imagenesEntity = new ArrayList<>();
            for (ImagenDTO dtoImagen : getImagenes()) {
                imagenesEntity.add(dtoImagen.toEntity());
            }
            blogE.setImagenes(imagenesEntity);
        }
        
        return blogE;
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
