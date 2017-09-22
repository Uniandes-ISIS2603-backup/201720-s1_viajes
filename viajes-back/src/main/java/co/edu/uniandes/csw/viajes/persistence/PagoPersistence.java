/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.PagoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author tv.huertas10
 */
@Stateless
public class PagoPersistence 
{
    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
     
     public PagoEntity create(PagoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public List<PagoEntity> findAll() {
        TypedQuery query = em.createQuery("select u from PagoEntity u", PagoEntity.class);
        return query.getResultList();
    }
        
    public PagoEntity findById(Long id) {
        return em.find(PagoEntity.class, id);
    }
    
    public PagoEntity findByName(String nombre)
    {
        TypedQuery<PagoEntity> query = em.createQuery("select u from PagoEntity u where u.nombre = :nombre", PagoEntity.class);
        query = query.setParameter("nombre", nombre);
        List<PagoEntity> listName = query.getResultList();
        if (listName.isEmpty()) {
            return null;
        } else {
            return listName.get(0);
        }
    }
    
    public void delete(Long id) {
        PagoEntity entity = em.find(PagoEntity.class, id);
        em.remove(entity);
    }
    
     public PagoEntity update(PagoEntity entity) {
        return em.merge(entity);
    }     
}