/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author m.rodriguez21
 */
@Entity
public class OficinaEntity extends BaseEntity
{
    private String nombreLugar;
    private String nombreEncargado;
       
    @PodamExclude
    @OneToOne(mappedBy = "oficina")
    private UbicacionEntity ubicacion;
      
    /**
     * @return el nombre del lugar
     */
    public String getNombreLugar()
    {
        return nombreLugar;
    }
    
    /**
     * @param nombreLugar el nombreLugar a settear
     */
    public void setNombreLugar(String nombreLugar)
    {
        this.nombreLugar = nombreLugar;
    }
    
    /**
     * @return el nombre del encargado
     */
    public String getNombreEncargado()
    {
        return nombreEncargado;
    }
    
    /**
     * @param nombreEncargado el nombre del encargado a settear
     */
    public void setNombreEncargado(String nombreEncargado)
    {
        this.nombreEncargado = nombreEncargado;
    }
    
    /**
     * @return la ubicacion
     */
    public UbicacionEntity getUbicacion() 
    {
        return ubicacion;
    }

    /**
     * @param ubicacion la ubicacion a settear
     */
    public void setUbicacion(UbicacionEntity ubicacion) 
    {
        this.ubicacion = ubicacion;
    }
    }
