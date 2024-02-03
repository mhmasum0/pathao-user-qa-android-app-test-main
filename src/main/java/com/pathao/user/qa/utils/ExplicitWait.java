package com.pathao.user.qa.utils;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {

    AndroidDriver androidDriver;

    public ExplicitWait(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
    }

    public void waitForElement(int seconds,By locator){
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(seconds));
        wait.until( ExpectedConditions.presenceOfElementLocated( locator ) );
    }
}
