/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
import co.edu.uniandes.csw.viajes.entities.GuiaEntity;
import co.edu.uniandes.csw.viajes.entities.HospedajeEntity;
import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import co.edu.uniandes.csw.viajes.entities.TransporteEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author js.beltran14
 */
public class ItinerarioDetailDTO extends ItinerarioDTO{

    
    private List<GuiaDTO> guias;
    
    private List<EntretenimientoDTO> entretenimientos;
    
    private List<HospedajeDTO> hospedajes;
    
    private List<TransporteDTO> transportes;
    
    public ItinerarioDetailDTO(){
        super();
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
            if(entity.getGias()!=null){
                for(GuiaEntity entityGuia : entity.getGias())  {
                guias.add(new GuiaDTO(entityGuia));
                }
            }
            entretenimientos = new ArrayList<>();
            if(entity.getEntretenimientos()!=null){
                for(EntretenimientoEntity entityEntretenimiento : entity.getEntretenimientos()){
                entretenimientos.add(new EntretenimientoDTO(entityEntretenimiento));
                }   
            }
            hospedajes = new ArrayList<>();
            if(entity.getHospedajes()!=null){
                for(HospedajeEntity entityHospedaje : entity.getHospedajes()){
                hospedajes.add(new HospedajeDTO(entityHospedaje));
                }   
            }
            transportes = new ArrayList<>();
            if(entity.getTransportes()!=null){
                for(TransporteEntity entityTransporte : entity.getTransportes()){
                transportes.add(new TransporteDTO(entityTransporte));
                }
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
        if(getEntretenimientos()!=null){
            List<EntretenimientoEntity> entretenimientosEntity = new ArrayList<>();
            for(EntretenimientoDTO dtoEntretenimiento : getEntretenimientos()){
                entretenimientosEntity.add(dtoEntretenimiento.toEntity());
            }
            entity.setEntretenimientos(entretenimientosEntity);
        }
        if(getHospedajes()!=null){
            List<HospedajeEntity> hospedajesEntity = new ArrayList<>();
            for(HospedajeDTO dtoHospedaje : getHospedajes()){
                hospedajesEntity.add(dtoHospedaje.toEntity());
            }
            entity.setHospedajes(hospedajesEntity);
        }
        if(getTransportes()!=null){
            List<TransporteEntity> transportesEntity = new ArrayList<>();
            for(TransporteDTO dtoTransporte : getTransportes()){
                transportesEntity.add(dtoTransporte.toEntity());
            }
            entity.setTransportes(transportesEntity);
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
    
    /**
     * @return the entretenimientos
     */
    public List<EntretenimientoDTO> getEntretenimientos() {
        return entretenimientos;
    }

    /**
     * @param entretenimientos the entretenimientos to set
     */
    public void setEntretenimientos(List<EntretenimientoDTO> entretenimientos) {
        this.entretenimientos = entretenimientos;
    }

    /**
     * @return the hospedajes
     */
    public List<HospedajeDTO> getHospedajes() {
        return hospedajes;
    }

    /**
     * @param hospedajes the hospedajes to set
     */
    public void setHospedajes(List<HospedajeDTO> hospedajes) {
        this.hospedajes = hospedajes;
    }

    /**
     * @return the transportes
     */
    public List<TransporteDTO> getTransportes() {
        return transportes;
    }

    /**
     * @param transportes the transportes to set
     */
    public void setTransportes(List<TransporteDTO> transportes) {
        this.transportes = transportes;
    }
}
