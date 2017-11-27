/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author m.rodriguez21
 */
@Entity
public class BlogEntity extends BaseEntity {

    /**
     * Título del blog
     */
    private String titulo;

    /**
     * Comentario del blog
     */
    private String comentario;

    /**
     * Imagenes del blog
     */
    @PodamExclude
    @OneToMany
    private List<ImagenEntity> imagenes;

    /**
     * Obtener el título del blog
     *
     * @return el titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Actualizar el título del blog
     *
     * @param titulo el titulo a settear
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtener el comentario del blog
     *
     * @return el comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Actualizar el comentario del blog
     *
     * @param comentario el comentario a settear
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Obtener las imagenes del blog
     *
     * @return las imagenes
     */
    public List<ImagenEntity> getImagenes() {
        return imagenes;
    }

    /**
     * Actualizar las imagenes del blog
     *
     * @param imagenes las imagenes a settear
     */
    public void setImagenes(List<ImagenEntity> imagenes) {
        this.imagenes = imagenes;
    }
}
