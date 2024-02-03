package com.pathao.user.qa.testcases.installedapptest;


import com.pathao.user.qa.helper.OpenAppFindElement;
import com.pathao.user.qa.screen.MainScreen;
import com.pathao.user.qa.testcases.basetests.InstalledAppBaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class RideHistoryTest extends InstalledAppBaseTest {

    MainScreen mainScreen;

    @Test(priority = 1, description = "Open the app")
    @Description("Open the app")
    public void openAppTest(){
        new OpenAppFindElement(getDriver()).openAppAndFindElement();
    }

    @Test(priority = 2)
    public void rideHistoryTest() {

        mainScreen = new MainScreen(getDriver());
        mainScreen.tapOnOrdersNav();
        mainScreen.tapOnCanceledRides();

    }

    @Test(priority = 3)
    public void RideRequestAgainTest() {
        mainScreen.tapOnFirstRideHistory();
        mainScreen.tapOnRequestAgain();

    }

}
