package com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS;

import com.IntegrativeNutrition.IIN_Learning_Center.Global.SwipeableWebDriver;
import com.IntegrativeNutrition.IIN_Learning_Center.Global.TestEnvironment;
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
}
