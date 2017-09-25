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

    private TipoHospedaje tipo;
    
    @PodamExclude
    @OneToOne()
    private UbicacionEntity ubicacion;
        
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
    
    @PodamExclude   
    @OneToMany
    private List<ImagenEntity> imagenes;
    
    @PodamExclude
    @ManyToOne
    private ItinerarioEntity itinerario;
    
    public TipoHospedaje getTipo() {
        return tipo;
    }

    public void setTipo(TipoHospedaje tipo) {
        this.tipo = tipo;
    }
    /*
    public CompaniaEntity getCompania()
    {
        return compania;
    }
    
    public void setCompania(CompaniaEntity compania)
    {
        this.compania = compania;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    }

    public void setImagenes(List<ImagenEntity> imagenes) {
        this.imagenes = imagenes;
    }

    public List<ImagenEntity> getImagenes() {
        return imagenes;
    }
    */
    
  
    
}
