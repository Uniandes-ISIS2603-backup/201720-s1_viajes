/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
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
public class UsuarioPersistence 
{
    /**
     * Conexión a base de datos
     */
    @PersistenceContext(unitName = "viajesPU")
    protected EntityManager em;
     
    /**
     * Crea un usuario
     * @param entity Usuario
     * @return usuario
     */
     public UsuarioEntity create(UsuarioEntity entity) {
        em.persist(entity);
        return entity;
    }
    
     /**
      * Lista con todos los usuarios de la aplicacion
      * @return usuarios
      */
    public List<UsuarioEntity> findAll() {
        TypedQuery query = em.createQuery("select u from UsuarioEntity u", UsuarioEntity.class);
        return query.getResultList();
    }
      
    /**
     * Se busca ek usuario por el id
     * @param id Id del usuario
     * @return usuario
     */
    public UsuarioEntity findById(Long id) {
        return em.find(UsuarioEntity.class, id);
    }
    
    /**
     * Se busca al usuario por el nombre
     * @param nombre Nombre del usuario
     * @return usuario
     */
    public UsuarioEntity findByName(String nombre)
    {
        TypedQuery<UsuarioEntity> query = em.createQuery("select u from UsuarioEntity u where u.nombre = :nombre", UsuarioEntity.class);
        query = query.setParameter("nombre", nombre);
        List<UsuarioEntity> listName = query.getResultList();
        if (listName.isEmpty()) {
            return null;
        } else {
            return listName.get(0);
        }
    }
    
    /**
     * Se elimina el usuario correspondiente al id dado
     * @param id Id del usuario que se va a eliminar
     */
    public void delete(Long id) {
        UsuarioEntity entity = em.find(UsuarioEntity.class, id);
        em.remove(entity);
    }
    
    /**
     * Se actualizan los datos del usuario
     * @param entity usuario
     * @return usuario
     */
     public UsuarioEntity update(UsuarioEntity entity) {
        return em.merge(entity);
    }    
}