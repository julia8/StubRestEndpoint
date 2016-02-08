package myservice.util;

import com.typesafe.config.ConfigFactory;

public class ConfigHandler {
    private static com.typesafe.config.Config config = ConfigFactory.defaultApplication();

    public static String get(String propertyName) {
        return config.getString(propertyName);
    }
}
