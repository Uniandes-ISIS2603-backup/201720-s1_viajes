/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;

/**
 *
 * @author Vanessa Huertas <tv.huertas10>
 */
public class TarjetaCreditoDTO {
    
    /**
     * Número de la cuenta
     */
    private Integer numero;
    
    /**
     * Fondos de la cuenta
     */
    private Long fondos; 
    
    /**
     * Constructor por defecto
     */
    public TarjetaCreditoDTO()
    {
        
    }
    
    /**
     * Número de la cuenta
     * @return numero
     */
    public Integer getNumero() {     
        return numero;
    }

    /**
     * Fondos de la encuesta
     * @return fondos
     */
    public Long getFondos() {    
        return fondos;
    }

    /**
     * Cambiar el número de la cuenta
     * @param numero 
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Cambiar la cantidad de dinero que se encuentra en la cuenta
     * @param fondos 
     */    
    public void setFondos(Long fondos) {
        this.fondos = fondos;
    }
    
    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param tarjeta:Es la entidad que se va a convertir a DTO 
     */
     public TarjetaCreditoDTO(TarjetaCreditoEntity tarjeta) {
       
        this.numero = tarjeta.getNumero();
        this.fondos = tarjeta.getFondos();
    }
     
      /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public TarjetaCreditoEntity toEntity() {
        TarjetaCreditoEntity entity = new TarjetaCreditoEntity();
        entity.setNumero(this.numero);
        entity.setFondos(this.fondos);
        return entity;
    }
}
