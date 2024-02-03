package com.pathao.user.qa.testcases.apktest;


import com.pathao.user.qa.screen.GetStartedScreen;
import com.pathao.user.qa.screen.LoginScreen;
import com.pathao.user.qa.screen.MainScreen;
import com.pathao.user.qa.screen.PermissionScreen;
import com.pathao.user.qa.testcases.basetests.APKBaseTest;
import com.pathao.user.qa.utils.ClearNotification;
import com.pathao.user.qa.utils.ConfigFileReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class LoginWithOTPTest extends APKBaseTest {

    int mobileNumber = Integer.parseInt(ConfigFileReader.getConfigProperty("mobileNumber"));

    @Test(priority = 1, description = "App Get Started")
    @Description("App Get Started")
    public void appGetStartedTest(){

        new GetStartedScreen(androidAPKDriver)
                .tapOnNextButton()
                .tapOnGetStartedButton();
    }

    @Test(priority = 2, description = "Login request with OTP")
    @Description("Login request with OTP")
    public void sendOTPTest(){

        LoginScreen loginScreen = new LoginScreen(androidAPKDriver);

        loginScreen.inputMobileNumber(mobileNumber);
        // Clear Notification
        new ClearNotification(androidAPKDriver).clearNotification();
        // OTP request
        loginScreen.sendOTPRequest();

    }

    @Test(priority = 3, description = "Verify the OTP")
    @Description("Verify the OTP")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyOTPTest(){
        LoginScreen loginScreen = new LoginScreen(androidAPKDriver);
        loginScreen.waitForOTP();
        String OTP = loginScreen.readOTP();
        loginScreen.inputOTP(OTP);
        loginScreen.submitOTP();
    }

    @Test(priority = 4, description = "App permission")
    @Description("App permission")
    public void setupAppPermissions(){
        PermissionScreen permissionScreen = new PermissionScreen(androidAPKDriver);
        permissionScreen.waitForPermission();

        permissionScreen.setupAppPermission();
    }

    @Test(priority = 5, description = "Skip the app tutorial")
    @Description("Skip the app tutorial")
    public void skipAppTutorial() throws InterruptedException {

        MainScreen mainScreen = new MainScreen(androidAPKDriver);
        mainScreen.skipTutorial();
    }
}
