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
public class HospedajeDTO extends ServicesAbstract{
   
    private Long id;
    
    /**
     * Constructor por defecto
     */
    public HospedajeDTO (){
 
    }
    
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
    
    /**
     * Devuelve el id
     * @return id
     */
    public Long getId() {
        return id;
    }
    /**
     * Setea el id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Transforma a entity
     * @return entidad de hospedaje
     */
    public HospedajeEntity toEntity(){
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