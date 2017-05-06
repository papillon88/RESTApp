package com.eightyeight.papillon.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by papillon on 5/6/2017.
 */
@Provider
public class GenericMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {
        ErrorMessage err =  new ErrorMessage(exception.getMessage(),500,"generic error");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(err)
                .build();
    }
}
