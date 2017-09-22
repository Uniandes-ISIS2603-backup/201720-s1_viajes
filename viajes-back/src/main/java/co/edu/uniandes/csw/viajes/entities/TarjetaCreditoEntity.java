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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author tv.huertas10
 */
@Entity
public class TarjetaCreditoEntity extends BaseEntity implements Serializable
{
    //ATRIBUTOS
    private Integer numero; //Número de cuenta 
    private Long fondos; //Cantidad de dinero disponible
    
    @PodamExclude
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PagoEntity> pagos;    
    
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
    private UsuarioEntity usuario;
    
    //GETTERS/SETTERS
    
    public UsuarioEntity getUsuario()
    {
        return usuario;
    }
    
    public void setUsuario(UsuarioEntity usuario)
    {
        this.usuario = usuario;
    }
    
    public List<PagoEntity> getPagos()
    {
        return pagos;
    }
    
    public void setPagos(List<PagoEntity> pagos)
    {
        this.pagos = pagos;
    }
    
    public Integer getNumero() {
        return numero;
    }

    public Long getFondos() {
        return fondos;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setFondos(Long fondos) {
        this.fondos = fondos;
    }
}