/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
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
    
    /**
     * Variable para acceder a la persistencia de la aplicación. 
     * Es una inyección de dependencias.
     */
    @Inject
    private ItinerarioPersistence persistence;
    
    @Inject
    private GuiaLogic guiaLogic;
    
    @Inject
    private EntretenimientoLogic entretenimientoLogic;
    
    @Inject
    private HospedajeLogic hospedajeLogic;
    
    @Inject
    private TransporteLogic transporteLogic;
    
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
        return guiaLogic.getGuia(guiaId);
        
    }
     
     /**
     * adiere un guia a un itinerario
     *
     * @param entretenimientoId : id del entretenimiento 
     * @param itinerarioId : id del itinerario
     */
     public EntretenimientoEntity addEntretenimiento(Long itinerarioId, Long entretenimientoId){
         return entretenimientoLogic.getEntretenimiento(entretenimientoId);
         
    }
     
     
     /**
     * adiere un guia a un itinerario
     *
     * @param hospedajeId  : id del hospedaje 
     * @param itinerarioId : id del itinerario
     */
     public HospedajeEntity addHospedaje(Long itinerarioId, Long hospedajeId){
         return hospedajeLogic.getHospedaje(hospedajeId);
         
    }
     
     
     /**
     * adiere un guia a un itinerario
     *
     * @param transporteId  : id del transporte 
     * @param itinerarioId : id del itinerario
     */
    public TransporteEntity addTransporte(Long itinerarioId, Long transporteId){
         return transporteLogic.getTransporte(transporteId);
         
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
     * remueve un entretentretenimiento a un itinerario
     *
     * @param entretenimientoId  : id del entretenimiento 
     * @param itinerarioId : id del itinerario
     */
     public void removeEntretenimiento(Long itinerarioId, Long entretenimientoId){
         ItinerarioEntity itinerarioEntity = getItinerario(itinerarioId);
         EntretenimientoEntity entretenimiento = entretenimientoLogic.getEntretenimiento(entretenimientoId);
         itinerarioEntity.getEntretenimientos().remove(entretenimiento);
     }
     
     
     /**
     * remueve un hospedaje a un itinerario
     *
     * @param hospedajeId  : id del hospedaje 
     * @param itinerarioId : id del itinerario
     */
     public void removeHospedaje(Long itinerarioId, Long hospedajeId){
         ItinerarioEntity itinerarioEntity = getItinerario(itinerarioId);
         HospedajeEntity hospedaje = hospedajeLogic.getHospedaje(hospedajeId);
         itinerarioEntity.getHospedajes().remove(hospedaje);
     }
     
     
     /**
     * remueve un transporte a un itinerario
     *
     * @param transporteId  : id del transporte 
     * @param itinerarioId : id del itinerario
     */
      public void removeTransporte(Long itinerarioId, Long transporteId){
         ItinerarioEntity itinerarioEntity = getItinerario(itinerarioId);
         TransporteEntity transporte = transporteLogic.getTransporte(transporteId);
         itinerarioEntity.getTransportes().remove(transporte);
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
     * @return  los entretenimientos a un itinerario
     *
     * @param itinerarioId : id del itinerario
     */
    public List<EntretenimientoEntity> getEntretenimientos(Long itinerarioId){
        return getItinerario(itinerarioId).getEntretenimientos();
    }
    
    
    /**
     * @return  los hospedajes a un itinerario
     *
     * @param itinerarioId : id del itinerario
     */
    public List<HospedajeEntity> getHospedajes(Long itinerarioId){
        return getItinerario(itinerarioId).getHospedajes();
    }
    
    
    /**
     * @return  los transportes a un itinerario
     *
     * @param itinerarioId : id del itinerario
     */
    public List<TransporteEntity> getTransportes(Long itinerarioId){
        return getItinerario(itinerarioId).getTransportes();
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
     * @return  un entretenimiento a un itinerario
     *
     * @param entretenimientoId  : id del entretenimiento 
     * @param itinerarioId : id del itinerario
     */
    public EntretenimientoEntity getEntretenimiento(Long itinerarioId, Long entretenimientoId) throws WebApplicationException{
        List<EntretenimientoEntity> entretenimientos = getItinerario(itinerarioId).getEntretenimientos();
        EntretenimientoEntity entreteniiento = entretenimientoLogic.getEntretenimiento(entretenimientoId);
        int index = entretenimientos.indexOf(entreteniiento);
        if(index>=0){
            return entretenimientos.get(index);
        }
         throw new WebApplicationException("El ENTRETENIMIENTO no está asociado a la editorial");

    }
    
    
    /**
     * @return  un hospedaje a un itinerario
     *
     * @param hospedajeId   : id del hospedaje 
     * @param itinerarioId : id del itinerario
     */
    public HospedajeEntity getHospedaje(Long itinerarioId, Long hospedajeId) throws WebApplicationException{
        List<HospedajeEntity> hospedajes = getItinerario(itinerarioId).getHospedajes();
        HospedajeEntity hospedaje = hospedajeLogic.getHospedaje(hospedajeId);
        int index = hospedajes.indexOf(hospedaje);
        if(index>=0){
            return hospedajes.get(index);
        }
         throw new WebApplicationException("El ENTRETENIMIENTO no está asociado a la editorial");

    }
    
    
    /**
     * @return  un transporte a un itinerario
     *
     * @param transporteId   : id del transporte 
     * @param itinerarioId : id del itinerario
     */
    public TransporteEntity getTransporte(Long itinerarioId, Long transporteId) throws WebApplicationException{
        List<TransporteEntity> transportes = getItinerario(itinerarioId).getTransportes();
        TransporteEntity transporte = transporteLogic.getTransporte(transporteId);
        int index = transportes.indexOf(transporte);
        if(index>=0){
            return transportes.get(index);
        }
         throw new WebApplicationException("El ENTRETENIMIENTO no está asociado a la editorial");

    }
    
    /**
     * @return lista con guias
     *
     * @param itinerarioId : id del itinerario
     */
    public List<GuiaEntity> listGuias(Long itinerarioId) {
        return getItinerario(itinerarioId).getGias();
    }
    
    
    /**
     * @return lista con entretenimientos
     *
     * @param itinerarioId : id del itinerario
     */
    public List<EntretenimientoEntity> listEntretenimientos(Long itinerarioId){
        return getItinerario(itinerarioId).getEntretenimientos();
    }
    
    
    /**
     * @return lista con hospedajes
     *
     * @param itinerarioId : id del itinerario
     */
    public List<HospedajeEntity> listHospedajes(Long itinerarioId){
        return getItinerario(itinerarioId).getHospedajes();
    }
    
    
    /**
     * @return lista con transportes
     *
     * @param itinerarioId : id del itinerario
     */
    public List<TransporteEntity> listTransportes(Long itinerarioId){
        return getItinerario(itinerarioId).getTransportes();
    }
}
