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
    
     
     @PersistenceContext(unitName = "viajesPU")
      protected EntityManager em;
     
     /**
     *
     * @param entity objeto Hospedaje que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
     public HospedajeEntity create(HospedajeEntity entity){
         em.persist(entity);
         return entity;
        
    }
   
     /**
     * Actualiza un Hospedaje.
     *
     * @param entity: el Hospedaje que viene con los nuevos cambios. 
     * @return un Hospedaje con los cambios aplicados.
     */
    public HospedajeEntity update(HospedajeEntity entity){
        return em.merge(entity);
    }
    
    /**
     *
     * Borra un Hospedaje de la base de datos recibiendo como argumento el id
     * del Hospedaje
     *
     * @param id: id correspondiente al Hospedaje a borrar.
     */
    public void delete(Long id){
        HospedajeEntity entity = em.find(HospedajeEntity.class, id);
        em.remove(entity);
    }
   
    /**
     * Busca si hay algún Hospedaje con el id que se envía de argumento
     *
     * @param id: id correspondiente al Hospedaje buscado.
     * @return un Hospedaje.
     */
    public HospedajeEntity find(Long id){       
        return em.find(HospedajeEntity.class, id);
    }
    
    /**
     * Devuelve todos los Hospedajes de la base de datos.
     *
     * @return una lista con todos los Hospedajes que encuentre en la base de
     * datos
     */
    public List<HospedajeEntity> findAll() {
         TypedQuery query = em.createQuery("select u from HospedajeEntity u", HospedajeEntity.class);
      
         return query.getResultList();
     }
}
