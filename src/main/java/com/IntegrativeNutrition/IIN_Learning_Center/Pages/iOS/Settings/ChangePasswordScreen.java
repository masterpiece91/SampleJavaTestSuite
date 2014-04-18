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

    @FindBys({@FindBy(how = How.XPATH, using = "//window[1]/navigationBar[1]/button[1]")})
        private WebElement backButton;

    @FindBys({@FindBy(how = How.XPATH, using = "//window[1]/navigationBar[1]/button[3]")})
        private WebElement submitButton;

    @FindBys({@FindBy(how = How.XPATH, using = "//window[1]/tableview[2]/cell[1]/secure[1]")})
        private WebElement currentPasswordTextField;

    @FindBys({@FindBy(how = How.XPATH, using = "//window[1]/tableview[2]/cell[2]/secure[1]")})
        private WebElement newPasswordTextField;

    @FindBys({@FindBy(how = How.XPATH, using = "//window[3]/alert[1]/image[1]/secure[1]")})
        private WebElement reenterPasswordTextField;

    SwipeableWebDriver driver;

    /**
     * *********************************
     * NAVIGATION TEST METHODS
     * **********************************
     */
    public void attemptChangePassword(String currentPassword, String newPassword){
        try{
            System.out.append(" - Attempting to change password.");
            currentPasswordTextField.clear();
            currentPasswordTextField.sendKeys(currentPassword);
            newPasswordTextField.clear();
            newPasswordTextField.sendKeys(newPassword);
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

    public void attemptSuccessfulPasswordChangeFinalization() {
        this.finalizePasswordChange("pass");
    }

    public void attemptUnsuccessfulPasswordChangeFinalization() {
       this.finalizePasswordChange("bass");
    }

    private void finalizePasswordChange(String password)
    {
        try {
            Common.waitForAlert(driver, 2);
            reenterPasswordTextField.clear();
            reenterPasswordTextField.sendKeys(password);
            Common.acceptAlert(driver);
        }
        catch (Exception exception) {
            System.out.println("  -  Error Found... Read below:");
            System.out.println("======================================================================================");
            System.out.println("*** attemptAuthentication failed - " + exception.getMessage());
            System.out.println("======================================================================================");
            System.out.println();
        }
    }


    public boolean assertReenterPasswordAlert(){
        return Common.assertAlertIsCorrect(driver, " - Asserting re-enter password alert is correct", "Change Password To finalize this password change, please enter your new password.", false);
    }
    public boolean assertPasswordChangeFailedBadCurrentPasswordAlert(){
        return Common.assertAlertIsCorrect(driver, " - Asserting password change failed alert is correct", "Password not updated The password provided was incorrect." , true);
    }
    public boolean assertPasswordChangeFailedNotMatchingAlert(){
        return Common.assertAlertIsCorrect(driver, " - Asserting password change failed alert is correct", "Password not updated The password provided did not match." , true);
    }
    public boolean assertPasswordChangedAlert(){
        return Common.assertAlertIsCorrect(driver, " - Asserting password changed alert is correct", "Your password has been updated" , true);
    }
    public void attemptBackNavigation() {
        Common.clickWebElement(backButton, " - Attempting to navigate to Settings.");
    }
}