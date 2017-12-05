package com.fanaticaltest.fttestmobilefactorydemo.devices;

import com.fanaticaltest.ftconfig.Property;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;



public class IosSimulator {

    private Property p = new Property("./src/main/resources/application.properties");

    public IosSimulator() {}

    public IOSDriver beforeScenario() throws MalformedURLException
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, p.read("iosSim.platformName"));
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, p.read("iosSim.platformVersion"));
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, p.read("iosSim.deviceName"));
        desiredCapabilities.setCapability(MobileCapabilityType.APP, p.read("iosSim.appZipUrl"));
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, Boolean.parseBoolean(p.read("iosSim.noReset")));
        desiredCapabilities.setCapability("appiumVersion", p.read("iosSim.appiumVersion"));

        URL urlAppiumServer = new URL(p.read("iosSim.appiumServerUrl"));
        return (new IOSDriver(urlAppiumServer, desiredCapabilities));
    }

    public void afterScenario(IOSDriver driver)
    {
        driver.quit();
    }


}
