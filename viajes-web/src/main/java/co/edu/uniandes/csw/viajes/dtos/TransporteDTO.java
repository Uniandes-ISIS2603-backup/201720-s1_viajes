/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import co.edu.uniandes.csw.viajes.entities.TransporteEntity.TipoTransporte;

/**
 * Clase que representa el DTO de un transporte
 * @author sa.silva1
 */
public class TransporteDTO {
    
    /**
     * Id del transporte
     */
    private Long id;
    
    /**
     * Nombre del transporte
     */
    private String nombre;
    
    /**
     * Fecha de inicio del transporte
     */
    private String fechaInicio;
    
    /**
     * Fecha de finalizacion del transporte 
     */
    private String fechaFinal;
    
    /**
     * Valor del transporte
     */
    private Double valor;
    
    /**
     * Calificacion del transporte
     */
    private Double calificacion;
    
    /**
     * Comentarios del transporte
     */
    private String comentarios;
    
    /**
     * Descripcion del transporte
     */
    private String descripcion;
    
    /**
     * Tipo de transporte
     */
    private TipoTransporte tipo;

    
    /**
     * Rretorna el id del transporte
     * @return id del transporte
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna un id al transporte
     * @param id a asignar
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /**
     *Retorna el nombre del transporte
     * @return nombre del transporte
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nombre al transporte
     * @param nombre a asigna
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la fecha de inicio del transporte
     * @return la fecha de inicio del transporte
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Asigna una fecha de inicio al transporte
     * @param fechaInicio a asignar
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Retorna la fecha de finalizacion del transporte
     * @return fecha de finalizacion del transporte
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Asigna la fecha de finalizacion del transporte
     * @param fechaFinal a asignar
     */
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Retorna el valor del transporte
     * @return el valor del transporte
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Asigna un valor al transporte
     * @param valor a asignar
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Retorna la calificacion de un transporte
     * @return la calificacion de un transporte
     */
    public Double getCalificacion() {
        return calificacion;
    }

    /**
     * Asigna una calificacion a un transporte
     * @param calificacion a asignar
     */
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Retorna los comentarios asociados a un transporte
     * @return los comentarios asociados al transporte
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Asigna comentarios a un transporte
     * @param comentarios a asignar
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Retorna la descripcion de unn transporte
     * @return la descripcion del transporte
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna una descripcion a un transporte
     * @param descripcion a asignar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Constructor por defecto
     */
    public TransporteDTO() {
    }
    
    /**
     * Cosntructor de la clase
     * @param transporte informacion del transporte a crear
     */
    public TransporteDTO(TransporteEntity transporte){
         this.id = transporte.getId();
        this.nombre = transporte.getNombre();
        this.fechaInicio = transporte.getFechaInicio();
        this.fechaFinal = transporte.getFechaFinal();
        this.valor = transporte.getValor();
        this.calificacion = transporte.getCalificacion();
        this.comentarios = transporte.getComentarios();
        this.descripcion = transporte.getDescripcion();
        this.tipo = transporte.getTipo();
    }

    /**
     * Retorna el tipo de transporte
     * @return el tipo de transporte
     */
    public TipoTransporte getTipo() {
        return tipo;
    }

    /**
     * Asigna un tipo a un transporte
     * @param tipo a asignar
     */
    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Crea un transporte entity con base a la informacion del DTO
     * @return la entidad transporte creada
     */
    public TransporteEntity toEntity(){
        TransporteEntity entity = new TransporteEntity();
        
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setFechaInicio(this.fechaInicio);
        entity.setFechaFinal(this.fechaFinal);
        entity.setValor(this.valor);
        entity.setCalificacion(this.calificacion);
        entity.setComentarios(this.comentarios);
        entity.setDescripcion(this.descripcion);
        entity.setTipo(this.tipo);
        return entity;
    }
    
}
