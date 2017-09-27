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
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author js.beltran14
 */
@Entity
public class ItinerarioEntity extends BaseEntity{
    
    private int costoTotal;
    
    private String fechaInicial;
    
    private String fechaFinal;
    
    private int numeroVisitantes;

    @PodamExclude
    @OneToMany(mappedBy = "itinerario")
    private List<GuiaEntity> gias;
    
    @PodamExclude
    @ManyToOne()
    private UsuarioEntity usuario;
        
    @PodamExclude
    @OneToMany(mappedBy = "itinerario")
    private List<HospedajeEntity> hospedajes;
     
    @PodamExclude
    @OneToMany(mappedBy = "itinerario")
    private List<EntretenimientoEntity> entretenimientos;
      
    @PodamExclude
    @OneToMany(mappedBy = "itinerario")
    private List<TransporteEntity> transportes;

    public List<EntretenimientoEntity> getEntretenimientos() {
        return entretenimientos;
    }

    public List<GuiaEntity> getGias() {
        return gias;
    }

    public List<HospedajeEntity> getHospedajes() {
        return hospedajes;
    }

    public List<TransporteEntity> getTransportes() {
        return transportes;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setEntretenimientos(List<EntretenimientoEntity> entretenimientos) {
        this.entretenimientos = entretenimientos;
    }

    public void setGias(List<GuiaEntity> gias) {
        this.gias = gias;
    }

    public void setHospedajes(List<HospedajeEntity> hospedajes) {
        this.hospedajes = hospedajes;
    }

    public void setTransportes(List<TransporteEntity> transportes) {
        this.transportes = transportes;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    
    
    /**
     * @return the costoTotal
     */
    public int getCostoTotal() {
        return costoTotal;
    }

    /**
     * @param costoTotal the costoTotal to set
     */
    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    /**
     * @return the fechaInicial
     */
    public String getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaInicial the fechaInicial to set
     */
    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return the fechaFinal
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return the numeroVisitantes
     */
    public int getNumeroVisitantes() {
        return numeroVisitantes;
    }

    /**
     * @param numeroVisitantes the numeroVisitantes to set
     */
    public void setNumeroVisitantes(int numeroVisitantes) {
        this.numeroVisitantes = numeroVisitantes;
    }

}
