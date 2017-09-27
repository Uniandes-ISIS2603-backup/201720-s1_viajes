/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 *
 * @author ma.forero11
 */
@Stateless
public class UbicacionPersistence {
    
     private static final Logger LOGGER = Logger.getLogger(UbicacionPersistence.class.getName());
     
     @PersistenceContext(unitName = "viajesPU")
      protected EntityManager em;
     
     /**
     *
     * @param entity objeto Ubicacion que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
     public UbicacionEntity create(UbicacionEntity entity){
         LOGGER.info("Creando una ubicación nueva");
         em.persist(entity);
         LOGGER.info("Nueva ubicación creada");
         return entity;
        
    }
   
     /**
     * Actualiza una Ubicacion.
     *
     * @param entity: la Ubicacion que viene con los nuevos cambios. 
     * @return una Ubicacion con los cambios aplicados.
     */
    public UbicacionEntity update(UbicacionEntity entity){
        LOGGER.log(Level.INFO, "Actualizando ubicación");
        return em.merge(entity);
    }
    
    /**
     *
     * Borra una Ubicacion de la base de datos recibiendo como argumento el id
     * de la Ubicacion
     *
     * @param id: id correspondiente a la Ubicacion a borrar.
     */
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando ubicación con id ", id);
        UbicacionEntity entity = em.find(UbicacionEntity.class, id);
        em.remove(entity);
    }
   
    /**
     * Busca si hay alguna Ubicacion con el id que se envía de argumento
     *
     * @param id: id correspondiente a la Ubicacion buscada.
     * @return una Ubicacion.
     */
    public UbicacionEntity find(Long id){
       LOGGER.log(Level.INFO, "Consultando ubicación con id ", id);
        
        return em.find(UbicacionEntity.class, id);
    }
    
    /**
     * Devuelve todas las Ubicaciones de la base de datos.
     *
     * @return una lista con todas las Ubicaciones que encuentre en la base de
     * datos
     */
    public List<UbicacionEntity> findAll() {
         LOGGER.info("Consultando todas las ubicaciones");
         TypedQuery query = em.createQuery("select u from UbicacionEntity u", UbicacionEntity.class);
      
         return query.getResultList();
     }
}
