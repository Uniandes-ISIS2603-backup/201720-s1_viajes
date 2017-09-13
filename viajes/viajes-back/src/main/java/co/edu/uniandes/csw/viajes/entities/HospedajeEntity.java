/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

/**
 *
 * @author ma.forero11
 */
public class HospedajeEntity{

    private String fechaInicio;
    private String fechaFinal;
    private String nombre;
    private Double valor;
    private Integer calificacion;
    private String comentarios;
    private long id;
    private String descripcion;
    
    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //private UbicacionEntity ubicacion;
    //private List<ImagenEntity> imagenes;
    //private CompaniaEntity compania;
    
    // public UbicacionEntity getUbicacion()
    //{
    //    return ubicacion;
    //}
     
//    public void setUbicacion(UbicacionEntity ubicacion)
//    {
//        this.ubicacion = ubicacion;
//    }
//     
//    public List<ImagenEntity> getImagenes()
//    {
//        return imagenes;
//    }
//    
//    public void setImagenes(List<ImagenEntity> imagenes)
//    {
//        this.imagenes = imagenes;
//    }
    
//    public CompaniaEntity getCompania()
//    {
//        return compania;
//    }
//    
//    public void setCompania(CompaniaEntity compania)
//    {
//        this.compania = compania;
//    }
     
}
