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
    
    @Inject
    private CompaniaPersistence persistence;
    
    /**
     * Obtiene la lista de los registros de Compania.
     *
     * @return Colección de objetos de CompaniaEntity.
     * @generated
     */
    public List<CompaniaEntity> getCompanias() {
        return persistence.findAll();
    }
    
    /**
     * Obtiene los datos de una instancia de Guia a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CompaniaEntity con los datos del compania consultado.
     * @generated
     */
    public CompaniaEntity getCompania(Long id) {
        return persistence.findById(id);
    }
    
    /**
     * Se encarga de crear un compania en la base de datos.
     *
     * @param entity Objeto de CompaniaEntity con los datos nuevos
     * @return Objeto de CompaniaEntity con los datos nuevos y su ID.
     * @generated
     */
    public CompaniaEntity createCompania(CompaniaEntity entity) {
        return persistence.create(entity);
    }
    
    /**
     * Actualiza la información de una instancia de Guia.
     *
     * @param entity Instancia de CompaniaEntity con los nuevos datos.
     * @return Instancia de CompaniaEntity con los datos actualizados.
     * @generated
     */
    public CompaniaEntity updateCompania(CompaniaEntity entity) {
        return persistence.update(entity);
    }
    
     /**
     * Elimina una instancia de Guia de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteCompania(Long id) {
        persistence.delete(id);
    }   
}
