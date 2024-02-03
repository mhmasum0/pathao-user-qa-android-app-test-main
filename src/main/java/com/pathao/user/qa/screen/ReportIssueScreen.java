package com.pathao.user.qa.screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ReportIssueScreen {
    AndroidDriver androidDriver;

    public ReportIssueScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy( uiAutomator = "text(\"I would like a refund\")")
    private WebElement refundIssueReport;

    @AndroidFindBy( uiAutomator = "text(\"My rider/captain was unprofessional\")")
    private WebElement captainUnprofessional;

    @AndroidFindBy( uiAutomator = "text(\"My rider/captain was rude\")")
    private WebElement captainWasRudeText;

    @AndroidFindBy( uiAutomator = "text(\"I was overcharged\")")
    private WebElement overChargeReport;

    @AndroidFindBy(id = "com.pathao.user.qa:id/rlTextInputContainer")
    private List<WebElement> allInputContainer;

    public void tapOnRefundIssueReport(){
        refundIssueReport.click();
    }

    public void tapOverChargeReport(){
        overChargeReport.click();
    }

    @Step("Tap on the Captain is unprofessional")
    public void tapOnCaptainUnprofessional(){
        captainUnprofessional.click();
    }

    @Step("Tap on the Captain was rude")
    public void tapCaptainWasRude(){
        captainWasRudeText.click();
    }

}
