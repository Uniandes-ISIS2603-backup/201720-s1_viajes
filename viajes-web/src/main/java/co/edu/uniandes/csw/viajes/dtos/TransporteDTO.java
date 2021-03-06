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
    
    /**
     * Nombre del transporte
     */
    private String nombre;
    /**
     * Fecha de inicio del transporte
     */
    private String fechaInicio;
    /**
     * Fecha final del transporte
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
     * Rretorna el id del transporte
     * @return id del transporte
     */
    public Long getIdTransporte() {
        return id;
    }

    /**
     * Asigna un id al transporte
     * @param id a asignar
     */
    public void setIdTransporte(Long id) {
        this.id = id;
    }
    
    /**
     * Retorna el tipo de transporte
     * @return el tipo de transporte
     */
    public TipoTransporte getTipoTransporte() {
        return tipo;
    }

    /**
     * Asigna un tipo a un transporte
     * @param tipo a asignar
     */
    public void setTipoTransporte(TipoTransporte tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Obtiene el atributo nombre.
     *
     * @return atributo nombre.
     * 
     */
    public String getNombreTransporte() {
        return nombre;
    }

    /**
     * Establece el valor del atributo nombre.
     *
     * @param nombre nuevo valor del atributo
     * 
     */
    public void setNombreTransporte(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el atributo fechaInicio.
     *
     * @return atributo fechaInicio.
     * 
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param fechaInicio nuevo valor del atributo
     * 
     */
    public void setFechaInicioTransporte(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene el atributo fechaFinal.
     *
     * @return atributo fechaFinal.
     * 
     */
    public String getFechaFinalTransporte() {
        return fechaFinal;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param fechaFinal nuevo valor del atributo
     * 
     */
    public void setFechaFinalTransporte(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Obtiene el atributo valor.
     *
     * @return atributo valor.
     * 
     */
    public Double getValorTransporte() {
        return valor;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param valor nuevo valor del atributo
     * 
     */
    public void setValorTransporte(Double valor) {
        this.valor = valor;
    }
    
    /**
     * Obtiene el atributo calificacion.
     *
     * @return atributo calificacion.
     * 
     */
    public Double getCalificacionTransporte() {
        return calificacion;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param calificacion nuevo valor del atributo
     * 
     */
    public void setCalificacionTransporte(Double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Obtiene el atributo comentarios.
     *
     * @return atributo calificacion.
     * 
     */
    public String getComentariosTransporte() {
        return comentarios;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param comentarios nuevo valor del atributo
     * 
     */
    public void setComentariosTransporte(String comentarios) {
        this.comentarios = comentarios;
    }
    
    /**
     * Obtiene el atributo descripcion.
     *
     * @return atributo calificacion.
     * 
     */
    public String getDescripcionTransporte() {
        return descripcion;
    }

    /**
     * Establece el valor del atributo valor.
     *
     * @param descripcion nuevo valor del atributo
     * 
     */
    public void setDescripcionTransporte(String descripcion) {
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
