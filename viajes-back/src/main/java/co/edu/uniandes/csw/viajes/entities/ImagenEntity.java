/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.Entity;

/**
 *
 * Falta el @entity
 * @author js.beltran14
 */
@Entity
public class ImagenEntity extends BaseEntity{

    /**
     * Ruta de la imagen
     */
    private String ruta;
        
    /**
     * Comentario de la imagen 
     */
    private String comentario;
           
    /**
     * Obtener la ruta de la imagen 
     * @return ruta de la imagen
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Actaulizar la ruta de la imagen 
     * @param ruta la ruta a actualizar
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * Obtener el comentario de la imagen 
     * @return El comentario de la imagen
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Actualizar el comentario de la imagen 
     * @param comentario el comentario a actualizar
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}