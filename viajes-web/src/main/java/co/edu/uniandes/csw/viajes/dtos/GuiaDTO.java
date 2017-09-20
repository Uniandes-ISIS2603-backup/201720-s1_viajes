<<<<<<< HEAD
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
     private Long id;
    private String nombre;
    private String lenguaje;
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
        
    }
    
     public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
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

    public Long getCalificacion() {
        return calificacion;
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

    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
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
        this.calificacion=guia.getCalificacion();
        this.valor=guia.getValor();
        this.contratoHora=guia.getContratoHora();
        this.fechaFinal=guia.getFechaFinal();
        this.fechaInicio=guia.getFechaInicio();
         }
        
    }
    
      /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public GuiaEntity toEntity() {
        GuiaEntity entity = new GuiaEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setCalificacion(this.calificacion);
        entity.setValor(this.valor);
        entity.setContratoHora(this.contratoHora);
        entity.setFechaFinal(this.fechaFinal);
        entity.setFechaInicio(this.fechaInicio);
        return entity;
    }  
}
=======
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
    private Long id;
    private String nombre;
    private String lenguaje;
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
        
    }
    
     public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
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

    public Long getCalificacion() {
        return calificacion;
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

    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
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
        this.calificacion=guia.getCalificacion();
        this.valor=guia.getValor();
        this.contratoHora=guia.getContratoHora();
        this.fechaFinal=guia.getFechaFinal();
        this.fechaInicio=guia.getFechaInicio();
         }
        
    }
    
      /**
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO 
     */
    public GuiaEntity toEntity() {
        GuiaEntity entity = new GuiaEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setCalificacion(this.calificacion);
        entity.setValor(this.valor);
        entity.setContratoHora(this.contratoHora);
        entity.setFechaFinal(this.fechaFinal);
        entity.setFechaInicio(this.fechaInicio);
        return entity;
    }  
}
>>>>>>> master
