<<<<<<< HEAD:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/entities/ItinerarioEntity.java
=======

>>>>>>> e7910ed95c91f9262305ad2222e729cc532d5bad:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/entities/ItinerarioEntity.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.Entity;

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
<<<<<<< HEAD:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/entities/ItinerarioEntity.java
=======

>>>>>>> e7910ed95c91f9262305ad2222e729cc532d5bad:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/entities/ItinerarioEntity.java
