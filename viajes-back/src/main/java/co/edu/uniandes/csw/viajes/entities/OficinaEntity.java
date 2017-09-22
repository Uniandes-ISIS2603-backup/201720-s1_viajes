/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @ManyToOne
    private CompaniaEntity compania;
    
    //////////////////////////////
    //REVISAR SI SE HACE @EMBEDDED
    //////////////////////////////
    //@OneToOne (fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
    //@JoinColumn(name="UBICACION_ID")
    //private UbicacionEntity ubicacion;
    
    
    public String getNombreLugar()
    {
        return nombreLugar;
    }
    
    public void setNombreLugar(String nombreLugar)
    {
        this.nombreLugar = nombreLugar;
    }
    
    public String getNombreEncargado()
    {
        return nombreEncargado;
    }
    
    public void setNombreEncargado(String nombreEncargado)
    {
        this.nombreEncargado = nombreEncargado;
    }

    public CompaniaEntity getCompania() {
        return compania;
    }

    public void setCompania(CompaniaEntity compania) {
        this.compania = compania;
    }
 
    
}
