package com.deepaksp.odg.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

    public static String get(String propertyName) throws IOException {
        Properties prop = new Properties();
        InputStream is = new FileInputStream(
                System.getProperty("user.dir").concat("/src/main/resources/odg.properties"));
        prop.load(is);
        return prop.getProperty(propertyName);
    }
}
