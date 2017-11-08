/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.PagoEntity;
import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import co.edu.uniandes.csw.viajes.persistence.TarjetaCreditoPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author tv.huertas10
 */
public class TarjetaCreditoLogic {
    
    
    /**
     * Acceso a la aplicación
     */
    @Inject
    private TarjetaCreditoPersistence persistence;    
    
   /**
     * Obtiene la lista de los registros de TarjetaCredito.
     *
     * @return Colección de objetos de TarjetaCreditoEntity.
     * @generated
     */
    public List<TarjetaCreditoEntity> getTarjetasCredito() {
        return persistence.findAll();
    }
    
    /**
     * Obtiene los datos de una instancia de TarjetaCredito a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de TarjetaCreditoEntity con los datos de la TarjetaCredito consultada.
     * @generated
     */
    public TarjetaCreditoEntity getTarjetaCredito(Long id) {
        return persistence.findById(id);
    }
    
    /**
     * Se encarga de crear una TarjetaCredito en la base de datos.
     *
     * @param entity Objeto de TarjetaCreditoEntity con los datos nuevos
     * @return Objeto de TarjetaCreditoEntity con los datos nuevos y su ID.
     * @generated
     */
    public TarjetaCreditoEntity createTarjetaCredito(TarjetaCreditoEntity entity) {
        return persistence.create(entity);
    }
    
    /**
     * Actualiza la información de una instancia de TarjetaCredito.
     *
     * @param id Id de la tarjeta
     * @param entity Instancia de TarjetaCreditoEntity con los nuevos datos.
     * @return Instancia de TarjetaCreditoEntity con los datos actualizados.
     * @generated
     */
    public TarjetaCreditoEntity updateTarjetaCredito(Long id,TarjetaCreditoEntity entity) {
        return persistence.update(entity);
    }
    
     /**
     * Elimina una instancia de TarjetaCredito de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteTarjetaCredito(Long id) {
        persistence.delete(id);
    }
    
    /**
     * Obtiene una instancia de UsuarioEntity asociada a una instancia de TarjetaCredito
     *
     * @param TarjetaCreditoId Id Identificador de la instancia de Author
     * @return
     * @generated
     */
    public UsuarioEntity getUsuario(Long TarjetaCreditoId) {
       UsuarioEntity usuario = getTarjetaCredito(TarjetaCreditoId).getUsuario();
        if (usuario!=null) {
            return usuario;
        }
        return null;
    }
    
    /**
     * Obtiene una instancia de PagoEntity asociada a una instancia de TarjetaCredito
     *
     * @param tarjetaId Identificador de la instancia de Usuario
     * @param pagosId Identificador de la instancia de Pago
     * @return El pago con id dado
     * 
     */
    public PagoEntity getPago(Long tarjetaId, Long pagosId) {
        List<PagoEntity> list = getTarjetaCredito(tarjetaId).getPagos();
        PagoEntity pagosEntity = new PagoEntity();
        pagosEntity.setId(pagosId);
        int index = list.indexOf(pagosEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }
    
    /**
     * Asocia un Pago existente a una TarjetaCredito
     *
     * @param tarjetaId Identificador de la instancia de TarjetaCredito
     * @param pagosId Identificador de la instancia de Pago
     * @return Instancia de PagoEntity que fue asociada a TarjetaCredito
     * 
     */
    public PagoEntity addPago(Long tarjetaId, Long pagosId) {
        TarjetaCreditoEntity tarjetaCreditoEntity = getTarjetaCredito(tarjetaId);
        PagoEntity pagosEntity = new PagoEntity();
        pagosEntity.setId(pagosId);
        tarjetaCreditoEntity.getPagos().add(pagosEntity);
        return getPago(tarjetaId, pagosId);
    }
    
    /**
     * Remplaza las instancias de Pago asociadas a una instancia de TarjetaCredito
     *
     * @param tarjetaId Identificador de la instancia de TarjetaCredito
     * @param list Colección de instancias de PagoEntity a asociar a instancia
     * de TarjetaCredito
     * @return Nueva colección de PagoEntity asociada a la instancia de TarjetaCredito
     * 
     */
    public List<PagoEntity> replacePago(Long tarjetaId, List<PagoEntity> list) {
        TarjetaCreditoEntity tarjetaCreditoEntity = getTarjetaCredito(tarjetaId);
        tarjetaCreditoEntity.setPagos(list);
        return tarjetaCreditoEntity.getPagos();
    }
    
    /**
     * Desasocia un Pago existente de una TarjetaCredito existente
     *
     * @param tarjetaId Identificador de la instancia de TarjetaCredito
     * @param pagosId Identificador de la instancia de Pago
     * 
     */
    public void removePago(Long tarjetaId, Long pagosId) {
        TarjetaCreditoEntity entity = getTarjetaCredito(tarjetaId);
        PagoEntity pagosEntity = new PagoEntity();
        pagosEntity.setId(pagosId);
        entity.getPagos().remove(pagosEntity);
    }
    
    /**
     * Obtiene una instancia de PagoEntity asociada a una instancia de TarjetaCredito
     *
     * @param tarjetaCreditoId Id Identificador de la instancia de TarjetaCredito
     * @return
     * @generated
     */
    public List<PagoEntity> getPagos(Long tarjetaCreditoId) {
       List<PagoEntity> pagos = getTarjetaCredito(tarjetaCreditoId).getPagos();
        if (pagos != null) {
            return pagos;
        }
        return null;
    }    
}
