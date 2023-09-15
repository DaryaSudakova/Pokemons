package helpers;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {
    private static final String PATH = "src/test/resources/test.properties";
    private static Properties properties = new Properties();

//    public static Properties getProperties () {
//        if (properties == null) {
//            loadProperties();
//        }
//        return properties;
//    }

    static {
        try (FileInputStream inputStream = new FileInputStream(PATH)){
            properties.load(inputStream);
        } catch (Throwable e) {
            String msg = "Can't initialize configuration properties bundle.";
            throw new RuntimeException(msg, e);
        }
    }

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    private static void loadProperties () {
        try (FileInputStream inputStream = new FileInputStream(PATH)){
            properties.load(inputStream);
        } catch (Throwable e) {
            String msg = "Can't initialize configuration properties bundle.";
            throw new RuntimeException(msg, e);
        }
    }

    public static String getBaseURL() {
        return properties.getProperty("base.url");
    }
}
