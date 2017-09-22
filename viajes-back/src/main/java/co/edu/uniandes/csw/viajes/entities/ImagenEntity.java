/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * Falta el @entity
 * @author js.beltran14
 */
@Entity
public class ImagenEntity extends BaseEntity{
    
    private String ruta;
    
    private String comentario;

    @PodamExclude
    @ManyToOne()
    private EntretenimientoEntity entretenimiento;
    
    
    @PodamExclude
    @ManyToOne()
    private TransporteEntity transporte;
    
    
    @PodamExclude
    @ManyToOne()
    private HospedajeEntity hospedaje;
    
    @PodamExclude
    @ManyToOne()
    private BlogEntity blog;
    
    
    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public EntretenimientoEntity getEntretenimiento() {
        return entretenimiento;
    }

    public void setEntretenimiento(EntretenimientoEntity entretenimiento) {
        this.entretenimiento = entretenimiento;
    }

    public TransporteEntity getTransporte() {
        return transporte;
    }

    public void setTransporte(TransporteEntity transporte) {
        this.transporte = transporte;
    }

    public HospedajeEntity getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(HospedajeEntity hospedaje) {
        this.hospedaje = hospedaje;
    }

 
}
