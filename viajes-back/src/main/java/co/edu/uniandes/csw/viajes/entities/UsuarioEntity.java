<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author tv.huertas10
 */
@Entity
public class UsuarioEntity extends BaseEntity 
{
    //ATRIBUTOS
    private String nombre; //Nombre del usuario    
    
    @PodamExclude
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TarjetaCreditoEntity> tarjetas;
    
    @ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private List<ItinerarioEntity> itinerarios;
    
    //GETTERS/SETTERS
    
    public List<ItinerarioEntity> getItinerarios()
    {
        return itinerarios;
    }
    
    public void setItinerarios(List<ItinerarioEntity> itinerarios)
    {
        this.itinerarios = itinerarios;
    }
        
    public List<TarjetaCreditoEntity> getTarjetas()
    {
        return tarjetas;
    }
    
    public void setTarjetas(List<TarjetaCreditoEntity> tarjetas)
    {
        this.tarjetas = tarjetas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author tv.huertas10
 */
@Entity
public class UsuarioEntity extends BaseEntity 
{
    //ATRIBUTOS
    private String nombre; //Nombre del usuario    
      
    //GETTERS/SETTERS
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
>>>>>>> 46b40ff28509a7518e8f096e4aaff7c5a508f362
