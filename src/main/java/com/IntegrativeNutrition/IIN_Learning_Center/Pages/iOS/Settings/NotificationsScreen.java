package com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Settings;

/**
 * Created by Noah Blake on 4/16/14.
 * Copyright (c) 2014 IIN. All rights reserved.
 */

import com.IntegrativeNutrition.IIN_Learning_Center.Global.Common;
import com.IntegrativeNutrition.IIN_Learning_Center.Global.SwipeableWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.*;

import java.util.List;

public class NotificationsScreen {
    /**
     * *********************************
     * CONSTRUCTORS
     * *********************************
     */
    public NotificationsScreen(SwipeableWebDriver _driver) {
        this.driver = _driver;
    }

    /**
     * *********************************
     * PAGE ELEMENTS SETUP
     * *********************************
     */

//    @FindBy(how = How.NAME, using = "Profile")
//        private WebElement profileCell;

    @FindBys({@FindBy(how = How.XPATH, using = "/window[1]/navigationBar[1]/button[1]")})
        private WebElement backButton;

    SwipeableWebDriver driver;

    /**
     * *********************************
     * NAVIGATION TEST METHODS
     * **********************************
     */
    public boolean assertPushNotificationAlert ()
    {
        boolean tmpFoundAlert = Common.waitForAlert(driver, 2);
        if (tmpFoundAlert){
            return Common.assertAlertIsCorrect(driver, " - Asserting push notifications alert is correct", "Push Notifications You must turn push notifications on in System Preferences to manage device settings on this screen." , true);
        }
        else{
            return true;
        }
    }

    public void attemptBackNavigation() {
        Common.clickWebElement(backButton, " - Attempting to navigate to Settings.");
    }
}