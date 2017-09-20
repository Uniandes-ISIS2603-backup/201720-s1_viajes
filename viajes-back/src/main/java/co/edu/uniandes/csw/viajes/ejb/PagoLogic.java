/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;


import co.edu.uniandes.csw.viajes.entities.PagoEntity;
import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.viajes.persistence.PagoPersistence;
import java.util.List;
import java.util.logging.Level;
import javax.inject.Inject;

/**
 *
 * @author tv.huertas10
 */
public class PagoLogic {
    
    
    @Inject
    private PagoPersistence persistence;
    
    @Inject
    private TarjetaCreditoLogic tarjetaLogic;
    
   /**
     * Obtiene la lista de los registros de Pago.
     *
     * @return Colección de objetos de PagoEntity.
     * @generated
     */
    public List<PagoEntity> getPagos() {
        return persistence.findAll();
    }
    
    /**
     * Obtiene los datos de una instancia de Pago a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de PagoEntity con los datos del Pago consultado.
     * @generated
     */
    public PagoEntity getPago(Long id) {
        return persistence.findById(id);
    }
    
    /**
     * Se encarga de crear un Pago en la base de datos.
     *
     * @param entity Objeto de PagoEntity con los datos nuevos
     * @return Objeto de PagoEntity con los datos nuevos y su ID.
     * @generated
     */
    public PagoEntity createPago(PagoEntity entity) {
        return persistence.create(entity);
    }
    
    /**
     * Actualiza la información de una instancia de Pago.
     *
     * @param entity Instancia de PagoEntity con los nuevos datos.
     * @return Instancia de PagoEntity con los datos actualizados.
     * @generated
     */
    public PagoEntity updatePago(PagoEntity entity) {
        return persistence.update(entity);
    }
    
     /**
     * Elimina una instancia de Pago de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deletePago(Long id) {
        persistence.delete(id);
    }
    
/**
     * Obtiene una instancia de TarjetaCreditoEntity asociada a una instancia de Pago
     *
     * @param PagoId Id Identificador de la instancia de Author
     * @return
     * @generated
     */
    public TarjetaCreditoEntity getTarjetaCredito(Long PagoId) {
       TarjetaCreditoEntity tarjeta = getPago(PagoId).getTarjeta();
        if (tarjeta!=null) {
            return tarjeta;
        }
        return null;
    } 
}
