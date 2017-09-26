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
 * @author m.rodriguez21
 */
@Entity
public class EntretenimientoEntity extends ServicioEntity
{  
    @PodamExclude
    @OneToMany
    private List<ImagenEntity> imagenes;
    
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
    
    @PodamExclude
    @OneToOne()
    private UbicacionEntity ubicacion;
    
    @PodamExclude
    @ManyToOne
    private ServicioEntity servicio;
   
    @Override
    public UbicacionEntity getUbicacion()
    {
        return ubicacion;
    }
    
    @Override
    public void setUbicacion(UbicacionEntity ubicacion)
    {
        this.ubicacion = ubicacion;
    }
    
    @Override
    public CompaniaEntity getCompania()
    {
        return compania;
    }
    
    @Override
    public void setCompania(CompaniaEntity compania)
    {
        this.compania = compania;
    }

    @Override
    public List<ImagenEntity> getImagenes()
    {
        return imagenes;
    }
    
    @Override
    public void setImagenes(List<ImagenEntity> imagenes)
    {
        this.imagenes = imagenes;
    }
}
