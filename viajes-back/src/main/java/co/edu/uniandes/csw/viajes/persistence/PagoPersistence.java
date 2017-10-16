/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.PagoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author tv.huertas10
 */
@Stateless
public class PagoPersistence 
{
    /**
     * Conexión a la base de datos
     */
    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
     
    /**
     * Crea un nuevo pago
     * @param entity Pago
     * @return pago
     */
     public PagoEntity create(PagoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    /**
     * Lista con todos los pagos
     * @return pagos
     */
    public List<PagoEntity> findAll() {
        TypedQuery query = em.createQuery("select u from PagoEntity u", PagoEntity.class);
        return query.getResultList();
    }
      
    /**
     * Se busca el pago por Id
     * @param id Id del pago
     * @return pago
     */
    public PagoEntity findById(Long id) {
        return em.find(PagoEntity.class, id);
    }
    
    /**
     * Se busca al pago por el nombre del usuario
     * @param nombre Nombre del usuario
     * @return pago
     */
    public PagoEntity findByName(String nombre)
    {
        TypedQuery<PagoEntity> query = em.createQuery("select u from PagoEntity u where u.nombre = :nombre", PagoEntity.class);
        query = query.setParameter("nombre", nombre);
        List<PagoEntity> listName = query.getResultList();
        return listName.get(0);        
    }
    
    /**
     * Se elimina el pago con el id dado
     * @param id Id del pago a eliminar
     */
    public void delete(Long id) {
        PagoEntity entity = em.find(PagoEntity.class, id);
        em.remove(entity);
    }
    
    /**
     * Se actualiza el pago
     * @param entity Pago
     * @return pago
     */
     public PagoEntity update(PagoEntity entity) {
        return em.merge(entity);
    }     
}