/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

/**
 *
 * @author Juan
 */
public class CompaniaEntity extends BaseEntity
{
    /*
    Email de la empresa
    */
     private String email;
     
     /*
     /Telefono de la empresa
     */
    private Long telefono;
    
    /*
    Nombre de la empresa
    */
    private String nombre;
    
    /**
     * Constructor de la  empresa
     */ 
    public CompaniaEntity()
    {
        
    }
    
    /*
    /Obtener  el email de la empresa
    /@return email
    */
    public String getEmail() {
        return email;
    }

    
     /*
    /Obtener  el telefono de la empresa
    /@return telefono
    */
    public Long getTelefono() {
        return telefono;
    }

     /*
    /Obtener  el nombre de la empresa
    /@return nombre
    */
    public String getNombre() {
        return nombre;
    }

    /*
    Actualizar  email
    @param email to set
    */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
    Actualizar  telefono
    @param telefono to set
    */
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    /*
    Actualizar  nombre
    @param nombre to set
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
