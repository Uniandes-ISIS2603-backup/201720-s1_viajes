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
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author js.beltran14
 */
@Stateless
public class ItinerarioLogic {

    /**
     * Variable para acceder a la persistencia de la aplicación. Es una
     * inyección de dependencias.
     */
    @Inject
    private ItinerarioPersistence persistence;

    /**
     * Variable para acceder a la persistencia de la aplicación. Es una
     * inyección de dependencias.
     */
    @Inject
    private GuiaLogic guiaLogic;

    /**
     * Variable para acceder a la persistencia de la aplicación. Es una
     * inyección de dependencias.
     */
    @Inject
    private EntretenimientoLogic entretenimientoLogic;

    /**
     * Variable para acceder a la persistencia de la aplicación. Es una
     * inyección de dependencias.
     */
    @Inject
    private HospedajeLogic hospedajeLogic;

    /**
     * Variable para acceder a la persistencia de la aplicación. Es una
     * inyección de dependencias.
     */
    @Inject
    private TransporteLogic transporteLogic;

    /**
     * Obtener la lista de los itinerarios
     *
     * @return lista de los itinerarios
     */
    public List<ItinerarioEntity> getItinerarios() {
        return persistence.findAll();
    }

    /**
     * Obtener un itinerario por medio de su id.
     *
     * @param id: id de la editorial para ser buscada.
     * @return el itinerario solicitada por medio de su id.
     */
    public ItinerarioEntity getItinerario(Long id) {
        return persistence.find(id);
    }

    /**
     * Se encarga de crear un itinerario en la base de datos.
     *
     * @param entity itinerario que se va a agregar
     * @return ItinerarioEntity
     */
    public ItinerarioEntity createItinerario(ItinerarioEntity entity) {
        persistence.create(entity);
        return entity;
    }

    /**
     * Actualizar un itinerario.
     *
     * @param entity: itinerario con los cambios para ser actualizada.
     * @return itinerario con los cambios actualizados en la base de datos.
     */
    public ItinerarioEntity updateItinerario(ItinerarioEntity entity) {
        return persistence.update(entity);
    }

    /**
     * Borrar un itinerario
     *
     * @param id: id del itinerario a borrar
     */
    public void deleteItinerario(Long id) {
        persistence.delete(id);
    }

    /**
     * Adiere un guia a un itinerario
     *
     * @param guiaId : id del guia
     * @param itinerarioId : id del itinerario
     * @return El guia agregado
     */
    public GuiaEntity addGuia(Long itinerarioId, Long guiaId) {
        return guiaLogic.getGuia(guiaId);
    }

    /**
     * Adiere un entretenimiento a un itinerario
     *
     * @param entretenimientoId : id del entretenimiento
     * @param itinerarioId : id del itinerario
     * @return El entretenimiento agregado
     */
    public EntretenimientoEntity addEntretenimiento(Long itinerarioId, Long entretenimientoId) {
        return entretenimientoLogic.getEntretenimiento(entretenimientoId);
    }

    /**
     * Adiere un hospedaje a un itinerario
     *
     * @param hospedajeId : id del hospedaje
     * @param itinerarioId : id del itinerario
     * @return El hospedaje agregado
     */
    public HospedajeEntity addHospedaje(Long itinerarioId, Long hospedajeId) {
        return hospedajeLogic.getHospedaje(hospedajeId);
    }

    /**
     * Adiere un transporte a un itinerario
     *
     * @param transporteId : id del transporte
     * @param itinerarioId : id del itinerario
     * @return El transporte agregado
     */
    public TransporteEntity addTransporte(Long itinerarioId, Long transporteId) {
        return transporteLogic.getTransporte(transporteId);
    }

    /**
     * Remueve un guia de un itinerario
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
     * Remueve un entretentretenimiento de un itinerario
     *
     * @param entretenimientoId : id del entretenimiento
     * @param itinerarioId : id del itinerario
     */
    public void removeEntretenimiento(Long itinerarioId, Long entretenimientoId) {
        ItinerarioEntity itinerarioEntity = getItinerario(itinerarioId);
        EntretenimientoEntity entretenimiento = entretenimientoLogic.getEntretenimiento(entretenimientoId);
        itinerarioEntity.getEntretenimientos().remove(entretenimiento);
    }

    /**
     * Remueve un hospedaje de un itinerario
     *
     * @param hospedajeId : id del hospedaje
     * @param itinerarioId : id del itinerario
     */
    public void removeHospedaje(Long itinerarioId, Long hospedajeId) {
        ItinerarioEntity itinerarioEntity = getItinerario(itinerarioId);
        HospedajeEntity hospedaje = hospedajeLogic.getHospedaje(hospedajeId);
        itinerarioEntity.getHospedajes().remove(hospedaje);
    }

    /**
     * Remueve un transporte de un itinerario
     *
     * @param transporteId : id del transporte
     * @param itinerarioId : id del itinerario
     */
    public void removeTransporte(Long itinerarioId, Long transporteId) {
        ItinerarioEntity itinerarioEntity = getItinerario(itinerarioId);
        TransporteEntity transporte = transporteLogic.getTransporte(transporteId);
        itinerarioEntity.getTransportes().remove(transporte);
    }

    /**
     * Devuelve el guia al que le corresponde un itinerario con el id dado
     *
     * @param guiaId : id del guia
     * @param itinerarioId : id del itinerario
     * @return Un guia de un itinerario
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
     * Devuelve el entretenimiento al que le corresponde un itinerario con el id dado
     *
     * @param entretenimientoId : id del entretenimiento
     * @param itinerarioId : id del itinerario
     * @return Un entretenimiento de un itinerario
     */
    public EntretenimientoEntity getEntretenimiento(Long itinerarioId, Long entretenimientoId) throws WebApplicationException {
        List<EntretenimientoEntity> entretenimientos = getItinerario(itinerarioId).getEntretenimientos();
        EntretenimientoEntity entreteniiento = entretenimientoLogic.getEntretenimiento(entretenimientoId);
        int index = entretenimientos.indexOf(entreteniiento);
        if (index >= 0) {
            return entretenimientos.get(index);
        }
        throw new WebApplicationException("El ENTRETENIMIENTO no está asociado a la editorial");

    }

    /**
     * Devuelve el hospedaje al que le corresponde un itinerario con el id dado
     *
     * @param hospedajeId : id del hospedaje
     * @param itinerarioId : id del itinerario
     * @return Un hospedaje de un itinerario
     */
    public HospedajeEntity getHospedaje(Long itinerarioId, Long hospedajeId) throws WebApplicationException {
        List<HospedajeEntity> hospedajes = getItinerario(itinerarioId).getHospedajes();
        HospedajeEntity hospedaje = hospedajeLogic.getHospedaje(hospedajeId);
        int index = hospedajes.indexOf(hospedaje);
        if (index >= 0) {
            return hospedajes.get(index);
        }
        throw new WebApplicationException("El ENTRETENIMIENTO no está asociado a la editorial");

    }

    /**
     * Devuelve el transporte al que le corresponde un itinerario con el id dado
     *
     * @param transporteId : id del transporte
     * @param itinerarioId : id del itinerario
     * @return Un transporte de un itinerario
     */
    public TransporteEntity getTransporte(Long itinerarioId, Long transporteId) throws WebApplicationException {
        List<TransporteEntity> transportes = getItinerario(itinerarioId).getTransportes();
        TransporteEntity transporte = transporteLogic.getTransporte(transporteId);
        int index = transportes.indexOf(transporte);
        if (index >= 0) {
            return transportes.get(index);
        }
        throw new WebApplicationException("El ENTRETENIMIENTO no está asociado a la editorial");

    }

    /**
     * Devuelve los guias del itinerario
     *
     * @param itinerarioId : id del itinerario
     * @return lista con guias
     */
    public List<GuiaEntity> listGuias(Long itinerarioId) {
        return getItinerario(itinerarioId).getGias();
    }

    /**
     * Devuelve los entretenimientos del itinerario
     *
     * @param itinerarioId : id del itinerario
     * @return lista con entretenimientos
     */
    public List<EntretenimientoEntity> listEntretenimientos(Long itinerarioId) {
        return getItinerario(itinerarioId).getEntretenimientos();
    }

    /**
     * Devuelve los hospedajes del itinerario
     *
     * @param itinerarioId : id del itinerario
     * @return lista con hospedajes
     */
    public List<HospedajeEntity> listHospedajes(Long itinerarioId) {
        return getItinerario(itinerarioId).getHospedajes();
    }

    /**
     * Devuelve los transportes del itinerario
     *
     * @param itinerarioId : id del itinerario
     * @return lista con transportes
     */
    public List<TransporteEntity> listTransportes(Long itinerarioId) {
        return getItinerario(itinerarioId).getTransportes();
    }
}
