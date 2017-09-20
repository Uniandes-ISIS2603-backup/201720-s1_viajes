/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import co.edu.uniandes.csw.viajes.persistence.TransportePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author sa.silva1
 */
@Stateless
public class TransporteLogic {
    
    private static final Logger LOGGER = Logger.getLogger(TransporteLogic.class.getName());

    @Inject
    private TransportePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    
    
     /**
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
     public TransporteEntity createTransporte(TransporteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de transporte");
        // Verifica la regla de negocio que dice que no puede haber dos transportes con el mismo id
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe un Transporte con el id \"" + entity.getId() + "\"");
        }
        // Invoca la persistencia para crear el transporte
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de transporte");
        return entity;
    }

    /**
     * 
     * Obtener todos los transportes existentes en la base de datos.
     *
     * @return una lista de transportes.
     */
    public List<TransporteEntity> getTransportes() {
        LOGGER.info("Inicia proceso de consultar todos los transportes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<TransporteEntity> transportes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas los transportes");
        return transportes;
    }

    /**
     *
     * Obtener un transporte por medio de su id.
     * 
     * @param id: id del transporte para ser buscado.
     * @return el transporte solicitado por medio de su id.
     */
    public TransporteEntity getTransporte(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar transporte con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        TransporteEntity transporte = persistence.find(id);
        if (transporte == null) {
            LOGGER.log(Level.SEVERE, "El transporte con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar transporte con id={0}", id);
        return transporte;
    }

    /**
     *
     * Actualizar un transporte.
     *
     * @param id: id del transporte para buscarlo en la base de datos.
     * @param entity: transporte con los cambios para ser actualizados, por
     * ejemplo el nombre.
     * @return el transporte con los cambios actualizados en la base de datos.
     */
    public TransporteEntity updateTransporte(Long id, TransporteEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar transporte con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        TransporteEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar transporte con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un transporte
     *
     * @param id: id del transporte a borrar
     */
    public void deleteTransporte(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar transporte con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar transporte con id={0}", id);
    }
}
