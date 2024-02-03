package com.pathao.user.qa.listeners;

import com.pathao.user.qa.testcases.basetests.APKBaseTest;
import com.pathao.user.qa.testcases.basetests.InstalledAppBaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        String testPackage = result.getInstance().getClass().getPackageName();

        String apkPackage = "com.pathao.user.qa.testcases.apktest";
        String appPackage = "com.pathao.user.qa.testcases.installedapptest";

        System.out.println("Failed Test Package "+ testPackage);
        System.out.println("Class "+ result.getTestContext().getClass().getName());

        if (apkPackage.equals(testPackage)){
            saveScreenshot("Failed apk: "+ result.getMethod().getMethodName(), APKBaseTest.getAndroidAPKDriver());
        }

        if (appPackage.equals(testPackage)){
            saveScreenshot("Failed app: "+ result.getMethod().getMethodName(), InstalledAppBaseTest.getDriver());
        }

    }

    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] saveScreenshot(String name, AndroidDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
