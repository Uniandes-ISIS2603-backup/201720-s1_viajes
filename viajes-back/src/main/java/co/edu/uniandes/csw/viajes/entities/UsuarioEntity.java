package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author tv.huertas10
 */
@Entity
public class UsuarioEntity extends BaseEntity 
{
    /** 
     * Nombre del usuario
     */
    private String nombre;  
    
    /**
     * Tarjetas que le pertenecen al usuario
     */
    @PodamExclude
    @OneToMany(mappedBy = "usuario")
    private List<TarjetaCreditoEntity> tarjeta;
    
    /**
     * Itinerarios que tiene el usuario
     */
    @PodamExclude
    @OneToMany
    private List<ItinerarioEntity> itinerario;
    
    
    /**
     * Blog que le pertenece al usuario
     */
    @PodamExclude
    @OneToOne
    private BlogEntity blog;
    
    /**
     * Lista de itinerarios programados por el usuario
     * 
     * @return itinerarios
     */
    public List<ItinerarioEntity> getItinerarios()
    {
        return itinerario;
    }
        
    /**
     * Se agregan itinerarios a la lista de itinerarios del usuario
     * @param itinerarios 
     */
    public void setItinerarios(List<ItinerarioEntity> itinerarios)
    {
        this.itinerario = itinerarios;
    }
        
    /**
     * Tarjetas de credito de las que el usuario es dueño
     * @return 
     */
    public List<TarjetaCreditoEntity> getTarjetas()
    {
        return tarjeta;
    }
    
    /**
     * Se agregan tarjetas al usuario
     * @param tarjetas 
     */
    public void setTarjetas(List<TarjetaCreditoEntity> tarjetas)
    {
        this.tarjeta = tarjetas;
    }
    
    /**
     * Nombre del usuario
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Se cambia el nombre del usuario
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Blog que le pertenece al usuario
     * @return blog
     */
    public BlogEntity getBlog() {
        return blog;
    }

    /**
     * Agrega un blog al usuario
     * @param blog 
     */
    public void setBlog(BlogEntity blog) {
        this.blog = blog;
    }    
}