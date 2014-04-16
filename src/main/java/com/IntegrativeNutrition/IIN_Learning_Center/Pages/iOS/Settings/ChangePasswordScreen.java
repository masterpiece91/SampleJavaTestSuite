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

public class ChangePasswordScreen {
    /**
     * *********************************
     * CONSTRUCTORS
     * *********************************
     */
    public ChangePasswordScreen(SwipeableWebDriver _driver) {
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
    public void attemptBackNavigation() {
        Common.clickWebElement(backButton, " - Attempting to navigate to Settings.");
    }
}