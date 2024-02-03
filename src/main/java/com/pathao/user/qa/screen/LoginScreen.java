package com.pathao.user.qa.screen;



import com.pathao.user.qa.utils.ExplicitWait;
import com.pathao.user.qa.utils.ScreenShot;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginScreen {

    AndroidDriver androidDriver;

    public LoginScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(id = "com.pathao.user.qa:id/etPhoneNumber")
    private WebElement mobileNumberInput;

    @AndroidFindBy(id = "com.pathao.user.qa:id/btnContinue")
    private WebElement sendOTPRequest;

    @AndroidFindBy(id = "android:id/message_text")
    private WebElement originalMessageText;

    @AndroidFindBy(id = "com.pathao.user.qa:id/btnSubmit")
    private WebElement otpSubmitButton;

    @Step("Type the mobile number {mobileNumber} to login")
    public void inputMobileNumber(int mobileNumber){
        mobileNumberInput.sendKeys(String.valueOf(mobileNumber));
    }

    @Step("Send OTP Request is sent")
    public void sendOTPRequest() {
        sendOTPRequest.click();
    }

    @Step("Read the OTP")
    public String readOTP(){
        String OTP;

        String message = originalMessageText.getText();

        ScreenShot screenShot = new ScreenShot(androidDriver);
        screenShot.pageScreenshot();

        OTP = this.extractOTP(message);

        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));

        return OTP;

    }

    @Step("Submit the OTP")
    public void submitOTP(){
        otpSubmitButton.click();
    }

    @Step("OTP Received")
    public void waitForOTP(){
        androidDriver.openNotifications();

        try {
            new ExplicitWait(androidDriver)
                    .waitForElement( 15, AppiumBy.id("android:id/message_text"));
            Allure.addAttachment("OTP is received", new ByteArrayInputStream( androidDriver.getScreenshotAs(OutputType.BYTES)));
        } catch (TimeoutException timeout){
            timeout.printStackTrace();
            Allure.addAttachment("OTP is not received, waited "+ 15 +"seconds long", timeout.getRawMessage());
        }

    }

    @Step("Extract the OTP from the message")
    private String extractOTP( String message){

        String extractedOTP = null;

        Pattern pattern = Pattern.compile("(\\d{6})");
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            extractedOTP = matcher.group(1);
        }
        return extractedOTP;
    }

    @Step("Enter the OTP {OTP}")
    public void inputOTP(String OTP ) {

        String[] digitSelectors = {
                "com.pathao.user.qa:id/etDigitOne",
                "com.pathao.user.qa:id/etDigitTwo",
                "com.pathao.user.qa:id/etDigitThree",
                "com.pathao.user.qa:id/etDigitFour",
                "com.pathao.user.qa:id/etDigitFive",
                "com.pathao.user.qa:id/etDigitSix"
        };

        for (int i = 0; i < digitSelectors.length; i++) {
            String digit = String.valueOf(OTP.charAt(i));
            androidDriver.findElement(AppiumBy.id(digitSelectors[i])).sendKeys(digit);
        }
    }

}
