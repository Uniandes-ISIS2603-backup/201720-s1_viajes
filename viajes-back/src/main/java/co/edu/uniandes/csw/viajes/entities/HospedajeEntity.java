/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ma.forero11
 * Anotaciones: no tenia @Entity, no extendia de servicio entity, no tenia id
 * Se agrego la enumeracion
 */
@Entity
public class HospedajeEntity extends ServicioEntity{

    public enum TipoHospedaje {
    
    HOTEL,
    CAMPING
    
    }
    
    /**
     * Tipo de hospedaje
     */
    private TipoHospedaje tipo;
    
    /**
     * Ubicación del hospedaje
     */
    @PodamExclude
    @OneToOne()
    private UbicacionEntity ubicacion;
    
    /**
     * Compañia a la que pertenece el hospedaje
     */
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
    
    /**
     * Imagenes del hospedaje
     */
    @PodamExclude   
    @OneToMany
    private List<ImagenEntity> imagenes;
    
    /**
     * Itinerario al que pertenece el hospedaje
     */
    @PodamExclude
    @ManyToOne
    private ItinerarioEntity itinerario;

    /**
     * Ubicacion del hospedaje
     * @return ubicacion
     */
    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }

    /**
     * Itinerario al que pertenece el hospedaje
     * @return itinerario
     */
    public ItinerarioEntity getItinerario() {
        return itinerario;
    }
    
    
    /** 
     * Cambia el itinerario al que pertenece el hospedaje
     * @param itinerario 
     */
    public void setItinerario(ItinerarioEntity itinerario) {
        this.itinerario = itinerario;
    }

    /**
     * Cambia la ubicacion del hospedaje
     * @param ubicacion 
     */
    public void setUbicacion(UbicacionEntity ubicacion) {
        this.ubicacion = ubicacion;
    }
    
   /**
    * Tipo de hospedaje
    * @return tipo
    */
   public TipoHospedaje getTipo() {
        return tipo;
    }

   /**
    * Cambia el tipo de hospedaje
    * @param tipo 
    */
    public void setTipo(TipoHospedaje tipo) {
        this.tipo = tipo;
    }

    /**
     * Compañia a la que pertenece el hospedaje
     * @return compania
     */
    public CompaniaEntity getCompania()
    {
        return compania;
    }
    
    /**
     * Cambia la compañia a la que pertenece el hospedaje
     * @param compania 
     */
    public void setCompania(CompaniaEntity compania)
    {
        this.compania = compania;
    }

    /**
     * Cambia las imagenes del hospedaje
     * @param imagenes 
     */
    public void setImagenes(List<ImagenEntity> imagenes) {
        this.imagenes = imagenes;
    }

    /**
     * Imagenes del hospedaje
     * @return imagenes
     */
    public List<ImagenEntity> getImagenes() {
        return imagenes;
    }
}