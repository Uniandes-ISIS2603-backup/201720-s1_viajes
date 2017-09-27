/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.BlogEntity;
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
public class BlogPersistence {
    
    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto blog que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public BlogEntity create(BlogEntity entity) {
        em.persist(entity);
        return entity;
    }

    /**
     * Actualiza un blog.
     *
     * @param entity: el blog que viene con los nuevos cambios. 
     * @return un blog con los cambios aplicados.
     */
    public BlogEntity update(BlogEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un blog de la base de datos recibiendo como argumento el id
     * de la blog
     *
     * @param id: id correspondiente a la blog a borrar.
     */
    public void delete(Long id) { 
        BlogEntity entity = em.find(BlogEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun blog con el id que se envía de argumento
     *
     * @param id: id correspondiente a la blog buscada.
     * @return un blog.
     */
    public BlogEntity find(Long id) {
        return em.find(BlogEntity.class, id);
    }

    /**
     * Devuelve todos los blogs de la base de datos.
     *
     * @return una lista con todas las blogs que encuentre en la base de
     * datos, "select u from blogEntity u" es como un "select * from
     * blogEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<BlogEntity> findAll() {        
        // Se crea un query para buscar todas las blogs en la base de datos.
        TypedQuery query = em.createQuery("select u from BlogEntity u", BlogEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de blogs.
        return query.getResultList();
    }

}
