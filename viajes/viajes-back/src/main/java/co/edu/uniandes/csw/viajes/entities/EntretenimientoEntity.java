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
public class EntretenimientoEntity extends ServicioEntity
{
    
    //////////////////////////////
    //REVISAR SI SE HACE @EMBEDDED
    //////////////////////////////
    //@OneToMany(fetch=FetchType.LAZY)
    //@JoinColumn(name="IMAGEN_ID")
    //private List<ImagenEntity> imagenes;
    
    //////////////////////////////
    //REVISAR SI SE HACE @EMBEDDED
    //////////////////////////////
    //@OneToOne (fetch=FetchType.LAZY)
    //@JoinColumn(name="UBICACION_ID")
    //private UbicacionEntity ubicacion;
    

    //@OneToOne (fetch=FetchType.LAZY)
    //@JoinColumn (name="UBICACION_ID")
    //private CompaniaEntity compania;
    
    //public UbicacionEntity getUbicacion()
    //{
    //    return ubicacion;
    //}
    
    //public void setUbicacion(UbicacionEntity ubicacion)
    //{
    //    this.ubicacion = ubicacion;
    //}

    //public CompaniaEntity getCompania()
    //{
    //    return compania;
    //}
    
    //public void setCompania(CompaniaEntity compania)
    //{
    //    this.compania = compania;
    //}

    //public List<ImagenEntity> getImagenes()
    //{
    //    return imagenes;
    //}
    
    //public void setImagenes(List<ImagenEntity> imagenes)
    //{
    //    this.imagenes = imagenes;
    //}
    
}
