package com.pathao.user.qa.testcases.installedapptest;


import com.pathao.user.qa.helper.OpenAppFindElement;
import com.pathao.user.qa.screen.MainScreen;
import com.pathao.user.qa.testcases.basetests.InstalledAppBaseTest;
import com.pathao.user.qa.screen.FoodHomeScreen;
import org.testng.annotations.Test;

public class OrderFoodTest extends InstalledAppBaseTest {

    MainScreen mainScreen;
    FoodHomeScreen foodHomeScreen;

    @Test(priority = 1)
    public void openAppTest(){
        new OpenAppFindElement(androidDriver).openAppAndFindElement();
    }

    @Test(priority = 2)
    public void orderFoodTest(){
        mainScreen = new MainScreen(androidDriver);
        mainScreen.tapOnFoodService();

        foodHomeScreen = new FoodHomeScreen(androidDriver);
        foodHomeScreen.scrollToMostPopularSection();
        foodHomeScreen.tapOnRestaurants();
        foodHomeScreen.addToCartThenCheckout();
        foodHomeScreen.scrollToPlaceOrder();

    }
}
