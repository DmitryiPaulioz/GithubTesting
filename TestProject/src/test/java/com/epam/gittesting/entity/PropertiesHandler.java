package com.epam.gittesting.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertiesHandler {
    private Properties dataProperties;
    private Properties environmentProperties;
    private String dataPath = "\\src\\test\\resources\\datafile.properties";
    private String environmentPath = "\\src\\test\\resources\\environment.properties";

    public PropertiesHandler(){
        try {
            FileInputStream dataLocator = new FileInputStream(System.getProperty("user.dir") + dataPath);
            FileInputStream environmentLocator = new FileInputStream(System.getProperty("user.dir") + environmentPath);
            dataProperties = new Properties();
            environmentProperties = new Properties();
            dataProperties.load(dataLocator);
            environmentProperties.load(environmentLocator);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getData(String propertyName){
        return dataProperties.getProperty(propertyName);
    }
    public String getEnvironment(String propertyName){
        return environmentProperties.getProperty(propertyName);
    }
}
