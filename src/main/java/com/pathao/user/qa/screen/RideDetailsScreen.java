package com.pathao.user.qa.screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RideDetailsScreen {
    AndroidDriver androidDriver;

    public RideDetailsScreen(AndroidDriver androidDriver ) {
        this.androidDriver = androidDriver;
        PageFactory.initElements( new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy( id = "com.pathao.user.qa:id/tvReportIssue")
    private WebElement reportIssueTextField;


    @Step("Tap on the Report Issue button")
    public void tapOnReportIssue(){
        reportIssueTextField.click();
    }
}
