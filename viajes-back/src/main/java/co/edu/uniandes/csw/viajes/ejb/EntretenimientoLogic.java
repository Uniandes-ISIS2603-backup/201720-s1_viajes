/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;
import co.edu.uniandes.csw.viajes.persistence.EntretenimientoPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author m.rodriguez21
 */
public class EntretenimientoLogic {

    /**
     * Variable para acceder a la persistencia de la aplicación. Es una
     * inyección de dependencias.
     */
    @Inject
    private EntretenimientoPersistence persistence;

    /**
     * Crear un nuevo Entretenimiento
     *
     * @param entity
     * @return
     */
    public EntretenimientoEntity createEntretenimiento(EntretenimientoEntity entity) {
        // Invoca la persistencia para crear la entretenimiento
        persistence.create(entity);

        return entity;
    }

    /**
     * Obtener todos los entretenimientos existentes en la base de datos.
     *
     * @return una lista de entretenimientos.
     */
    public List<EntretenimientoEntity> getEntretenimientos() {
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        return persistence.findAll();
    }

    /**
     * Obtener una entretenimiento por medio de su id.
     *
     * @param id: id del entretenimiento para ser buscada.
     * @return la entretenimiento solicitada por medio de su id.
     */
    public EntretenimientoEntity getEntretenimiento(Long id) {
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        return persistence.find(id);
    }

    /**
     * Actualizar una entretenimiento.
     *
     * @param entity: entretenimiento con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return la entretenimiento con los cambios actualizados en la base de
     * datos.
     */
    public EntretenimientoEntity updateEntretenimiento(EntretenimientoEntity entity) {
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        return persistence.update(entity);
    }

    /**
     * Borrar un entretenimiento
     *
     * @param id: id del entretenimiento a borrar
     */
    public void deleteEntretenimiento(Long id) {
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
    }

    /**
     * Obtiene una colección de instancias de ImagenEntity asociadas a una
     * instancia de Entretenimiento
     *
     * @param entretenimientoId Identificador de la instancia de Entretenimiento
     * @return Colección de instancias de ImagenEntity asociadas a la instancia
     * de Entretenimiento
     */
    public List<ImagenEntity> listImagenes(Long entretenimientoId) {

        return getEntretenimiento(entretenimientoId).getImagenes();
    }

    /**
     * Obtiene una instancia de ImagenEntity asociada a una instancia de
     * Entretenimiento
     *
     * @param entretenimientoId Identificador de la instancia de Entretenimiento
     * @param imagenesId Identificador de la instancia de Imagen
     * @return La imagen con id dado
     */
    public ImagenEntity getImagen(Long entretenimientoId, Long imagenesId) {

        List<ImagenEntity> list = getEntretenimiento(entretenimientoId).getImagenes();
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        int index = list.indexOf(imagenesEntity);

        return list.get(index);

    }

    /**
     * Asocia una Imagen existente a un Entretenimiento
     *
     * @param entretenimientoId Identificador de la instancia de Entretenimiento
     * @param imagenesId Identificador de la instancia de Imagen
     * @return Instancia de ImagenEntity que fue asociada a Entretenimiento
     */
    public ImagenEntity addImagen(Long entretenimientoId, Long imagenesId) {

        EntretenimientoEntity entretenimientoEntity = getEntretenimiento(entretenimientoId);
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        entretenimientoEntity.getImagenes().add(imagenesEntity);

        return getImagen(entretenimientoId, imagenesId);
    }

    /**
     * Obtiene una instancia de UbicacionEntity asociada a un hospedaje
     * 
     * @param hospedajeId Identificador de la instancia de Hospedaje
     * @return La instancia de Ubicación
     */
    public UbicacionEntity getUbicacion(Long entretenimientoId){
        UbicacionEntity entity = getEntretenimiento(entretenimientoId).getUbicacion();
        return entity;
    }
    /**
     * Remplaza las instancias de Imagen asociadas a una instancia de
     * Entretenimiento
     *
     * @param entretenimientoId Identificador de la instancia de Entretenimiento
     * @param list Colección de instancias de ImagenEntity a asociar a instancia
     * de Entretenimiento
     * @return Nueva colección de ImagenEntity asociada a la instancia de
     * Entretenimiento
     */
    public List<ImagenEntity> replaceImagenes(Long entretenimientoId, List<ImagenEntity> list) {
        
        EntretenimientoEntity entretenimientoEntity = getEntretenimiento(entretenimientoId);
        entretenimientoEntity.setImagenes(list);
        
        return entretenimientoEntity.getImagenes();
    }

    /**
     * Desasocia un Imagen existente de un Entretenimiento existente
     *
     * @param entretenimientoId Identificador de la instancia de Entretenimiento
     * @param imagenesId Identificador de la instancia de Imagen
     */
    public void removeImagen(Long entretenimientoId, Long imagenesId) {
        
        EntretenimientoEntity entity = getEntretenimiento(entretenimientoId);
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        entity.getImagenes().remove(imagenesEntity);
    }
}
