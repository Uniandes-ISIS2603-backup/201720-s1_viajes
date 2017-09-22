/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.CascadeType;
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
     @OneToMany(mappedBy = "blog",cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<ImagenEntity> imagenes;
    
    public String getTitulo()
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
    
     public List<ImagenEntity> getImagenes()
    {
        return imagenes;
    }
    
    public void setImagenes(List<ImagenEntity> imagenes)
    {
        this.imagenes = imagenes;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }    

}
