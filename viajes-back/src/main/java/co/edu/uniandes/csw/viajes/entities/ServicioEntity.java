/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa la entidad del Servicio en general
 * @author sa.silva1
 */
//@Entity
//@Table
//@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@MappedSuperclass
public abstract class ServicioEntity extends BaseEntity{
    
    /**
     * Nombre del servicio
     */
    private String nombre;
    
    /**
     * Fecha de inicio del servicio
     */
    private String fechaInicio;
    
    /**
     * Fecha de finalizacion del servicio
     */
    private String fechaFinal;
    
    /**
     * Valor neto del servicio
     */
    private Double valor;
    
    /**
     * Calificacion del servicio otorgada por los usuarios
     */
    private Double calificacion;
    
    /**
     * Comentarios asosciados al servicio
     */
    private String comentarios;
    
    /**
     * Descripcion del servicio
     */
    private String descripcion;

    @PodamExclude
    @OneToOne()
    private UbicacionEntity ubicacion;
        
    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
    
    @PodamExclude   
    @OneToMany
    private List<ImagenEntity> imagenes;
    
    @PodamExclude
    @ManyToOne
    private ItinerarioEntity itinerario;
    
    @PodamExclude
    @OneToMany(mappedBy = "servicio")
    private List<HospedajeEntity> hospedajes;
     
    @PodamExclude
    @OneToMany(mappedBy = "servicio")
    private List<EntretenimientoEntity> entretenimientos;
      
    @PodamExclude
    @OneToMany(mappedBy = "servicio")
    private List<TransporteEntity> transportes;

     /**
      * Retornar el nombre del servicio
      * @return nombre del servicio
      */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asignar el nombre del servicio
     * @param nombre del servicio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retornar la fecha de inicio del servicio
     * @return fecha de inicio del servicio
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Asignar la fecha de inicio del servicio
     * @param fechaInicio del servicio
     */
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Retornar la fecha final del servicio
     * @return la fecha final del revicio
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Asignar la fecha final del servicio
     * @param fechaFinal del servicio
     */
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * Retornar el valor neto del servicio
     * @return el valor neto del servicio
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Asignar el valor al servicio
     * @param valor del servicio
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Retornar la calificacion del servicio
     * @return la calificacion del servicio
     */
    public Double getCalificacion() {
        return calificacion;
    }

    /**
     * Asignar la calificacion al servicio
     * @param calificacion del servicio
     */
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Retorna los comentarios asociados al servicio
     * @return los comentarios asociados al servicio
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Asignar comentarios a un servicio
     * @param comentarios de un servicio
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    /**
     * Retornar la descripcion del servicio
     * @return la descripcion de un servicio
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna descripcion a un servicio
     * @param descripcion para un servicio
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the ubicacion
     */
    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(UbicacionEntity ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the compania
     */
    public CompaniaEntity getCompania() {
        return compania;
    }

    /**
     * @param compania the compania to set
     */
    public void setCompania(CompaniaEntity compania) {
        this.compania = compania;
    }

    /**
     * @return the imagenes
     */
    public List<ImagenEntity> getImagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setImagenes(List<ImagenEntity> imagenes) {
        this.imagenes = imagenes;
    }

    /**
     * @return the itinerario
     */
    public ItinerarioEntity getItinerario() {
        return itinerario;
    }

    /**
     * @param itinerario the itinerario to set
     */
    public void setItinerario(ItinerarioEntity itinerario) {
        this.itinerario = itinerario;
    }
}