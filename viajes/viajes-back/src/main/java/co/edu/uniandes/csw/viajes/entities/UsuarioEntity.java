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
public class UsuarioEntity extends BaseEntity 
{
    //ATRIBUTOS
    private String nombre; //Nombre del usuario    
    
    //GETTERS/SETTERS
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
