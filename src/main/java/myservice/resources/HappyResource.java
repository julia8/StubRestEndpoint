package myservice.resources;

import myservice.api.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/happy/{occasion}")
@Produces(MediaType.APPLICATION_JSON)
public class HappyResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(HappyResource.class);

    @GET
    @Produces("application/json")
    public Response getResponse(@QueryParam("to") String name, @PathParam("occasion") String occasion) {
        Response resp = new Response(200, "Ok");
        resp.setContent("Happy " + occasion + " to " + name);
        return resp;
    }
}
