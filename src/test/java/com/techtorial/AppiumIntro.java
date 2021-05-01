package com.techtorial;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumIntro {

    @Test
    public  void test1() throws MalformedURLException {
        File appFile= new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "renas63");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("app", appFile.getAbsolutePath());

        URL appiumServerUrl=new URL("http://localhost:4723/wd/hub");
        AndroidDriver<AndroidElement> driver=new AndroidDriver(appiumServerUrl,desiredCapabilities);
        AndroidElement accessibilityLink= driver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility']"));

        String text=accessibilityLink.getText();
        System.out.println(text);
        accessibilityLink.click();

    }
    @Test
    public void test2() throws MalformedURLException {

        File apkFile= new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability("deviceName", "renas63");

        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath() );


        URL appiumServerUrl= new URL("http://localhost:4723/wd/hub");

        AndroidDriver<AndroidElement> driver= new AndroidDriver<AndroidElement>(appiumServerUrl, desiredCapabilities);

     AndroidElement animationButton=   driver.findElement(By.xpath("//android.widget.TextView[@text='Animation']"));

        AndroidElement contentButton=   driver.findElement(By.xpath("//android.widget.TextView[@text='Content']"));

        AndroidElement appButton=   driver.findElement(By.xpath("//android.widget.TextView[@text='App']"));

        animationButton.click();
        driver.navigate().back();

        appButton.click();
        driver.navigate().back();

        contentButton.click();



    }
}
