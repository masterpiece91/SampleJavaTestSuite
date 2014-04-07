package com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS;

import com.IntegrativeNutrition.IIN_Learning_Center.Global.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 4/04/14
 * Contains all elements of the timeline screen
 */

public class TimelineScreen {

    /************************************
     * CONSTRUCTORS
     ***********************************/
    public TimelineScreen(SwipeableWebDriver _driver) {
        this.driver = _driver;
    }

    /************************************
     * PAGE ELEMENTS SETUP
     ***********************************/

    @FindBys({@FindBy(how = How.XPATH, using = "//window[1]/scrollview[1]/button")})
            private List<WebElement> timelineActivityList;

    //This element will always exist
    @FindBy(how = How.NAME, using = "iconGradcap")
            private WebElement iconGradcapButton;

    SwipeableWebDriver driver;
    List<WebElement> expandedTimelineActivityList;

    /************************************
     * PAGE TEST METHODS
     ************************************/

    public boolean AcceptWelcomeMessage() {
        String expectedMessage = "You Made It! Welcome to the Classroom. Would you like to take a tour before using the app?";
        return Common.acceptAlert(driver, expectedMessage);
    }

    public boolean DismissWelcomeMessage() {
        String expectedMessage = "You Made It! Welcome to the Classroom. Would you like to take a tour before using the app?";
        return Common.dismissAlert(driver, expectedMessage);

    }

    /* In order to confirm authentication we confirm the existence of an element that should always be there. */
    public boolean AssertAuthenticationSuccess() {
        try {
            if (iconGradcapButton.isDisplayed()) {
                return true;
            }

            return false;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void findAnAssigment() {
        //In order to find a list of assignments, we must expand every
    }

    public void completeAssigment() {
    }

    public boolean AssertAssigmentComplete() {
        return true;
    }

    /************************************
     * PRIVATE METHODS
     ************************************/

    /* Purpose is to expand all Modules available in order to gather all activities */
    private void expandAllModules() {
        System.out.println();

        for (WebElement timelineViewItems : timelineActivityList) {
            System.out.append(timelineViewItems.getText());
            if (timelineViewItems.getText().contains("MODULE"))     {
                System.out.append(" - IsModule");
                if (timelineViewItems.isEnabled()) {
                    System.out.append(" - IsEnabled");
                    timelineViewItems.click();  //This will expand
                }
            }
            System.out.println();
        }
    }

    private void captureAllElementsOnExpandedTimeline() {
        expandedTimelineActivityList = driver.findElements(By.xpath("//window[1]/scrollview[1]/button"));
    }

    private void identifyActivity() {
        for (WebElement timelineViewItem : expandedTimelineActivityList) {

        }
    }
}


