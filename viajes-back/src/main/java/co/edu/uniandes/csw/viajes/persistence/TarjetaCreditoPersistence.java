/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
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
public class TarjetaCreditoPersistence 
{
    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
     
     public TarjetaCreditoEntity create(TarjetaCreditoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    public List<TarjetaCreditoEntity> findAll() {
        TypedQuery query = em.createQuery("select u from TarjetaCreditoEntity u", TarjetaCreditoEntity.class);
        return query.getResultList();
    }
        
    public TarjetaCreditoEntity findById(Long id) {
        return em.find(TarjetaCreditoEntity.class, id);
    }
    
    public TarjetaCreditoEntity findByNumber(Integer numero)
    {
        TypedQuery<TarjetaCreditoEntity> query = em.createQuery("select u from TarjetaCreditoEntity u where u.numero = :numero", TarjetaCreditoEntity.class);
        query = query.setParameter("numero", numero);
        List<TarjetaCreditoEntity> listName = query.getResultList();
        if (listName.isEmpty()) {
            return null;
        } else {
            return listName.get(0);
        }
    }
    
    public void delete(Long id) {
        TarjetaCreditoEntity entity = em.find(TarjetaCreditoEntity.class, id);
        em.remove(entity);
    }
    
     public TarjetaCreditoEntity update(TarjetaCreditoEntity entity) {
        return em.merge(entity);
    }     
  
}