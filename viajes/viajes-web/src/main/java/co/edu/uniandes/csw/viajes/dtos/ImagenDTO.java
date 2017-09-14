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
public class ImagenDTO {
    
    private Long id;
    
    private String ruta;
    
    private String comentario;

    public ImagenDTO(){
        
    }
    
    public ImagenDTO(ImagenEntity entity){
        this.id = entity.getId();
        this.comentario = entity.getComentario();
        this.ruta = entity.getRuta();
    }
    
    
    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
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
    
    public ImagenEntity toEntity(){
        ImagenEntity entity = new ImagenEntity();
        entity.setId(this.id);
        entity.setComentario(this.comentario);
        entity.setRuta(this.ruta);
        return entity;
    }

    
}
