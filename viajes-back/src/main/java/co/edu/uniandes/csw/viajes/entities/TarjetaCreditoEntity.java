/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author tv.huertas10
 */
@Entity
public class TarjetaCreditoEntity extends BaseEntity implements Serializable
{
    //ATRIBUTOS
    private Integer numero; //Número de cuenta 
    private Long fondos; //Cantidad de dinero disponible
    
    
    //GETTERS/SETTERS
    
    public Integer getNumero() {
        return numero;
    }

    public Long getFondos() {
        return fondos;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setFondos(Long fondos) {
        this.fondos = fondos;
    }
}
