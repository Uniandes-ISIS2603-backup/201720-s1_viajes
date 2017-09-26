/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;


import co.edu.uniandes.csw.viajes.entities.GuiaEntity;


/**
 *
 * @author Juan
 */
public class GuiaDetailDTO extends GuiaDTO
{
    
    //private CompaniaDTO compania;
    
     public GuiaDetailDTO() {
        super();
    }
     
     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
     /*
    public GuiaDetailDTO(GuiaEntity entity) {
        super(entity);
        if (entity.getCompania()!=null) {
         //   this.compania=new CompaniaDTO(entity.getCompania());
        }
        else{
            entity.setCompania(null);
        }
    }
    */
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
     /*
    @Override
    public GuiaEntity toEntity() {
        GuiaEntity guiaE = super.toEntity();
        if (this.getCompania()!=null) {
//            guiaE.setCompania(this.getCompania().toEntity());
        }
        return guiaE;
    }
    
    */
    
  /*
    public CompaniaDTO getCompania() {
        return compania;
    }

    public void setCompania(CompaniaDTO compania) {
        this.compania = compania;
    }

*/    
     
}
