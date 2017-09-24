/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.CompaniaEntity;

/**
 *
 * @author Juan
 */
public class CompaniaDTO {
    
    private Long id;  //id de la empresa
    private String email; //Email de la empresa
    private Long telefono; //Telefono de la empresa
    private String nombre; //Nombre de la empresa
    
    /**
     * Constructor por defecto
     */
    public CompaniaDTO()
    {
        
    }

    /**
     * Obtiene el atributo nombre.
     *
     * @return atributo nombre.
     * 
     */
    public String getNombre() {
        return nombre;
    }

     /**
     * Obtiene el atributo id.
     *
     * @return atributo id.
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor del atributo nombre.
     *
     * @param nombre nuevo valor del atributo
     * 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el valor del atributo id.
     *
     * @param id nuevo valor del atributo
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

      /**
     * Obtiene el atributo email.
     *
     * @return atributo email.
     * 
     */
    public String getEmail() {
        return email;
    }

      /**
     * Obtiene el atributo telefono.
     *
     * @return atributo telefono.
     * 
     */
    public Long getTelefono() {
        return telefono;
    }

    /**
     * Establece el valor del atributo email.
     *
     * @param email nuevo valor del atributo
     * 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Establece el valor del atributo telefono.
     *
     * @param telefono nuevo valor del atributo
     * 
     */
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
      
    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param compania:Es la entidad que se va a convertir a DTO 
     */
     public CompaniaDTO(CompaniaEntity compania) {
        this.id = compania.getId();
        this.nombre = compania.getNombre();
        this.email= compania.getEmail();
        this.telefono=compania.getTelefono();
    }
     
      /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public CompaniaEntity toEntity() {
        CompaniaEntity entity = new CompaniaEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setEmail(this.email);
        entity.setTelefono(this.telefono);
        return entity;
    }
    
}
