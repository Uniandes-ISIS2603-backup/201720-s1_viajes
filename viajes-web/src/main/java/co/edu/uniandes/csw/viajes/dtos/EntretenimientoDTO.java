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
public class EntretenimientoDTO{
    
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
         //Constructor por defecto
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
    public Long getIdEntretenimiento() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setIdEntretenimiento(Long id) {
        this.id = id;
    }
    
    /**
     * Obtiene el atributo nombre.
     *
     * @return atributo nombre.
     * 
     */
    public String getNombreEntretenimiento() {
        return nombre;
    }

    /**
     * Establece el valor del atributo nombre.
     *
     * @param nombre nuevo valor del atributo
     * 
     */
    public void setNombreEntretenimiento(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el atributo fechaInicio.
     *
     * @return atributo fechaInicio.
     * 
     */
    public String getFechaInicioEntretenimiento() {
        return fechaInicio;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param fechaInicio nuevo valor del atributo
     * 
     */
    public void setFechaInicioEntretenimiento(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene el atributo fechaFinal.
     *
     * @return atributo fechaFinal.
     * 
     */
    public String getFechaFinalEntretenimiento() {
        return fechaFinal;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param fechaFinal nuevo valor del atributo
     * 
     */
    public void setFechaFinalEntretenimiento(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Obtiene el atributo valor.
     *
     * @return atributo valor.
     * 
     */
    public Double getValorEntretenimiento() {
        return valor;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param valor nuevo valor del atributo
     * 
     */
    public void setValorEntretenimiento(Double valor) {
        this.valor = valor;
    }
    
    /**
     * Obtiene el atributo calificacion.
     *
     * @return atributo calificacion.
     * 
     */
    public Double getCalificacionEntretenimiento() {
        return calificacion;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param calificacion nuevo valor del atributo
     * 
     */
    public void setCalificacionEntretenimiento(Double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Obtiene el atributo comentarios.
     *
     * @return atributo calificacion.
     * 
     */
    public String getComentariosEntretenimiento() {
        return comentarios;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param comentarios nuevo valor del atributo
     * 
     */
    public void setComentariosEntretenimiento(String comentarios) {
        this.comentarios = comentarios;
    }
    
    /**
     * Obtiene el atributo descripcion.
     *
     * @return atributo calificacion.
     * 
     */
    public String getDescripcionEntretenimiento() {
        return descripcion;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param descripcion nuevo valor del atributo
     * 
     */
    public void setDescripcionEntretenimiento(String descripcion) {
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
