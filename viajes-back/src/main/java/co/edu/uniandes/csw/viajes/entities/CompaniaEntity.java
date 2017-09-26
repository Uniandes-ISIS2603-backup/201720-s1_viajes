/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

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
    
    @PodamExclude
    @OneToMany(mappedBy = "compania")
    private List<GuiaEntity> guias = new ArrayList();
      
    @PodamExclude
    @OneToMany(mappedBy = "compania")
    private List<TransporteEntity> transportes = new ArrayList();
    
    @PodamExclude
    @OneToMany(mappedBy = "compania")
    private List<EntretenimientoEntity> entretenimientos = new ArrayList();
     
    @PodamExclude
    @OneToMany(mappedBy = "compania")
    private List<HospedajeEntity> hospedajes = new ArrayList();

    @PodamExclude
    @OneToMany(mappedBy = "compania")
    private List<OficinaEntity> oficinas = new ArrayList();

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

    public List<OficinaEntity> getOficinas() {
        return oficinas;
    }

    public void setOficinas(List<OficinaEntity> oficinas) {
        this.oficinas = oficinas;
    }
   
    
}

