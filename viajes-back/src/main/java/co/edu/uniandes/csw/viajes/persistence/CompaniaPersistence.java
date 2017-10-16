/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.CompaniaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juan
 */
@Stateless
public class CompaniaPersistence {
 
    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;  
    
    /**
     * Crear una  CompaniaEntity
     * @param entity objeto compania que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CompaniaEntity create(CompaniaEntity entity) {
        em.persist(entity);
        return entity;
    }
       
    /**
     * Devuelve todas las companias de la base de datos.
     *
     * @return una lista con todas las companias que encuentre en la base de
     * datos, "select u from CompaniaEntity u" es como un "select * from
     * CompaniaEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<CompaniaEntity> findAll() {
        TypedQuery query = em.createQuery("select u from CompaniaEntity u", CompaniaEntity.class);
        return query.getResultList();
    }
    
    
    /**
     * Busca si hay alguna compania con el id que se envía de argumento
     *
     * @param id: id correspondiente a la compania buscada.
     * @return una compania.
     */   
    public CompaniaEntity findById(Long id) {
        return em.find(CompaniaEntity.class, id);
    }
    
     /**
     *
     * Borra una compania de la base de datos recibiendo como argumento el id
     * de la compania
     *
     * @param id: id correspondiente a la compania a borrar.
     */
    public void delete(Long id) {
        CompaniaEntity entity = em.find(CompaniaEntity.class, id);
        em.remove(entity);
    }
    
    /**
     * Actualiza una compania.
     *
     * @param entity: la compania que viene con los nuevos cambios. Por ejemplo
     * el nombre pudo cambiar. En ese caso, se haria uso del método update.
     * @return una compania con los cambios aplicados.
     */
    public CompaniaEntity update(CompaniaEntity entity) {
        return em.merge(entity);
    }
}
