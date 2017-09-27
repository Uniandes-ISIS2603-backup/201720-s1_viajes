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
    
    private String nombre; //Nombre del usuario que hizo el pago
    private String fecha; //Fecha en la que se realizó el pago
    private Double valor; //Valor por el cuál se hizo el pago
    
    /**
     * Constructor por defecto
     */
    public PagoDTO()
    {
        
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
