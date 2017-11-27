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

    /**
     * Id del hospedaje
     */
    private Long id;

    /**
     * Nombre del hospedaje
     */
    private String nombre;

    /**
     * Fecha de inicio de uso del hospedaje
     */
    private String fechaInicio;

    /**
     * Fecha de terminación de uso del hospedaje
     */
    private String fechaFinal;

    /**
     * Valor del hospedaje
     */
    private Double valor;

    /**
     * Calificacion del hospedaje
     */
    private Double calificacion;

    /**
     * Comentarios del hospedaje
     */
    private String comentarios;

    /**
     * Descripción del hospedaje
     */
    private String descripcion;

    /**
     * Constructor por defecto
     */
    public HospedajeDTO() {
        //Constructor por defecto
    }

    /**
     * Constructor Hospedaje
     *
     * @param entity
     */
    public HospedajeDTO(HospedajeEntity entity) {
        this.fechaInicio = entity.getFechaInicio();
        this.fechaFinal = entity.getFechaFinal();
        this.nombre = entity.getNombre();
        this.valor = entity.getValor();
        this.calificacion = entity.getCalificacion();
        this.comentarios = entity.getComentarios();
        this.id = entity.getId();
        this.descripcion = entity.getDescripcion();
    }

    /**
     * Devuelve el id
     *
     * @return id
     */
    public Long getIdHospedaje() {
        return id;
    }

    /**
     * Setea el id
     *
     * @param id
     */
    public void setIdHospedaje(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el atributo nombre.
     *
     * @return atributo nombre.
     *
     */
    public String getNombreHospedaje() {
        return nombre;
    }

    /**
     * Establece el valor del atributo nombre.
     *
     * @param nombre nuevo valor del atributo
     *
     */
    public void setNombreHospedaje(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el atributo fechaInicio.
     *
     * @return atributo fechaInicio.
     *
     */
    public String getFechaInicioHospedaje() {
        return fechaInicio;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param fechaInicio nuevo valor del atributo
     *
     */
    public void setFechaInicioHospedaje(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene el atributo fechaFinal.
     *
     * @return atributo fechaFinal.
     *
     */
    public String getFechaFinalHospedaje() {
        return fechaFinal;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param fechaFinal nuevo valor del atributo
     *
     */
    public void setFechaFinalHospedaje(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Obtiene el atributo valor.
     *
     * @return atributo valor.
     *
     */
    public Double getValorHospedaje() {
        return valor;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param valor nuevo valor del atributo
     *
     */
    public void setValorHospedaje(Double valor) {
        this.valor = valor;
    }

    /**
     * Obtiene el atributo calificacion.
     *
     * @return atributo calificacion.
     *
     */
    public Double getCalificacionHospedaje() {
        return calificacion;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param calificacion nuevo valor del atributo
     *
     */
    public void setCalificacionHospedaje(Double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Obtiene el atributo comentarios.
     *
     * @return atributo calificacion.
     *
     */
    public String getComentariosHospedaje() {
        return comentarios;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param comentarios nuevo valor del atributo
     *
     */
    public void setComentariosHospedaje(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Obtiene el atributo descripcion.
     *
     * @return atributo calificacion.
     *
     */
    public String getDescripcionHospedaje() {
        return descripcion;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param descripcion nuevo valor del atributo
     *
     */
    public void setDescripcionHospedaje(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Transforma a entity
     *
     * @return entidad de hospedaje
     */
    public HospedajeEntity toEntity() {
        HospedajeEntity entity = new HospedajeEntity();
        entity.setFechaInicio(this.fechaInicio);
        entity.setFechaFinal(this.fechaFinal);
        entity.setNombre(this.nombre);
        entity.setValor(this.valor);
        entity.setCalificacion(this.calificacion);
        entity.setComentarios(this.comentarios);
        entity.setId(this.id);
        entity.setDescripcion(this.descripcion);
        return entity;
    }
}
