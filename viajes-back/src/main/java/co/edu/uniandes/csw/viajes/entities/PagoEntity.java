package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author tv.huertas10
 */
@Entity
public class PagoEntity extends BaseEntity
{
    //ATRIBUTOS
    
    /**
     * Nombre del usuario que hizo el pago
     */
    private String nombre;
    
    /**
     * Fecha en la que el pago fue realizado
     */
    private String fecha;
    
    /**
     * Valor por el cual se hizo el pago
     */
    private Double valor;
    
    /**
     * Tarjeta de credito con la que se realizó el pago
     */
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
    private TarjetaCreditoEntity tarjeta;
    
    //GETTERS/SETTERS
    
    /**
     * Valor del pago
     * 
     * @return valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Fecha del pago
     * 
     * @return fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Nombre del usuario que realizó el pago
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Se cambia el valor actual por el valor que entra por parámetro
     * 
     * @param valor 
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /** 
     * Se cambia el nombre actual por el nombre que entra por parámetro
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Se cambia la fecha actual por la fecha que entra por parámetro
     * 
     * @param fecha 
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    /**
     * Tarjeta de credito con la cual el pago fue realizado
     * 
     * @return tarjeta
     */
    public TarjetaCreditoEntity getTarjeta()            
    {
        return tarjeta;
    }
    
    /**
     * Se cambia la tarjeta de credito actual por la tarjeta que entra por parámetro
     * 
     * @param tarjeta 
     */
    public void setTarjeta(TarjetaCreditoEntity tarjeta)
    {
        this.tarjeta = tarjeta;
    }
}
