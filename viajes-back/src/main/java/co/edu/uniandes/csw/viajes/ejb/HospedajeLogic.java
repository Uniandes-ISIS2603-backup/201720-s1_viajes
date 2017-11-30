/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import co.edu.uniandes.csw.viajes.entities.UbicacionEntity;
import co.edu.uniandes.csw.viajes.persistence.HospedajePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ma.forero11
 */
@Stateless
public class HospedajeLogic {

    /**
     * Variable para acceder a la persistencia de la aplicación. Es una
     * inyección de dependencias.
     */
    @Inject
    private HospedajePersistence persistence;

    /**
     * Obtiene la lista de los registros de Hospedajes.
     *
     * @return Colección de objetos de Hospedaje.
     */
    public List<HospedajeEntity> getHospedajes() {
        return persistence.findAll();
    }

    /**
     * Obtiene los datos de una instancia de Hospedaje a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de HospedajeEntity con los datos del Hospedaje
     * consultado.
     */
    public HospedajeEntity getHospedaje(Long id) {
        return persistence.find(id);
    }

    /**
     * Se encarga de crear un hospedaje en la base de datos.
     *
     * @param entity Objeto de HospedajeEntity con los datos nuevos
     * @return Objeto de HospedajeEntity con los datos nuevos y su ID.
     */
    public HospedajeEntity createHospedaje(HospedajeEntity entity) {
        persistence.create(entity);
        return entity;
    }

    /**
     * Actualiza la información de una instancia de Hospedaje.
     *
     * @param entity Instancia de HospedajeEntity con los nuevos datos.
     * @return Instancia de HospedajeEntity con los datos actualizados.
     */
    public HospedajeEntity updateHospedaje(HospedajeEntity entity) {
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Hospedaje de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteHospedaje(Long id) {
        persistence.delete(id);
    }

    /**
     * Obtiene una colección de instancias de ImagenEntity asociadas a una
     * instancia de Hospedaje
     *
     * @param hospedajeId Identificador de la instancia de Hospedaje
     * @return Colección de instancias de ImagenEntity asociadas a la instancia
     * de Hospedaje
     */
    public List<ImagenEntity> listImagenes(Long hospedajeId) {
        return getHospedaje(hospedajeId).getImagenes();
    }

    /**
     * Obtiene una instancia de ImagenEntity asociada a una instancia de
     * Hospedaje
     *
     * @param hospedajeId Identificador de la instancia de Hospedaje
     * @param imagenesId Identificador de la instancia de Imagen
     * @return La imagen con id dado
     */
    public ImagenEntity getImagen(Long hospedajeId, Long imagenesId) {
        List<ImagenEntity> list = getHospedaje(hospedajeId).getImagenes();
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        int index = list.indexOf(imagenesEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }
    
    /**
     * Obtiene una instancia de UbicacionEntity asociada a un hospedaje
     * 
     * @param hospedajeId Identificador de la instancia de Hospedaje
     * @return La instancia de Ubicación
     */
    public UbicacionEntity getUbicacion(Long hospedajeId){
        UbicacionEntity entity = getHospedaje(hospedajeId).getUbicacion();
        return entity;
    }

    /**
     * Asocia una Imagen existente a un Hospedaje
     *
     * @param hospedajeId Identificador de la instancia de Hospedaje
     * @param imagenesId Identificador de la instancia de Imagen
     * @return Instancia de ImagenEntity que fue asociada a Hospedaje
     */
    public ImagenEntity addImagen(Long hospedajeId, Long imagenesId) {
        HospedajeEntity hospedajeEntity = getHospedaje(hospedajeId);
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        hospedajeEntity.getImagenes().add(imagenesEntity);
        return getImagen(hospedajeId, imagenesId);
    }
//    
//    public UbicacionEntity addUbicacion(Long hospedajeId, Long ubicacionId){
//        HospedajeEntity hospedajeEntity = getHospedaje(hospedajeId);
//        UbicacionEntity ubicacionEntity = new UbicacionEntity();
//        ubicacionEntity.setId(ubicacionId);
//        hospedajeEntity.
//    }

    /**
     * Remplaza las instancias de Imagen asociadas a una instancia de Hospedaje
     *
     * @param hospedajeId Identificador de la instancia de Blog
     * @param list Colección de instancias de ImagenEntity a asociar a instancia
     * de Hospedaje
     * @return Nueva colección de ImagenEntity asociada a la instancia de
     * Hospedaje
     */
    public List<ImagenEntity> replaceImagenes(Long hospedajeId, List<ImagenEntity> list) {
        HospedajeEntity hospedajeEntity = getHospedaje(hospedajeId);
        hospedajeEntity.setImagenes(list);
        return hospedajeEntity.getImagenes();
    }

    /**
     * Desasocia un Imagen existente de un Blog existente
     *
     * @param hospedajeId Identificador de la instancia de Blog
     * @param imagenesId Identificador de la instancia de Imagen
     */
    public void removeImagen(Long hospedajeId, Long imagenesId) {
        HospedajeEntity entity = getHospedaje(hospedajeId);
        ImagenEntity imagenesEntity = new ImagenEntity();
        imagenesEntity.setId(imagenesId);
        entity.getImagenes().remove(imagenesEntity);
    }
}