package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author MSI
 */
public class LoadConfig {

    private static final String CONFIG_PATH = "/config.properties";
    private static LoadConfig intanse;
    private Properties properties = new Properties();

    public LoadConfig() {
        readConfig();
    }

    public static LoadConfig getIntanse() {
        if (intanse == null) {
            intanse = new LoadConfig();
        }
        return intanse;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public Properties getProperties() {
        return properties;
    }

    private void readConfig() {
        InputStream inputStream = null;
        try {
            inputStream = getClass().getResourceAsStream(CONFIG_PATH);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
