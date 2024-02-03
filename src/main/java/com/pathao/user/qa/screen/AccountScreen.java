package com.pathao.user.qa.screen;


import com.pathao.user.qa.utils.ScreenShot;
import com.pathao.user.qa.utils.Scroll;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountScreen {
    AndroidDriver androidDriver;

    public AccountScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements( new AppiumFieldDecorator( androidDriver ), this );
    }

    @AndroidFindBy (id = "com.pathao.user.qa:id/tvLogoutName")
    private WebElement logOut;

    @AndroidFindBy (id = "com.pathao.user.qa:id/tvYes")
    private WebElement confirmYes;

    public void scrollToPage(){

        Scroll scroll = new Scroll(androidDriver);
        scroll.scrollToElement(0,"Log out");

    }

    @Step("Tap on the Logout Button")
    public void tapOnLogout(){
        logOut.click();
    }

    @Step("Tap on the Confirm Button")
    public void tapOnConfirmYes(){
        confirmYes.click();
    }

    public boolean isLoggedOut(){
        GetStartedScreen getStartedScreen = new GetStartedScreen(androidDriver);

        boolean startupScreenIsVisible = getStartedScreen.isGetStarted();

        ScreenShot screenShot = new ScreenShot(androidDriver);
        screenShot.pageScreenshot();

        return startupScreenIsVisible;
    }



}
