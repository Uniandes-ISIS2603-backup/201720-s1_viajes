/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.ServicioEntity;

/**
 *
 * @author sa.silva1
 */
public class ServicioDTO {
 
    
    private String fechaInicio;
    
    private String fechaFinal;
    
    private String nombre;
    
    private Double valor;
    
    private Double calificacion;
    
    private String comentarios;

    
    public ServicioDTO() {
    }

     public ServicioDTO(ServicioEntity servicio) {
         this.fechaInicio = servicio.getFechaInicio();
         this.fechaFinal = servicio.getFechaFinal();
         this.nombre = servicio.getNombre();
         this.valor = servicio.getValor();
         this.calificacion = servicio.getCalificacion();
         this.comentarios = servicio.getComentarios();     
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
    
    public ServicioEntity toEntity() {
        ServicioEntity entity = new ServicioEntity() {};
        entity.setFechaInicio(this.fechaInicio);
        entity.setFechaFinal(this.fechaFinal);
        entity.setNombre(this.nombre);
        entity.setValor(this.valor);
        entity.setCalificacion(this.calificacion);
        entity.setComentarios(this.comentarios);
        
        return entity;
    }
}
