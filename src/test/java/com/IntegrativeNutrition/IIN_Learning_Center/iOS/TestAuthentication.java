package com.IntegrativeNutrition.IIN_Learning_Center.iOS;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 3/28/14
 * Contains all authentication tests
 */

import com.IntegrativeNutrition.IIN_Learning_Center.Global.*;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAuthentication {

    /**************************************
     * Prerequisites for all tests classes
     **************************************/

    @AfterClass(alwaysRun = true)
    public static void TestCleanUp() {
        TestEnvironment.StopEnvironment();
    }

    @BeforeClass(alwaysRun = true)
    public static void TestSetup() {
        TestEnvironment.StartEnvironment(System.getProperty("appPath"),
                System.getProperty("browserName"),
                System.getProperty("browserVersion"),
                System.getProperty("browserPlatform"),
                System.getProperty("appPackage"),
                System.getProperty("appActivity"),
                System.getProperty("testURL"));
    }

    /***************************************
     * TESTS
     ***************************************/

    @Test (groups = {"regression", "critical", "ios"}, priority = 1)
    public void LoginUnsuccessfully() {
        LoginScreen loginScreen = Screens.LoginScreen();
        loginScreen.attemptAuthentication("bad username", "bass password");
        Assert.assertTrue(loginScreen.assertIncorrectUserNamePasswordAlertExists(true));
    }

    @Test (groups = {"regression", "critical", "ios"}, priority = 2)
    public void LoginSuccessfully() {
        LoginScreen loginScreen = Screens.LoginScreen();
        loginScreen.attemptAuthentication("qauser", "iinusers");
    }

    @Test (groups = {"experimental", "ios"}, priority = 3)
    public  void TestRobotManeuvers() {
        Assert.assertTrue(Common.sendIPhoneIPadAppToBackground());
        Assert.assertTrue(Common.rotateIPhoneIPadLeft());
        Assert.assertTrue(Common.rotateIPhoneIPadRight());
        Assert.assertTrue(Common.shakeIPhoneIPadDevice());
        Assert.assertTrue(Common.simulateIPhoneIPadMemoryWarning());
        Assert.assertTrue(Common.toggleIPhoneIPadInCallStatusBar());
        Assert.assertTrue(Common.simulateIPhoneIPadHardwareKeyboard());
        Assert.assertTrue(Common.clickIPhoneIPadHomeButton());
    }
}


