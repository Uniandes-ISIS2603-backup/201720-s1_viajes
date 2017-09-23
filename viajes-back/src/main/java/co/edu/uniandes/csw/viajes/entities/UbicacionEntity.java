/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ma.forero11
 */
@Entity
public class UbicacionEntity extends BaseEntity {
    
    private String longitud;
    private String latitud;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
       
    @PodamExclude
    @OneToOne
    private OficinaEntity oficina;
    
    @PodamExclude
    @OneToOne
    private HospedajeEntity hospedaje;
    
    @PodamExclude
    @OneToOne
    private EntretenimientoEntity entretenimiento;
    
    @PodamExclude
    @OneToOne
    private TransporteEntity origen;
    
    @PodamExclude
    @OneToOne
    private TransporteEntity destino;
    
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

    /*
    public OficinaEntity getOficina() {
        return oficina;
    }

    public void setOficina(OficinaEntity oficina) {
        this.oficina = oficina;
    }
*/
    
    
}
