/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author sa.silva1
 */
@Stateless
public class TransportePersistence {
    
      @PersistenceContext(unitName = "viajesPU")
      protected EntityManager em;
      
      public TransporteEntity find(Long id) {
        return em.find(TransporteEntity.class, id);
    }


    public List<TransporteEntity> findAll() {
        Query q = em.createQuery("select u from TransporteEntity u");
        return q.getResultList();
    }

    public TransporteEntity create(TransporteEntity entity) {
        em.persist(entity);
        return entity;
    }

    public TransporteEntity update(TransporteEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        TransporteEntity entity = em.find(TransporteEntity.class, id);
        em.remove(entity);
    }
}
