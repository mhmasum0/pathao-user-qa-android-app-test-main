package com.pathao.user.qa.screen;


import com.pathao.user.qa.utils.ExplicitWait;
import com.pathao.user.qa.utils.Scroll;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class FoodHomeScreen {
    AndroidDriver androidDriver;

    public FoodHomeScreen(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy (id = "com.pathao.user.qa:id/tvAdd")
    private WebElement addMenuButton;

    @AndroidFindBy(uiAutomator = "text(\"CHECKOUT\")")
    private WebElement checkOut;

    public void scrollToMostPopularSection(){
        Scroll scroll = new Scroll(androidDriver);
        scroll.scrollToElement(0,"All Restaurants");
    }

    @Step("Tap on the restaurant")
    public void tapOnRestaurants(){

        try {
            new ExplicitWait(androidDriver)
                    .waitForElement(10,AppiumBy.id("com.pathao.user.qa:id/rlDetails"));
        } catch (TimeoutException timeout){

        }

        androidDriver.findElement(AppiumBy.id("com.pathao.user.qa:id/rlDetails")).click();

        if (androidDriver.findElements(AppiumBy.className("android.widget.Switch")).size() > 0){
            WebElement availableFood = androidDriver.findElement(AppiumBy.className("android.widget.Switch"));
            boolean isAvailableFood = Boolean.parseBoolean(availableFood.getAttribute("checked"));
            if ( !isAvailableFood ){
                availableFood.click();
            }
        }
    }

    @Step("Add to cart")
    public void addFootToCart(){
        addMenuButton.click();
    }

    @Step("Add to cart and Checkout")
    public void addToCartThenCheckout(){

        addFootToCart();
        System.out.println("Add to cart: 1");
        boolean isCheckoutFound = (androidDriver.findElements(AppiumBy.androidUIAutomator("text(\"CHECKOUT\")")).size() > 0) || (androidDriver.findElements(AppiumBy.id("com.pathao.user.qa:id/tvItemAddCart")).size() > 0);

        if ( isCheckoutFound ){
            orderCheckout();
            System.out.println("Checkout: 1");
        }

        if ( ! isCheckoutFound  ){
            androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
            System.out.println("Get Back: 1");
            tapOnRestaurants();

            isCheckoutFound = (androidDriver.findElements(AppiumBy.androidUIAutomator("text(\"CHECKOUT\")")).size() > 0) || (androidDriver.findElements(AppiumBy.id("com.pathao.user.qa:id/tvItemAddCart")).size() > 0);

            if ( isCheckoutFound ){
                orderCheckout();
                System.out.println("Checkout: 2");
            }

            if ( ! isCheckoutFound ){
                addFootToCart();
                System.out.println("Add to cart: 2");

                androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
                System.out.println("Get Back: 2");
                tapOnRestaurants();

                isCheckoutFound = (androidDriver.findElements(AppiumBy.androidUIAutomator("text(\"CHECKOUT\")")).size() > 0) || (androidDriver.findElements(AppiumBy.id("com.pathao.user.qa:id/tvItemAddCart")).size() > 0);

                if ( isCheckoutFound ){
                    System.out.println("Checkout: 3");
                    orderCheckout();
                }

                if ( ! isCheckoutFound ){
                    addFootToCart();
                    System.out.println("Add to cart: 3");

                    orderCheckout();

                }
            }
        }
    }

    @Step("Scroll to place the Order")
    public void scrollToPlaceOrder()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        androidDriver.hideKeyboard();
        new Scroll(androidDriver).scrollForward(0);
    }

    @Step("Check out the Order")
    private void orderCheckout(){

        boolean isAddToCartButton = androidDriver.findElements(AppiumBy.id("com.pathao.user.qa:id/tvItemAddCart")).size() > 0;

        if (isAddToCartButton){

            boolean isAddToCartEnabled = Boolean.parseBoolean(androidDriver.findElement(AppiumBy.id("com.pathao.user.qa:id/tvItemAddCart")).getAttribute("enabled"));
            if (!isAddToCartEnabled){
                androidDriver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
            }
            androidDriver.findElement(AppiumBy.id("com.pathao.user.qa:id/tvItemAddCart")).click();
        }

        checkOut.click();

        if (androidDriver.findElements(AppiumBy.androidUIAutomator("text(\"Order More Than ৳50.0\")")).size() > 0) {
            System.out.println("order more");
            androidDriver.findElement(AppiumBy.id("com.pathao.user.qa:id/viewPositiveAction")).click();
            addFootToCart();
            checkOut.click();
        }
    }
}
