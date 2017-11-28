/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import co.edu.uniandes.csw.viajes.persistence.ImagenPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author js.beltran14
 */
@Stateless
public class ImagenLogic {
    
    /**
     * Variable para acceder a la persistencia de la aplicación. 
     * Es una inyección de dependencias.
     */
    @Inject
    private ImagenPersistence persistence;
    
    /**
     * Obtiene la lista de los registros de Imagenes
     * @return Colección de objetos de Imagen.
     */    
    public List<ImagenEntity> getImagenes() {
        return persistence.findAll();
    }
    
    /**
     * Obtiene los datos de una instancia de Imagen a partir de su ID.
     * @param id Identificador de la instancia a consultar
     * @return Instancia de ImagenEntity con los datos de la Imagen consultado.
     */
    public ImagenEntity getImagen(Long id) {
        return persistence.find(id);
    }
     
    /**
     * Se encarga de crear una imagen en la base de datos.
     * @param entity Objeto de ImagenEntity con los datos nuevos
     * @return Objeto de ImagenEntity con los datos nuevos y su ID.
     */
    public ImagenEntity createImagen(ImagenEntity entity) {
        persistence.create(entity);
        return entity;
    }
    
    /**
     * Actualiza la información de una instancia de Imagen.
     * @param entity Instancia de ImagenEntity con los nuevos datos.
     * @return Instancia de ImagenEntity con los datos actualizados.
     */   
    public ImagenEntity updateImagen(ImagenEntity entity) {
        return persistence.update(entity);
    }
   
    /**
     * Elimina una instancia de Hospedaje de la base de datos.
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteImagen(Long id) {
        persistence.delete(id);
    }     
}
