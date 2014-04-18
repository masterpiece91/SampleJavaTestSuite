package com.IntegrativeNutrition.IIN_Learning_Center.iOS;

/**
 * Created by Noah Blake on 4/18/14.
 * Copyright (c) 2014 IIN. All rights reserved.
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

public class TestSettings extends TestStarter {
    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 101)
    public void loginSuccessfully() {
        LoginScreen loginScreen = Screens.LoginScreen();
        loginScreen.attemptAuthentication("fuzzier", "pass");
        Assert.assertTrue(loginScreen.AssertAuthenticationSuccess());
    }

    /***************************************
     * SETTINGS TESTS
     ***************************************/
    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 102)
    public void openSettings() {
        TimelineScreen timelineScreen = Screens.TimelineScreen();
        timelineScreen.attemptOpenMenu();

        MenuScreen menuScreen = Screens.MenuScreen();
        Assert.assertTrue(menuScreen.assertSettingsNavigation());
    }

    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 103)
    public void clearAll() {
        SettingsScreen settingsScreen = Screens.SettingScreen();
        settingsScreen.attemptClearDownloadedContent();
        Assert.assertTrue(settingsScreen.assertClearDownloadedContentAlert());
    }

    /***************************************
     * EDIT PROFILE TESTS
     ***************************************/
    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 104)
    public void openProfile() {
        SettingsScreen settingsScreen = Screens.SettingScreen();
        settingsScreen.attemptProfileNavigation();

        ProfileScreen profileScreen = Screens.ProfileScreen();
        profileScreen.attemptBackNavigation();
    }

    /***************************************
     * CHANGE PASSWORD PROFILE TESTS
     ***************************************/
    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 105)
    public void changePasswordAlertIsCorrect() {
        SettingsScreen settingsScreen = Screens.SettingScreen();
        settingsScreen.attemptChangePasswordNavigation();

        // Validate reenter password alert
        ChangePasswordScreen changePasswordScreen = Screens.ChangePasswordScreen();
        changePasswordScreen.attemptChangePassword("pass", "pass");
        Assert.assertTrue(changePasswordScreen.assertReenterPasswordAlert());
    }

    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 106)
    public void failPasswordChangeWithIncorrectCurrentPassword() {
        // Validate reenter password alert
        ChangePasswordScreen changePasswordScreen = Screens.ChangePasswordScreen();
        changePasswordScreen.attemptChangePassword("bass", "pass");
        changePasswordScreen.attemptSuccessfulPasswordChangeFinalization();
        Assert.assertTrue(changePasswordScreen.assertPasswordChangeFailedBadCurrentPasswordAlert());

        SettingsScreen settingsScreen = Screens.SettingScreen();
        settingsScreen.attemptChangePasswordNavigation();
    }

    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 107)
    public void failPasswordChangeWithNonMatchingPasswords() {
        // Validate reenter password alert
        ChangePasswordScreen changePasswordScreen = Screens.ChangePasswordScreen();
        changePasswordScreen.attemptChangePassword("pass", "pass");
        changePasswordScreen.attemptUnsuccessfulPasswordChangeFinalization();
        Assert.assertTrue(changePasswordScreen.assertPasswordChangeFailedNotMatchingAlert());
    }

    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 108)
    public void changePasswordSuccessfully() {
        // Validate reenter password alert
        ChangePasswordScreen changePasswordScreen = Screens.ChangePasswordScreen();
        changePasswordScreen.attemptChangePassword("pass", "pass");
        changePasswordScreen.attemptSuccessfulPasswordChangeFinalization();
        Assert.assertTrue(changePasswordScreen.assertPasswordChangedAlert());
    }

    @Test (groups = {"ios.regression", "ios.critical", "ios"}, priority = 109)
    public void openNotifications() {
        SettingsScreen settingsScreen = Screens.SettingScreen();
        settingsScreen.attemptNotificationsNavigation();

        NotificationsScreen notificationsScreen = Screens.NotificationsScreen();
        Assert.assertTrue(notificationsScreen.assertPushNotificationAlert());
        notificationsScreen.attemptBackNavigation();
    }
}
