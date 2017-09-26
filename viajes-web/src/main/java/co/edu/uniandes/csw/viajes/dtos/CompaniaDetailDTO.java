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
    /*
    List de oficinas
    */
    private List<OficinaDTO> oficinas;
    
    /*
    Constructor por defecto
    */
    public CompaniaDetailDTO()
    {
        super();
    }
    
    /*
    Constructor para  transformar un Entity en DTO
    @param entity 
    */
    public CompaniaDetailDTO (CompaniaEntity entity )
    {
        super(entity);
        if (entity!=null) {
            oficinas= new ArrayList<>();
            for(OficinaEntity entityOficina : entity.getOficinas())
            {
                oficinas.add(new OficinaDTO(entityOficina));
            }
        }
    }
    
    /**
     * Transformar un DTO  en una  Entity 
     * @return una  CompaniaEntity
     */
    public CompaniaEntity toEntity()
    {
        CompaniaEntity companiaE= super.toEntiy();
        if (oficinas!=null) {
            List<OficinaEntity> oficinaEntity= new ArrayList<>();
            for(OficinaDTO dtoOficina : oficinas)
            {
                oficinaEntity.add(dtoOficina.toEntity());
            }
            companiaE.setOficinas(oficinaEntity);
        }
        return companiaE;
    }


    /**
     * Obtener las oficinas 
     * @return  oficinas
     */
    public List<OficinaDTO> getOficinas() {
        return oficinas;
    }

    /**
     * Actualizar las Oficinas
     * @param oficinas 
     */
    public void setOficinas(List<OficinaDTO> oficinas) {
        this.oficinas = oficinas;
    }
    
    
}
