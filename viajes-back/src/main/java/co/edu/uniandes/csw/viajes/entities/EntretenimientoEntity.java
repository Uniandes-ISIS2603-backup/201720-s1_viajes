/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author m.rodriguez21
 */
@Entity
public class EntretenimientoEntity extends ServicioEntity {

    /**
     * Lista de imagenes del entretenimiento
     */
    @PodamExclude
    @OneToMany
    private List<ImagenEntity> imagenes;

    /**
     * Compañia a la que pertenece el entretenimiento
     */
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;

    /**
     * Ubicación del lugar de entretenimiento
     */
    @PodamExclude
    @OneToOne()
    private UbicacionEntity ubicacion;

    /**
     * Obtener la ubicacion del lugar del entretenimiento
     *
     * @return la ubicacion del lugar del entretenimiento
     */
    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }

    /**
     * Actualizar la ubicación del lugar de entretenimiento
     *
     * @param ubicacion la ubicacion a actualizar
     */
    public void setUbicacion(UbicacionEntity ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtener la compañia a la que pertenece el entretenimiento
     *
     * @return la compañia a la que pertenece el entretenimiento
     */
    public CompaniaEntity getCompania() {
        return compania;
    }

    /**
     * Actualizar la compañia a la que pertenece el entretenimiento
     *
     * @param compania la compañia a actualizar
     */
    public void setCompania(CompaniaEntity compania) {
        this.compania = compania;
    }

    /**
     * Obtener las imagenes del entretenimiento
     *
     * @return las imagenes del entretenimiento
     */
    public List<ImagenEntity> getImagenes() {
        return imagenes;
    }

    /**
     * Actualizar las imagenes del entretenimiento
     *
     * @param imagenes las imagenes a actualizar
     */
    public void setImagenes(List<ImagenEntity> imagenes) {
        this.imagenes = imagenes;
    }
}
