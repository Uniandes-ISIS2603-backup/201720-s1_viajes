/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;

/**
 *
 * @author Vanessa Huertas <tv.huertas10>
 */
public class UsuarioDTO {
    
    /**
     * Nombre del usuario
     */
    private String nombre;
    
    /**
     * Id del usuario
     */
    private Long id;
    
    /**
     * Constructir por defecto
     */
    public UsuarioDTO()
    {       
    }
    
    /**
     * Nombre del usuario
     * @return nombre 
     */
     public String getNombre() {
       
        return nombre;
    }
     
    /**
     * Cambiar el nombre del usuario
     * @param nombre
     */
    public void setNombre(String nombre) {     
        this.nombre = nombre;
    }

    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param usuario:Es la entidad que se va a convertir a DTO 
     */
    public UsuarioDTO(UsuarioEntity usuario) {
        this.nombre = usuario.getNombre();
       }
     
     /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public UsuarioEntity toEntity() {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setNombre(this.nombre);
        return entity;
    }  

    /**
     * Id del usuario
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Cambia el id del usuario
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }      
}
