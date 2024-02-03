package com.pathao.user.qa.testcases.installedapptest;


import com.pathao.user.qa.helper.OpenAppFindElement;
import com.pathao.user.qa.screen.MainScreen;
import com.pathao.user.qa.screen.RidesScreen;
import com.pathao.user.qa.testcases.basetests.InstalledAppBaseTest;
import com.pathao.user.qa.utils.ConfigFileReader;
import org.testng.annotations.Test;

public class SearchRideTest extends InstalledAppBaseTest {

    MainScreen mainScreen;
    RidesScreen ridesScreen;

    String destinationLocation = ConfigFileReader.getConfigProperty("destinationLocation");


    @Test(priority = 1)
    public void openApp(){
        new OpenAppFindElement(getDriver()).openAppAndFindElement();
    }

    @Test(priority = 2)
    public void searchRide() {
        mainScreen = new MainScreen(getDriver());
        mainScreen.tapOnBikeService();

        ridesScreen = new RidesScreen(getDriver());
        ridesScreen.tapOnAddressInputArea();
        ridesScreen.tapOnAddress();
        ridesScreen.typeDestinationAddress(destinationLocation);
        ridesScreen.selectRandomDestination();
    }
}
