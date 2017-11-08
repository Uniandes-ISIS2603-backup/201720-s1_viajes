/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import co.edu.uniandes.csw.viajes.persistence.TransportePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que representa la logica de Transportes
 * @author sa.silva1
 */
@Stateless
public class TransporteLogic {
    
    /**
    *Logger de la clase, se encarga de imprimir en consola lo que está sucediendo
    */
    private static final Logger LOGGER = Logger.getLogger(TransporteLogic.class.getName());

    /**
    *Persistencia de transporte
    */
    @Inject
    private TransportePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    
    
     /**
      * Metodo que llama a la persistencia para crear el transporte
     * @param entity
     * @return entity, entidad transporte creada
     */
     public TransporteEntity createTransporte(TransporteEntity entity){
        LOGGER.info("Inicia proceso de creación de transporte");
        // Invoca la persistencia para crear el transporte
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de transporte");
        return entity;
    }

    /**
     * 
     * Obtener todos los transportes existentes en la base de datos.
     *
     * @return una lista de transportes.
     */
    public List<TransporteEntity> getTransportes() {
        LOGGER.info("Inicia proceso de consultar todos los transportes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<TransporteEntity> transportes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas los transportes");
        return transportes;
    }

    /**
     *
     * Obtener un transporte por medio de su id.
     * 
     * @param id: id del transporte para ser buscado.
     * @return el transporte solicitado por medio de su id.
     */
    public TransporteEntity getTransporte(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar transporte con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        TransporteEntity transporte = persistence.find(id);
        if (transporte == null) {
            LOGGER.log(Level.SEVERE, "El transporte con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar transporte con id={0}", id);
        return transporte;
    }

    /**
     *
     * Actualizar un transporte.
     *
     * @param id: id del transporte para buscarlo en la base de datos.
     * @param entity: transporte con los cambios para ser actualizados, por
     * ejemplo el nombre.
     * @return el transporte con los cambios actualizados en la base de datos.
     */
    public TransporteEntity updateTransporte(Long id, TransporteEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar transporte con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        TransporteEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar transporte con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un transporte
     *
     * @param id: id del transporte a borrar
     */
    public void deleteTransporte(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar transporte con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar transporte con id={0}", id);
    }
    
    /**
     * Obtiene una colección de instancias de ImagenEntity asociadas a una
     * instancia de Transporte
     *
     * @param transporteId Identificador de la instancia de Transporte
     * @return Colección de instancias de ImagenEntity asociadas a la instancia
     * de Transporte
     * 
     */
    public List<ImagenEntity> listImagenes(Long transporteId) {
        return getTransporte(transporteId).getImagenes();
    }
    
    /**
     * Obtiene una instancia de ImagenEntity asociada a una instancia de Transporte
     *
     * @param transporteId Identificador de la instancia de Transporte
     * @param imagenesId Identificador de la instancia de Imagen
     * @return La imagen con id dado
     * 
     */
    public ImagenEntity getImagen(Long transporteId, Long imagenesId) {
        List<ImagenEntity> list = getTransporte(transporteId).getImagenes();
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        int index = list.indexOf(imagenesEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }
    
    /**
     * Asocia una Imagen existente a un Transporte
     *
     * @param transporteId Identificador de la instancia de Transporte
     * @param imagenesId Identificador de la instancia de Imagen
     * @return Instancia de ImagenEntity que fue asociada a Transporte
     * 
     */
    public ImagenEntity addImagen(Long transporteId, Long imagenesId) {
        TransporteEntity transporteEntity = getTransporte(transporteId);
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        transporteEntity.getImagenes().add(imagenesEntity);
        return getImagen(transporteId, imagenesId);
    }

    /**
     * Remplaza las instancias de Imagen asociadas a una instancia de Transporte
     *
     * @param transporteId Identificador de la instancia de Transporte
     * @param list Colección de instancias de ImagenEntity a asociar a instancia
     * de Transporte
     * @return Nueva colección de ImagenEntity asociada a la instancia de Transporte
     * 
     */
    public List<ImagenEntity> replaceImagenes(Long transporteId, List<ImagenEntity> list) {
        TransporteEntity transporteEntity = getTransporte(transporteId);
        transporteEntity.setImagenes(list);
        return transporteEntity.getImagenes();
    }

    /**
     * Desasocia un Imagen existente de un Transporte existente
     *
     * @param transporteId Identificador de la instancia de Transporte
     * @param imagenesId Identificador de la instancia de Imagen
     * 
     */
    public void removeImagen(Long transporteId, Long imagenesId) {
        TransporteEntity entity = getTransporte(transporteId);
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        entity.getImagenes().remove(imagenesEntity);
    }
}
