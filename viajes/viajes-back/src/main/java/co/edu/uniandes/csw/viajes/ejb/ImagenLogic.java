/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejb;

import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import co.edu.uniandes.csw.viajes.persistence.ImagenPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author js.beltran14
 */
@Stateless
public class ImagenLogic {
    
    private static final Logger LOGGER = Logger.getLogger(ImagenLogic.class.getName());
    
    @Inject
    private ImagenPersistence persistence;
    
     public List<ImagenEntity> getImagenes() {
        return persistence.findAll();
    }
    
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
