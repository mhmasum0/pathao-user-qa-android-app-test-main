package com.pathao.user.qa.screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReportSubmissionScreen {
    AndroidDriver androidDriver;

    public ReportSubmissionScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy (id = "com.pathao.user.qa:id/rlTextInputContainer")
    private List<WebElement> allInputContainer;

    @AndroidFindBy(id = "com.pathao.user.qa:id/etInput")
    private List<WebElement> inputFields;

    @AndroidFindBy (className = "android.widget.Button")
    private WebElement submitButton;

    @Step("Captain was rude case {behaviourWasRude} ")
    public void captainWasRude(String behaviourWasRude) {
        allInputContainer.get(0).click();
        if (inputFields.get(0).isDisplayed()){
            inputFields.get(0).sendKeys(behaviourWasRude);
        }
    }

    @Step("Tap on submit report button d")
    public void submitIssue(){
        submitButton.click();
    }


}
