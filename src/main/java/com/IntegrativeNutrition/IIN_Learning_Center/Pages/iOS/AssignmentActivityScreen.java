package com.IntegrativeNutrition.IIN_Learning_Center.Pages.iOS;

import com.IntegrativeNutrition.IIN_Learning_Center.Global.*;
import static com.IntegrativeNutrition.IIN_Learning_Center.Global.TestEnvironment.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 4/04/14
 * Contains all elements of Assignment Activity Screen
 */

public class AssignmentActivityScreen {

    /************************************
     * CONSTRUCTORS
     ***********************************/
    public AssignmentActivityScreen(SwipeableWebDriver _driver) {
        this.driver = _driver;
    }

    /************************************
     * PAGE ELEMENTS SETUP
     ***********************************/

    @FindBy(how = How.XPATH, using = "//window[1]/scrollview[1]/textview[1]")
            private WebElement assignmentDescriptionTexView;

    @FindBy(how = How.XPATH, using = "//window[1]/scrollview[1]/text[1]")
            private WebElement assignmentTitleLabel;

    @FindBy(how = How.NAME, using = "Assignment Complete")
            private WebElement completeAssignmentButton;

    SwipeableWebDriver driver;

    /************************************
     * PAGE TEST METHODS
     ************************************/
}
