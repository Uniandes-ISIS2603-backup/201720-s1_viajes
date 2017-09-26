/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;


import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
import co.edu.uniandes.csw.viajes.persistence.GuiaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Juan
 */
public class GuiaLogic {

    private static final Logger LOGGER = Logger.getLogger(GuiaLogic.class.getName());
      
   @Inject
    private GuiaPersistence persistence;
   
   /*
    @Inject
    private CompaniaLogic companiaLogic;
    
     /**
     * Obtiene la lista de los registros de Guia.
     *
     * @return Colección de objetos de GuiaEntity.
     * @generated
     */
    public List<GuiaEntity> getGuias() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los guais");
        return persistence.findAll();
    }
    
    /**
     * Obtiene los datos de una instancia de Guia a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de GuiaEntity con los datos del Guia consultado.
     * @generated
     */
    public GuiaEntity getGuia(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un guia con id = {0}", id);
        return persistence.findById(id);
    }
    
    /**
     * Se encarga de crear un Guia en la base de datos.
     *
     * @param entity Objeto de GuiaEntity con los datos nuevos
     * @return Objeto de GuiaEntity con los datos nuevos y su ID.
     * @generated
     */
    public GuiaEntity createGuia(GuiaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de crear un guia ");
        return persistence.create(entity);
    }
    
    /**
     * Actualiza la información de una instancia de Guia.
     *
     * @param entity Instancia de GuiaEntity con los nuevos datos.
     * @return Instancia de GuiaEntity con los datos actualizados.
     * @generated
     */
    public GuiaEntity updateGuia(GuiaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un guia ");
        return persistence.update(entity);
    }
    
     /**
     * Elimina una instancia de Guia de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteGuia(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un guia ");
        persistence.delete(id);
    }
    

}
