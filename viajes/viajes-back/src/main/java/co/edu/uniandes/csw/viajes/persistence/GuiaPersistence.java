/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;



import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jc.sanchez12
 */
public class GuiaPersistence 
{

    private static final Logger LOGGER = Logger.getLogger(GuiaPersistence.class.getName());
     @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
     
     public GuiaEntity create(GuiaEntity entity) {
        LOGGER.info("Creando un guia nuevo");
        em.persist(entity);
        LOGGER.info("Se creo un  guia nuevo");
        return entity;
    }
    
    public List<GuiaEntity> findAll() {
        LOGGER.info("Consultando todos los guias");
        TypedQuery query = em.createQuery("select u from GuiaEntity u", GuiaEntity.class);
        return query.getResultList();
    }
        
    public GuiaEntity findById(Long id) {
        LOGGER.log(Level.INFO, "Consultando guia ", id);
        return em.find(GuiaEntity.class, id);
    }
    
    public GuiaEntity findByLenguaje(String lenguaje)
    {
        LOGGER.log(Level.INFO, "Consultando guia  por nombre ", lenguaje);
        TypedQuery<GuiaEntity> query = em.createQuery("select u from GuiaEntity u where u.lenguaje = :lenguaje", GuiaEntity.class);
        query = query.setParameter("lenguaje", lenguaje);
        List<GuiaEntity> sameLenguaje = query.getResultList();
        if (sameLenguaje.isEmpty()) {
            return null;
        } else {
            return sameLenguaje.get(0);
        }
    }
    
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando guia con id={0}", id);
        GuiaEntity entity = em.find(GuiaEntity.class, id);
        em.remove(entity);
    }
    
     public GuiaEntity update(GuiaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando guia con id={0}", entity.getId());
        return em.merge(entity);
    }
     
}
