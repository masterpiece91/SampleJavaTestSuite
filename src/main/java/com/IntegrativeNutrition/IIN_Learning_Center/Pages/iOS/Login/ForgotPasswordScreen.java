package com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS.Login;

/**
 * Created by Noah Blake on 4/15/14.
 * Copyright (c) 2014 IIN. All rights reserved.
 */

import com.IntegrativeNutrition.IIN_Learning_Center.Global.*;
import static com.IntegrativeNutrition.IIN_Learning_Center.Global.TestEnvironment.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class ForgotPasswordScreen {
    /************************************
     * CONSTRUCTORS
     ***********************************/
    public ForgotPasswordScreen(SwipeableWebDriver _driver){
        this.driver = _driver;
    }

    /************************************
     * PAGE ELEMENTS SETUP
     ***********************************/

    @FindBy(how = How.NAME, using = "Email Address")
    private WebElement emailTextBox;

    @FindBy(how = How.NAME, using = "Please enter your email address and we will email you instructions to create a new password.")
    private WebElement instructionsTextBox;

    @FindBy(how = How.NAME, using = "Close")
    private WebElement closeButton;

    @FindBy(how = How.NAME, using = "Submit")
    private WebElement submitButton;

    SwipeableWebDriver driver;

    /************************************
     * SCREEN TEST METHODS
     ************************************/

    /************************************
     * Navigation methods
     ************************************/
    public void attemptReturnToLogin() {
        try {
            System.out.append(" - Attempting to return to login.");
            closeButton.click();
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

    /************************************
     * Request authentication methods
     ************************************/
    public void attemptNewPasswordRequest (String userEmail)
    {
        try {
            System.out.append(" - Attempting to request new password.");
            emailTextBox.clear();
            emailTextBox.sendKeys(userEmail);
            submitButton.click();
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

    public boolean assertNewPasswordRequestSuccess(Boolean acceptAlert) {
        return Common.assertAlertIsCorrect(driver, " - Asserting email alert is correct", "Request received We will email you instructions to create a new password.", acceptAlert);
    }

    public boolean assertNewPasswordRequestFailure(String systemOutMessage, String alertMessage, Boolean acceptAlert) {
       return Common.assertAlertIsCorrect(driver, systemOutMessage, alertMessage, acceptAlert);
    }


}
