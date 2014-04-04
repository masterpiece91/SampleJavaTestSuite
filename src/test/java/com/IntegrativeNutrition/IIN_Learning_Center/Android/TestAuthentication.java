package com.IntegrativeNutrition.IIN_Learning_Center.Android;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 3/28/14
 * Contains all authentication tests
 */

import com.IntegrativeNutrition.IIN_Learning_Center.Common.TestStarter;
import com.IntegrativeNutrition.IIN_Learning_Center.Global.*;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.Android.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAuthentication extends TestStarter {

    /***************************************
     * TESTS
     ***************************************/

    @Test (groups = {"android.regression", "android.critical", "android"}, priority = 1)
    public void LoginUnsuccessfully() {
        LoginScreen loginScreen = Screens.LoginScreen();
        loginScreen.attemptAuthentication("bad username", "bass password");
        Assert.assertTrue(loginScreen.assertIncorrectUserNamePasswordAlertExists(true));
    }

    @Test (groups = {"android.regression", "android.critical", "android"}, priority = 2)
    public void LoginSuccessfully() {
        LoginScreen loginScreen = Screens.LoginScreen();
        loginScreen.attemptAuthentication("qauser", "iinusers");
    }
}


