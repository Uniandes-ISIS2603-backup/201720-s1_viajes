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
public class GuiaEntity extends  BaseEntity  
{    
    private String lenguaje; //Lenguaje  del guia
    private Long valor; //Valor del guia
    private Long contratoHora; //Contrato por hora del guia
    private String fechaInicio; //Fecha  de inicio del servicio de guia
    private String fechaFinal; //Fecha  del final del servicio de guia
    private String nombre; //Nombre del guia
    private Long calificacion; //Clasificación del guia
        
    /**
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
    */
    public GuiaEntity()
    {        
    }
   
     /**
     * Obtener el atributo lenguaje
     * 
     * @return  lenguaje
     */
    public String getLenguaje() {
        return lenguaje;
    }

     /**
     * Obtener el atributo valor
     * 
     * @return  valor
     */
    public Long getValor() {
        return valor;
    }

     /**
     * Obtener el atributo contratoHora
     * 
     * @return  contratoHora
     */
    public Long getContratoHora() {
        return contratoHora;
    }

     /**
     * Obtener el atributo fechaInicio
     * 
     * @return  fechaInicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

     /**
     * Obtener el atributo fechaFinal
     * 
     * @return  fechaFinal
     */
    public String getFechaFinal() {
        return fechaFinal;
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
     * Obtener el atributo calificacion
     * 
     * @return  calificacion
     */
    public Long getCalificacion() {
        return calificacion;
    }
    
     /**
     * Obtener el atributo compania
     * 
     * @return  compania
     
     public CompaniaEntity getCompania() {
        return compania;
    }
     */
    
     /**
     * Actualizar el atributo lenguaje
     * @param lenguaje lenguaje to set
     */
    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    /**
     * Actualizar el atributo valor
     * @param valor valor to set
     */
    public void setValor(Long valor) {
        this.valor = valor;
    }

    /**
     * Actualizar el atributo contratoHora
     * @param contratoHora contratoHora to set
     */
    public void setContratoHora(Long contratoHora) {
        this.contratoHora = contratoHora;
    }

    /**
     * Actualizar el atributo fechaInicio
     * @param fechaInicio fechaInicio to set
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Actualizar el atributo fechaFinal
     * @param fechaFinal fechaFinal to set
     */
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Actualizar el atributo nombre
     * @param nombre nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Actualizar el atributo calificacion
     * @param calificacion calificacion to set
     */
    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Actualizar el atributo compania
     * @param compania compania to set
     
    public void setCompania(CompaniaEntity compania) {
        this.compania = compania;
    } 
*/
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}