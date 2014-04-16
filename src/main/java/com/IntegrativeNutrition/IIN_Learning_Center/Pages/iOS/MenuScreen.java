package com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS;

/**
 * Created by Noah Blake on 4/15/14.
 * Copyright (c) 2014 IIN. All rights reserved.
 */

import com.IntegrativeNutrition.IIN_Learning_Center.Global.*;
import static com.IntegrativeNutrition.IIN_Learning_Center.Global.TestEnvironment.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.*;

import java.util.List;

public class MenuScreen {

    /************************************
     * CONSTRUCTORS
     ***********************************/
    public MenuScreen(SwipeableWebDriver _driver){
        this.driver = _driver;
    }

    /************************************
     * PAGE ELEMENTS SETUP
     ***********************************/

    @FindBy(how = How.NAME, using = "Live Web Classes")
        private WebElement liveWebClassesCell;

    @FindBy(how = How.NAME, using = "Documents")
        private WebElement documentsCell;

    @FindBy(how = How.NAME, using = "Settings")
        private WebElement settingsCell;

    @FindBy(how = How.NAME, using = "Sign Out")
        private WebElement signOutCell;

    @FindBys({@FindBy(how = How.XPATH, using = "//window[3]/alert[1]/tableview[1]")})
        private List<WebElement> cancelButton;

    @FindBys({@FindBy(how = How.XPATH, using = "//window[3]/alert[1]/tableview[2]")})
        private List<WebElement> signOutButton;


    SwipeableWebDriver driver;

    /************************************
     * NAVIGATION TEST METHODS
     ************************************/
    public boolean assertLiveWebClasses() {
        return Common.clickWebElement(signOutCell, " - Attempting to navigate to Live Web Classes.");
    }

    public boolean assertSettingsNavigation() {
        return Common.clickWebElement(settingsCell, " - Attempting to navigate to Settings.");
    }

    public void attemptSignOut() {
        Common.clickWebElement(signOutCell, " - Attempting to sign out.");
    }

    public boolean assertSignOutAccepted(Boolean acceptAlert) {
        return Common.assertAlertIsCorrect(driver, " - Asserting sign out alert is shown", "Sign Out Are you sure you want to sign out of the Classroom App?", acceptAlert);
    }

    public boolean assertSignOutDeclined(Boolean acceptAlert) {
        return Common.assertAlertIsCorrect(driver, " - Asserting sign out alert is shown", "Sign Out Are you sure you want to sign out of the Classroom App?", acceptAlert);
    }
}

