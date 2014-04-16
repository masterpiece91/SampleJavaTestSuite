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
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.interactions.touch.TouchActions;

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

    @FindBy(how = How.NAME, using = "Sign Out")
        private WebElement signOutCell;

    SwipeableWebDriver driver;

    /************************************
     * NAVIGATION TEST METHODS
     ************************************/
    public void attemptSignOut() {
        try {
            System.out.append(" - Attempting to sign out.");
            //perform swipe gesture
            TouchActions swipe = new TouchActions(driver).flick(0, -1000);
            swipe.perform();
            signOutCell.click();
            System.out.println("  -  Successful");
        }
        catch (Exception exception) {
            System.out.println("  -  Error Found... Read below:");
            System.out.println("======================================================================================");
            System.out.println("*** attemptAuthentication failed - " + exception.getMessage());
            System.out.println("======================================================================================");
            System.out.println();
        }
    }

    public boolean assertSignOutAccepted(Boolean dismissAlert) {
        return Common.assertAlertIsCorrect(driver, " - Asserting sign out alert is shown", "Sign Out Are you sure you want to sign out of the Classroom App?.", dismissAlert);
    }

    public boolean assertSignOutDeclined(Boolean dismissAlert) {
        return Common.assertAlertIsCorrect(driver, " - Asserting sign out alert is shown", "Sign Out Are you sure you want to sign out of the Classroom App?.", dismissAlert);
    }
}

