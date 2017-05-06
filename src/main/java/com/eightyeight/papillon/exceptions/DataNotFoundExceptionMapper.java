package com.eightyeight.papillon.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by papillon on 5/6/2017.
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    @Override
    public Response toResponse(DataNotFoundException exception) {
        ErrorMessage err =  new ErrorMessage(exception.getMessage(),404,"dummy");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(err)
                .build();
    }
}
