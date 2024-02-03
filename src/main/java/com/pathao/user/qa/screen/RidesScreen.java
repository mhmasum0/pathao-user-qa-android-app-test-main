package com.pathao.user.qa.screen;

import com.pathao.user.qa.utils.ExplicitWait;
import com.pathao.user.qa.utils.ScreenShot;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class RidesScreen {
    AndroidDriver androidDriver;

    public RidesScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy( id = "com.pathao.user.qa:id/etAddress")
    private WebElement addressInput;

    @AndroidFindBy( id = "com.pathao.user.qa:id/destinationAddressWidget")
    private WebElement addressInputArea;

    @AndroidFindBy ( id = "com.pathao.user.qa:id/tvAddress")
    private List<WebElement> destinationAddress;

    @AndroidFindBy ( id = "com.pathao.user.qa:id/btnConfirm")
    private WebElement confirmButton;

    @AndroidFindBy ( id = "com.pathao.user.qa:id/btnSendRequest")
    private WebElement findRiderButton;

    @AndroidFindBy ( id = "com.pathao.user.qa:id/rlRideOption")
    private WebElement rideFare;

    @Step("Tap on the Address")
    public void tapOnAddress(){
        new ExplicitWait(androidDriver)
                .waitForElement(5, AppiumBy.id("com.pathao.user.qa:id/etAddress"));
        addressInput.click();
    }

    @Step("Tap on the address input area")
    public void tapOnAddressInputArea(){
        addressInputArea.click();
    }

    @Step("Type the destination address {destinationAddress}")
    public void typeDestinationAddress(String destinationAddress){
        addressInput.sendKeys(destinationAddress);
    }

    @Step("Select the destination")
    public void selectRandomDestination(){

        Random random = new Random();
        int min = 0;
        int max = destinationAddress.size();
        int randomDestinationIndex = random.nextInt( max + min ) + min;

        destinationAddress.get( randomDestinationIndex ).click();
    }

    public void tapOnConfirm(){
        findRiderButton.click();
    }

    public boolean checkFindRider(){
        ScreenShot screenShot = new ScreenShot(androidDriver);
        screenShot.pageScreenshot();
        screenShot.elementScreenShotPath(AppiumBy.id("com.pathao.user.qa:id/btnSendRequest"));

        return findRiderButton.isDisplayed();
    }

}
