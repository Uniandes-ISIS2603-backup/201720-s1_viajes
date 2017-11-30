/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jc.sanchez12
 */
@Entity
public class GuiaEntity extends BaseEntity {

    /**
     * Lenguaje del guia
     */
    private String lenguaje;

    /**
     * Valor del guia
     */
    private Long valor;

    /**
     * Contrato por hora del guia
     */
    private Long contratoHora;

    /**
     * Fecha de inicio del servicio de guia
     */
    private String fechaInicio;

    /**
     * Fecha del final del servicio de guia
     */
    private String fechaFinal;

    /**
     * Nombre del guia
     */
    private String nombre;

    /**
     * Clasificación del guia
     */
    private Long calificacion;

    /**
     * Compañia a la que pertence el guia
     */
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;

    /**
     * Obtener el atributo lenguaje
     *
     * @return lenguaje del guia
     */
    public String getLenguaje() {
        return lenguaje;
    }

    /**
     * Obtener el atributo valor
     *
     * @return valor del guia
     */
    public Long getValor() {
        return valor;
    }

    /**
     * Obtener el atributo contratoHora
     *
     * @return contratoHora del guia
     */
    public Long getContratoHora() {
        return contratoHora;
    }

    /**
     * Obtener el atributo fechaInicio
     *
     * @return fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Obtener el atributo fechaFinal
     *
     * @return fechaFinal
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Obtener el atributo nombre
     *
     * @return nombre del guia
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtener el atributo calificacion
     *
     * @return calificacion del guia
     */
    public Long getCalificacion() {
        return calificacion;
    }

    /**
     * Obtener el atributo compania
     *
     * @return compania a la que pertenece el guia
     */
    public CompaniaEntity getCompania() {
        return compania;
    }

    /**
     * Actualizar el atributo lenguaje
     *
     * @param lenguaje lenguaje a actualizar
     */
    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    /**
     * Actualizar el atributo valor
     *
     * @param valor valor a actualizar
     */
    public void setValor(Long valor) {
        this.valor = valor;
    }

    /**
     * Actualizar el atributo contratoHora
     *
     * @param contratoHora contratoHora a actualizar
     */
    public void setContratoHora(Long contratoHora) {
        this.contratoHora = contratoHora;
    }

    /**
     * Actualizar el atributo fechaInicio
     *
     * @param fechaInicio fechaInicio a actualizar
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Actualizar el atributo fechaFinal
     *
     * @param fechaFinal fechaFinal a actualizar
     */
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
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
     * Actualizar el atributo calificacion
     *
     * @param calificacion calificacion a actualizar
     */
    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Actualizar el atributo compania
     *
     * @param compania compania a actualizar
     */
    public void setCompania(CompaniaEntity compania) {
        this.compania = compania;
    }
}
