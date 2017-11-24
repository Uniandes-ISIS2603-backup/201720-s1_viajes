/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.OficinaEntity;
import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;
import co.edu.uniandes.csw.viajes.persistence.OficinaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author m.rodriguez21
 */
public class OficinaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(OficinaLogic.class.getName());

    /**
     * Variable para acceder a la persistencia de la aplicación. 
     * Es una inyección de dependencias.
     */
    @Inject
    private OficinaPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *Crear una nueva oficina
     * 
     * @param entity
     * @return
     */
    public OficinaEntity createOficina(OficinaEntity entity) {
        LOGGER.info("Inicia proceso de creación de oficina");
        // Invoca la persistencia para crear la oficina
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de oficina");
        return entity;
    }

    /**
     * 
     * Obtener todas las oficinas existentes en la base de datos.
     *
     * @return una lista de oficinas.
     */
    public List<OficinaEntity> getOficinas() {
        LOGGER.info("Inicia proceso de consultar todas las oficinas");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<OficinaEntity> oficinas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las oficinas");
        return oficinas;
    }

    /**
     *
     * Obtener una oficina por medio de su id.
     * 
     * @param id: id de la oficina para ser buscada.
     * @return la oficina solicitada por medio de su id.
     */
    public OficinaEntity getOficina(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar oficina con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        OficinaEntity oficina = persistence.find(id);
        if (oficina == null) {
            LOGGER.log(Level.SEVERE, "La oficina con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar oficina con id={0}", id);
        return oficina;
    }

    /**
     *
     * Actualizar una oficina.
     *
     * @param id: id de la oficina para buscarla en la base de datos.
     * @param entity: oficina con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return la oficina con los cambios actualizados en la base de datos.
     */
    public OficinaEntity updateOficina(Long id, OficinaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar oficina con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        OficinaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar oficina con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar una oficina
     *
     * @param id: id de la oficina a borrar
     */
    public void deleteOficina(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar oficina con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar oficina con id={0}", id);
    }

       
}
