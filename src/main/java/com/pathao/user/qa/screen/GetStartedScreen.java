package com.pathao.user.qa.screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GetStartedScreen {

    AndroidDriver androidDriver;

    public GetStartedScreen(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
    }

    @AndroidFindBy(id = "com.pathao.user.qa:id/btnNext")
    private WebElement nextButton;

    @AndroidFindBy(id = "com.pathao.user.qa:id/btnGetStarted")
    private WebElement getStartedButton;

    @AndroidFindBy(id = "com.pathao.user.qa:id/btnFake")
    private WebElement fakeButt;

    @Step("Tap on next button")
    public GetStartedScreen tapOnNextButton(){
        nextButton.click();
        return this;
    }

    @Step("Tap on GetStarted button")
    public GetStartedScreen tapOnGetStartedButton(){
        if (isGetStarted()){
            getStartedButton.click();
        }
        return this;
    }

    @Step("Get Started button is visible")
    public boolean isGetStarted(){
        return getStartedButton.isDisplayed();
    }

    @Step("Fake button is visible")
    public boolean isFake(){
        return fakeButt.isDisplayed();
    }


}
