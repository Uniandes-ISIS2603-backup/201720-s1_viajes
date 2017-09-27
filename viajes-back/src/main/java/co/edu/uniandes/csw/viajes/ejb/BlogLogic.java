
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.BlogEntity;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
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
     * Crear un nuevo blog.
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
     * Obtener todos los blogs existentes en la base de datos.
     *
     * @return una lista de blogs.
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
     * Obtener un blog por medio de su id.
     * 
     * @param id: id del blog para ser buscado.
     * @return el blog solicitado por medio de su id.
     */
    public BlogEntity getBlog(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar blog con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        BlogEntity blog = persistence.find(id);
        if (blog == null) {
            LOGGER.log(Level.SEVERE, "El blog con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar blog con id={0}", id);
        return blog;
    }

    /**
     *
     * Actualizar una blog.
     *
     * @param id: id del blog para buscarlo en la base de datos.
     * @param entity: blog con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return el blog con los cambios actualizados en la base de datos.
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
     * @param id: id del blog a borrar
     */
    public void deleteBlog(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar blog con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar blog con id={0}", id);
    }

    /**
     * Obtiene una colección de instancias de ImagenEntity asociadas a una
     * instancia de Blog
     *
     * @param blogId Identificador de la instancia de Blog
     * @return Colección de instancias de ImagenEntity asociadas a la instancia
     * de Blog
     * 
     */
    public List<ImagenEntity> listImagenes(Long blogId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los autores del libro con id = {0}", blogId);
        return getBlog(blogId).getImagenes();
    }

    /**
     * Obtiene una instancia de ImagenEntity asociada a una instancia de Blog
     *
     * @param blogId Identificador de la instancia de Blog
     * @param imagenesId Identificador de la instancia de Imagen
     * @return La imagen con id dado
     * 
     */
    public ImagenEntity getImagen(Long blogId, Long imagenesId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un autor del libro con id = {0}", blogId);
        List<ImagenEntity> list = getBlog(blogId).getImagenes();
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        int index = list.indexOf(imagenesEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia una Imagen existente a un Blog
     *
     * @param blogId Identificador de la instancia de Blog
     * @param imagenesId Identificador de la instancia de Imagen
     * @return Instancia de ImagenEntity que fue asociada a Blog
     * 
     */
    public ImagenEntity addImagen(Long blogId, Long imagenesId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un autor al libro con id = {0}", blogId);
        BlogEntity blogEntity = getBlog(blogId);
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        blogEntity.getImagenes().add(imagenesEntity);
        return getImagen(blogId, imagenesId);
    }

    /**
     * Remplaza las instancias de Imagen asociadas a una instancia de Blog
     *
     * @param blogId Identificador de la instancia de Blog
     * @param list Colección de instancias de ImagenEntity a asociar a instancia
     * de Blog
     * @return Nueva colección de ImagenEntity asociada a la instancia de Blog
     * 
     */
    public List<ImagenEntity> replaceImagenes(Long blogId, List<ImagenEntity> list) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar un autor del libro con id = {0}", blogId);
        BlogEntity blogEntity = getBlog(blogId);
        blogEntity.setImagenes(list);
        return blogEntity.getImagenes();
    }

    /**
     * Desasocia un Imagen existente de un Blog existente
     *
     * @param blogId Identificador de la instancia de Blog
     * @param imagenesId Identificador de la instancia de Imagen
     * 
     */
    public void removeImagen(Long blogId, Long imagenesId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor del libro con id = {0}", blogId);
        BlogEntity entity = getBlog(blogId);
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        entity.getImagenes().remove(imagenesEntity);
    }

}