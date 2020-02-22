package com.zeroBank.utilities;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;

/*
Will reads configuration.properties file
 */
public class ConfigurationReader {
private static Properties properties;

static {
    try{
        String path = "configuration.properties";
        FileInputStream input = new FileInputStream(path);
        properties = new Properties();
        properties.load(input);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static String get (String keyName){
    return properties.getProperty(keyName);
}

}
