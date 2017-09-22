/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.CompaniaEntity;
import co.edu.uniandes.csw.viajes.entities.OficinaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class CompaniaDetailDTO extends CompaniaDTO
{
   // private List<OficinaDTO> oficinas;
    
     public CompaniaDetailDTO() {
        super();
    }
    
     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
     
    public CompaniaDetailDTO(CompaniaEntity entity) {
        super(entity);
        /*
        if (entity.getOficinas()!=null) {
         //    oficinas = new ArrayList<>();
            for (OficinaEntity entityOficina : entity.getOficinas()) {
            //   oficinas.add(new OficinaDTO(entityOficina));
            }
        }
        */
    }
    
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public CompaniaEntity toEntity() {
        CompaniaEntity companiaE = super.toEntity();
       /*if (this.getOficinas!=null) {
        List<OficinaEntity> oficinasEntity = new ArrayList<>();
      //      for (OficinaDTO dtoOficina : getOficinas()) {
      //         oficinasEntity.add(dtoOficina.toEntity());
      //     }
            companiaE.setOficinas(oficinasEntity);
        //}
    */
        return companiaE;
         
    }
     
    
    //public OficinaDTO getOficinas() {
    //    return oficinas;
    //}

    //public void setOficina(OficinaDTO oficina) {
    //    this.oficina = oficina;
    //}
}
