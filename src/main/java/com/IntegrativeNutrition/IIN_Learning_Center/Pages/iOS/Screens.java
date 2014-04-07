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

    public static TimelineScreen TimelineScreen() {
        driver = TestEnvironment.get_driver();
        TimelineScreen timelineScreen = new TimelineScreen(driver);
        PageFactory.initElements(driver, timelineScreen);
        return timelineScreen;
    }
}
