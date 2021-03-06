/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.PagoEntity;

/**
 *
 * @author tv.huertas10
 */
public class PagoDTO {
    
    /**
     * Nombre del usuario que hizo el pago
     */
    private String nombre; 
    
    /**
     * Fecha en la que se realizó el pago
     */
    private String fecha;
    
    /**
     * Valor por el cuál se hizo el pago
     */
    private Double valor;
    
    /**
     * Id del usuario
     */
    private Long id;
    
    /**
     * Constructor por defecto
     */
    public PagoDTO()
    {
         //Constructor por defecto
    }
        
    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param pago:Es la entidad que se va a convertir a DTO 
     */
     public PagoDTO(PagoEntity pago) {
       
        this.nombre = pago.getNombre();
        this.fecha= pago.getFecha();
        this.valor=pago.getValor();
    }
         
    /**
     * Valor del pago
     * @return valor
     */
     public Double getValor() {
        return valor;
    }

    /**
     * Fecha en la que se realizó el pago
     * @return 
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Nombre de quíen hizo el pago
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Id del pago
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Se cambia el id del pago
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }   
    
    /**
     * Cambiar el valor del pago
     * @param valor 
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Cambiar el nombre de quien le petenece el pago
     * @param nombre 
     */    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
      /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public PagoEntity toEntity() {
        PagoEntity entity = new PagoEntity();
        entity.setNombre(this.nombre);
        entity.setFecha(this.fecha);
        entity.setValor(this.valor);
        return entity;
    }    
}
