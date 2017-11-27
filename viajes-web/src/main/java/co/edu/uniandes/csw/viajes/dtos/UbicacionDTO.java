/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;

/**
 *
 * @author ma.forero11
 */
public class UbicacionDTO {
    
    private Double longitud;
    private Double latitud;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
    private Long id;
    
    /**
     * Constructor por defecto
     */
    public UbicacionDTO (){
         //Constructor por defecto
    }
    
    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en la entidad que viene de argumento.
     * @param entity: Es la entidad que se va a convertir a DTO 
     */
    public UbicacionDTO (UbicacionEntity entity){
        this.longitud = entity.getLongitud();
        this.latitud = entity.getLatitud();
        this.nombre = entity.getNombre();
        this.direccion = entity.getDireccion();
        this.ciudad = entity.getCiudad();
        this.pais = entity.getPais();
        this.id = entity.getId();
    }

    /**
     * @return the longitud
     */
    public Double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud
     */
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the latitud
     */
    public Double getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud
     */
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the id to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the id to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the id to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public UbicacionEntity toEntity(){
        UbicacionEntity entity = new UbicacionEntity();
        entity.setId(this.id);
        entity.setCiudad(this.ciudad);
        entity.setDireccion(this.direccion);
        entity.setLatitud(this.latitud);
        entity.setLongitud(this.longitud);
        entity.setPais(this.pais);
        entity.setNombre(this.nombre);
        return entity;
    }
}