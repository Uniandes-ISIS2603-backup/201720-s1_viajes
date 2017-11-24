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
     * @return Instancia de HospedajeEntity con los datos del Hospedaje consultado.
     */
    public ImagenEntity getImagen(Long id) {
        return persistence.find(id);
    }
     
     public ImagenEntity createImagen(ImagenEntity entity) {
        persistence.create(entity);
        return entity;
    }
   
    public ImagenEntity updateImagen(ImagenEntity entity) {
        return persistence.update(entity);
    }
   
    public void deleteImagen(Long id) {
        persistence.delete(id);
    }     
}
