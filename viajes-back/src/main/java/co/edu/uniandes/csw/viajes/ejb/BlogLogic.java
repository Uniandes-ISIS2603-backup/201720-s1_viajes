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
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author m.rodriguez21
 */
@Stateless
public class BlogLogic {

    /**
     * Variable para acceder a la persistencia de la aplicación. 
     * Es una inyección de dependencias.
     */
    @Inject
    private BlogPersistence persistence; 

    /**
     * Crear un nuevo Blog.
     * @param entity
     * @return El blog
     */
    public BlogEntity createBlog(BlogEntity entity) {
        persistence.create(entity);
        return entity;
    }

    /**
     * Obtener todos los blogs existentes en la base de datos.
     * @return una lista de blogs.
     */
    public List<BlogEntity> getBlogs() {
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        return persistence.findAll();
    }

    /**
     * Obtener un Blog por medio de su id.
     * @param id: Id del blog para ser buscado.
     * @return El blog solicitado por medio de su id.
     */
    public BlogEntity getBlog(Long id) {
        BlogEntity blog = persistence.find(id);
        if (blog != null) {
                return blog;
        }
        return null;
    }

    /**
     * Actualizar un Blog.
     * @param id: id del blog para buscarlo en la base de datos.
     * @param entity: blog con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return el blog con los cambios actualizados en la base de datos.
     */
    public BlogEntity updateBlog(BlogEntity entity) {
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        return persistence.update(entity);
    }

    /**
     * Borrar un Blog
     * @param id: id del blog a borrar
     */
    public void deleteBlog(Long id) {
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
    }

    /**
     * Obtiene una colección de instancias de ImagenEntity asociadas a una
     * instancia de Blog
     * @param blogId Identificador de la instancia de Blog
     * @return Colección de instancias de ImagenEntity asociadas a la instancia
     * de Blog
     */
    public List<ImagenEntity> listImagenes(Long blogId) {
        return getBlog(blogId).getImagenes();
    }

    /**
     * Obtiene una instancia de ImagenEntity asociada a una instancia de Blog
     * @param blogId Identificador de la instancia de Blog
     * @param imagenesId Identificador de la instancia de Imagen
     * @return La imagen con id dado
     */
    public ImagenEntity getImagen(Long blogId, Long imagenesId) {
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
     * @param blogId Identificador de la instancia de Blog
     * @param imagenesId Identificador de la instancia de Imagen
     * @return Instancia de ImagenEntity que fue asociada a Blog
     */
    public ImagenEntity addImagen(Long blogId, Long imagenesId) {
        BlogEntity blogEntity = getBlog(blogId);
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        blogEntity.getImagenes().add(imagenesEntity);
        return getImagen(blogId, imagenesId);
    }

    /**
     * Remplaza las instancias de Imagen asociadas a una instancia de Blog
     * @param blogId Identificador de la instancia de Blog
     * @param list Colección de instancias de ImagenEntity a asociar a instancia
     * de Blog
     * @return Nueva colección de ImagenEntity asociada a la instancia de Blog
     */
    public List<ImagenEntity> replaceImagenes(Long blogId, List<ImagenEntity> list) {
        BlogEntity blogEntity = getBlog(blogId);
        blogEntity.setImagenes(list);
        return blogEntity.getImagenes();
    }

    /**
     * Desasocia un Imagen existente de un Blog existente
     * @param blogId Identificador de la instancia de Blog
     * @param imagenesId Identificador de la instancia de Imagen
     */
    public void removeImagen(Long blogId, Long imagenesId) {
        BlogEntity entity = getBlog(blogId);
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        entity.getImagenes().remove(imagenesEntity);
    }
}