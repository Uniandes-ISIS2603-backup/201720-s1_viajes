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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author sa.silva1
 */
@Entity
@Table
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class ServicioEntity extends BaseEntity{
    
    private String nombre;
    
    private String fechaInicio;
    
    private String fechaFinal;
    
    private Double valor;
    
    private Double calificacion;
    
    private String comentarios;
    
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
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

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