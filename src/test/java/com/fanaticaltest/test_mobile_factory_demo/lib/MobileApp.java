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

    private Property prop = new Property();
    private IOSDriver driver;
    private String urlAppium = prop.read("appium_server_url");
    private String urlAppUnderTest = prop.read("app_under_test_url");
    private String platformName = prop.read("platform_name");
    private String platformVersion = prop.read("platform_version");
    private String deviceName = prop.read("device_name");
    private boolean noReset = Boolean.parseBoolean(prop.read("capability_no_reset"));
    private String appiumVersion = prop.read("appium_version");

    public void beforeScenario() throws MalformedURLException
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, urlAppUnderTest);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, noReset);
        desiredCapabilities.setCapability("appiumVersion", appiumVersion);

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

    public void tapButton(By by, int fingers, int durationInMillisecond)
    {
        MobileElement selectedButton = (MobileElement) driver.findElement(by);
        selectedButton.tap(fingers,durationInMillisecond);
    }

    public void assertTextInElementBy(String value, By by)
    {
        MobileElement resultField = (MobileElement) driver.findElement(by);
        assertThat(resultField.getText(), containsString(value));
    }
}
