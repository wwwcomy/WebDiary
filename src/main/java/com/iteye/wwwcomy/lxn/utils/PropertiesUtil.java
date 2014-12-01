package com.iteye.wwwcomy.lxn.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties loadProperties(String file) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(new File(file)));
        return prop;
    }

    public static Properties loadPropertiesFromClassPath(String file) throws IOException {
        Properties prop = new Properties();
        prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(file));
        return prop;
    }

    public static String getProp(String file, String key) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(new File(file)));
        return prop.getProperty(key);
    }

    public static String getProp(String file, String key, String defaultValue) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(new File(file)));
        return prop.getProperty(key, defaultValue);
    }
}
