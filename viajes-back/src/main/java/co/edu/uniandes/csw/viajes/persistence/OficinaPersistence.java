/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.OficinaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author m.rodriguez21
 */
@Stateless
public class OficinaPersistence {
    
    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto oficina que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public OficinaEntity create(OficinaEntity entity) {
        em.persist(entity);
        return entity;
    }

    /**
     * Actualiza un oficina.
     *
     * @param entity: el oficina que viene con los nuevos cambios. 
     * @return un oficina con los cambios aplicados.
     */
    public OficinaEntity update(OficinaEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un oficina de la base de datos recibiendo como argumento el id
     * de la oficina
     *
     * @param id: id correspondiente a la oficina a borrar.
     */
    public void delete(Long id) { 
        OficinaEntity entity = em.find(OficinaEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun oficina con el id que se envía de argumento
     *
     * @param id: id correspondiente a la oficina buscada.
     * @return un oficina.
     */
    public OficinaEntity find(Long id) {
        return em.find(OficinaEntity.class, id);
    }

    /**
     * Devuelve todas las oficinas de la base de datos.
     *
     * @return una lista con todas las oficinas que encuentre en la base de
     * datos, "select u from oficinaEntity u" es como un "select * from
     * oficinaEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<OficinaEntity> findAll() {
        
        // Se crea un query para buscar todas las oficinas en la base de datos.
        TypedQuery query = em.createQuery("select u from OficinaEntity u", OficinaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de oficinas.
        return query.getResultList();
    }
}
