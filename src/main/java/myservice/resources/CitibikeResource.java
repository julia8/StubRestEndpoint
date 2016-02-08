package myservice.resources;

import com.google.gson.Gson;
import myservice.api.Response;
import myservice.client.CitiBikeStationData;
import myservice.util.ConfigHandler;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStreamReader;

@Path("/citi")
@Produces(MediaType.APPLICATION_JSON)
public class CitibikeResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(CitibikeResource.class);
    private HttpClient client;

    public CitibikeResource(HttpClient client) {
        this.client = client;
    }

    @GET
    public Response getNumStations() {
        HttpGet getRequest = null;
        try {
            String url=ConfigHandler.get("citibike.url");
            getRequest = new HttpGet(url);
            HttpResponse resp = client.execute(getRequest);

            InputStreamReader streamReader = new InputStreamReader(resp.getEntity().getContent());
            Gson g = new Gson();
            CitiBikeStationData data = g.fromJson(streamReader, CitiBikeStationData.class);
            Response myResponse = new Response(200, "OK");
            myResponse.setContent("There are " + data.getStationBeanList().size() + " stations");
            return myResponse;
        }catch(Exception e) {
            LOGGER.error("Cannot read", e);
            return new Response(500, "Unable to process");
        } finally {
            if(getRequest != null) {
                getRequest.releaseConnection();
            }
        }
    }

}
