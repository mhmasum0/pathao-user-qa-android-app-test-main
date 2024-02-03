package com.pathao.user.qa.utils;
// Not specific to the project

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;

public class ClearNotification {
    AndroidDriver androidDriver;

    public ClearNotification(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    @Step("Clear the notification")
    public void  clearNotification( ){
        androidDriver.openNotifications();

        boolean isScrollable = Boolean.parseBoolean(androidDriver.findElement(AppiumBy.id("com.android.systemui:id/notification_stack_scroller")).getAttribute("scrollable"));
        boolean isClearButton = androidDriver.findElements(AppiumBy.id("com.android.systemui:id/dismiss_text")).size() > 0;

        if ( !isScrollable && !isClearButton){
            androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        }

        if ( isClearButton) {
            clearNotificationGetBack();
        }
        if ( isScrollable) {
            Scroll scroll = new Scroll(androidDriver);
            scroll.scrollForward(1);
            clearNotificationGetBack();
        }

    }

    private void clearNotificationGetBack(){
        androidDriver.findElement(AppiumBy.id("com.android.systemui:id/dismiss_text")).click();
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
