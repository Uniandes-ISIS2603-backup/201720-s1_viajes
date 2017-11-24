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
public class BlogDTO {
    
    private Long id;
    private String titulo;
    private String comentario;

    /**
     * Constructor por defecto
     */
    public BlogDTO() {
        //Constructor por defecto
    }

    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param blog: Es la entidad que se va a convertir a DTO 
     */
    public BlogDTO(BlogEntity blog) {
        this.id = blog.getId();
        this.titulo = blog.getTitulo();
        this.comentario = blog.getComentario();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public BlogEntity toEntity() {
        BlogEntity entity = new BlogEntity();
        entity.setId(this.id);
        entity.setTitulo(this.titulo);
        entity.setComentario(this.comentario);
        return entity;
    }    
}
