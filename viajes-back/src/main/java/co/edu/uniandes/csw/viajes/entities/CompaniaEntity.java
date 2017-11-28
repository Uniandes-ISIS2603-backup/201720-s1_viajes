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
public class CompaniaEntity extends BaseEntity {

    /**
     * Email de contacto de la companñia
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
     * Relacion asociada a los guias que ofrece una compañia
     */
    @PodamExclude
    @OneToMany
    private List<GuiaEntity> guias;

    /**
     * Relacion asociada a los transportes que ofrece una compañia
     */
    @PodamExclude
    @OneToMany
    private List<TransporteEntity> transportes;

    /**
     * Relacion asociada a los servicios de entretenimiento que tiene una
     * compañia
     */
    @PodamExclude
    @OneToMany
    private List<EntretenimientoEntity> entretenimientos;

    /**
     * Relacion asociada a los hospedajes que ofrece una comañia
     */
    @PodamExclude
    @OneToMany
    private List<HospedajeEntity> hospedajes;

    /**
     * Relacion asociada a las oficinas que conforman la compañia
     */
    @PodamExclude
    @OneToMany
    private List<OficinaEntity> oficinas;

    /**
     * Obtener el email de la compania
     *
     * @return email de la compañia
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtener el telefono de la compañia
     *
     * @return telefono de la compañia
     */
    public Long getTelefono() {
        return telefono;
    }

    /**
     * Obtener el nombre de la compañia
     *
     * @return nombre de la compañia
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualizar el atributo email
     *
     * @param email email a actualizar
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Actualizar el atributo telefono
     *
     * @param telefono telefono a actualizar
     */
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    /**
     * Actualizar el atributo nombre
     *
     * @param nombre nombre a actualizar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener la lista de guias
     * @return Lista con los guias de la compañía 
     */
    public List<GuiaEntity> getGuias() {
        return guias;
    }

    /**
     * Actualizar el atributo guias
     *
     * @param guias guias a actualizar
     */
    public void setGuias(List<GuiaEntity> guias) {
        this.guias = guias;
    }

    /**
     * Obtener la lista de transportes
     *
     * @return Lista de transportes de la compañia
     */
    public List<TransporteEntity> getTransportes() {
        return transportes;
    }

    /**
     * Actualizar el atributo transportes
     *
     * @param transportes transportes a actualizar
     */
    public void setTransportes(List<TransporteEntity> transportes) {
        this.transportes = transportes;
    }

    /**
     * Obtener la lista de entretenimientos
     *
     * @return Lista de entretenimientos de la compañia
     */
    public List<EntretenimientoEntity> getEntretenimientos() {
        return entretenimientos;
    }

    /**
     * Actualizar el atributo entretenimientos
     *
     * @param entretenimientos entretenimientos a actualizar
     */
    public void setEntretenimientos(List<EntretenimientoEntity> entretenimientos) {
        this.entretenimientos = entretenimientos;
    }

    /**
     * Obtener la lista de hospedajes
     *
     * @return Lista de hospedajes de la compañia
     */
    public List<HospedajeEntity> getHospedajes() {
        return hospedajes;
    }

    /**
     * Actualizar el atributo hospedajes
     *
     * @param hospedajes hospedajes a actualizar
     */
    public void setHospedajes(List<HospedajeEntity> hospedajes) {
        this.hospedajes = hospedajes;
    }

    /**
     * Obtener la lista de oficinas
     *
     * @return Lista de oficinas de la compañia
     */
    public List<OficinaEntity> getOficinas() {
        return oficinas;
    }

    /**
     * Actualizar el atributo oficinas
     *
     * @param oficinas oficinas a actualizar
     */
    public void setOficinas(List<OficinaEntity> oficinas) {
        this.oficinas = oficinas;
    }
}
