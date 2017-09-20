<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

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
    
    //private UbicacionEntity ubicacion;
    //private List<ImagenEntity> imagenes;
    //private CompaniaEntity compania;
    
    public TipoHospedaje getTipo() {
        return tipo;
    }

    public void setTipo(TipoHospedaje tipo) {
        this.tipo = tipo;
    }
    
    // public UbicacionEntity getUbicacion()
    //{
    //    return ubicacion;
    //}
     
//    public void setUbicacion(UbicacionEntity ubicacion)
//    {
//        this.ubicacion = ubicacion;
//    }
//     
//    public List<ImagenEntity> getImagenes()
//    {
//        return imagenes;
//    }
//    
//    public void setImagenes(List<ImagenEntity> imagenes)
//    {
//        this.imagenes = imagenes;
//    }
    
//    public CompaniaEntity getCompania()
//    {
//        return compania;
//    }
//    
//    public void setCompania(CompaniaEntity compania)
//    {
//        this.compania = compania;
//    }
     
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

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
    
    private UbicacionEntity ubicacion;
    private List<ImagenEntity> imagenes;
    private CompaniaEntity compania;
    
    public TipoHospedaje getTipo() {
        return tipo;
    }

    public void setTipo(TipoHospedaje tipo) {
        this.tipo = tipo;
    }
    
    // public UbicacionEntity getUbicacion()
    //{
    //    return ubicacion;
    //}
     
    public void setUbicacion(UbicacionEntity ubicacion)
    {
        this.ubicacion = ubicacion;
    }
     
    public List<ImagenEntity> getImagenes()
    {
        return imagenes;
    }
    
    public void setImagenes(List<ImagenEntity> imagenes)
    {
        this.imagenes = imagenes;
    }
    
    public CompaniaEntity getCompania()
    {
        return compania;
    }
    
    public void setCompania(CompaniaEntity compania)
    {
        this.compania = compania;
    }
     
}
>>>>>>> master
