package com.techtorial;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Locators {

    /*
    launch the application
    navigate to reference --> Switch--> Check  checkbox preferences
    verify the checkbox is select

     */

    @Test
    public void testId() throws MalformedURLException, InterruptedException {
        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability("deviceName", "renas63");
        desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());
        desiredCapabilities.setCapability("newCommandTimeout", "300");
        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumServerUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement preferenceButton = driver.findElement(By.xpath("//*[@content-desc='Preference']"));
        preferenceButton.click();
        AndroidElement switchButton = driver.findElement(By.xpath("//android.widget.TextView[@text='9. Switch']"));
        switchButton.click();
        AndroidElement checkBox = driver.findElement(By.id("android:id/checkbox"));
        Assert.assertFalse(checkBox.isSelected());
        checkBox.click();
        Thread.sleep(2000);
        checkBox = driver.findElement(By.id("android:id/checkbox"));
        System.out.println(checkBox.getAttribute("checked"));
        System.out.println(checkBox.isSelected());
        Assert.assertTrue(checkBox.isSelected());
    }
    @Test
    public void test2() throws MalformedURLException, InterruptedException {
        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability("deviceName", "renas63");
        desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());
        desiredCapabilities.setCapability("newCommandTimeout", "300");
        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumServerUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement viewsButton = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        viewsButton.click();
    }
    @Test
    public void test3() throws MalformedURLException, InterruptedException {
        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability("deviceName", "renas63");
        desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());
        desiredCapabilities.setCapability("newCommandTimeout", "300");
        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumServerUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement views = driver.findElementByAccessibilityId("Views");
        views.click();
    }
}
