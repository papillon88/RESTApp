package com.eightyeight.papillon.endpoints;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by papillon on 5/4/2017.
 */

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("/annotations")
    public String getParamUsingAnnotation(@MatrixParam("param") String matrixParam,
                                          @HeaderParam("headerVal") String header,
                                          @CookieParam("name") String cookie){
        return "Matrix Param : " + matrixParam + " Header Param : "+ header;
    }

    @GET
    @Path("/context")
    public String getParamUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){

        String line = uriInfo.getAbsolutePath().toString();
        String cooky = headers.getCookies().toString();
        return line+" "+cooky;
    }


}
