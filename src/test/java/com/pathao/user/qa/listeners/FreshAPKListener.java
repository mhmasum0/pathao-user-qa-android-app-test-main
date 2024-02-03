package com.pathao.user.qa.listeners;

import com.pathao.user.qa.testcases.basetests.APKBaseTest;
import com.pathao.user.qa.testcases.basetests.InstalledAppBaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FreshAPKListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        if (APKBaseTest.getAndroidAPKDriver() != null) {
            saveScreenshot("Failed: "+ result.getMethod().getMethodName(), APKBaseTest.getAndroidAPKDriver());
        }

    }

    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] saveScreenshot(String name, AndroidDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Test passed {0}")
    public String testPass(String tests){
        return tests;
    }

}
