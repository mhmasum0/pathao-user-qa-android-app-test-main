package com.pathao.user.qa.utils;

import com.pathao.user.qa.core.Constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    public static String getConfigProperty(String propertyName){

        String configPath = "";
        try(InputStream inputStream = new FileInputStream(Constants.CONFIG_PATH)) {

            Properties properties = new Properties();
            properties.load(inputStream);
            configPath = properties.getProperty(propertyName);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO exception: " + e.getMessage());
            e.printStackTrace();
        }

        return configPath;
    }
}