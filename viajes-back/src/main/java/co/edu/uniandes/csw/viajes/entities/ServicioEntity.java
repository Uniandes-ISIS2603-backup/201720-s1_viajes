/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.MappedSuperclass;

/**
 * Clase que representa la entidad del Servicio en general
 * @author sa.silva1
 */
@MappedSuperclass
public abstract class ServicioEntity extends BaseEntity{
    
    /**
     * Nombre del servicio
     */
    private String nombre;
    
    /**
     * Fecha de inicio del servicio
     */
    private String fechaInicio;
    
    /**
     * Fecha de finalizacion del servicio
     */
    private String fechaFinal;
    
    /**
     * Valor neto del servicio
     */
    private Double valor;
    
    /**
     * Calificacion del servicio otorgada por los usuarios
     */
    private Double calificacion;
    
    /**
     * Comentarios asosciados al servicio
     */
    private String comentarios;
    
    /**
     * Descripcion del servicio
     */
    private String descripcion;
        
     /**
      * Retornar el nombre del servicio
      * @return nombre del servicio
      */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asignar el nombre del servicio
     * @param nombre del servicio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retornar la fecha de inicio del servicio
     * @return fecha de inicio del servicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Asignar la fecha de inicio del servicio
     * @param fechaInicio del servicio
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Retornar la fecha final del servicio
     * @return la fecha final del revicio
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Asignar la fecha final del servicio
     * @param fechaFinal del servicio
     */
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Retornar el valor neto del servicio
     * @return el valor neto del servicio
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Asignar el valor al servicio
     * @param valor del servicio
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Retornar la calificacion del servicio
     * @return la calificacion del servicio
     */
    public Double getCalificacion() {
        return calificacion;
    }

    /**
     * Asignar la calificacion al servicio
     * @param calificacion del servicio
     */
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Retorna los comentarios asociados al servicio
     * @return los comentarios asociados al servicio
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Asignar comentarios a un servicio
     * @param comentarios de un servicio
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    /**
     * Retornar la descripcion del servicio
     * @return la descripcion de un servicio
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna descripcion a un servicio
     * @param descripcion para un servicio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}