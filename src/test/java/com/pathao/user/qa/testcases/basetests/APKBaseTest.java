package com.pathao.user.qa.testcases.basetests;

import com.pathao.user.qa.core.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.SessionNotCreatedException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class APKBaseTest {
    public static AndroidDriver androidAPKDriver;

    @BeforeClass
    public void setup(){

        UiAutomator2Options uiAutomator2APKOptions = new UiAutomator2Options()
                .setUdid(Constants.DEVICE_NAME)
                .setPlatformName("Android")
                .setAutomationName("uiautomator2")
                .setApp(Constants.APP_PATH)
                .setNewCommandTimeout(Duration.ofSeconds(60));

        try {

            URL appiumServerUrl = new URL("http://"+ Constants.SERVER_IP + ":" + Constants.SERVER_PORT);

            androidAPKDriver = new AndroidDriver(  appiumServerUrl, uiAutomator2APKOptions);
            androidAPKDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            System.out.println("Driver setup Complete:APK");

        } catch (SessionNotCreatedException sessionNotCreatedException){
            System.out.println("Appium Server is not running or device is not connected");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        androidAPKDriver.quit();
    }

    public static AndroidDriver getAndroidAPKDriver(){
        return androidAPKDriver;
    }
}
