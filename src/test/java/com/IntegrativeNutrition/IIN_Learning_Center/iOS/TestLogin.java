package com.IntegrativeNutrition.IIN_Learning_Center.iOS;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 3/28/14
 * Contains all authentication tests
 */

import com.IntegrativeNutrition.IIN_Learning_Center.Common.TestStarter;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.*;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Login.ForgotPasswordScreen;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Login.LoginScreen;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Settings.ChangePasswordScreen;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Settings.ProfileScreen;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Settings.SettingsScreen;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Settings.NotificationsScreen;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLogin extends TestStarter {

    /***************************************
     * FORGOT PASSWORD TESTS
     ***************************************/
    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 1)
    public void enterForgotPasswordScreen () {
        LoginScreen loginScreen = Screens.LoginScreen();
        Assert.assertTrue(loginScreen.assertNavigationToForgotPassword());
    }

    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 2)
    public void requestNewPasswordUnsuccessfully () {
        ForgotPasswordScreen forgotPasswordScreen = Screens.ForgotPasswordScreen();

        // Case sensitivity
        forgotPasswordScreen.attemptNewPasswordRequest("NOAH@fuzzproductions.com");
        forgotPasswordScreen.assertNewPasswordRequestFailure("- Asserting case sensitive email is rejected", "Request not sent. The email you provided did not match that of any known user.", true);
        // Blank email
        forgotPasswordScreen.attemptNewPasswordRequest("");
        forgotPasswordScreen.assertNewPasswordRequestFailure("- Asserting empty email is rejected", "Request not sent. The email you provided did not match that of any known user.", true);
        // Invalid email format
        forgotPasswordScreen.attemptNewPasswordRequest("noahATFuzzproductions.com");
        forgotPasswordScreen.assertNewPasswordRequestFailure("- Asserting improperly formatted email is rejected", "Request not sent. The email you provided did not match that of any known user.", true);
    }

    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 3)
    public void requestNewPasswordSuccessfully () {
        ForgotPasswordScreen forgotPasswordScreen = Screens.ForgotPasswordScreen();
        forgotPasswordScreen.attemptNewPasswordRequest("noah@fuzzproductions.com");
        Assert.assertTrue(forgotPasswordScreen.assertNewPasswordRequestSuccess(true));
        forgotPasswordScreen.attemptReturnToLogin();
    }

  /***************************************
   * LOGIN TESTS
   ***************************************/
    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 4)
    public void LoginUnsuccessfully() {
        LoginScreen loginScreen = Screens.LoginScreen();

        // Blank login
        loginScreen.attemptAuthentication("", "");
        loginScreen.assertIncorrectUserNamePasswordAlertExists("- Asserting blank fields are rejected.", "Failure to login The username <em class=\"placeholder\"></em> has not been activated or is blocked.", true);
        // Invalid email format
        loginScreen.attemptAuthentication("fuzzyATFuzzproductions.com", "pass");
        loginScreen.assertIncorrectUserNamePasswordAlertExists("- Asserting improperly formatted email is rejected.", "Failure to login Wrong username or password." , true);
        // Bad data
        loginScreen.attemptAuthentication("bad username", "bass password");
        loginScreen.assertIncorrectUserNamePasswordAlertExists("- Asserting bad data is rejected", "Failure to login Wrong username or password." , true);
        // No email
        loginScreen.attemptAuthentication("", "pass");
        loginScreen.assertIncorrectUserNamePasswordAlertExists("- Asserting missing email is rejected.", "Failure to login The username <em class=\"placeholder\"></em> has not been activated or is blocked." , true);
        // No password
        loginScreen.attemptAuthentication("noah@fuzzproductions.com", "");
        loginScreen.assertIncorrectUserNamePasswordAlertExists("- Asserting missing password is rejected.", "Failure to login Wrong username or password." , true);
//        Case sensitivity
//        loginScreen.attemptAuthentication("NOAH@fuzzproductions.com", "pass");
//        loginScreen.assertIncorrectUserNamePasswordAlertExists("- Asserting case sensitive email is rejected.", "Failure to login Wrong username or password.", true);
          loginScreen.attemptAuthentication("noah@fuzzproductions.com", "PASS");
          loginScreen.assertIncorrectUserNamePasswordAlertExists("- Asserting case sensitive password is rejected.", "Failure to login Account is temporarily blocked.", true);

        Assert.assertTrue(true);
    }

    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 5)
    public void loginSuccessfully() {
        LoginScreen loginScreen = Screens.LoginScreen();
        loginScreen.attemptAuthentication("fuzzier", "pass");
        Assert.assertTrue(loginScreen.AssertAuthenticationSuccess());
    }
    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 10)
    public void signOut() {
        TimelineScreen timelineScreen = Screens.TimelineScreen();
        timelineScreen.attemptOpenMenu();

        MenuScreen menuScreen = Screens.MenuScreen();
        menuScreen.attemptSignOut();
        menuScreen.assertSignOutDeclined(false);
        menuScreen.attemptSignOut();
        menuScreen.assertSignOutAccepted(true);
    }
//    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 8)
//    public void openLiveWebClasses() {
//        TimelineScreen timelineScreen = Screens.TimelineScreen();
//        timelineScreen.attemptOpenMenu();
//
//        MenuScreen menuScreen = Screens.MenuScreen();
//        Assert.assertTrue(menuScreen.assertLiveWebClasses());
//    }


//
//    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 7)
//    public void CompleteAnAssignment() {
//        TimelineScreen timelineScreen = Screens.TimelineScreen();
//        timelineScreen.findAnAssigment();
//        timelineScreen.completeAssigment();
//        Assert.assertTrue(timelineScreen.AssertAssigmentComplete());
//    }

//    @Test (groups = {"ios.experimental", "ios"}, priority = 99)
//    public  void TestRobotManeuvers() {
//        Assert.assertTrue(Common.sendIPhoneIPadAppToBackground());
//        Assert.assertTrue(Common.rotateIPhoneIPadLeft());
//        Assert.assertTrue(Common.rotateIPhoneIPadRight());
//        Assert.assertTrue(Common.shakeIPhoneIPadDevice());
//        Assert.assertTrue(Common.simulateIPhoneIPadMemoryWarning());
//        Assert.assertTrue(Common.toggleIPhoneIPadInCallStatusBar());
//        Assert.assertTrue(Common.simulateIPhoneIPadHardwareKeyboard());
//        Assert.assertTrue(Common.clickIPhoneIPadHomeButton());
//    }
}


