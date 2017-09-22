/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;

/**
 *
 * @author ma.forero11
 */
public class HospedajeDTO {
    
    private String fechaInicio;
    private String fechaFinal;
    private String nombre;
    private Double valor;
    private Double calificacion;
    private String comentarios;
    private long id;
    private String descripcion;
    
    public HospedajeDTO (HospedajeEntity entity){
        this.fechaInicio = entity.getFechaInicio();
        this.fechaFinal = entity.getFechaFinal();
        this.nombre = entity.getNombre();
        this.valor = entity.getValor();
        this.calificacion = entity.getCalificacion();
        this.comentarios = entity.getComentarios();
        this.id = entity.getId();
        this.descripcion = entity.getDescripcion();
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public HospedajeEntity toEntity(){
        HospedajeEntity entity = new HospedajeEntity();
        entity.setFechaInicio(this.fechaInicio);
        entity.setFechaFinal(this.fechaFinal);
        entity.setNombre(this.nombre);
        entity.setValor(this.valor);
        entity.setCalificacion(this.calificacion);
        entity.setComentarios(this.comentarios);
        entity.setId(this.id);
        return entity;
    }
}