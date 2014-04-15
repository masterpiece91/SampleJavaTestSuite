package com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 3/28/14
 * Contains all elements of the login screen
 */

import com.IntegrativeNutrition.IIN_Learning_Center.Global.*;
import static com.IntegrativeNutrition.IIN_Learning_Center.Global.TestEnvironment.*;

import com.sun.org.apache.xerces.internal.dom.CommentImpl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginScreen {

    /************************************
     * CONSTRUCTORS
     ***********************************/
    public LoginScreen(SwipeableWebDriver _driver){
        this.driver = _driver;
    }

    /************************************
     * PAGE ELEMENTS SETUP
     ***********************************/

    @FindBy(how = How.NAME, using = "Email address")
            private WebElement usernameTextbox;

    @FindBy(how = How.NAME, using = "password")
            private WebElement passwordTextbox;

    @FindBy(how = How.NAME, using = "Login")
            private WebElement signInButton;

    @FindBy(how = How.NAME, using = "Forgot Password?")
        private WebElement forgotPasswordButton;

    SwipeableWebDriver driver;

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

    public boolean assertIncorrectUserNamePasswordAlertExists(String systemOutMessage, String alertMessage, Boolean dismissAlert) {
        return Common.assertAlertIsCorrect(driver, systemOutMessage, alertMessage, dismissAlert);
    }

    public boolean AssertAuthenticationSuccess() {
        TimelineScreen timelineScreen = Screens.TimelineScreen();
        timelineScreen.AcceptWelcomeMessage();
        return timelineScreen.AssertAuthenticationSuccess();
    }

    public boolean assertNavigationToForgotPassword() {
        try {

            System.out.append(" - Attempting to move to forgot password screen");
            forgotPasswordButton.click();
            System.out.println("  -  Successful");
            return true;
        }
        catch (Exception exception) {
            System.out.println("======================================================================================");
            System.out.println("*** attemptForgotPassword failed - " + exception.getMessage());
            System.out.println("======================================================================================");
            System.out.println();
            return false;
        }
    }


}
