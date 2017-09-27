/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author tv.huertas10
 */
@Entity
public class TarjetaCreditoEntity extends BaseEntity
{
    //ATRIBUTOS
    
    /**
     * Número de cuenta
     */
    private Integer numero;
    
    /**
     * Cantidad de dinero disponible
     */
    private Long fondos; 
    
    /**
     * Pagos realizados con la tarjeta
     */
    @PodamExclude
    @OneToMany(mappedBy = "tarjeta")
    private List<PagoEntity> pagos; 
    
    /**
     * Usuario al que le pertence la tarjeta
     */
    @PodamExclude
    @ManyToOne
    private UsuarioEntity usuario;
    
    //GETTERS/SETTERS   
    
    /**
     * Usuario al que le pertenece la tarjeta
     * @return usuario
     */
    public UsuarioEntity getUsuario()
    {
        return usuario;
    }
    
    /**
     * Agrega el usuario al que le pertenece la tarjeta
     * @param usuario 
     */
    public void setUsuario(UsuarioEntity usuario)
    {
        this.usuario = usuario;
    }
    
    /**
     * Pagos hechos con la tarjeta
     * @return pagos
     */
    public List<PagoEntity> getPagos()
    {
        return pagos;
    }
    
    /**
     * Agrega un nuevo pago 
     * @param pago
     */
    public void setPagos(PagoEntity pago)
    {
        this.pagos.add(pago);
    }
    
    /**
     * Número de cuenta
     * @return numero
     */   
    public Integer getNumero() {
        return numero;
    }

    /**
     * Fondos de la cuenta
     * @return fondos
     */
    public Long getFondos() {
        return fondos;
    }

    /**
     * Cambia el número de la cuenta
     * @param numero 
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Cambia la cantidad de dinero disponible
     * @param fondos 
     */
    public void setFondos(Long fondos) {
        this.fondos = fondos;
    }
}
