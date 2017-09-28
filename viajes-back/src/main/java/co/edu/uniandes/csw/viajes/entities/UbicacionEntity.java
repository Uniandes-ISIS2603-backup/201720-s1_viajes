/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.Entity;

/**
 *
 * @author ma.forero11
 */
@Entity
public class UbicacionEntity extends BaseEntity {
    
    /**
     * Longitud de la ubicacion
     */
    private Double longitud;
    
    /**
     * Latitud de la ubicacion
     */
    private Double latitud;
    
    /**
     * Nombre del lugar
     */
    private String nombre;
    
    /**
     * Direccion del lugar
     */
    private String direccion;
    
    /**
     * Ciudad de la direccion
     */
    private String ciudad;
    
    /**
     * País en el que se encuentra el lugar
     */
    private String pais;

    /**
     * Longitud de la ubicación
     * @return longitud
     */
    public Double getLongitud() {
        return longitud;
    }

    /**
     * Cambiar longitud de la ubicación
     * @param longitud 
     */
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    /**
     * Latitud de la ubicación
     * @return latitud
     */
    public Double getLatitud() {
        return latitud;
    }

    /**
     * Cambiar latitud de la ubicación
     * @param latitud 
     */
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    /**
     * Nombre del lugar
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambiar el nombre del lugar
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Dirección del lugar
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Cambiar direccion del lugar
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Ciudad del lugar
     * @return ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Cambiar la ciudad de la dirección
     * @param ciudad 
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * País del lugar 
     * @return 
     */
    public String getPais() {
        return pais;
    }

    /**
     * Cambiar el país
     * @param pais 
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
 }
