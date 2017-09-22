<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.BlogDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.BlogLogic;
import co.edu.uniandes.csw.viajes.entities.BlogEntity;
import co.edu.uniandes.csw.viajes.persistence.BlogPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author m.rodriguez21
 */
@Path("blogs")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class BlogResource {
    
    @Inject
    BlogLogic blogLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(BlogPersistence.class.getName());

    /**
     * POST http://localhost:8080/viajesp-web/api/blogs Ejemplo
     * json: { "name":"Norma" }
     *
     * @param blog correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "blogDetailDTO", "id": 1, "name": "Norma" }
     */
    @POST
    public BlogDetailDTO createBlog(BlogDetailDTO blog)  {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        BlogEntity blogEntity = blog.toEntity();
        // Invoca la lógica para crear la blog nueva
        BlogEntity nuevoBlog = blogLogic.createBlog(blogEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new BlogDetailDTO(nuevoBlog);
    }

    /**
     * GET para todas las bloges.
     * http://localhost:8080/viajes-web/api/blogs
     *
     * @return la lista de todas las bloges en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<BlogDetailDTO> getBlogs(){
        return listEntity2DetailDTO(blogLogic.getBlogs());
    }

    /**
     * GET para una blog
     * http://localhost:8080/viajesp-web/api/blogs/1
     *
     * @param id corresponde al id de la blog buscada.
     * @return La blog encontrada. Ejemplo: { "type": "blogDetailDTO",
     * "id": 1, "name": "Norma" }
     * En caso de no existir el id de la blog buscada se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public BlogDetailDTO getBlog(@PathParam("id") Long id){
        BlogEntity entity = blogLogic.getBlog(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /blogs/" + id + " no existe.", 404);
        }
        return new BlogDetailDTO(blogLogic.getBlog(id));
    }

    /**
     * PUT http://localhost:8080/viajesp-web/api/blogs/1 Ejemplo
     * json { "id": 1, "name": "cambio de nombre" }
     *
     * @param id corresponde a la blog a actualizar.
     * @param blog corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La blog actualizada.
     * En caso de no existir el id de la blog a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public BlogDetailDTO updateBlog(@PathParam("id") Long id, BlogDetailDTO blog)  {
        blog.setId(id);
        BlogEntity entity = blogLogic.getBlog(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /blogs/" + id + " no existe.", 404);
        }
        return new BlogDetailDTO(blogLogic.updateBlog(id, blog.toEntity()));
    }

    /**
     * DELETE http://localhost:8080/viajesp-web/api/blogs/1
     *
     * @param id corresponde a la blog a borrar.
     * En caso de no existir el id de la blog a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBlog(@PathParam("id") Long id)  {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una blog con id {0}", id);
        BlogEntity entity = blogLogic.getBlog(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /blogs/" + id + " no existe.", 404);
        }
        blogLogic.deleteBlog(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos BlogEntity a una lista de
     * objetos BlogDetailDTO (json)
     *
     * @param entityList corresponde a la lista de bloges de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de bloges en forma DTO (json)
     */
    private List<BlogDetailDTO> listEntity2DetailDTO(List<BlogEntity> entityList) {
        List<BlogDetailDTO> list = new ArrayList<>();
        for (BlogEntity entity : entityList) {
            list.add(new BlogDetailDTO(entity));
        }
        return list;
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.BlogDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.BlogLogic;
import co.edu.uniandes.csw.viajes.entities.BlogEntity;
import co.edu.uniandes.csw.viajes.persistence.BlogPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author m.rodriguez21
 */
@Path("blogs")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class BlogResource {
    
    @Inject
    BlogLogic blogLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(BlogPersistence.class.getName());

    /**
     * POST http://localhost:8080/viajesp-web/api/blogs Ejemplo
     * json: { "name":"Norma" }
     *
     * @param blog correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "blogDetailDTO", "id": 1, "name": "Norma" }
     */
    @POST
    public BlogDetailDTO createBlog(BlogDetailDTO blog)  {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        BlogEntity blogEntity = blog.toEntity();
        // Invoca la lógica para crear la blog nueva
        BlogEntity nuevoBlog = blogLogic.createBlog(blogEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new BlogDetailDTO(nuevoBlog);
    }

    /**
     * GET para todas las bloges.
     * http://localhost:8080/viajes-web/api/blogs
     *
     * @return la lista de todas las bloges en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<BlogDetailDTO> getBlogs(){
        return listEntity2DetailDTO(blogLogic.getBlogs());
    }

    /**
     * GET para una blog
     * http://localhost:8080/viajesp-web/api/blogs/1
     *
     * @param id corresponde al id de la blog buscada.
     * @return La blog encontrada. Ejemplo: { "type": "blogDetailDTO",
     * "id": 1, "name": "Norma" }
     * En caso de no existir el id de la blog buscada se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public BlogDetailDTO getBlog(@PathParam("id") Long id){
        BlogEntity entity = blogLogic.getBlog(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /blogs/" + id + " no existe.", 404);
        }
        return new BlogDetailDTO(blogLogic.getBlog(id));
    }

    /**
     * PUT http://localhost:8080/viajesp-web/api/blogs/1 Ejemplo
     * json { "id": 1, "name": "cambio de nombre" }
     *
     * @param id corresponde a la blog a actualizar.
     * @param blog corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La blog actualizada.
     * En caso de no existir el id de la blog a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public BlogDetailDTO updateBlog(@PathParam("id") Long id, BlogDetailDTO blog)  {
        blog.setId(id);
        BlogEntity entity = blogLogic.getBlog(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /blogs/" + id + " no existe.", 404);
        }
        return new BlogDetailDTO(blogLogic.updateBlog(id, blog.toEntity()));
    }

    /**
     * DELETE http://localhost:8080/viajesp-web/api/blogs/1
     *
     * @param id corresponde a la blog a borrar.
     * En caso de no existir el id de la blog a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBlog(@PathParam("id") Long id)  {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una blog con id {0}", id);
        BlogEntity entity = blogLogic.getBlog(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /blogs/" + id + " no existe.", 404);
        }
        blogLogic.deleteBlog(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos BlogEntity a una lista de
     * objetos BlogDetailDTO (json)
     *
     * @param entityList corresponde a la lista de bloges de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de bloges en forma DTO (json)
     */
    private List<BlogDetailDTO> listEntity2DetailDTO(List<BlogEntity> entityList) {
        List<BlogDetailDTO> list = new ArrayList<>();
        for (BlogEntity entity : entityList) {
            list.add(new BlogDetailDTO(entity));
        }
        return list;
    }
    
}
>>>>>>> js.beltran14
