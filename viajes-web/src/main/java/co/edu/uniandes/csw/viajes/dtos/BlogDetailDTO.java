/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.BlogEntity;

/**
 *
 * @author m.rodriguez21
 */
public class BlogDetailDTO extends BlogDTO {
    
    /**
     * Constructor por defecto
     */
    public BlogDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public BlogDetailDTO(BlogEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public BlogEntity toEntity() {
        BlogEntity blogE = super.toEntity();
        return blogE;
    }
    
}
