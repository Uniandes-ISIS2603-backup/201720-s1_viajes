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
     
     public UbicacionEntity create(UbicacionEntity entity){
         LOGGER.info("Creando una ubicación nueva");
         em.persist(entity);
         LOGGER.info("Nueva ubicación creada");
         return entity;
        
    }
   
    public UbicacionEntity update(UbicacionEntity entity){
        LOGGER.log(Level.INFO, "Actualizando ubicación");
        return em.merge(entity);
    }
    
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando ubicación con id ", id);
        UbicacionEntity entity = em.find(UbicacionEntity.class, id);
        em.remove(entity);
    }
   
    public UbicacionEntity find(Long id){
       LOGGER.log(Level.INFO, "Consultando ubicación con id ", id);
        
        return em.find(UbicacionEntity.class, id);
    }
    
    public List<UbicacionEntity> findAll() {
         LOGGER.info("Consultando todas las ubicaciones");
         TypedQuery query = em.createQuery("select u from UbicacionEntity u", UbicacionEntity.class);
      
         return query.getResultList();
     }
}
