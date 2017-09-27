/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import co.edu.uniandes.csw.viajes.persistence.ItinerarioPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

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
    
    /**
     *
     * Obtener la lista de los itinerarios
     * @return lista de los itinerarios
     */
    public List<ItinerarioEntity> getItinerarios() {
        LOGGER.info("Inicia proceso de consultar todas los itinerarios");
        return persistence.findAll();
    }
    
    /**
     *
     * Obtener un itinerario por medio de su id.
     *
     * @param id: id de la editorial para ser buscada.
     * @return el itinerario solicitada por medio de su id.
     */
    public ItinerarioEntity getItinerario(Long id) {
        LOGGER.info("Inicia proceso de consultar un itinerario");
        return persistence.find(id);
    }
    
    /**
     *
     * @param entity
     * @return ItinerarioEntity
     */
    public ItinerarioEntity createItinrario(ItinerarioEntity entity) {
        LOGGER.info("Inicia proceso de creación de itinerario");
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de itinerario");
        LOGGER.info(entity.getFechaInicial()+" "+entity.getFechaFinal());
        return entity;
    }

    
    /**
     *
     * Actualizar un itinerario.
     * @param entity: itinerario con los cambios para ser actualizada.
     * @return  itinerario con los cambios actualizados en la base de datos.
     */
    public ItinerarioEntity updateItinerario(ItinerarioEntity entity) {
        LOGGER.info("Inicia proceso de consultar un itinerario");
        return persistence.update(entity);
    }

   /**
     * Borrar un itinerario
     *
     * @param id: id del itinerario a borrar
     */
    public void deleteItinerario(Long id) {
        LOGGER.info("Inicia proceso de borrar un itinerario");
        persistence.delete(id);
        LOGGER.info("Termina proceso de borrar un itinerario");
    }
     
    /**
     * adiere un guia a un itinerario
     *
     * @param guiaId : id del guia 
     * @param itinerarioId : id del itinerario
     */
     public GuiaEntity addGuia(Long itinerarioId, Long guiaId) {
        GuiaEntity guiaEntity = guiaLogic.getGuia(guiaId);
        return guiaEntity;
    }
     
     /**
     * remueve un guia a un itinerario
     *
     * @param guiaId : id del guia 
     * @param itinerarioId : id del itinerario
     */
     public void removeGuia(Long guiaId, Long itinerarioId) {
        ItinerarioEntity itinerarioEntity = getItinerario(itinerarioId);
        GuiaEntity guia = guiaLogic.getGuia(guiaId);
        itinerarioEntity.getGias().remove(guia);
    }
     
     /**
     * adiere un guia a un itinerario
     *
     * @param itinerarioId : id del guia 
     * @param guias : id del itinerario
     */
    public List<GuiaEntity> replaceGuias(Long itinerarioId, List<GuiaEntity> guias) {
        ItinerarioEntity itinerario = getItinerario(itinerarioId);
        List<GuiaEntity> guiaList = guiaLogic.getGuias();
        //for (GuiaEntity guia : guiaList) {
          //  if (guias.contains(guia)) {
            //} else if (guia.getItinerario() != null && guia.getItinerario().equals(itinerario)) {
              //  guia.setItinerario(null);
            //}
        //}
        return guias;
    } 
    
    /**
     * @return  los guia a un itinerario
     *
     * @param itinerarioId : id del itinerario
     */
    public List<GuiaEntity> getGuias(Long itinerarioId) {
        return getItinerario(itinerarioId).getGias();
    }
    
    /**
     * @return  un guia a un itinerario
     *
     * @param guiaId : id del guia 
     * @param itinerarioId : id del itinerario
     */
    public GuiaEntity getGuia(Long itinerarioId, Long guiaId) throws WebApplicationException {
        List<GuiaEntity> guias = getItinerario(itinerarioId).getGias();
        GuiaEntity guia = guiaLogic.getGuia(guiaId);
        int index = guias.indexOf(guia);
        if (index >= 0) {
            return guias.get(index);
        }
        throw new WebApplicationException("El GUIA no está asociado a la editorial");

    }
    
    /**
     * @return lista con guias
     *
     * @param itinerarioId : id del itinerario
     */
    public List<GuiaEntity> listGuias(Long itinerarioId) {
        return getItinerario(itinerarioId).getGias();
    }
}
