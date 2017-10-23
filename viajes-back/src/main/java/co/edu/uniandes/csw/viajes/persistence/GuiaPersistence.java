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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jc.sanchez12
 */
@Stateless
public class GuiaPersistence 
{

    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
     
     
      /**
     * Crear una  GuiaEntity
     * @param entity objeto guia que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
     public GuiaEntity create(GuiaEntity entity) {
        em.persist(entity);
        return entity;
    }
    
     /**
     * Devuelve todos los guias de la base de datos.
     *
     * @return una lista con todos los guias que encuentre en la base de
     * datos, "select u from GuiaEntity u" es como un "select * from
     * GuiaEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<GuiaEntity> findAll() {
        TypedQuery query = em.createQuery("select u from GuiaEntity u", GuiaEntity.class);
        return query.getResultList();
    }
    
    /**
     * Busca si hay algun guia con el id que se envía de argumento
     *
     * @param id: id correspondiente a la compania buscada.
     * @return una compania.
     */  
    public GuiaEntity findById(Long id) {
        return em.find(GuiaEntity.class, id);
    }
   
    
     /**
     *
     * Borra un guia de la base de datos recibiendo como argumento el id
     * de la guia
     *
     * @param id: id correspondiente a la compania a borrar.
     */
    public void delete(Long id) {
        GuiaEntity entity = em.find(GuiaEntity.class, id);
        em.remove(entity);
    }
    
    
     /**
     * Actualiza un guia.
     *
     * @param entity: el guia que viene con los nuevos cambios. Por ejemplo
     * el nombre pudo cambiar. En ese caso, se haria uso del método update.
     * @return una compania con los cambios aplicados.
     */
     public GuiaEntity update(GuiaEntity entity) {
        return em.merge(entity);
    }
     
}
