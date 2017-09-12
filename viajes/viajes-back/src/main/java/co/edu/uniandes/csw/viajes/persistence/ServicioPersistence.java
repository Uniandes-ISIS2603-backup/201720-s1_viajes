/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.ServicioEntity;
import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sa.silva1
 */

@Stateless 
public class ServicioPersistence {
    
    @PersistenceContext(unitName = "GorrasToursPU")
    protected EntityManager em;
      
      public ServicioEntity find(Long id) {
        return em.find(ServicioEntity.class, id);
    }

      /*
    public EmployeeEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando employee con name= ", name);
        TypedQuery<EmployeeEntity> q
                = em.createQuery("select u from EmployeeEntity u where u.name = :name", EmployeeEntity.class);
        q = q.setParameter("name", name);
        return q.getSingleResult();
    }
*/

    public List<ServicioEntity> findAll() {
        Query q = em.createQuery("select u from ServicioEntity u");
        return q.getResultList();
    }

    public ServicioEntity create(ServicioEntity entity) {
        em.persist(entity);
        return entity;
    }

    public ServicioEntity update(ServicioEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        ServicioEntity entity = em.find(TransporteEntity.class, id);
        em.remove(entity);
    }
    
}
