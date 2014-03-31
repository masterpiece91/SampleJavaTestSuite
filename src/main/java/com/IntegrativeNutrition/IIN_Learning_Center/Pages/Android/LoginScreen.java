package com.IntegrativeNutrition.IIN_Learning_Center.Pages.Android;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 3/28/14
 * Contains all elements of the login screen
 */

import com.IntegrativeNutrition.IIN_Learning_Center.Global.Common;
import com.IntegrativeNutrition.IIN_Learning_Center.Global.SwipeableWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import static com.IntegrativeNutrition.IIN_Learning_Center.Global.TestEnvironment.*;

public class LoginScreen {

    /************************************
     * PAGE ELEMENTS SETUP
     ***********************************/

    @FindBy(how = How.ID, using = "com.integrativenutrition.android.nextgen:id/email_address")
    private WebElement usernameTextbox;

    @FindBy(how = How.ID, using = "com.integrativenutrition.android.nextgen:id/password")
    private WebElement passwordTextbox;

    @FindBy(how = How.ID, using = "com.integrativenutrition.android.nextgen:id/sign_in")
    private WebElement signInButton;

    SwipeableWebDriver Driver;

    /************************************
     * PAGE TEST METHODS
     ************************************/

    public void attemptAuthentication (String username, String password)
    {
        try {
            System.out.append(" - Attempting to Authenticate.");
            usernameTextbox.clear();
            usernameTextbox.sendKeys(username);
            passwordTextbox.clear();
            passwordTextbox.sendKeys(password);
            signInButton.click();
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

    public boolean assertIncorrectUserNamePasswordAlertExists( Boolean dismissAlert) {
        try {
            System.out.append(" - Asserting incorrect username and/or password message is correct");

            String expectedMessage = "Failure to login Wrong username or password.";

            Boolean isCorrectMessage = Common.assertCorrectMessage(get_driver(), expectedMessage);

            if (dismissAlert) {
                Common.acceptAlert(get_driver());
            }

            System.out.println("  -  Assertion is: " + isCorrectMessage.toString());
            return  isCorrectMessage;
        }
        catch (Exception exception) {
            System.out.println("  -  Error Found... Read below:");
            System.out.println("======================================================================================");
            System.out.println("*** assertIncorrectUserNamePasswordMessageExists failed - " + exception.getMessage());
            System.out.println("======================================================================================");
            System.out.println();
            return  false;
        }
    }
}
