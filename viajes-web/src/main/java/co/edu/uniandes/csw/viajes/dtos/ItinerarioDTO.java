/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;

/**
 *
 * @author js.beltran14
 */
public class ItinerarioDTO {
    
    private Long id;
    
    private int costoTotal;
    
    private String fechaInicial;
    
    private String fechaFinal;
    
    private int numeroVisitantes;
    
    public ItinerarioDTO(){
         //Constructor por defecto
    }
    
     /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param entity: Es la entidad que se va a convertir a DTO 
     */
    public ItinerarioDTO(ItinerarioEntity entity){
        this.id = entity.getId();
        this.numeroVisitantes = entity.getNumeroVisitantes();
        this.costoTotal = entity.getCostoTotal();
        this.fechaInicial = entity.getFechaInicial();
        this.fechaFinal = entity.getFechaFinal();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
    
    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public ItinerarioEntity toEntity(){
        ItinerarioEntity entity = new ItinerarioEntity();
        entity.setId(this.id);
        entity.setNumeroVisitantes(this.numeroVisitantes);
        entity.setCostoTotal(this.costoTotal);
        entity.setFechaInicial(this.fechaInicial);
        entity.setFechaFinal(this.fechaFinal);
        return entity;
    }
    
}
