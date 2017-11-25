/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;

/**
 *
 * @author m.rodriguez21
 */
public class EntretenimientoDTO extends ServicesAbstract{
    
    private Long id;
    
    /**
     * Constructor por defecto
     */
    public EntretenimientoDTO() {
        
    }
    
    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param entretenimiento: Es la entidad que se va a convertir a DTO 
     */
    public EntretenimientoDTO(EntretenimientoEntity entretenimiento) {
        this.id = entretenimiento.getId();
        this.nombre = entretenimiento.getNombre();
        this.fechaInicio = entretenimiento.getFechaInicio();
        this.fechaFinal = entretenimiento.getFechaFinal();
        this.valor = entretenimiento.getValor();
        this.calificacion = entretenimiento.getCalificacion();
        this.comentarios = entretenimiento.getComentarios();
        this.descripcion = entretenimiento.getDescripcion();
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
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public EntretenimientoEntity toEntity() {
        EntretenimientoEntity entity = new EntretenimientoEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setFechaInicio(this.fechaInicio);
        entity.setFechaFinal(this.fechaFinal);
        entity.setValor(this.valor);
        entity.setCalificacion(this.calificacion);
        entity.setComentarios(this.comentarios);
        entity.setDescripcion(this.descripcion);
        return entity;
    }
    
}
