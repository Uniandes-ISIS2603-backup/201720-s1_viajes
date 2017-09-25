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
    //ATRIBUTOS
    
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
    @OneToMany(mappedBy = "usuario")
    private List<ItinerarioEntity> itinerario;
    
    
    /**
     * Blog que le pertenece al usuario
     */
    @PodamExclude
    private BlogEntity blog;
    
    //GETTERS/SETTERS
    
    /**
     * Lista de itinerarios programados por el usuario
     * 
     * @return itinerarios
     */
    public List<ItinerarioEntity> getItinerarios()
    {
        return itinerario;
    }
    
    public void setItinerarios(List<ItinerarioEntity> itinerarios)
    {
        this.itinerario = itinerarios;
    }
        
    public List<TarjetaCreditoEntity> getTarjetas()
    {
        return tarjeta;
    }
    
    public void setTarjetas(List<TarjetaCreditoEntity> tarjetas)
    {
        this.tarjeta = tarjetas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}