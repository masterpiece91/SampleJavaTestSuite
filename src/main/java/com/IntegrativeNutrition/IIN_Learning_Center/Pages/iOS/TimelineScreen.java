package com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS;

import com.IntegrativeNutrition.IIN_Learning_Center.Global.*;
import static com.IntegrativeNutrition.IIN_Learning_Center.Global.TestEnvironment.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 4/04/14
 * Contains all elements of the timeline screen
 */

public class TimelineScreen {

    /************************************
     * PAGE ELEMENTS SETUP
     ***********************************/

    @FindBys({@FindBy(how = How.XPATH, using = "//window[1]/scrollview[1]")})
            private WebElement timelineViewList;

    //This element will always exist
    @FindBy(how = How.NAME, using = "iconGradcap")
            private WebElement iconGradcapButton;

    SwipeableWebDriver Driver;

    /************************************
     * PAGE TEST METHODS
     ************************************/

    public boolean AcceptWelcomeMessage() {
        String expectedMessage = "You Made It! Welcome to the Classroom. Would you like to take a tour before using the app?";
        SwipeableWebDriver driver = get_driver();
        return Common.acceptAlert(driver, expectedMessage);
    }

    public boolean DismissWelcomeMessage() {
        String expectedMessage = "You Made It! Welcome to the Classroom. Would you like to take a tour before using the app?";
        SwipeableWebDriver driver = get_driver();
        return Common.dismissAlert(driver, expectedMessage);

    }

    // In order to confirm authentication we confirm the existence of an element that should always be there.
    public boolean AssertAuthenticationSuccess() {
        if (iconGradcapButton.isDisplayed()) {
            return true;
        }

        return false;
    }



}


