/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @OneToMany(mappedBy = "usuario")
    private List<TarjetaCreditoEntity> tarjeta;
    
    @PodamExclude
    @OneToMany(mappedBy = "usuario")
    private List<ItinerarioEntity> itinerario;
    
    @PodamExclude
    @OneToOne(mappedBy = "usuario")
    private BlogEntity blog;
    
    //GETTERS/SETTERS
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
