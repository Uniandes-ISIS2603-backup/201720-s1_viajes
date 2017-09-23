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
    
    private String longitud;
    private String latitud;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
    private Long id;
    
    public UbicacionDTO (UbicacionEntity entity){
        this.longitud = entity.getLongitud();
        this.latitud = entity.getLatitud();
        this.nombre = entity.getNombre();
        this.direccion = entity.getDireccion();
        this.ciudad = entity.getCiudad();
        this.pais = entity.getPais();
        this.id = entity.getId();
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
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