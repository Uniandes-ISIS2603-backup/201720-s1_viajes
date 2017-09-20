<<<<<<< HEAD:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
=======

>>>>>>> e7910ed95c91f9262305ad2222e729cc532d5bad:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author js.beltran14
 */
@Stateless
public class ImagenPersistence {
    
     private static final Logger LOGGER = Logger.getLogger(ImagenPersistence.class.getName());

    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
    
<<<<<<< HEAD:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
=======
    /**
     *
     * @param entity objeto imagen que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
>>>>>>> e7910ed95c91f9262305ad2222e729cc532d5bad:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
    public ImagenEntity create(ImagenEntity entity){
        LOGGER.info("Creando una imagen nueva");
        em.persist(entity);
        LOGGER.info("Creando una imagen nueva");
        return entity;
       
    }
    
<<<<<<< HEAD:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
=======
    /**
     *
     * @param entity objeto imagen que se cambiara en la base de datos
     * @return devuelve la entidad cambiada.
     */
>>>>>>> e7910ed95c91f9262305ad2222e729cc532d5bad:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
    public ImagenEntity update(ImagenEntity entity){
        LOGGER.log(Level.INFO, "Actualizando imagen con id={0}", entity.getId());
        return em.merge(entity);
    }
    
<<<<<<< HEAD:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
=======
    /**
     *
     * @param id objeto imagen que se borrara de la base de datos
     */
>>>>>>> e7910ed95c91f9262305ad2222e729cc532d5bad:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando imagen con id={0}", id);
        ImagenEntity entity = em.find(ImagenEntity.class, id);
        em.remove(entity);
    }
    
<<<<<<< HEAD:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
=======
    /**
     * Busca si hay alguna imagen con el id que se envía de argumento
     *
     * @param id: id de la imagen que se está buscando
     * @return null si no existe ninguna imagen con el id del argumento. Si
     * existe alguna devuelve la primera.
     */
>>>>>>> e7910ed95c91f9262305ad2222e729cc532d5bad:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
    public ImagenEntity find(Long id){
        LOGGER.log(Level.INFO, "Consultando imagen con id={0}", id);
        
        return em.find(ImagenEntity.class, id);
    }
    
<<<<<<< HEAD:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
=======
    /**
     *
     * @return devuelve las imagenes en la base de datos.
     */
>>>>>>> e7910ed95c91f9262305ad2222e729cc532d5bad:viajes-back/src/main/java/co/edu/uniandes/csw/viajes/persistence/ImagenPersistence.java
    public List<ImagenEntity> findAll() {
        LOGGER.info("Consultando todas las imagenes");
        TypedQuery query = em.createQuery("select u from ImagenEntity u", ImagenEntity.class);
     
        return query.getResultList();
    }
    
}
