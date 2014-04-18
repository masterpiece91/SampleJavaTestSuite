package com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Settings;

/**
 * Created by Noah Blake on 4/16/14.
 * Copyright (c) 2014 IIN. All rights reserved.
 */

import static com.IntegrativeNutrition.IIN_Learning_Center.Global.TestEnvironment.*;

import com.IntegrativeNutrition.IIN_Learning_Center.Global.Common;
import com.IntegrativeNutrition.IIN_Learning_Center.Global.SwipeableWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.*;

import java.util.List;

public class SettingsScreen {
    /**
     * *********************************
     * CONSTRUCTORS
     * *********************************
     */
    public SettingsScreen(SwipeableWebDriver _driver) {
        this.driver = _driver;
    }
    /**
     * *********************************
     * PAGE ELEMENTS SETUP
     * *********************************
     */
    @FindBy(how = How.NAME, using = "Clear All")
        private WebElement clearAllButton;

    @FindBy(how = How.NAME, using = "Profile")
        private WebElement profileCell;

    @FindBy(how = How.NAME, using = "Change Password")
        private WebElement changePasswordCell;

    @FindBy(how = How.NAME, using = "Walkthrough")
        private WebElement walkthroughCell;

    @FindBy(how = How.NAME, using = "Notifications")
        private WebElement notificationsCell;

//    @FindBys({@FindBy(how = How.XPATH, using = "//window[3]/alert[1]/tableview[2]")})
//    private List<WebElement> signOutButton;
      SwipeableWebDriver driver;

    /**
     * *********************************
     * NAVIGATION TEST METHODS
     * **********************************
     */
    public void attemptClearDownloadedContent(){
        Common.clickWebElement(clearAllButton, " - Attempting to clear all downloaded content.");
    }
    public boolean assertClearDownloadedContentAlert(){
        return Common.assertAlertIsCorrect(driver, " - Asserting clear downloaded content alert is correct", "Downloaded Content. Are you sure you want to clear your downloaded content?" , false);
    }

    public void attemptProfileNavigation() {
        Common.clickWebElement(profileCell, " - Attempting to navigate to Profile.");
    }

    public void attemptChangePasswordNavigation() {
        Common.clickWebElement(changePasswordCell, " - Attempting to navigate to Change Password.");
    }

    public void attemptWalkthroughNavigation() {
        Common.clickWebElement(walkthroughCell, " - Attempting to navigate to Walkthrough.");
    }

    public void attemptNotificationsNavigation() {
        Common.clickWebElement(notificationsCell, " - Attempting to navigate to Notifications.");
    }
}


