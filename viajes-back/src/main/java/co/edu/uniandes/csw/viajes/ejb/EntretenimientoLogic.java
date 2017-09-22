/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
import co.edu.uniandes.csw.viajes.persistence.EntretenimientoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author m.rodriguez21
 */
public class EntretenimientoLogic {
    
    private static final Logger LOGGER = Logger.getLogger(EntretenimientoLogic.class.getName());

    @Inject
    private EntretenimientoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     */
    public EntretenimientoEntity createEntretenimiento(EntretenimientoEntity entity) {
        LOGGER.info("Inicia proceso de creación de entretenimiento");
        // Invoca la persistencia para crear la entretenimiento
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de entretenimiento");
        return entity;
    }

    /**
     * 
     * Obtener todas las entretenimientoes existentes en la base de datos.
     *
     * @return una lista de entretenimientoes.
     */
    public List<EntretenimientoEntity> getEntretenimientos() {
        LOGGER.info("Inicia proceso de consultar todas las entretenimientoes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<EntretenimientoEntity> entretenimientos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las entretenimientoes");
        return entretenimientos;
    }

    /**
     *
     * Obtener una entretenimiento por medio de su id.
     * 
     * @param id: id de la entretenimiento para ser buscada.
     * @return la entretenimiento solicitada por medio de su id.
     */
    public EntretenimientoEntity getEntretenimiento(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar entretenimiento con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        EntretenimientoEntity entretenimiento = persistence.find(id);
        if (entretenimiento == null) {
            LOGGER.log(Level.SEVERE, "La entretenimiento con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar entretenimiento con id={0}", id);
        return entretenimiento;
    }

    /**
     *
     * Actualizar una entretenimiento.
     *
     * @param id: id de la entretenimiento para buscarla en la base de datos.
     * @param entity: entretenimiento con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return la entretenimiento con los cambios actualizados en la base de datos.
     */
    public EntretenimientoEntity updateEntretenimiento(Long id, EntretenimientoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar entretenimiento con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        EntretenimientoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar entretenimiento con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un entretenimiento
     *
     * @param id: id de la entretenimiento a borrar
     */
    public void deleteEntretenimiento(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar entretenimiento con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar entretenimiento con id={0}", id);
    }
    
}
