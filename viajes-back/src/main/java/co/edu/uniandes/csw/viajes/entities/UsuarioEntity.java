package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author tv.huertas10
 */
@Entity
public class UsuarioEntity extends BaseEntity 
{
    //ATRIBUTOS
    
    /** 
     * Nombre del usuario
     */
    private String nombre;  
    
    /**
     * Tarjetas que le pertenecen al usuario
     */
    @PodamExclude
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TarjetaCreditoEntity> tarjetas;
    
    /**
     * Itinerarios que tiene el usuario
     */
    @ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private List<ItinerarioEntity> itinerarios;
    
    //GETTERS/SETTERS
    
    /**
     * Lista de itinerarios programados por el usuario
     * 
     * @return itinerarios
     */
    public List<ItinerarioEntity> getItinerarios()
    {
        return itinerarios;
    }
    
    public void setItinerarios(List<ItinerarioEntity> itinerarios)
    {
        this.itinerarios = itinerarios;
    }
        
    public List<TarjetaCreditoEntity> getTarjetas()
    {
        return tarjetas;
    }
    
    public void setTarjetas(List<TarjetaCreditoEntity> tarjetas)
    {
        this.tarjetas = tarjetas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}