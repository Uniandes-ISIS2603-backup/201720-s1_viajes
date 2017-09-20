/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
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
public class HospedajePersistence {
    
     private static final Logger LOGGER = Logger.getLogger(HospedajePersistence.class.getName());
     
     @PersistenceContext(unitName = "viajesPU")
      protected EntityManager em;
     
     public HospedajeEntity create(HospedajeEntity entity){
         LOGGER.info("Creando un hospedaje nuevo");
         em.persist(entity);
         LOGGER.info("Nuevo hospedaje creado");
         return entity;
        
    }
   
    public HospedajeEntity update(HospedajeEntity entity){
        LOGGER.log(Level.INFO, "Actualizando hospedaje");
        return em.merge(entity);
    }
    
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando hospedaje con id ", id);
        HospedajeEntity entity = em.find(HospedajeEntity.class, id);
        em.remove(entity);
    }
   
    public HospedajeEntity find(Long id){
       LOGGER.log(Level.INFO, "Consultando hospedaje con id ", id);
        
        return em.find(HospedajeEntity.class, id);
    }
    
    public List<HospedajeEntity> findAll() {
         LOGGER.info("Consultando todos los hospedajes");
         TypedQuery query = em.createQuery("select u from HospedajeEntity u", HospedajeEntity.class);
      
         return query.getResultList();
     }
}
