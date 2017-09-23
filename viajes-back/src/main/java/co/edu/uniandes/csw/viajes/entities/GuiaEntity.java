/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;


/**
 *
 * @author jc.sanchez12
 */
@Entity
public class GuiaEntity extends  BaseEntity  implements Serializable
{    
    private String lenguaje; //Lenguaje  del guia
    private Long valor; //Valor del guia
    private Long contratoHora; //Contrato por hora del guia
    private String fechaInicio; //Fecha  de inicio del servicio de guia
    private String fechaFinal; //Fecha  del final del servicio de guia
    private String nombre; //Nombre del guia
    private Long calificacion; //Clasificación del guia
    
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
    
    @PodamExclude
    @ManyToOne
    private ItinerarioEntity itinerario;

    public GuiaEntity() 
    {
        
    }
   
    public String getLenguaje() {
        return lenguaje;
    }

    public Long getValor() {
        return valor;
    }

    public Long getContratoHora() {
        return contratoHora;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getCalificacion() {
        return calificacion;
    }
    
    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public void setContratoHora(Long contratoHora) {
        this.contratoHora = contratoHora;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }

    public CompaniaEntity getCompania() {
        return compania;
    }

    public void setCompania(CompaniaEntity compania) {
        this.compania = compania;
    }

  
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
}