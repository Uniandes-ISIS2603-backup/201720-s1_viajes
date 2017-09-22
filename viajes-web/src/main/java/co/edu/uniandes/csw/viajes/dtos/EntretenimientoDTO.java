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
public class EntretenimientoDTO {
    
    private Long id;
    private String nombre;
    private String fechaInicio;
    private String fechaFinal;
    private Double valor;
    private Double calificacion;
    private String comentarios;
    private String descripcion;
    
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
