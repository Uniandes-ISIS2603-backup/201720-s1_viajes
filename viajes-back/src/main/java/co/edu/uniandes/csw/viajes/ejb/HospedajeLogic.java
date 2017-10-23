
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
import co.edu.uniandes.csw.viajes.persistence.HospedajePersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ma.forero11
 */
@Stateless
public class HospedajeLogic {
    
    private static final Logger LOGGER = Logger.getLogger(HospedajeLogic.class.getName());
    
    @Inject
    private HospedajePersistence persistence;
    
    /**
     * Obtiene la lista de los registros de Hospedajes.
     *
     * @return Colección de objetos de Hospedaje.
     */
    public List<HospedajeEntity> getHospedajes() {
         return persistence.findAll();
     }
    
    /**
     * Obtiene los datos de una instancia de Hospedaje a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de HospedajeEntity con los datos del Hospedaje consultado.
     */
    public HospedajeEntity getHospedaje(Long id) {
        return persistence.find(id);
    }
    
    /**
     * Se encarga de crear un hospedaje en la base de datos.
     *
     * @param entity Objeto de HospedajeEntity con los datos nuevos
     * @return Objeto de HospedajeEntity con los datos nuevos y su ID.
     */
    public HospedajeEntity createHospedaje(HospedajeEntity entity) {
         persistence.create(entity);
         return entity;
     }
    
    /**
     * Actualiza la información de una instancia de Hospedaje.
     *
     * @param entity Instancia de HospedajeEntity con los nuevos datos.
     * @return Instancia de HospedajeEntity con los datos actualizados.
     */
    public HospedajeEntity updateHospedaje(HospedajeEntity entity) {
         return persistence.update(entity);
     }
 
    /**
     * Elimina una instancia de Hospedaje de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
     public void deleteHospedaje(Long id) {
         persistence.delete(id);
     }
    
}