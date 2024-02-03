package com.pathao.user.qa.helper;

import com.pathao.user.qa.utils.ExplicitWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

public class OpenAppFindElement {
    AndroidDriver androidDriver;

    public OpenAppFindElement(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    @Step("Launch the application")
    public void openAppAndFindElement(){
            new ExplicitWait(androidDriver)
                    .waitForElement(30,AppiumBy.xpath("//android.widget.TextView[@text='Take a ride to']"));

            androidDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Take a ride to']")).click();

    }

}
