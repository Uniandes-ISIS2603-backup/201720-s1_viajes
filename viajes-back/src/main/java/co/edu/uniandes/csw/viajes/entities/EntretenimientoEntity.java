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
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author m.rodriguez21
 */
@Entity
public class EntretenimientoEntity extends ServicioEntity
{
    

    @OneToMany(mappedBy = "entretenimiento",cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<ImagenEntity> imagenes;
    
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
    
    //////////////////////////////
    //REVISAR SI SE HACE @EMBEDDED
    //////////////////////////////
    //@OneToOne (fetch=FetchType.LAZY)
    //@JoinColumn(name="UBICACION_ID")
    //private UbicacionEntity ubicacion;
   
    //public UbicacionEntity getUbicacion()
    //{
    //    return ubicacion;
    //}
    
    //public void setUbicacion(UbicacionEntity ubicacion)
    //{
    //    this.ubicacion = ubicacion;
    //}

    public CompaniaEntity getCompania()
    {
        return compania;
    }
    
    public void setCompania(CompaniaEntity compania)
    {
        this.compania = compania;
    }

    public List<ImagenEntity> getImagenes()
    {
        return imagenes;
    }
    
    public void setImagenes(List<ImagenEntity> imagenes)
    {
        this.imagenes = imagenes;
    }
    
}
