
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
    
    /**
     *
     * @param entity objeto imagen que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ImagenEntity create(ImagenEntity entity){
        LOGGER.info("Creando una imagen nueva");
        em.persist(entity);
        LOGGER.info("Creando una imagen nueva");
        return entity;
       
    }
    
    /**
     *
     * @param entity objeto imagen que se cambiara en la base de datos
     * @return devuelve la entidad cambiada.
     */
    public ImagenEntity update(ImagenEntity entity){
        LOGGER.log(Level.INFO, "Actualizando imagen con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    /**
     *
     * @param id objeto imagen que se borrara de la base de datos
     */
    public void delete(Long id){
        LOGGER.log(Level.INFO, "Borrando imagen con id={0}", id);
        ImagenEntity entity = em.find(ImagenEntity.class, id);
        em.remove(entity);
    }
    
    /**
     * Busca si hay alguna imagen con el id que se envía de argumento
     *
     * @param id: id de la imagen que se está buscando
     * @return null si no existe ninguna imagen con el id del argumento. Si
     * existe alguna devuelve la primera.
     */
    public ImagenEntity find(Long id){
        LOGGER.log(Level.INFO, "Consultando imagen con id={0}", id);
        
        return em.find(ImagenEntity.class, id);
    }
    
    /**
     *
     * @return devuelve las imagenes en la base de datos.
     */
    public List<ImagenEntity> findAll() {
        LOGGER.info("Consultando todas las imagenes");
        TypedQuery query = em.createQuery("select u from ImagenEntity u", ImagenEntity.class);
     
        return query.getResultList();
    }
    
}
