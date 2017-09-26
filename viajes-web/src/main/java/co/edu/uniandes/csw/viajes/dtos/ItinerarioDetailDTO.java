/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import co.edu.uniandes.csw.viajes.entities.ServicioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author js.beltran14
 */
public class ItinerarioDetailDTO extends ItinerarioDTO{
    
    //private List<ServicioDTO> servicios;
    
    public ItinerarioDetailDTO(){
        
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public ItinerarioDetailDTO(ItinerarioEntity entity){
        super(entity);
        if (entity != null) {
           // servicios = new ArrayList<>();
            //for (ServicioEntity entityServicio : entity.getServicios()) {
              //  servicios.add(new ServicioDTO(entityServicio));
            //}

        }
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public ItinerarioEntity toEntity(){
        ItinerarioEntity entity = super.toEntity();
//        if (getServicios() != null) {
            List<ServicioEntity> serviciosEntity = new ArrayList<>();
            //for (ServicioDTO dtoServicio : getServicios()) {
              //  serviciosEntity.add(dtoServicio.toEntity());
            //}
            //entity.setServicios(serviciosEntity);
  //      }
        return entity;
    }

    /**
     * @return the servicios
     */
    //public List<ServicioDTO> getServicios() {
     //   return servicios;
    //}

    /**
     * @param servicios the servicios to set
     */
    //public void setServicios(List<ServicioDTO> servicios) {
      //  this.servicios = servicios;
    //}
    
}
