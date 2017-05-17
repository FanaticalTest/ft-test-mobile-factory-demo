package com.fanaticaltest.test_mobile_factory_demo.lib;


import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class MobileApp {

    private IOSDriver driver;
    private String urlAppium = "http://docker.sak:4723/wd/hub";

    public void beforeScenario() throws MalformedURLException
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "http://appium.s3.amazonaws.com/TestApp7.1.app.zip");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability("appiumVersion", "1.6.4");

        URL urlAppiumServer = new URL(urlAppium);
        driver = new IOSDriver(urlAppiumServer, desiredCapabilities);
    }

    public void afterScenario()
    {
        driver.quit();
    }

    public void fillField(String value, By by)
    {
        MobileElement selectedField = (MobileElement) driver.findElement(by);
        selectedField.sendKeys(value);
    }

    public void clickButton(By by)
    {
        MobileElement selectedButton = (MobileElement) driver.findElement(by);
        selectedButton.tap(1,1000);
    }

    public void assertTextInElementBy(String value, By by)
    {
        MobileElement resultField = (MobileElement) driver.findElement(by);
        assertThat(resultField.getText(), containsString(value));
    }
}
