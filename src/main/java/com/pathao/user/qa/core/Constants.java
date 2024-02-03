package com.pathao.user.qa.core;


import com.pathao.user.qa.utils.ConfigFileReader;

import java.io.File;

public class Constants {
    public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "/screenshots";
    public static final String CONFIG_PATH = System.getProperty("user.dir") + File.separator +"src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"config.properties";
    public static final String DEVICE_NAME = ConfigFileReader.getConfigProperty("deviceName");
    public static final String APP_PATH = System.getProperty("user.dir") + ConfigFileReader.getConfigProperty("apkPath");
    public static final String SERVER_IP = ConfigFileReader.getConfigProperty("serverIP");
    public static final String SERVER_PORT = ConfigFileReader.getConfigProperty("serverPort");
    public static final String APP_PACKAGE = ConfigFileReader.getConfigProperty("appPackage");
    public static final String APP_MAIN_ACTIVITY = ConfigFileReader.getConfigProperty("appMainActivity");


}
