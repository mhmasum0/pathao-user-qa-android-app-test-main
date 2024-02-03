package com.pathao.user.qa.testcases.installedapptest;


import com.pathao.user.qa.helper.OpenAppFindElement;
import com.pathao.user.qa.screen.MainScreen;
import com.pathao.user.qa.screen.ReportIssueScreen;
import com.pathao.user.qa.screen.ReportSubmissionScreen;
import com.pathao.user.qa.screen.RideDetailsScreen;
import com.pathao.user.qa.testcases.basetests.InstalledAppBaseTest;
import org.testng.annotations.Test;

public class ReportRideTest extends InstalledAppBaseTest {

    MainScreen mainScreen;
    RideDetailsScreen rideDetailsScreen;
    ReportIssueScreen reportIssueScreen;
    ReportSubmissionScreen reportSubmissionScreen;

    @Test(priority = 1)
    public void openAppTest(){

        new OpenAppFindElement(androidDriver).openAppAndFindElement();

    }

    @Test(priority =2)
    public void ReportRideTest(){
        mainScreen = new MainScreen(androidDriver);
        mainScreen.tapOnOrdersNav();
        mainScreen.tapOnCanceledRides();
        mainScreen.tapOnFirstRideHistory();

        rideDetailsScreen = new RideDetailsScreen(androidDriver);
        rideDetailsScreen.tapOnReportIssue();

        reportIssueScreen = new ReportIssueScreen(androidDriver);
        reportIssueScreen.tapOnCaptainUnprofessional();
        reportIssueScreen.tapCaptainWasRude();

        reportSubmissionScreen = new ReportSubmissionScreen(androidDriver);
        reportSubmissionScreen.captainWasRude("Behaviour was rude");
//        reportSubmissionScreen.submitIssue();

    }
}
