package com.pathao.user.qa.testcases.installedapptest;


import com.pathao.user.qa.screen.AccountScreen;
import com.pathao.user.qa.helper.OpenAppFindElement;
import com.pathao.user.qa.screen.MainScreen;
import com.pathao.user.qa.testcases.basetests.InstalledAppBaseTest;
import org.testng.annotations.Test;

public class LogoutTest extends InstalledAppBaseTest {

    MainScreen mainScreen;
    AccountScreen accountScreen;

    @Test(priority = 1)
    public void openApp(){

        new OpenAppFindElement(androidDriver).openAppAndFindElement();

    }

    @Test(priority = 2, enabled = true)
    public void profileLogout(){
        mainScreen = new MainScreen(androidDriver);
        mainScreen.tapOnUserProfile();

        accountScreen = new AccountScreen(androidDriver);
        accountScreen.scrollToPage();
        accountScreen.tapOnLogout();
//        accountScreen.tapOnConfirmYes();

//        Assert.assertEquals(accountScreen.isLoggedOut(), true);
    }
}
