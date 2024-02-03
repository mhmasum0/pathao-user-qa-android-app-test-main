package com.pathao.user.qa.screen;



import com.pathao.user.qa.utils.ExplicitWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PermissionScreen {
    AndroidDriver androidDriver;

    public PermissionScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator( androidDriver ), this);
    }

    @AndroidFindBy(id = "com.pathao.user.qa:id/btnRequestPermission")
    private WebElement requestPermissionButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement locationPermission;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement photoPermission;

    @Step("Waiting for the permission screen to be visible")
    public void waitForPermission(){

        try {
            new ExplicitWait(androidDriver)
                    .waitForElement( 30, AppiumBy.id("com.pathao.user.qa:id/btnRequestPermission"));
        } catch (TimeoutException timeout){
            timeout.printStackTrace();
            Allure.addAttachment("Permission is not visible, waited too long", timeout.getRawMessage());
        }

    }

    @Step("Setting up the app permissions")
    public void setupAppPermission(){

        requestPermissionButton.click();
        locationPermission.click();
        photoPermission.click();
    }
}
