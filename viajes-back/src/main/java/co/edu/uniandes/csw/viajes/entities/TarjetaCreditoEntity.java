/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
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
    private Integer numero; //Número de cuenta 
    private Long fondos; //Cantidad de dinero disponible
    
    @PodamExclude
    @OneToMany(mappedBy = "tarjeta")
    private List<PagoEntity> pagos; 
    
    @PodamExclude
    @ManyToOne
    private UsuarioEntity usuario;
    
    //GETTERS/SETTERS
    
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

    public void setPagos(List<PagoEntity> pagos) {
        this.pagos = pagos;
    }

    public List<PagoEntity> getPagos() {
        return pagos;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    
}
