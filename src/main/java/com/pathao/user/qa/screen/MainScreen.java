package com.pathao.user.qa.screen;


import com.pathao.user.qa.utils.ExplicitWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainScreen {

    AndroidDriver androidDriver;

    public MainScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator( this.androidDriver ), this);
    }

    @AndroidFindBy(uiAutomator = "text(\"Bike\")")
    private WebElement bikeServiceButton;

    @AndroidFindBy( uiAutomator = "text(\"Food\")")
    private WebElement foodService;

    @AndroidFindBy ( id = "com.pathao.user.qa:id/ivUserProfile")
    private WebElement userProfile;

    @AndroidFindBy(accessibility = "History")
    private WebElement navTitle;

    @AndroidFindBy(uiAutomator = "text(\"Orders\")")
    private WebElement ordersNav;

    @AndroidFindBy( id = "com.pathao.user.qa:id/rlRideInfo")
    private WebElement  firstRideHistory;

    @AndroidFindBy(className = "android.widget.Switch" )
    private WebElement cancelToggleButton;

    @AndroidFindBy(id = "com.pathao.user.qa:id/rlLocation")
    private WebElement previousRide;

    @AndroidFindBy(id = "com.pathao.user.qa:id/rlRequestAgain")
    private WebElement requestAgainButton;

    @Step("Tap on the Orders")
    public void tapOnOrdersNav(){
        ordersNav.click();
    }

    @Step("Tap on Cancel toggle button")
    public void tapOnCanceledRides(){
        cancelToggleButton.click();
    }

    public void tapOnPreviousRides(){
        System.out.println("Searching for");
        new ExplicitWait(androidDriver)
                .waitForElement(10, AppiumBy.id("com.pathao.user:id/rlLocation"));

        System.out.println("Wating completed");
        previousRide.click();

        System.out.println("Clicked finally");
    }

    @Step("Tap on REQUEST AGAIN button")
    public void tapOnRequestAgain(){
        requestAgainButton.click();
    }

    @Step("Tap on Bike Service")
    public void tapOnBikeService(){
        bikeServiceButton.click();
    }

    @Step("Tap on User Profile")
    public void tapOnUserProfile(){
        userProfile.click();
    }

    @Step("Tap on the First ride details from the history")
    public void tapOnFirstRideHistory(){
        firstRideHistory.click();
    }

    @Step("Tap on the Food Service")
    public void tapOnFoodService(){
        foodService.click();
    }

    @Step("Skipping the tutorial")
    public void skipTutorial() throws InterruptedException {

        Thread.sleep(2000);
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

}
