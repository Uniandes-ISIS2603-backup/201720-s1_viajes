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
    /**
    * Id
    */
    private Long id;
    
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
   *Constructor por defecto
   */
   public CompaniaDTO()
   {
       
   }
    
    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param compania:Es la entidad que se va a convertir a DTO 
     */
    public CompaniaDTO(CompaniaEntity compania)
    {
        this.id=compania.getId();
        this.email=compania.getEmail();
        this.nombre=compania.getNombre();
        this.telefono=compania.getTelefono();
    }
    
    /**
     * Obtener el atributo id
     * 
     * @return id
     */ 
   public Long getId() {
        return id;
    }

    /**
     * Obtener el atributo telefono
     * 
     * @return telefono
     */
    public Long getTelefono() {
        return telefono;
    }

    /**
     * Obtener el atributo nombre
     * 
     * @return  nombre
     */
    public String getNombre() {
        return nombre;
    }

      /**
     * Obtener el atributo email
     * 
     * @return  email
     */
    public String getEmail() 
    {
        return email;
    }

    /**
     * Actualizar el atributo  email
     * @param email email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Actualizar el atributo telefono 
     * @param telefono telefono to set
     */
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    /**
     * Actualizar el atributo nombre
     * @param nombre nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     /**
     * Actualizar el atributo id
     * @param id nombre to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     *Convertir un DTO a un Entity
     * @return un Entity de los  valores del DTO
     */
    public CompaniaEntity toEntity()
    {
        CompaniaEntity entity= new CompaniaEntity();
        entity.setId(id);
        entity.setNombre(nombre);
        entity.setEmail(email);
        entity.setTelefono(telefono);
        return entity;
    }
}
