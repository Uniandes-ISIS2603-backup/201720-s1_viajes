/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;
import co.edu.uniandes.csw.viajes.persistence.UbicacionPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ma.forero11
 */
@Stateless
public class UbicacionLogic {
    
    private static final Logger LOGGER = Logger.getLogger(HospedajeLogic.class.getName());
    
    @Inject
    private UbicacionPersistence persistence;
    
    public List<UbicacionEntity> getUbicaciones() {
         return persistence.findAll();
     }
    
    public UbicacionEntity getUbicacion(Long id) {
        return persistence.find(id);
    }
    
    public UbicacionEntity createUbicacion(UbicacionEntity entity) {
         persistence.create(entity);
         return entity;
     }
    
    public UbicacionEntity updateUbicacion(UbicacionEntity entity) {
         return persistence.update(entity);
     }
 
    
     public void deleteUbicacion(Long id) {
         persistence.delete(id);
     }
    
}