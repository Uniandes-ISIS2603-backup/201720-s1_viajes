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
public class PagoEntity extends BaseEntity implements Serializable
{
    //ATRIBUTOS
    private String nombre; //Nombre del usuario que hizo el pago
    private String fecha; //Fecha en la que se realizó el pago
    private Double valor; //Valor por el cuál se hizo el pago
    
    //GETTERS/SETTERS
    
    public Double getValor() {
        return valor;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
