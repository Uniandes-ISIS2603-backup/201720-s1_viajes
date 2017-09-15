/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.Entity;

/**
 *
 * @author sa.silva1
 * Anotaciones: No debia haber constructor
 */
@Entity
public class TransporteEntity extends ServicioEntity{
    
    public enum TipoTransporte {
    
    AVION,
    TREN,
    TAXI
    
    }
    
    private TipoTransporte tipo;
    
    /*
    private ImagenEntity[] imagenes;
    
    private UbicacionEntity origen;
    
    private UbicacionEntity destino;
    
    private CompañiaEntity compañia;

*/
    
    public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
/*
    public ImagenEntity[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(ImagenEntity[] imagenes) {
        this.imagenes = imagenes;
    }

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

    public CompañiaEntity getCompañia() {
        return compañia;
    }

    public void setCompañia(CompañiaEntity compañia) {
        this.compañia = compañia;
    }
    
    
    */
}