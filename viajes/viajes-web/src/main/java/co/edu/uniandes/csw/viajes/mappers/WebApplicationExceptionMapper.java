/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.mappers;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author sa.silva1
 */
@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    /**
     * Generador de una respuesta a partir de una excepción
     * WebApplicationException
     *
     * @param exception excepión a convertir a una respuesta REST
     * @return
     */
    @Override
    public Response toResponse(WebApplicationException exception) {

        return Response.status(exception.getResponse().getStatus())// Se recibe el status
                .entity(getInitCause(exception).getLocalizedMessage())// Se envía la causa
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();

    }

    private Throwable getInitCause(Throwable e) {
        if (e.getCause() != null) {
            return getInitCause(e.getCause());
        } else {
            return e;
        }

    }
}
