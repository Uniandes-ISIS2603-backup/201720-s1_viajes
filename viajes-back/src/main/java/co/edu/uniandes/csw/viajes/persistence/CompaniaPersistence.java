/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.CompaniaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jc.sanchez12
 */
@Stateless
public class CompaniaPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(CompaniaPersistence.class.getName());
    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
 
    
    public CompaniaEntity create(CompaniaEntity entity) {
        LOGGER.info("Creando una compañia nueva");
        em.persist(entity);
        LOGGER.info("Se creo una compañia nueva");
        return entity;
    }
    
    public CompaniaEntity findByName(String name)
    {
        LOGGER.log(Level.INFO, "Consultando compañia  por nombre ", name);
        TypedQuery<CompaniaEntity> query = em.createQuery("select u from CompaniaEntity u where u.name = :name", CompaniaEntity.class);
        query = query.setParameter("name", name);
        List<CompaniaEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
    
    public List<CompaniaEntity> findAll() {
        LOGGER.info("Consultando todas las compañias");
        TypedQuery query = em.createQuery("select u from CompaniaEntity u", CompaniaEntity.class);
        return query.getResultList();
    }
    
    public CompaniaEntity findById(Long id) {
        LOGGER.log(Level.INFO, "Consultando compañia ", id);
        return em.find(CompaniaEntity.class, id);
    }
    
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando compañina con id={0}", id);
        CompaniaEntity entity = em.find(CompaniaEntity.class, id);
        em.remove(entity);
    }
    
    public CompaniaEntity update(CompaniaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando compañia con id={0}", entity.getId());
        return em.merge(entity);
    }
    
}
