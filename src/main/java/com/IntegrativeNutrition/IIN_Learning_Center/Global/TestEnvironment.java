package com.IntegrativeNutrition.IIN_Learning_Center.Global;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date Created: 3/28/14
 * Contains test environment methods. This class is used when setting up a test.
 */

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestEnvironment {
    private static SwipeableWebDriver _driver;
    private static WebDriverWait _waitForElement;

    public static SwipeableWebDriver get_driver() {
        return _driver;
    }

    public static WebDriverWait get_waitForElement() {
        return _waitForElement;
    }

    public static SwipeableWebDriver StartEnvironment(String appPath, String browserName, String browserVersion,
                                                      String browserPlatform, String appPackage, String appActivity,
                                                      String testURL) {
        try {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
            capabilities.setCapability(CapabilityType.VERSION, browserVersion);
            capabilities.setCapability(CapabilityType.PLATFORM, browserPlatform);
            capabilities.setCapability("app", appPath);
            if (browserName.toLowerCase() == "android") {
                capabilities.setCapability("device", "AndroidPages");
                capabilities.setCapability("app-package", appPackage);
                capabilities.setCapability("app-activity", appActivity);
            }
            else {
                capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
            }

            URL url = new URL(testURL);
            _driver = new SwipeableWebDriver(url, capabilities);
            _driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            return _driver;
        }
        catch (Exception seleniumError)
        {
            System.out.println(seleniumError.getMessage());
            return null;
        }
    }

    public static void StopEnvironment() {
        try {
            _driver.quit();
            _driver = null ;
        }
        catch (Exception seleniumError)
        {
            System.out.println(seleniumError.getMessage());
        }
    }
}


