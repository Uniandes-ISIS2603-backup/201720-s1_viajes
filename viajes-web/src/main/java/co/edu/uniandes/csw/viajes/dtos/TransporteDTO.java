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
public class TransporteDTO extends ServicesAbstract{
    
    /**
     * Id del transporte
     */
    private Long id;
    
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
