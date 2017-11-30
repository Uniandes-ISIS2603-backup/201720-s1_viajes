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
 * Clase que representa la entidad de un transporte
 * @author sa.silva1
 * Anotaciones: No debia haber constructor
 */
@Entity
public class TransporteEntity extends ServicioEntity 
{
    /**
     * Enumerable del tipo de transporte
     */
    public enum TipoTransporte {
    
    Avión,
    Tren,
    Barco,
    Bus,
    Taxi
    
    }
    
    /**
     * Tipo de transporte
     */
    private TipoTransporte tipo;

    /**
     * Compania a la cual pertenece el transporte
     */
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
     
   
    /**
     * Imagenes asociadas al transporte
     */
    @PodamExclude
    @OneToMany
    private List<ImagenEntity> imagenes;
    
    /**
     * Direccion de origen del transporte
     */
    @PodamExclude
    @OneToOne
    private UbicacionEntity origen;
    
    /**
     * Direccion destino del transporte
     */
    @PodamExclude
    @OneToOne
    private UbicacionEntity destino;
   
    /**
     * Retornar el tipo del transporte
     * @return tipo del transporte
     */
    public TipoTransporte getTipo() {
        return tipo;
    }

    /**
     * Asignar un tipo al transporte
     * @param tipo de transporte
     */
    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }

    /**
     * Rretornar la compania a la cual pertenece el transporte
     * @return compania del transporte
     */
    public CompaniaEntity getCompania() {
        return compania;
    }

    /**
     * Asignar la compania del transporte
     * @param compania del transporte
     */
    public void setCompania(CompaniaEntity compania) {
        this.compania = compania;
    }

    /**
     * Imagenes del transporte
     * @return imagenes
     */
    public List<ImagenEntity> getImagenes() {
        return imagenes;
    }
    /**
     * Cambia o agrega las imagenes
     * @param imagenes 
     */
    public void setImagenes(List<ImagenEntity> imagenes) {
        this.imagenes = imagenes;
    }
    
    /**
     * Ubicación origen del transporte
     * @return origen
     */
    public UbicacionEntity getOrigen() {
        return origen;
    }
    
    /**
     * Cambia la ubicación de origen 
     * @param origen 
     */
    public void setOrigen(UbicacionEntity origen) {
        this.origen = origen;
    }
    
    /**
     * Ubicacion destino del transporte
     * @return destino
     */
    public UbicacionEntity getDestino() {
        return destino;
    }
    
    /**
     * Cambia la ubicación de destino del transporte
     * @param destino 
     */
    public void setDestino(UbicacionEntity destino) {
        this.destino = destino;
    }   
}