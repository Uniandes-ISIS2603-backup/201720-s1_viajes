/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author jc.sanchez12
 */
@Entity
public class CompaniaEntity extends BaseEntity
{
    //*************
    //**ATRIBUTOS**
    //*************
    
    
    private String email; //Email de la empresa
    private Long telefono; //Telefono de la empresa
    private String nombre; //Nombre de la empresa
    
    @OneToMany(mappedBy = "compania",cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<GuiaEntity> guias;
   
    /*
   @OneToMany(mappedBy = "compania", cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<OficinaEntity> oficinas;
   */
   
    @OneToMany(mappedBy = "compania", cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<TransporteEntity> transportes;
    
    @OneToMany(mappedBy = "compania", cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<EntretenimientoEntity> entretenimientos;
     
     @OneToMany(mappedBy = "compania", cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<HospedajeEntity> hospedajes;


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
     * 
     * @param email email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @param telefono telefono to set
     */
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    /**
     * 
     * @param nombre nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    public List<GuiaEntity> getGuias() {
        return guias;
    }

    public void setGuias(List<GuiaEntity> guias) {
        this.guias = guias;
    }
 /*
    public List<OficinaEntity> getOficinas() {
        return oficinas;
    }

    public void setOficinas(List<OficinaEntity> oficinas) {
        this.oficinas = oficinas;
    }
*/
   
    public List<TransporteEntity> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<TransporteEntity> transportes) {
        this.transportes = transportes;
    }

    public List<EntretenimientoEntity> getEntretenimientos() {
        return entretenimientos;
    }

    public void setEntretenimientos(List<EntretenimientoEntity> entretenimientos) {
        this.entretenimientos = entretenimientos;
    }

    public List<HospedajeEntity> getHospedajes() {
        return hospedajes;
    }

    public void setHospedajes(List<HospedajeEntity> hospedajes) {
        this.hospedajes = hospedajes;
    }

    public String getEmail() {
        return email;
    }
   
    
}