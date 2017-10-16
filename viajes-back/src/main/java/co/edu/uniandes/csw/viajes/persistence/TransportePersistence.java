/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase que se encarga de la persistencia de los transportes
 * @author sa.silva1
 */
@Stateless
public class TransportePersistence {
    
      @PersistenceContext(unitName = "viajesPU")
      protected EntityManager em;
      
      public TransporteEntity find(Long id) {
        return em.find(TransporteEntity.class, id);
    }


      /**
       * Retornar la lista completa de los transportes
       * @return todos los transportes registrados
       */
    public List<TransporteEntity> findAll() {
        Query q = em.createQuery("select u from TransporteEntity u");
        return q.getResultList();
    }

    /**
     * Crea y registra un transporte en el sistema
     * @param entity informacion del transporte a crear
     * @return transporte creado
     */
    public TransporteEntity create(TransporteEntity entity) {
        em.persist(entity);
        return entity;
    }

    /**
     * Actualiza la informacion de un transporte 
     * @param entity nueva infomacion de un transporte
     * @return el transporte actualizado
     */
    public TransporteEntity update(TransporteEntity entity) {
        return em.merge(entity);
    }

    /**
     * Elimina un transporte con id dado
     * @param id del transporte a eliminar
     */
    public void delete(Long id) {
        TransporteEntity entity = em.find(TransporteEntity.class, id);
        em.remove(entity);
    }
}
