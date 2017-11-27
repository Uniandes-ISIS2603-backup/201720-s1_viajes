/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.ItinerarioEntity;
import co.edu.uniandes.csw.viajes.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vanessa Huertas <tv.huertas10>
 */
public class UsuarioDetailDTO extends UsuarioDTO {

    /**
     * Lista de tarjetas que le pertenecen al usuario
     */
    private List<TarjetaCreditoDTO> tarjeta;

    /**
     * Lista de itinerarios planeados por el usuario
     */
    private List<ItinerarioDTO> itinerario;

    /**
     * Blog en el que el usuario interactua
     */
    private BlogDTO blog;

    /**
     * Constructor por defecto
     */
    public UsuarioDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public UsuarioDetailDTO(UsuarioEntity entity) {
        super(entity);

        if (entity.getTarjetas() != null) {
            tarjeta = new ArrayList<>();
            for (TarjetaCreditoEntity entityTarjetaCredito : entity.getTarjetas()) {
                tarjeta.add(new TarjetaCreditoDTO(entityTarjetaCredito));
            }
        }

        if (entity.getItinerarios() != null) {
            itinerario = new ArrayList<>();
            for (ItinerarioEntity entityItinerario : entity.getItinerarios()) {
                itinerario.add(new ItinerarioDTO(entityItinerario));
            }
        }

        if (entity.getBlog() != null) {
            this.blog = new BlogDTO(entity.getBlog());
        } else {
            entity.setBlog(null);
        }
    }

    /**
     * Blog en el que el usuario interactua
     *
     * @return blog
     */
    public BlogDTO getBlog() {
        return blog;
    }

    /**
     * Lista de itinerarios planeados por el usuario
     *
     * @return itinerario
     */
    public List<ItinerarioDTO> getItinerario() {
        return itinerario;
    }

    /**
     * Lista de tarjetas que le pertenecen al usuario
     *
     * @return tarjeta
     */
    public List<TarjetaCreditoDTO> getTarjeta() {
        return tarjeta;
    }

    /**
     * Agrega el nuevo blog del usuario
     *
     * @param blog
     */
    public void setBlog(BlogDTO blog) {
        this.blog = blog;
    }

    /**
     * Agrega un nuevo itinerario a la lista
     *
     * @param itinerario
     */
    public void setItinerario(List<ItinerarioDTO> itinerario) {
        this.itinerario = itinerario;
    }

    /**
     * Se agrega una nueva tarjeta a la lista que le pertenecen al usuario
     *
     * @param tarjeta
     */
    public void setTarjeta(List<TarjetaCreditoDTO> tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return
     */
    @Override
    public UsuarioEntity toEntity() {
        UsuarioEntity usuarioE = super.toEntity();

        if (this.getTarjeta() != null) {
            List<TarjetaCreditoEntity> tarjetaCreditoEntity = new ArrayList<>();
            for (TarjetaCreditoDTO dtoTarjetaCredito : getTarjeta()) {
                tarjetaCreditoEntity.add(dtoTarjetaCredito.toEntity());
            }
            usuarioE.setTarjetas(tarjetaCreditoEntity);
        }

        if (this.getItinerario() != null) {
            List<ItinerarioEntity> itinerarioEntity = new ArrayList<>();
            for (ItinerarioDTO dtoItinerario : getItinerario()) {
                itinerarioEntity.add(dtoItinerario.toEntity());
            }
            usuarioE.setItinerarios(itinerarioEntity);
        }

        if (this.getBlog() != null) {
            usuarioE.setBlog(this.getBlog().toEntity());
        }
        return usuarioE;
    }
}
