
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;
import co.edu.uniandes.csw.viajes.persistence.UbicacionPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ma.forero11
 */
@Stateless
public class UbicacionLogic {
    
    private static final Logger LOGGER = Logger.getLogger(HospedajeLogic.class.getName());
    
    @Inject
    private UbicacionPersistence persistence;
    
    /**
     * Obtiene la lista de los registros de Ubicacion.
     *
     * @return Colección de objetos de Ubicacion.
     */
    public List<UbicacionEntity> getUbicaciones() {
         return persistence.findAll();
     }
    
    /**
     * Obtiene los datos de una instancia de Ubicación a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de UbicacionEntity con los datos de la ubicación consultada.
     */
    public UbicacionEntity getUbicacion(Long id) {
        return persistence.find(id);
    }
    
    /**
     * Se encarga de crear una ubicación en la base de datos.
     *
     * @param entity Objeto de UbicacionEntity con los datos nuevos
     * @return Objeto de UbicacionEntity con los datos nuevos y su ID.
     */
    public UbicacionEntity createUbicacion(UbicacionEntity entity) {
        LOGGER.info("Inicia proceso de creación de ubicación");
        // Invoca la persistencia para crear la ubicación
         persistence.create(entity);
        LOGGER.info("Termina proceso de creación de ibicación");
         return entity;
     }
    
    /**
     * Actualiza la información de una instancia de Ubicacion.
     *
     * @param entity Instancia de UbicacionEntity con los nuevos datos.
     * @return Instancia de UbicacionEntity con los datos actualizados.
     */
    public UbicacionEntity updateUbicacion(UbicacionEntity entity) {
         return persistence.update(entity);
     }
 
    /**
     * Elimina una instancia de Ubicación de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
     public void deleteUbicacion(Long id) {
         persistence.delete(id);
     }
    
}