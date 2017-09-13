/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author m.rodriguez21
 */
public class BlogEntity extends BaseEntity
{
    private String titulo;
    private String comentario;
    
    //////////////////////////////
    //REVISAR SI SE HACE @EMBEDDED
    //////////////////////////////
    //@OneToMany(fetch=FetchType.LAZY)
    //@JoinColumn(name="IMAGEN_ID")
    //private List<ImagenEntity> imagen;
    
    public String getNombreTitulo()
    {
        return titulo;
    }
    
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    
    public String getComentario()
    {
        return comentario;
    }
    
    public void setComentario(String comentario)
    {
        this.comentario = comentario;
    }
    
    // public List<ImagenEntity> getImagenes()
    //{
    //    return imagenes;
    //}
    
    //public void setImagenes(List<ImagenEntity> imagenes)
    //{
    //    this.imagenes = imagenes;
    //}
    
}
