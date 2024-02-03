package com.pathao.user.qa.testcases.basetests;

import com.pathao.user.qa.core.Constants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.SessionNotCreatedException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class InstalledAppBaseTest {
    public static AndroidDriver androidDriver;

    @BeforeClass
    public void setup(){

        UiAutomator2Options appOptions = new UiAutomator2Options()
                .setUdid(Constants.DEVICE_NAME)
                .setPlatformName("Android")
                .setAutomationName("uiautomator2")
                .setAppPackage(Constants.APP_PACKAGE)
                .setAppActivity(Constants.APP_MAIN_ACTIVITY)
                .setNoReset(true)
                .eventTimings();
        try {

            URL appiumServerUrl = new URL("http://"+ Constants.SERVER_IP + ":" + Constants.SERVER_PORT);

            androidDriver = new AndroidDriver(appiumServerUrl, appOptions);
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            System.out.println("Driver setup Complete:App");
        } catch (SessionNotCreatedException appiumSessionEx){
            System.out.println("Appium Server is not running or device is not connected");
            System.out.println(appiumSessionEx.getRawMessage());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        androidDriver.terminateApp(androidDriver.getCurrentPackage());
        androidDriver.quit();
    }

    public static AndroidDriver getDriver(){
        return androidDriver;
    }

}
