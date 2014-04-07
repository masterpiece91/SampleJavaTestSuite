package com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 3/28/14
 * Contains all elements of the login screen
 */

import com.IntegrativeNutrition.IIN_Learning_Center.Global.*;
import static com.IntegrativeNutrition.IIN_Learning_Center.Global.TestEnvironment.*;
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

    public boolean assertIncorrectUserNamePasswordAlertExists( Boolean dismissAlert) {
        try {
            System.out.append(" - Asserting incorrect username and/or password message is correct");

            String expectedMessage = "Failure to login Wrong username or password.";

            if (!Common.waitForAlert(driver))
                return false;
            Boolean isCorrectMessage = Common.assertCorrectMessage(driver, expectedMessage);

            if (dismissAlert) {
                Common.acceptAlert(driver);
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

    public boolean AssertAuthenticationSuccess() {
        TimelineScreen timelineScreen = Screens.TimelineScreen();
        PageFactory.initElements(get_driver(), timelineScreen);
        timelineScreen.AcceptWelcomeMessage();
        return timelineScreen.AssertAuthenticationSuccess();
    }
}
