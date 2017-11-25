
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.OficinaEntity;

/**
 *
 * @author m.rodriguez21
 */
public class OficinaDTO {
    
    private Long id;
    private String nombreLugar;
    private String nombreEncargado;

    /**
     * Constructor por defecto
     */
    public OficinaDTO() {
         //Constructor por defecto
    }

    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param oficina: Es la entidad que se va a convertir a DTO 
     */
    public OficinaDTO(OficinaEntity oficina) {
        this.id = oficina.getId();
        this.nombreLugar = oficina.getNombreLugar();
        this.nombreEncargado = oficina.getNombreEncargado();
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
     * @return the nombreLugar
     */
    public String getNombreLugar() {
        return nombreLugar;
    }

    /**
     * @param nombreLugar the nombreLugar to set
     */
    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }
    
    /**
     * @return the nombreEncargado
     */
    public String getNombreEncargado() {
        return nombreEncargado;
    }

    /**
     * @param nombreEncargado the nombreEncargado to set
     */
    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public OficinaEntity toEntity() {
        OficinaEntity entity = new OficinaEntity();
        entity.setId(this.id);
        entity.setNombreLugar(this.nombreLugar);
        entity.setNombreEncargado(this.nombreEncargado);
        return entity;
    }
    
}
