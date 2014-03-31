package com.IntegrativeNutrition.IIN_Learning_Center.Global;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

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
}
