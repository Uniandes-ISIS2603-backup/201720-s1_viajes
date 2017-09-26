/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author sa.silva1
 * Anotaciones: No debia haber constructor
 */
@Entity
public class TransporteEntity extends ServicioEntity 
{
    
    public enum TipoTransporte {
    
    AVION,
    TREN,
    TAXI
    
    }
    
    private TipoTransporte tipo;

    /*
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
    */
    
    @PodamExclude
    @OneToMany(mappedBy = "transporte")
    private List<ImagenEntity> imagenes;
    
    @PodamExclude
    @OneToOne(mappedBy = "origen")
    private UbicacionEntity origen;
    
    @PodamExclude
    @OneToOne(mappedBy = "destino")
    private UbicacionEntity destino;
    
    @PodamExclude
    @ManyToOne
    private ItinerarioEntity itinerario;   
    
    public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
    /*
    public CompaniaEntity getCompania() {
        return compania;
    }

    public void setCompañia(CompaniaEntity compania) {
        this.compania = compania;
    }    

*/
    public List<ImagenEntity> getImagenes() {
        return imagenes;
    }

    public UbicacionEntity getOrigen() {
        return origen;
    }

    public UbicacionEntity getDestino() {
        return destino;
    }

    public ItinerarioEntity getItinerario() {
        return itinerario;
    }

    public void setOrigen(UbicacionEntity origen) {
        this.origen = origen;
    }

    public void setImagenes(List<ImagenEntity> imagenes) {
        this.imagenes = imagenes;
    }

    public void setItinerario(ItinerarioEntity itinerario) {
        this.itinerario = itinerario;
    }

    /*
    public void setCompania(CompaniaEntity compania) {
        this.compania = compania;
    }
    */
}