package com.IntegrativeNutrition.IIN_Learning_Center.iOS;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 3/28/14
 * Contains all authentication tests
 */

import com.IntegrativeNutrition.IIN_Learning_Center.Common.TestStarter;
import com.IntegrativeNutrition.IIN_Learning_Center.Global.*;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAuthentication extends TestStarter {

    /***************************************
     * TESTS
     ***************************************/

    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 1)
    public void LoginUnsuccessfully() {
        LoginScreen loginScreen = Screens.LoginScreen();
        loginScreen.attemptAuthentication("bad username", "bass password");
        Assert.assertTrue(loginScreen.assertIncorrectUserNamePasswordAlertExists(true));
    }

    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 2)
    public void LoginSuccessfully() {
        LoginScreen loginScreen = Screens.LoginScreen();
        loginScreen.attemptAuthentication("fuzzy", "fuzzy");
        Assert.assertTrue(loginScreen.AssertAuthenticationSuccess());
    }

    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 3)
    public void CompleteAnAssignment() {
        TimelineScreen timelineScreen = Screens.TimelineScreen();
        timelineScreen.findAnAssigment();
        timelineScreen.completeAssigment();
        Assert.assertTrue(timelineScreen.AssertAssigmentComplete());
    }

    @Test (groups = {"ios.experimental", "ios"}, priority = 99)
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


