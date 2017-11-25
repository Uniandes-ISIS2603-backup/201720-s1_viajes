/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import co.edu.uniandes.csw.viajes.persistence.UsuarioPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author tv.huertas10
 */
public class UsuarioLogic {

    /**
     * Variable para acceder a la persistencia de la aplicación. 
     * Es una inyección de dependencias.
     */
    @Inject
    private UsuarioPersistence persistence;
    
    /**
     * Acceso a la aplicación de tarjeta
     */
    @Inject
    private TarjetaCreditoLogic tarjetaLogic;
    
    /**
     * Acceso a la palicacion de itinerario
     */
    @Inject
    private ItinerarioLogic itinerarioLogic;
    
   /**
     * Obtiene la lista de los registros de Usuario.
     *
     * @return Colección de objetos de UsuarioEntity.
     * @generated
     */
    public List<UsuarioEntity> getUsuarios() {
        return persistence.findAll();
    }
    
    /**
     * Obtiene los datos de una instancia de Usuario a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de UsuarioEntity con los datos del Usuario consultado.
     * @generated
     */
    public UsuarioEntity getUsuario(Long id) {
        return persistence.findById(id);
    }
    
    /**
     * Se encarga de crear un Usuario en la base de datos.
     *
     * @param entity Objeto de UsuarioEntity con los datos nuevos
     * @return Objeto de UsuarioEntity con los datos nuevos y su ID.
     * @generated
     */
    public UsuarioEntity createUsuario(UsuarioEntity entity) {
        return persistence.create(entity);
    }
    
    /**
     * Actualiza la información de una instancia de Usuario.
     * @param entity Instancia de UsuarioEntity con los nuevos datos.
     * @return Instancia de UsuarioEntity con los datos actualizados.
     * @generated
     */
    public UsuarioEntity updateUsuario(UsuarioEntity entity) {
        return persistence.update(entity);
    }
    
     /**
     * Elimina una instancia de Usuario de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteUsuario(Long id) {
        persistence.delete(id);
    }
    
/**
     * Obtiene una instancia de TarjetaCreditoEntity asociada a una instancia de Usuario
     *
     * @param usuarioId Id Identificador de la instancia de Author
     * @return
     * @generated
     */
    public List<TarjetaCreditoEntity> getTarjetaCredito(Long usuarioId) {
       return getUsuario(usuarioId).getTarjetas();
    } 
    
    /**
     * Obtiene una instancia de ItinerarioEntity asociada a una instancia de Usuario
     *
     * @param UsuarioId Id Identificador de la instancia de Author
     * @return
     * @generated
     */
    public List<ItinerarioEntity> getItinerario(Long usuarioId) {
       return getUsuario(usuarioId).getItinerarios();
    } 
    
    /**
     * Obtiene una instancia de ItinerarioEntity asociada a una instancia de Usuario
     *
     * @param usuarioId Identificador de la instancia de Usuario
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @return El itinerario con id dado
     * 
     */
    public ItinerarioEntity getItinerario(Long usuarioId, Long itinerariosId) {
        List<ItinerarioEntity> list = getUsuario(usuarioId).getItinerarios();
        ItinerarioEntity itinerariosEntity = new ItinerarioEntity();
        itinerariosEntity.setId(itinerariosId);
        int index = list.indexOf(itinerariosEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }
    
    /**
     * Asocia un Itinerario existente a un Usuario
     *
     * @param usuarioId Identificador de la instancia de Usuario
     * @param itinerariosId Identificador de la instancia de Itinerario
     * @return Instancia de ItinerarioEntity que fue asociada a Usuario
     * 
     */
    public ItinerarioEntity addItinerario(Long usuarioId, Long itinerariosId) {
        UsuarioEntity usuarioEntity = getUsuario(usuarioId);
        ItinerarioEntity itinerariosEntity = new ItinerarioEntity();
        itinerariosEntity.setId(itinerariosId);
        usuarioEntity.getItinerarios().add(itinerariosEntity);
        return getItinerario(usuarioId, itinerariosId);
    }
    
    /**
     * Remplaza las instancias de Itinerario asociadas a una instancia de Usuario
     *
     * @param usuarioId Identificador de la instancia de Usuario
     * @param list Colección de instancias de ItinerarioEntity a asociar a instancia
     * de Usuario
     * @return Nueva colección de ItinerarioEntity asociada a la instancia de Usuario
     * 
     */
    public List<ItinerarioEntity> replaceItinerarios(Long usuarioId, List<ItinerarioEntity> list) {
        UsuarioEntity usuarioEntity = getUsuario(usuarioId);
        usuarioEntity.setItinerarios(list);
        return usuarioEntity.getItinerarios();
    }
    
    /**
     * Desasocia un Itinerario existente de un Usuario existente
     *
     * @param usuarioId Identificador de la instancia de Usuario
     * @param itinerariosId Identificador de la instancia de Itinerario
     * 
     */
    public void removeItinerario(Long usuarioId, Long itinerariosId) {
        UsuarioEntity entity = getUsuario(usuarioId);
        ItinerarioEntity itinerariosEntity = new ItinerarioEntity();
        itinerariosEntity.setId(itinerariosId);
        entity.getItinerarios().remove(itinerariosEntity);
    }
    
    /**
     * Obtiene una instancia de TarjetaCreditoEntity asociada a una instancia de Usuario
     *
     * @param UsuarioId Id Identificador de la instancia de Author
     * @return
     * @generated
     */
    public List<TarjetaCreditoEntity> getTarjetasCredito(Long usuarioId) {
       return getUsuario(usuarioId).getTarjetas();
    } 
    
    /**
     * Obtiene una instancia de TarjetaCreditoEntity asociada a una instancia de Usuario
     *
     * @param usuarioId Identificador de la instancia de Usuario
     * @param tarjetasId Identificador de la instancia de TarjetaCredito
     * @return La tarjeta con id dado
     * 
     */
    public TarjetaCreditoEntity getTarjeta(Long usuarioId, Long tarjetasId) {
        List<TarjetaCreditoEntity> list = getUsuario(usuarioId).getTarjetas();
        TarjetaCreditoEntity tarjetasEntity = new TarjetaCreditoEntity();
        tarjetasEntity.setId(tarjetasId);
        int index = list.indexOf(tarjetasEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }
    
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
