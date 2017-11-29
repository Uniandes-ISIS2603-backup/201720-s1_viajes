/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
import co.edu.uniandes.csw.viajes.persistence.GuiaPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Juan
 */
public class GuiaLogic {

    /**
     * Variable para acceder a la persistencia de la aplicación. Es una
     * inyección de dependencias.
     */
    @Inject
    private GuiaPersistence persistence;

    /**
     * Obtiene la lista de los registros de Guia.
     *
     * @return Colección de objetos de GuiaEntity.
     */
    public List<GuiaEntity> getGuias() {
        return persistence.findAll();
    }

    /**
     * Obtiene los datos de una instancia de Guia a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de GuiaEntity con los datos del Guia consultado.
     */
    public GuiaEntity getGuia(Long id) {
        return persistence.findById(id);
    }

    /**
     * Se encarga de crear un Guia en la base de datos.
     *
     * @param entity Objeto de GuiaEntity con los datos nuevos
     * @return Objeto de GuiaEntity con los datos nuevos y su ID.
     */
    public GuiaEntity createGuia(GuiaEntity entity) {
        return persistence.create(entity);
    }

    /**
     * Actualiza la información de una instancia de Guia.
     *
     * @param entity Instancia de GuiaEntity con los nuevos datos.
     * @return Instancia de GuiaEntity con los datos actualizados.
     */
    public GuiaEntity updateGuia(GuiaEntity entity) {
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Guia de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteGuia(Long id) {
        persistence.delete(id);
    }
}
