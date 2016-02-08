package myservice;

import io.dropwizard.Application;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.setup.Environment;
import myservice.health.DummyHealthCheck;
import myservice.resources.CitibikeResource;
import myservice.resources.HappyResource;
import org.apache.http.client.HttpClient;

public class App extends Application<AppConfig> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    public void run(AppConfig config, Environment env) {
        final HttpClient client = new HttpClientBuilder(env).using(config.getHttpClientConfiguration())
                .build("http-client");

        env.healthChecks().register("Dummy", new DummyHealthCheck());
        env.jersey().register(new HappyResource());
        env.jersey().register(new CitibikeResource(client));
    }

}
