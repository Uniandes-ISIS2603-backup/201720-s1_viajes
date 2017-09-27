/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Juan
 */
@Entity
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
    
    @PodamExclude
    @OneToMany(mappedBy = "compania")
    private List<GuiaEntity> guias;
      
    @PodamExclude
    @OneToMany
    private List<TransporteEntity> transportes;
    
    @PodamExclude
    @OneToMany(mappedBy = "compania")
    private List<EntretenimientoEntity> entretenimientos;
     
    @PodamExclude
    @OneToMany
    private List<HospedajeEntity> hospedajes;

    @PodamExclude
    @OneToMany
    private List<OficinaEntity> oficinas;
    
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

    public List<EntretenimientoEntity> getEntretenimientos() {
        return entretenimientos;
    }

    public List<GuiaEntity> getGuias() {
        return guias;
    }

    public List<HospedajeEntity> getHospedajes() {
        return hospedajes;
    }

    public List<OficinaEntity> getOficinas() {
        return oficinas;
    }

    public List<TransporteEntity> getTransportes() {
        return transportes;
    }
    
    
}
