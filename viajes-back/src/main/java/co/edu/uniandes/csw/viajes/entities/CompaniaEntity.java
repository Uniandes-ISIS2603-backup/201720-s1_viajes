/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
    
    
   // @OneToMany(fetch=FetchType.LAZY) //Tipo de relación
   // @JoinColumn(name="OFICINA_ID") //Columna  asociada
    //private List<OficinaEntity> oficinas; //Modela la  coleccion de  oficinas 
    


    /**
     * Obtener el atributo email
     * 
     * @return  email
     */
    public String getEmail() {
        return email;
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
}
