/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author js.beltran14
 */
@Stateless
public class ItinerarioPersistence {
 
     private static final Logger LOGGER = Logger.getLogger(ItinerarioPersistence.class.getName());

    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
    
    public ItinerarioEntity create(ItinerarioEntity entity){
        LOGGER.info("Creando un itinerario nueva");
        em.persist(entity);
        LOGGER.info("Creando un itinerario nueva");
        return entity;
       
    }
    
    public ItinerarioEntity update(ItinerarioEntity entity){
        LOGGER.log(Level.INFO, "Actualizando itinerario con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando itinerario con id={0}", id);
        ItinerarioEntity entity = em.find(ItinerarioEntity.class, id);
        em.remove(entity);
    }
    
    public ItinerarioEntity find(Long id){
        LOGGER.log(Level.INFO, "Consultando itinerario con id={0}", id);
        
        return em.find(ItinerarioEntity.class, id);
    }
    
    public List<ItinerarioEntity> findAll() {
        LOGGER.info("Consultando todas los itinerarios");
        TypedQuery query = em.createQuery("select u from ItinerarioEntity u", ItinerarioEntity.class);
     
        return query.getResultList();
    }
    
}
