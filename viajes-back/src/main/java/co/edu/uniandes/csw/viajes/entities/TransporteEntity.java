/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author sa.silva1
 * Anotaciones: No debia haber constructor
 */
@Entity
public class TransporteEntity extends ServicioEntity 
{
    
    public enum TipoTransporte {
    
    AVION,
    TREN,
    TAXI
    
    }
    
    private TipoTransporte tipo;

    @PodamExclude
    @ManyToOne
    private CompaniaEntity compania;
    
    public TipoTransporte getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }
    public CompaniaEntity getCompania() {
        return compania;
    }

    public void setCompañia(CompaniaEntity compania) {
        this.compania = compania;
    }
}