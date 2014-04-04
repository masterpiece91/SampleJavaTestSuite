package com.IntegrativeNutrition.IIN_Learning_Center.Common;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 4/4/14
 * Common methods that all classes need to call.
 */

import com.IntegrativeNutrition.IIN_Learning_Center.Global.*;
import org.testng.annotations.*;

/**************************************
 * Prerequisites for all tests classes
 **************************************/

public abstract class TestStarter {

    @BeforeClass(alwaysRun = true)
    public static void TestSetup() {
        TestEnvironment.StartEnvironment(System.getProperty("appPath"),
                System.getProperty("browserName"),
                System.getProperty("browserVersion"),
                System.getProperty("browserPlatform"),
                System.getProperty("appPackage"),
                System.getProperty("appActivity"),
                System.getProperty("testURL"));
    }

    @AfterClass(alwaysRun = true)
    public static void TestCleanUp() {
        TestEnvironment.StopEnvironment();
    }

}
