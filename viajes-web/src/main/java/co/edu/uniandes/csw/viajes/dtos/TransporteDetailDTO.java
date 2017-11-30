/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.TransporteEntity;

/**
 * Clase del transporte DTO en detalle
 * @author sa.silva1
 */
public class TransporteDetailDTO extends TransporteDTO{
    
    /**
     * ubicacion origen
     */
    private UbicacionDTO origen;
    
    /**
     * Ubicacion destino
     */
    private UbicacionDTO destino;
    
    /**
     * Constructor por defecto
     */
    public TransporteDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    
    public TransporteDetailDTO(TransporteEntity entity) {
        super(entity);
        if(entity.getOrigen()!=null){
            origen = new UbicacionDTO(entity.getOrigen());
        }
        if(entity.getDestino()!=null){
            destino = new UbicacionDTO(entity.getDestino());
        }
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public TransporteEntity toEntity(){
        TransporteEntity entity = super.toEntity();
        
//        if(this.getImagenes()!=null){
//            List<ImagenEntity> imagenesEntity = new ArrayList<>();
//            for (ImagenDTO dtoImagen : getImagenes()) {
//                imagenesEntity.add(dtoImagen.toEntity());
//            }
//            entity.setImagenes(imagenesEntity);
//        }
        if(this.getOrigen()!=null){
            entity.setOrigen(origen.toEntity());
        }
        if(this.getDestino()!=null){
            entity.setDestino(destino.toEntity());
        }
        return entity;
    }
    
    /**
     * @return the ubicacion
     */
    public UbicacionDTO getOrigen(){
        return origen;
    }
    
    /**
     * @param orig the ubicacion to set
     */
    public void setOrigen(UbicacionDTO orig){
    this.origen = orig;
    }
    
    /**
     * @return the ubicacion
     */
    public UbicacionDTO getDestino(){
        return destino;
    }
    
    /**
     * @param dest the ubicacion to set
     */
    public void setDestino(UbicacionDTO dest){
    this.destino = dest;
    }
}
