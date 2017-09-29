/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
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
public class ItinerarioPersistence {
 
    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
   
    /**
     *
     * @param entity objeto itinerario que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ItinerarioEntity create(ItinerarioEntity entity){
        em.persist(entity);
        return entity;       
    }
   
    /**
     *
     * @param entity objeto itinerario que se cambiara en la base de datos
     * @return devuelve la entidad cambiada.
     */
    public ItinerarioEntity update(ItinerarioEntity entity){
        return em.merge(entity);
    }
   
    /**
     *
     * @param id del objeto itinerario que se borrara de la base de datos
     */
    public void delete(Long id){
        ItinerarioEntity entity = em.find(ItinerarioEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun itinerario con el id que se envía de argumento
     *
     * @param id: id de la imagen que se está buscando
     * @return null si no existe ninguna imagen con el id del argumento. Si
     * existe alguna devuelve la primera.
     */
    public ItinerarioEntity find(Long id){
        
        return em.find(ItinerarioEntity.class, id);
    }

    /**
     *
     * @return devuelve los itinerarios en la base de datos.
     */
    public List<ItinerarioEntity> findAll() {
        TypedQuery query = em.createQuery("select u from ItinerarioEntity u", ItinerarioEntity.class);
     
        return query.getResultList();
    }    
}
