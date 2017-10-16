/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.UsuarioDetailDTO;
import co.edu.uniandes.csw.viajes.ejb.UsuarioLogic;
import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Vanessa Huertas <tv.huertas10>
 */
@Path("usuarios")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class UsuarioResource {
    
    @Inject
    UsuarioLogic usuarioLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    /**
     * POST http://localhost:8080/viajesp-web/api/usuarios Ejemplo
     * json: { "name":"Norma" }
     *
     * @param usuario correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "UsuarioDetailDTO", "id": 1, "name": "Norma" }
     */
    @POST
    public UsuarioDetailDTO createUsuario(UsuarioDetailDTO usuario)  {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        UsuarioEntity usuarioEntity = usuario.toEntity();
        // Invoca la lógica para crear el usuario nuevo
        UsuarioEntity nuevoUsuario = usuarioLogic.createUsuario(usuarioEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new UsuarioDetailDTO(nuevoUsuario);
    }

    /**
     * GET para todos los usuarios.
     * http://localhost:8080/viajes-web/api/usuarios
     *
     * @return la lista de todas las bloges en objetos json DTO.
     * @throws WebApplicationException
     */
    @GET
    public List<UsuarioDetailDTO> getUsuario(){
        return listEntity2DetailDTO(usuarioLogic.getUsuarios());
    }

    /**
     * GET para un usuario
     * http://localhost:8080/viajesp-web/api/usuarios/1
     *
     * @param id corresponde al id de la usuario buscada.
     * @return El usuario encontrada. Ejemplo: { "type": "blogDetailDTO",
     * "id": 1, "name": "Norma" }
     * En caso de no existir el id de el usuario buscada se retorna un 404 con
     * el mensaje.
     */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDetailDTO getUsuario(@PathParam("id") Long id){
        UsuarioEntity entity = usuarioLogic.getUsuario(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /usuarios/" + id + " no existe.", 404);
        }
        return new UsuarioDetailDTO(usuarioLogic.getUsuario(id));
    }

    /**
     * PUT http://localhost:8080/viajesp-web/api/usuarios/1 Ejemplo
     * json { "id": 1, "name": "cambio de nombre" }
     *
     * @param id corresponde a la usuario a actualizar.
     * @param usuario corresponde a al objeto con los cambios que se van a
     * realizar.
     * @return La usuario actualizada.
     * En caso de no existir el id de la blog a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDetailDTO updateBlog(@PathParam("id") Long id, UsuarioDetailDTO usuario)  {
        usuario.setId(id);
        UsuarioEntity entity = usuarioLogic.getUsuario(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /usuarios/" + id + " no existe.", 404);
        }
        return new UsuarioDetailDTO(usuarioLogic.updateUsuario(id,usuario.toEntity()));
    }

    /**
     * DELETE http://localhost:8080/viajesp-web/api/usuarios/1
     *
     * @param id corresponde al usuario a borrar.
     * En caso de no existir el id del Usuario a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteUsuario(@PathParam("id") Long id)  {
        UsuarioEntity entity = usuarioLogic.getUsuario(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /usuarios/" + id + " no existe.", 404);
        }
        usuarioLogic.deleteUsuario(id);
    }
    
    @Path("usuariosId: \\d+}/itinerarios")
    public Class<UsuarioItinerariosResource> getUsuarioItinerariosResource(@PathParam("usuariosId") Long usuariosId) {
        UsuarioEntity entity = usuarioLogic.getUsuario(usuariosId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /usuarios/" + usuariosId + "/itinerarios no existe.", 404);
        }
        return UsuarioItinerariosResource.class;
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos UsuarioEntity a una lista de
     * objetos UsuarioDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Usuarios de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Usuarios en forma DTO (json)
     */
    private List<UsuarioDetailDTO> listEntity2DetailDTO(List<UsuarioEntity> entityList) {
        List<UsuarioDetailDTO> list = new ArrayList<>();
        for (UsuarioEntity entity : entityList) {
            list.add(new UsuarioDetailDTO(entity));
        }
        return list;
    }
}
