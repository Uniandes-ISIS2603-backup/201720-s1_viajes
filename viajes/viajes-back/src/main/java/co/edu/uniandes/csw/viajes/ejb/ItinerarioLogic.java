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
        LOGGER.info("Inicia proceso de consultar todas los itinerarios");
        return persistence.findAll();
    }
    
    public ItinerarioEntity getItinerario(Long id) {
        LOGGER.info("Inicia proceso de consultar un itinerario");
        return persistence.find(id);
    }
     
    public ItinerarioEntity createItinrario(ItinerarioEntity entity) {
        LOGGER.info("Inicia proceso de creación de itinerario");
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de itinerario");
        LOGGER.info(entity.getFechaInicial()+" "+entity.getFechaFinal());
        return entity;
    }

   
    public ItinerarioEntity updateItinerario(ItinerarioEntity entity) {
        LOGGER.info("Inicia proceso de consultar un itinerario");
        return persistence.update(entity);
    }

   
    public void deleteItinerario(Long id) {
        LOGGER.info("Inicia proceso de borrar un itinerario");
        persistence.delete(id);
        LOGGER.info("Termina proceso de borrar un itinerario");
    }
     
    
}
