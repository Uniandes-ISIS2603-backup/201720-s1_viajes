
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;


import java.util.List;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    
    //@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    //private UbicacionEntity ubicacion;
    
    //private List<ImagenEntity> imagenes;
    
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
    
   
    @OneToMany(mappedBy = "hospedaje",cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<ImagenEntity> imagenes;
    
    
    public TipoHospedaje getTipo() {
        return tipo;
    }

    public void setTipo(TipoHospedaje tipo) {
        this.tipo = tipo;
    }
    
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
    
    
  
    
}
