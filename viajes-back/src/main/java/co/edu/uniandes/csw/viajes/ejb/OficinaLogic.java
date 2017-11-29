/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.OficinaEntity;
import co.edu.uniandes.csw.viajes.persistence.OficinaPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author m.rodriguez21
 */
public class OficinaLogic {

    /**
     * Variable para acceder a la persistencia de la aplicación. Es una
     * inyección de dependencias.
     */
    @Inject
    private OficinaPersistence persistence;

    /**
     * Crear una nueva oficina
     *
     * @param entity Oficina que se quiere crear
     * @return La oficina creada
     */
    public OficinaEntity createOficina(OficinaEntity entity) {
        persistence.create(entity);
        return entity;
    }

    /**
     *
     * Obtener todas las oficinas existentes en la base de datos.
     *
     * @return una lista de oficinas.
     */
    public List<OficinaEntity> getOficinas() {
        List<OficinaEntity> oficinas = persistence.findAll();
        return oficinas;
    }

    /**
     *
     * Obtener una oficina por medio de su id.
     *
     * @param id: id de la oficina para ser buscada.
     * @return la oficina solicitada por medio de su id.
     */
    public OficinaEntity getOficina(Long id) {
        OficinaEntity oficina = persistence.find(id);
        return oficina;
    }

    /**
     *
     * Actualizar una oficina.
     *
     *
     * @param entity: oficina con los cambios para ser actualizada, por ejemplo
     * el nombre.
     * @return la oficina con los cambios actualizados en la base de datos.
     */
    public OficinaEntity updateOficina(OficinaEntity entity) {
        OficinaEntity newEntity = persistence.update(entity);
        return newEntity;
    }

    /**
     * Borrar una oficina
     *
     * @param id: id de la oficina a borrar
     */
    public void deleteOficina(Long id) {
        persistence.delete(id);
    }
}
