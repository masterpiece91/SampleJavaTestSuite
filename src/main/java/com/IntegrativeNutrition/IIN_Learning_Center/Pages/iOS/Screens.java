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

    private SwipeableWebDriver Driver;

    public static LoginScreen LoginScreen() {
        LoginScreen loginScreen = new LoginScreen();
        PageFactory.initElements(TestEnvironment.get_driver(), loginScreen);
        return loginScreen;
    }

}
