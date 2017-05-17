package com.fanaticaltest.test_mobile_factory_demo.lib;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileApp {

    private DesiredCapabilities capabilities;
    private IOSDriver driver;
    private String urlAppium = "";

    public void beforeScenario() throws MalformedURLException
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.3");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "http://appium.s3.amazonaws.com/TestApp7.1.app.zip");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        //desiredCapabilities.setCapability("appiumVersion", "1.3.4");

        URL urlAppiumServer = new URL(urlAppium);
        driver = new IOSDriver(urlAppiumServer, desiredCapabilities);
    }

    public void afterScenario()
    {
        driver.quit();
    }
}
