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
    
    public List<HospedajeEntity> getHospedajes() {
         return persistence.findAll();
     }
    
    public HospedajeEntity getHospedaje(Long id) {
        return persistence.find(id);
    }
    
    public HospedajeEntity createHospedaje(HospedajeEntity entity) {
         persistence.create(entity);
         return entity;
     }
    
    public HospedajeEntity updateHospedaje(HospedajeEntity entity) {
         return persistence.update(entity);
     }
 
    
     public void deleteHospedaje(Long id) {
         persistence.delete(id);
     }
    
}