
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.BlogEntity;
import co.edu.uniandes.csw.viajes.persistence.BlogPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author m.rodriguez21
 */
@Stateless
public class BlogLogic {

    private static final Logger LOGGER = Logger.getLogger(BlogLogic.class.getName());

    @Inject
    private BlogPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     */
    public BlogEntity createBlog(BlogEntity entity) {
        LOGGER.info("Inicia proceso de creación de blog");
        // Invoca la persistencia para crear la blog
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de blog");
        return entity;
    }

    /**
     * 
     * Obtener todas las bloges existentes en la base de datos.
     *
     * @return una lista de bloges.
     */
    public List<BlogEntity> getBlogs() {
        LOGGER.info("Inicia proceso de consultar todas las bloges");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<BlogEntity> blogs = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las bloges");
        return blogs;
    }

    /**
     *
     * Obtener una blog por medio de su id.
     * 
     * @param id: id de la blog para ser buscada.
     * @return la blog solicitada por medio de su id.
     */
    public BlogEntity getBlog(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar blog con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        BlogEntity blog = persistence.find(id);
        if (blog == null) {
            LOGGER.log(Level.SEVERE, "La blog con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar blog con id={0}", id);
        return blog;
    }

    /**
     *
     * Actualizar una blog.
     *
     * @param id: id de la blog para buscarla en la base de datos.
     * @param entity: blog con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return la blog con los cambios actualizados en la base de datos.
     */
    public BlogEntity updateBlog(Long id, BlogEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar blog con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        BlogEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar blog con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un blog
     *
     * @param id: id de la blog a borrar
     */
    public void deleteBlog(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar blog con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar blog con id={0}", id);
    }
}