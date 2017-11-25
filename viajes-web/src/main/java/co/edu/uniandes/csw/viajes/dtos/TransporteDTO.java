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
public class TransporteDTO{
    
    /**
     * Id del transporte
     */
    private Long id;
    public String nombre;
    public String fechaInicio;
    public String fechaFinal;
    public Double valor;
    public Double calificacion;
    public String comentarios;
    public String descripcion;
    
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
     * Constructor por defecto.
     * Esta vacío ya que el constructor que necesitamos necesita un parámetro 
     * de TransporteEntity.
     */
    public TransporteDTO() {
        //No es utilizado
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
