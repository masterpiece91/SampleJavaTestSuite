package com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS;

import com.IntegrativeNutrition.IIN_Learning_Center.Global.SwipeableWebDriver;
import com.IntegrativeNutrition.IIN_Learning_Center.Global.TestEnvironment;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Login.ForgotPasswordScreen;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Login.LoginScreen;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Settings.ChangePasswordScreen;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Settings.ProfileScreen;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Settings.SettingsScreen;
import com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Settings.NotificationsScreen;
import org.openqa.selenium.support.PageFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 3/28/14
 * Contains instantiation of all screen objects
 */

public class Screens {

    static SwipeableWebDriver driver;

    public static LoginScreen LoginScreen() {
        driver = TestEnvironment.get_driver();
        LoginScreen loginScreen = new LoginScreen(driver);
        PageFactory.initElements(driver, loginScreen);
        return loginScreen;
    }

    public static ForgotPasswordScreen ForgotPasswordScreen() {
        driver = TestEnvironment.get_driver();
        ForgotPasswordScreen forgotPasswordScreen = new ForgotPasswordScreen(driver);
        PageFactory.initElements(driver, forgotPasswordScreen);
        return forgotPasswordScreen;
    }

    public static TimelineScreen TimelineScreen() {
        driver = TestEnvironment.get_driver();
        TimelineScreen timelineScreen = new TimelineScreen(driver);
        PageFactory.initElements(driver, timelineScreen);
        return timelineScreen;
    }

    public static MenuScreen MenuScreen() {
        driver = TestEnvironment.get_driver();
        MenuScreen menuScreen = new MenuScreen(driver);
        PageFactory.initElements(driver, menuScreen);
        return menuScreen;
    }

    /************************************
     * SETTINGS SCREENS
     ***********************************/
    public static SettingsScreen SettingScreen() {
        driver = TestEnvironment.get_driver();
        SettingsScreen settingsScreen = new SettingsScreen(driver);
        PageFactory.initElements(driver, settingsScreen);
        return settingsScreen;
    }

    public static ProfileScreen ProfileScreen() {
        driver = TestEnvironment.get_driver();
        ProfileScreen profileScreen = new ProfileScreen(driver);
        PageFactory.initElements(driver, profileScreen);
        return profileScreen;
    }

    public static ChangePasswordScreen ChangePasswordScreen() {
        driver = TestEnvironment.get_driver();
        ChangePasswordScreen changePasswordScreen = new ChangePasswordScreen(driver);
        PageFactory.initElements(driver, changePasswordScreen);
        return changePasswordScreen;
    }

    public static NotificationsScreen NotificationsScreen() {
        driver = TestEnvironment.get_driver();
        NotificationsScreen notificationsScreen = new NotificationsScreen(driver);
        PageFactory.initElements(driver, notificationsScreen);
        return notificationsScreen;
    }
}
