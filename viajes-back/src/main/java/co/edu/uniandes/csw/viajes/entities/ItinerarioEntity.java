/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author js.beltran14
 */
@Entity
public class ItinerarioEntity extends BaseEntity{
    
    /**
     * Costo del itinerario
     */
    private int costoTotal;
    
    /**
     * Fecha de inicio del itinerario
     */
    private String fechaInicial;
    
    /**
     * Fecha final del itinerario
     */
    private String fechaFinal;
    
    /**
     * Numero de visitantes del itinerario
     */
    private int numeroVisitantes;

    /**
     * Guias del itinerario
     */
    @PodamExclude
    @OneToMany
    private List<GuiaEntity> guias;
        
    /**
     * Hospedajes en el itinerario
     */
    @PodamExclude
    @OneToMany
    private List<HospedajeEntity> hospedajes;
     
    /**
     * Entretenimientos que se encuentran en el itinerario
     */
    @PodamExclude
    @OneToMany
    private List<EntretenimientoEntity> entretenimientos;
      
    /**
     * Transportes que se encuentran en el itinerario
     */
    @PodamExclude
    @OneToMany
    private List<TransporteEntity> transportes;
    
    /**
     * Entretenimientos que se encuentran en el itinerario
     * @return entretenimientos
     */
    public List<EntretenimientoEntity> getEntretenimientos() {
        return entretenimientos;
    }

    /**
     * Guias del itinerario
     * @return guias
     */
    public List<GuiaEntity> getGias() {
        return guias;
    }

    /**
     * Hospedajes del itinerario
     * @return hospedajes
     */
    public List<HospedajeEntity> getHospedajes() {
        return hospedajes;
    }

    /**
     * Transportes del itinerario
     * @return transportes
     */
    public List<TransporteEntity> getTransportes() {
        return transportes;
    }

    /**
     * Cambia o agrega los entretenimientos del itinerario
     * @param entretenimientos 
     */
    public void setEntretenimientos(List<EntretenimientoEntity> entretenimientos) {
        this.entretenimientos = entretenimientos;
    }

    /**
     * Cambia los guias del itinerario
     * @param gias 
     */
    public void setGias(List<GuiaEntity> gias) {
        this.guias = gias;
    }

    /**
     * Cambia los hospedajes del itinerario
     * @param hospedajes 
     */
    public void setHospedajes(List<HospedajeEntity> hospedajes) {
        this.hospedajes = hospedajes;
    }

    /**
     * Cambia los transportes del itinerario
     * @param transportes 
     */
    public void setTransportes(List<TransporteEntity> transportes) {
        this.transportes = transportes;
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
