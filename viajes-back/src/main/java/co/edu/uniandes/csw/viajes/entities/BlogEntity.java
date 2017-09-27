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
public class BlogEntity extends BaseEntity
{
    private String titulo;
    private String comentario;
    
    @PodamExclude
    @OneToMany
    private List<ImagenEntity> imagenes;
    
    /**
     * @return el titulo
     */
    public String getTitulo()
    {
        return titulo;
    }
    
    /**
     * @param titulo el titulo a settear
     */
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    
    /**
     * @return el comentario
     */
    public String getComentario()
    {
        return comentario;
    }
    
    /**
     * @param comentario el comentario a settear
     */
    public void setComentario(String comentario)
    {
        this.comentario = comentario;
    }
    
    /**
     * @return las imagenes
     */
     public List<ImagenEntity> getImagenes()
    {
        return imagenes;
    }
    
     /**
     * @param imagenes las imagenes a settear
     */
    public void setImagenes(List<ImagenEntity> imagenes)
    {
        this.imagenes = imagenes;
    }
}
