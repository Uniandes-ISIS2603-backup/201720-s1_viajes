/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.EntretenimientoEntity;
import co.edu.uniandes.csw.viajes.entities.ImagenEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.rodriguez21
 */
public class EntretenimientoDetailDTO extends EntretenimientoDTO{
    
    // relación  cero o muchos imagenes
    private List<ImagenDTO> imagenes;
    
    /*
    * Relación a una ubicacion
    */
    private UbicacionDTO ubicacion;
    
    /*
    * Relación a una ubicacion
    */
    //private CompaniaDTO compania;
    
    /**
     * Constructor por defecto
     */
    public EntretenimientoDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public EntretenimientoDetailDTO(EntretenimientoEntity entity) {
        super(entity);
        
        if (entity.getImagenes() != null) {
            imagenes = new ArrayList<>();
            for (ImagenEntity entityImagen : entity.getImagenes()) {
                imagenes.add(new ImagenDTO(entityImagen));
            }
        }
        if (entity.getUbicacion() != null) {
            this.ubicacion = new UbicacionDTO(entity.getUbicacion());
        } else {
            entity.setUbicacion(null);
        }
        /*if (entity.getCompania() != null) {
            this.ubicacion = new CompaniaDTO(entity.getCompania());
        } else {
            entity.setUbicacion(null);
        }
        */
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public EntretenimientoEntity toEntity() {
        EntretenimientoEntity entretenimientoE = super.toEntity();
        
        if (this.getImagenes()!= null) {
            List<ImagenEntity> imagenesEntity = new ArrayList<>();
            for (ImagenDTO dtoImagen : getImagenes()) {
                imagenesEntity.add(dtoImagen.toEntity());
            }
            entretenimientoE.setImagenes(imagenesEntity);
        }
        
        if (this.getUbicacion() != null) {
            entretenimientoE.setUbicacion(this.getUbicacion().toEntity());
        }
        
        /*if (this.getCompania() != null) {
            entretenimientoE.setUbicacion(this.getCompania().toEntity());
        }
        */
        return entretenimientoE;
    }
    
    /**
     * @return the imagenes
     */
    public List<ImagenDTO> getImagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setImagens(List<ImagenDTO> imagenes) {
        this.imagenes = imagenes;
    }
    
    public void setUbicacion(UbicacionDTO ubicacion) {
        this.ubicacion = ubicacion;
    }

    public UbicacionDTO getUbicacion() {
        return ubicacion;
    }
    
    /*public void setCompania(CompaniaDTO compania) {
        this.compania = compania;
    }

    public CompaniaDTO getCompania() {
        return compania;
    }
    */
}