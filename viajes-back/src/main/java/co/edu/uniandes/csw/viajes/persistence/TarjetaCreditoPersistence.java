/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
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
public class TarjetaCreditoPersistence 
{
    /**
     * Conexión a base de datos
     */
    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
     
    /**
     * Se crea la Tarjeta de crédito
     * @param entity Tarjeta 
     * @return tarjeta
     */
     public TarjetaCreditoEntity create(TarjetaCreditoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
     /**
      * Lista con todas las tarjetas
      * @return tarjetas
      */
    public List<TarjetaCreditoEntity> findAll() {
        TypedQuery query = em.createQuery("select u from TarjetaCreditoEntity u", TarjetaCreditoEntity.class);
        return query.getResultList();
    }
      
    /**
     * Se busca la tarjeta por id
     * @param id Id de la tarjeta que se va a buscar
     * @return tarjeta
     */
    public TarjetaCreditoEntity findById(Long id) {
        return em.find(TarjetaCreditoEntity.class, id);
    }
    
    /**
     * Se busca la tarjeta por número de cuenta
     * @param numero Número de la cuenta
     * @return tarjeta
     */
    public TarjetaCreditoEntity findByNumber(Integer numero)
    {
        TypedQuery<TarjetaCreditoEntity> query = em.createQuery("select u from TarjetaCreditoEntity u where u.numero = :numero", TarjetaCreditoEntity.class);
        query = query.setParameter("numero", numero);
        List<TarjetaCreditoEntity> listName = query.getResultList();
        return listName.get(0);
    }
    
    /**
     * Se elimina la tarjeta por el id
     * @param id Id de la tarjeta que se va a a eliminar
     */
    public void delete(Long id) {
        TarjetaCreditoEntity entity = em.find(TarjetaCreditoEntity.class, id);
        em.remove(entity);
    }
    
    /**
     * Se actualiza la tarjeta de crédito
     * @param entity Tarjeta de crédito que va a ser actualizada
     * @return tarjeta
     */
     public TarjetaCreditoEntity update(TarjetaCreditoEntity entity) {
        return em.merge(entity);
    }    
}