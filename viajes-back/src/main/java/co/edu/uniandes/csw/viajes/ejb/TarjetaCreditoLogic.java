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
     * Obtiene una instancia de PagoEntity asociada a una instancia de TarjetaCredito
     *
     * @param TarjetaCreditoId Id Identificador de la instancia de Author
     * @return
     * @generated
     */
    public List<PagoEntity> getPagos(Long TarjetaCreditoId) {
       List<PagoEntity> pago = getTarjetaCredito(TarjetaCreditoId).getPagos();
        if (pago!=null) {
            return pago;
        }
        return null;
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
     * Obtiene una instancia de PagoEntity asociada a una instancia de Usuario
     *
     * @param usuarioId Identificador de la instancia de Usuario
     * @param pagosId Identificador de la instancia de Pago
     * @return El pago con id dado
     * 
     */
    public PagoEntity getPago(Long usuarioId, Long pagosId) {
        List<PagoEntity> list = getTarjetaCredito(usuarioId).getPagos();
        PagoEntity pagosEntity = new PagoEntity();
        pagosEntity.setId(pagosId);
        int index = list.indexOf(pagosEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }
    //-------------- SEGUIR DESDE AQUí
    /**
     * Asocia una TarjetaCredito existente a un Usuario
     *
     * @param usuarioId Identificador de la instancia de Usuario
     * @param tarjetasId Identificador de la instancia de TarjetaCredito
     * @return Instancia de TarjetaCreditoEntity que fue asociada a Usuario
     * 
     */
    public TarjetaCreditoEntity addTarjeta(Long usuarioId, Long tarjetasId) {
        UsuarioEntity usuarioEntity = getUsuario(usuarioId);
        TarjetaCreditoEntity tarjetasEntity = new TarjetaCreditoEntity();
        tarjetasEntity.setId(tarjetasId);
        usuarioEntity.getTarjetas().add(tarjetasEntity);
        return getTarjeta(usuarioId, tarjetasId);
    }
    
    /**
     * Remplaza las instancias de TarjetaCredito asociadas a una instancia de Usuario
     *
     * @param usuarioId Identificador de la instancia de Usuario
     * @param list Colección de instancias de TarjetaCreditoEntity a asociar a instancia
     * de Usuario
     * @return Nueva colección de TarjetaCreditoEntity asociada a la instancia de Usuario
     * 
     */
    public List<TarjetaCreditoEntity> replaceTarjetaCredito(Long usuarioId, List<TarjetaCreditoEntity> list) {
        UsuarioEntity usuarioEntity = getUsuario(usuarioId);
        usuarioEntity.setTarjetas(list);
        return usuarioEntity.getTarjetas();
    }
    
    /**
     * Desasocia un TarjetaCredito existente de un Usuario existente
     *
     * @param usuarioId Identificador de la instancia de Usuario
     * @param tarjetasId Identificador de la instancia de TarjetaCredito
     * 
     */
    public void removeTarjetaCredito(Long usuarioId, Long tarjetasId) {
        UsuarioEntity entity = getUsuario(usuarioId);
        TarjetaCreditoEntity tarjetasEntity = new TarjetaCreditoEntity();
        tarjetasEntity.setId(tarjetasId);
        entity.getTarjetas().remove(tarjetasEntity);
    }
}
