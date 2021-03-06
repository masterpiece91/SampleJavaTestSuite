package com.IntegrativeNutrition.IIN_Learning_Center.Global;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.IntegrativeNutrition.IIN_Learning_Center.DrupalServices.DrupalTools;
import com.IntegrativeNutrition.IIN_Learning_Center.DrupalServices.User;
import com.IntegrativeNutrition.IIN_Learning_Center.DrupalServices.UserAddress;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 11/13/13
 * Time: 9:59 AM
 * Contains all methods that are common to the whole test suite
 */
public class Common {
    public static void setFocusOnSimulator() {
        try {
            // Script for setting iPhone Simulator to foreground
            String[] cmd = {"osascript", "-e", "tell application \"iPhone Simulator\" to activate"};
            Process ls;
            ls = Runtime.getRuntime().exec(cmd);
            ls.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void captureScreenShot(String screenShotName, String imageType, boolean includeDateTime){
        BufferedImage screenCapture;
        File file;
        String folderName = "ScreenShots";
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd_HH");

        try {
            if (includeDateTime) {
                Date currentDateTime = new Date();
                folderName = folderName + "_" + simpleDate.format(currentDateTime.getTime());
                simpleDate.applyPattern("yyyy-MM-dd_HH-mm-ssZ");
                screenShotName = screenShotName + "_" + simpleDate.format(currentDateTime.getTime());
             }

            file = new File(folderName);

            /*If folder does not exists create it.*/
            if (!file.exists())
            {
                if(file.mkdir())
                {
                    file = new File(folderName + "/" + screenShotName);
                }
                else
                {
                    file = new File(screenShotName);
                }
            }
            else
            {
                file = new File(folderName + "/" + screenShotName);
            }

            screenCapture = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

            /* Ensure that only 3 image formats are allowed otherwise default to jpg */
            if (imageType.equals("jpg") || imageType.equals("png") || imageType.equals("img")) {
                ImageIO.write(screenCapture, imageType, file);
            } else {
                ImageIO.write(screenCapture, "jpg", file);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static boolean clickIPhoneIPadHomeButton(){
        Robot robot;
        try {
            robot = new Robot();
            setFocusOnSimulator();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_H);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_H);

            Thread.sleep(2000);

            //Capture image
            captureScreenShot("Classroom_App_clickIPhoneIPadHomeButton", "png", true);

            return true;
        } catch (AWTException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean sendIPhoneIPadAppToBackground() {
        try {
            JavascriptExecutor javascriptExecutor = TestEnvironment.get_driver();
            javascriptExecutor.executeScript("au.backgroundApp(5)"); //my application should wait for 6 seconds in background

            //Capture image
            captureScreenShot("Classroom_App_sendIPhoneIPadAppToBackground", "png", true);

            return true;
        } catch (Exception seleniumError)
        {
            seleniumError.printStackTrace();
            return false;
        }
    }

    public static boolean toggleIPhoneIPadInCallStatusBar() {
        Robot robot;
        try {
            robot = new Robot();
            setFocusOnSimulator();

            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_Y);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_Y);

            Thread.sleep(2000);

            //Capture image
            captureScreenShot("Classroom_App_toggleIPhoneIPadInCallStatusBar", "png", true);

            return true;
        } catch (AWTException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean simulateIPhoneIPadMemoryWarning(){
        Robot robot;
        try {
            robot = new Robot();
            setFocusOnSimulator();

            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_M);

            Thread.sleep(2000);

            //Capture image
            captureScreenShot("Classroom_App_simulateIPhoneIPadMemoryWarning", "png", true);

            return true;
        } catch (AWTException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean simulateIPhoneIPadHardwareKeyboard(){
        Robot robot;
        try {
            robot = new Robot();
            setFocusOnSimulator();

            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_M);

            Thread.sleep(6000);

            //Capture image
            captureScreenShot("Classroom_App_simulateIPhoneIPadHardwareKeyboard", "png", true);

            return true;
        } catch (AWTException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean rotateIPhoneIPadLeft(){
        Robot robot;
        try {
            robot = new Robot();
            setFocusOnSimulator();

            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.keyRelease(KeyEvent.VK_LEFT);
            robot.keyRelease(KeyEvent.VK_META);

            Thread.sleep(2000);

            //Capture image
            captureScreenShot("Classroom_App_rotateIPhoneIPadLeft", "png", true);

            return true;
        } catch (AWTException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean rotateIPhoneIPadRight(){
        Robot robot;
        try {
            robot = new Robot();
            setFocusOnSimulator();

            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_RIGHT);

            Thread.sleep(2000);

            //Capture image
            captureScreenShot("Classroom_App_rotateIPhoneIPadRight", "png", true);

            return true;
        } catch (AWTException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean shakeIPhoneIPadDevice(){
        Robot robot;
        try {
            robot = new Robot();
            setFocusOnSimulator();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_Z);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_Z);

            Thread.sleep(2000);

            //Capture image
            captureScreenShot("Classroom_App_shakeIPhoneIPadDevice", "png", true);

            return true;
        } catch (AWTException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean assertCorrectMessage(SwipeableWebDriver driver, String expectedMessage) {
        if (driver.switchTo().alert().getText().contentEquals(expectedMessage)) {
            return  true;
        }

        return  false;
    }

    public static void acceptAlert(SwipeableWebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static  boolean acceptAlert(SwipeableWebDriver driver, String expectedMessage) {
        if (assertCorrectMessage(driver, expectedMessage)) {
            driver.switchTo().alert().accept();
            return  true;
        }

        return false;
    }

    public static void dismissAlert(SwipeableWebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public static boolean dismissAlert(SwipeableWebDriver driver, String expectedMessage) {
        if (assertCorrectMessage(driver, expectedMessage)) {
            driver.switchTo().alert().dismiss();
            return  true;
        }

        return false;
    }

    public static boolean waitForAlert(SwipeableWebDriver driver) {
        return Common.waitForAlert(driver, 10);
    }

    public static boolean waitForAlert(SwipeableWebDriver driver, int waitDuration) {
        int tries = 0;
        int maxTries = waitDuration;
        while (tries < maxTries)
        {
            System.out.println();
            System.out.println("Waiting for alert");
            System.out.println();
            tries++;

            try
            {
                driver.switchTo().alert();
                return true;
            }
            catch (Exception exception)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
        System.out.println();
        System.out.println("Failed to find alert");
        System.out.println();
        return false;
    }

    public static boolean assertAlertIsCorrect(SwipeableWebDriver driver, String systemOutMessage, String expectedMessage, Boolean acceptAlert) {
        try {
            System.out.append(systemOutMessage);

            if (!Common.waitForAlert(driver))
                return false;
            Boolean isCorrectMessage = Common.assertCorrectMessage(driver, expectedMessage);

            if (acceptAlert) {
                Common.acceptAlert(driver);
            }
            else{
                Common.dismissAlert(driver);
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

    public static boolean clickWebElement(WebElement webElement, String systemOutMessage)
    {
        try {
            System.out.append(systemOutMessage);
            //perform swipe gesture
            webElement.click();
            System.out.println("  -  Successful");
            return true;
        }
        catch (Exception exception) {
            System.out.println("  -  Error Found... Read below:");
            System.out.println("======================================================================================");
            System.out.println("*** attemptAuthentication failed - " + exception.getMessage());
            System.out.println("======================================================================================");
            System.out.println();
            return false;
        }
    }

    public static boolean assertKeyboardIsEmail(SwipeableWebDriver driver)
    {
        try{
   //         driver.elementByXpath("//window[2]/UIAKeyboard[1]");
            return true;
        }
        catch (Exception exception) {
            System.out.println("  -  Error Found... Read below:");
            System.out.println("======================================================================================");
            System.out.println("*** assertIncorrectUserNamePasswordMessageExists failed - " + exception.getMessage());
            System.out.println("======================================================================================");
            System.out.println();
            return false;
        }
    }

    // convert InputStream to String
    public static String convertInputStreamToString(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

    public static User createAndEnrollStudent(String userName, String password) throws Exception {
        DrupalTools drupalTools = new DrupalTools("test.learn.iin.nu");
        drupalTools.LoginToSite(userName, password, true);

        // Use date & time to create unique variables
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();

        User newStudent = new User();
        UserAddress homeAddress = new UserAddress();
        UserAddress shippingAddress = new UserAddress();
        UserAddress workAddress = new UserAddress();

        newStudent.setFirstName("automated");
        newStudent.setLastName("tool");
        newStudent.setName("tester-" + dateFormat.format(date));

        //Must change email. Gmail allows you to provide "tags" along with email address.
        //This allows us to use the same email address while providing a unique value for the backend.
        newStudent.setEmail("masterpiece91+" + dateFormat.format(date) + "@gmail.com");
        newStudent.setContactPhone("212-555-1234");
        newStudent.setDisplayName("tester-" + dateFormat.format(date));
        newStudent.setInitialSetupCompleted(false);
        newStudent.setMigrated(false);
        newStudent.setFinancialStanding("1");

        homeAddress.setAddressType("home");
        homeAddress.setPostalCode("10016");
        homeAddress.setCountry("US");
        homeAddress.setProvince("NY");
        homeAddress.setCity("New York");
        homeAddress.setAddress1("test ave");
        homeAddress.setAddress2("apt 3");

        newStudent.setUserHomeAddress(homeAddress);

        shippingAddress.setAddressType("shipping");
        shippingAddress.setPostalCode("10016");
        shippingAddress.setCountry("US");
        shippingAddress.setProvince("NY");
        shippingAddress.setCity("New York");
        shippingAddress.setAddress1("test ave");
        shippingAddress.setAddress2("apt 3");

        newStudent.setUserShippingAddress(shippingAddress);

        workAddress.setAddressType("work");
        workAddress.setPostalCode("10016");
        workAddress.setCountry("US");
        workAddress.setProvince("NY");
        workAddress.setCity("New York");
        workAddress.setAddress1("test ave");
        workAddress.setAddress2("apt 3");

        newStudent.setUserWorkAddress(workAddress);

        //Once you have provided all info then simply make call to create user and then based on that user create new
        //enrollment.
        return drupalTools.enrollStudent(drupalTools.createNewStudent(newStudent));
    }
}
