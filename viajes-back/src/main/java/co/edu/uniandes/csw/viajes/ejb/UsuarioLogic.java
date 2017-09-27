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
     * Acceso a la aplicación
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
     *
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
     * @param UsuarioId Id Identificador de la instancia de Author
     * @return
     * @generated
     */
    public List<TarjetaCreditoEntity> getTarjetaCredito(Long UsuarioId) {
       List<TarjetaCreditoEntity> tarjeta = getUsuario(UsuarioId).getTarjetas();
        if (tarjeta!=null) {
            return tarjeta;
        }
        return null;
    } 
    
    /**
     * Obtiene una instancia de ItinerarioEntity asociada a una instancia de Usuario
     *
     * @param UsuarioId Id Identificador de la instancia de Author
     * @return
     * @generated
     */
    public List<ItinerarioEntity> getItinerario(Long UsuarioId) {
       List<ItinerarioEntity> itinerario = getUsuario(UsuarioId).getItinerarios();
        if (itinerario!=null) {
            return itinerario;
        }
        return null;
    } 
}
