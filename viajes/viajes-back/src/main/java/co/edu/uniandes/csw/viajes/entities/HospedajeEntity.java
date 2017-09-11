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
 * @author ma.forero11
 */
public class HospedajeEntity extends ServicioEntity{
    
    private UbicacionEntity ubicacion;
    private List<ImagenEntity> imagenes;
    private CompaniaEntity compania;
    
     public UbicacionEntity getUbicacion()
    {
        return ubicacion;
    }
     
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
