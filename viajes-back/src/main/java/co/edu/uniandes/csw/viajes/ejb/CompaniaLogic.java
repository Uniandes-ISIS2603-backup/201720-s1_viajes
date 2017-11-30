/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.CompaniaEntity;
import co.edu.uniandes.csw.viajes.persistence.CompaniaPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Juan
 */
public class CompaniaLogic {

    /**
     * Variable para acceder a la persistencia de la aplicación. Es una
     * inyección de dependencias.
     */
    @Inject
    private CompaniaPersistence persistence;

    /**
     * Obtiene la lista de los registros de Compania.
     *
     * @return Colección de objetos de CompaniaEntity.
     */
    public List<CompaniaEntity> getCompanias() {
        
        return persistence.findAll();
    }

    /**
     * Obtiene los datos de una instancia de Compania a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CompaniaEntity con los datos del compania
     * consultado.
     */
    public CompaniaEntity getCompania(Long id) {
        
        return persistence.findById(id);
    }

    /**
     * Se encarga de crear una Compania en la base de datos.
     *
     * @param entity Objeto de CompaniaEntity con los datos nuevos
     * @return Objeto de CompaniaEntity con los datos nuevos y su ID.
     */
    public CompaniaEntity createCompania(CompaniaEntity entity) {
        
        return persistence.create(entity);
    }

    /**
     * Actualiza la información de una instancia de Compania.
     *
     * @param entity Instancia de CompaniaEntity con los nuevos datos.
     * @return Instancia de CompaniaEntity con los datos actualizados.
     */
    public CompaniaEntity updateCompania(CompaniaEntity entity) {
        
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Compania de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteCompania(Long id) {
        
        persistence.delete(id);
    }
}
