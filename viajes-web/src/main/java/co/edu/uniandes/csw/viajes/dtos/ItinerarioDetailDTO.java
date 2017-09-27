/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author js.beltran14
 */
public class ItinerarioDetailDTO extends ItinerarioDTO{
    
    //private List<ServicioDTO> servicios;
    
    private List<GuiaDTO> guias;
    
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
            guias = new ArrayList<>();
            for(GuiaEntity entityGuia : entity.getGias())  {
                guias.add(new GuiaDTO(entityGuia));
            }
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
        if (getGuias() != null) {
            List<GuiaEntity> guiasEntity = new ArrayList<>();
            for (GuiaDTO dtoGuia : getGuias()) {
                guiasEntity.add(dtoGuia.toEntity());
            }
            entity.setGias(guiasEntity);
        }
        return entity;
    }

    /**
     * @return the guias
     */
    public List<GuiaDTO> getGuias() {
        return guias;
    }

    /**
     * @param guias the guias to set
     */
    public void setGuias(List<GuiaDTO> guias) {
        this.guias = guias;
    }    
}
