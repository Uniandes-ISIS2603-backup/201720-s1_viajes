/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
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
public class EntretenimientoPersistence {
    
    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto entretenimiento que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public EntretenimientoEntity create(EntretenimientoEntity entity) {
        em.persist(entity);
        return entity;
    }

    /**
     * Actualiza un entretenimiento.
     *
     * @param entity: el entretenimiento que viene con los nuevos cambios. 
     * @return un entretenimiento con los cambios aplicados.
     */
    public EntretenimientoEntity update(EntretenimientoEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un entretenimiento de la base de datos recibiendo como argumento el id
     * de la entretenimiento
     *
     * @param id: id correspondiente a la entretenimiento a borrar.
     */
    public void delete(Long id) { 
        EntretenimientoEntity entity = em.find(EntretenimientoEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun entretenimiento con el id que se envía de argumento
     *
     * @param id: id correspondiente a la entretenimiento buscada.
     * @return un entretenimiento.
     */
    public EntretenimientoEntity find(Long id) {
        return em.find(EntretenimientoEntity.class, id);
    }

    /**
     * Devuelve todas las entretenimientoes de la base de datos.
     *
     * @return una lista con todas las entretenimientos que encuentre en la base de
     * datos, "select u from entretenimientoEntity u" es como un "select * from
     * entretenimientoEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<EntretenimientoEntity> findAll() {
        
        // Se crea un query para buscar todas las entretenimientos en la base de datos.
        TypedQuery query = em.createQuery("select u from EntretenimientoEntity u", EntretenimientoEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de entretenimientoes.
        return query.getResultList();
    }
}