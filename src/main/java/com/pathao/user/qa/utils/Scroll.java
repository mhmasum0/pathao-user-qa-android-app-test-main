package com.pathao.user.qa.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Scroll {
    AndroidDriver androidDriver;

    public Scroll(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public void scrollToElement(int instance, String searchText){
        androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable( new UiSelector().className(\"android.widget.ScrollView\").instance("+ instance +")).scrollIntoView(new UiSelector().text(\"" + searchText + "\"));"));
    }

    public void scrollForward(int instance){
        androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").instance("+ instance +")).scrollForward()"));

    }
}
