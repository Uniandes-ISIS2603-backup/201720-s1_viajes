/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

<<<<<<< HEAD
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
=======
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
>>>>>>> d71f2a17803c7a06c430d486bbe74c8952948412
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

    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
    
<<<<<<< HEAD
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    private ImagenEntity[] imagenes;
    
    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    private UbicacionEntity origen;
    
    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    private UbicacionEntity destino;
    
    @PodamExclude
    @OneToOne
    private CompaniaEntity compania;


=======
    
    @OneToMany(mappedBy = "transporte",cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<ImagenEntity> imagenes;
    
    /*
  
>>>>>>> 35b72520c904c5a12d64deabe3e0b875926023f6
    private UbicacionEntity origen;
    
    
    private UbicacionEntity destino;
    
 
    private CompaniaEntity compania;

 
>>>>>>> d71f2a17803c7a06c430d486bbe74c8952948412
    

<<<<<<< HEAD
    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }

=======
<<<<<<< HEAD
>>>>>>> d71f2a17803c7a06c430d486bbe74c8952948412
    public ImagenEntity[] getImagenes() {
=======
    public List<ImagenEntity> getImagenes() {
>>>>>>> 35b72520c904c5a12d64deabe3e0b875926023f6
        return imagenes;
    }

    public void setImagenes(List<ImagenEntity> imagenes) {
        this.imagenes = imagenes;
    }
/*
    public UbicacionEntity getOrigen() {
        return origen;
    }

    public void setOrigen(UbicacionEntity origen) {
        this.origen = origen;
    }

    public UbicacionEntity getDestino() {
        return destino;
    }

    public void setDestino(UbicacionEntity destino) {
        this.destino = destino;
    }
<<<<<<< HEAD

    public CompaniaEntity getCompania() {
        return compania;
    }

    public void setCompañia(CompaniaEntity compania) {
        this.compania = compania;
    }
    
    
  
=======
*/
    public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
    public CompaniaEntity getCompania() {
        return compania;
    }

    public void setCompañia(CompaniaEntity compania) {
        this.compania = compania;
    }    
>>>>>>> d71f2a17803c7a06c430d486bbe74c8952948412
}