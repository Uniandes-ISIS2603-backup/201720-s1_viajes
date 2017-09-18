/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import co.edu.uniandes.csw.viajes.persistence.ItinerarioPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author js.beltran14
 */
@Stateless
public class ItinerarioLogic {
    
    private static final Logger LOGGER = Logger.getLogger(ItinerarioLogic.class.getName());
    
    @Inject
    private ItinerarioPersistence persistence;
    
     public List<ItinerarioEntity> getItinerarios() {
        return persistence.findAll();
    }
    
      public ItinerarioEntity getItinerario(Long id) {
        return persistence.find(id);
    }
     
     public ItinerarioEntity createItinrario(ItinerarioEntity entity) {
        persistence.create(entity);
        return entity;
    }

   
    public ItinerarioEntity updateItinerario(ItinerarioEntity entity) {
        return persistence.update(entity);
    }

   
    public void deleteItinerario(Long id) {
        persistence.delete(id);
    }
     
    
}
