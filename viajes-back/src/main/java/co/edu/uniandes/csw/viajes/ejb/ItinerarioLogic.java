/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import co.edu.uniandes.csw.viajes.excpetions.BusinessLogicException;
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
    
    @Inject
    private GuiaLogic guiaLogic;
    
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
     
     public GuiaEntity addGuia(Long guiaId, Long itinerarioId) {
        ItinerarioEntity itinerarioEntity = getItinerario(itinerarioId);
        GuiaEntity guiaEntity = guiaLogic.getGuia(guiaId);
        guiaEntity.setItinerario(itinerarioEntity);
        return guiaEntity;
    }
     
     public void removeGuia(Long guiaId, Long itinerarioId) {
        ItinerarioEntity itinerarioEntity = getItinerario(itinerarioId);
        GuiaEntity guia = guiaLogic.getGuia(guiaId);
        guia.setItinerario(null);
        itinerarioEntity.getGias().remove(guia);
    }
     
    public List<GuiaEntity> replaceGuias(Long itinerarioId, List<GuiaEntity> guias) {
        ItinerarioEntity itinerario = getItinerario(itinerarioId);
        List<GuiaEntity> guiaList = guiaLogic.getGuias();
        for (GuiaEntity guia : guiaList) {
            if (guias.contains(guia)) {
                guia.setItinerario(itinerario);
            } else if (guia.getItinerario() != null && guia.getItinerario().equals(itinerario)) {
                guia.setItinerario(null);
            }
        }
        return guias;
    } 
    
    public List<GuiaEntity> getGuias(Long itinerarioId) {
        return getItinerario(itinerarioId).getGias();
    }
    
    public GuiaEntity getGuia(Long itinerarioId, Long guiaId) throws BusinessLogicException {
        List<GuiaEntity> guias = getItinerario(itinerarioId).getGias();
        GuiaEntity guia = guiaLogic.getGuia(guiaId);
        int index = guias.indexOf(guia);
        if (index >= 0) {
            return guias.get(index);
        }
        throw new BusinessLogicException("El libro no está asociado a la editorial");

    }
    
    public List<GuiaEntity> listGuias(Long itinerarioId) {
        return getItinerario(itinerarioId).getGias();
    }
}
