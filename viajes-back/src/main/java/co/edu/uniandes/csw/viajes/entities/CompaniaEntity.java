/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.Entity;

/**
 *
 * @author Juan
 */
@Entity
public class CompaniaEntity extends BaseEntity{
        
    /**
    * Email  de contacto de la companñia
    */
    private String email; 
    
    /**
    * Telefono de contacto de la compañia
    */
    private Long telefono; 
    
    /**
    * Nombre de la compañia
    */
    private String nombre;
    
    /**
     * Constructor de la  empresa
     */ 
    public CompaniaEntity()
    {
        
    }       
}
