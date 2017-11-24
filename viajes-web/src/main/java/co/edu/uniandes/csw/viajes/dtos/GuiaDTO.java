/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.GuiaEntity;

/**
 *
 * @author Juan
 */
public class GuiaDTO {
    
    private Long id;//id del guia 
    private String nombre;//nombre del guia
    private String lenguaje;//lenguaje del guia
    private Long valor; //Valor del guia
    private Long contratoHora; //Contrato por hora del guia
    private String fechaInicio; //Fecha  de inicio del servicio de guia
    private String fechaFinal; //Fecha  del final del servicio de guia
    private Long calificacion; //Clasificación del guia
        
    /**
     * Constructor por defecto
     */
    public GuiaDTO()
    {
         //Constructor por defecto
    }
    
    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param guia:Es la entidad que se va a convertir a DTO 
     */
     public GuiaDTO(GuiaEntity guia) {
         if (guia!=null) {
        this.id = guia.getId();
        this.nombre = guia.getNombre();
        this.lenguaje=guia.getLenguaje();
        this.calificacion=guia.getCalificacion();
        this.valor=guia.getValor();
        this.contratoHora=guia.getContratoHora();
        this.fechaFinal=guia.getFechaFinal();
        this.fechaInicio=guia.getFechaInicio();
         }
        
    }
     /**
     * Obtiene el atributo nombre.
     *
     * @return atributo nombre.
     * 
     */
     public String getNombre() {
        return nombre;
    }
     
    /**
     * Obtiene el atributo id.
     *
     * @return atributo id.
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor del atributo nombre.
     *
     * @param nombre nuevo valor del atributo
     * 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el valor del atributo id.
     *
     * @param id nuevo valor del atributo
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

     /**
     * Obtiene el atributo lenguaje.
     *
     * @return atributo lenguaje.
     * 
     */
    public String getLenguaje() {
        return lenguaje;
    }
    
    
    /**
     * Establece el valor del atributo lenguaje.
     *
     * @param lenguaje nuevo valor del atributo
     * 
     */
    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

     /**
     * Obtiene el atributo valor.
     *
     * @return atributo valor.
     * 
     */
    public Long getValor() {
        return valor;
    }

    
     /**
     * Obtiene el atributo contratoHora.
     *
     * @return atributo contratoHora.
     * 
     */
    public Long getContratoHora() {
        return contratoHora;
    }

     /**
     * Obtiene el atributo fechaInicio.
     *
     * @return atributo fechaInicio.
     * 
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Obtiene el atributo fechaFinal.
     *
     * @return atributo fechaFinal.
     * 
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Obtiene el atributo calificacion.
     *
     * @return atributo calificacion.
     * 
     */
    public Long getCalificacion() {
        return calificacion;
    }

   /**
     * Establece el valor del atributo valor.
     *
     * @param valor nuevo valor del atributo
     * 
     */
    public void setValor(Long valor) {
        this.valor = valor;
    }

      /**
     * Establece el valor del atributo contratoHora.
     *
     * @param contratoHora nuevo valor del atributo
     * 
     */
    public void setContratoHora(Long contratoHora) {
        this.contratoHora = contratoHora;
    }

     /**
     * Establece el valor del atributo fechaInicio.
     *
     * @param fechaInicio nuevo valor del atributo
     * 
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

     /**
     * Establece el valor del atributo fechaFinal.
     *
     * @param fechaFinal nuevo valor del atributo
     * 
     */
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
     /**
     * Establece el valor del atributo calificacion.
     *
     * @param calificacion nuevo valor del atributo
     * 
     */
    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }
   
    /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public GuiaEntity toEntity() {
        GuiaEntity entity = new GuiaEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setLenguaje(this.lenguaje);
        entity.setCalificacion(this.calificacion);
        entity.setValor(this.valor);
        entity.setContratoHora(this.contratoHora);
        entity.setFechaFinal(this.fechaFinal);
        entity.setFechaInicio(this.fechaInicio);
        return entity;
    }  
}
