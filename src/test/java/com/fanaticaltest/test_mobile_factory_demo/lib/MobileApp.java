package com.fanaticaltest.test_mobile_factory_demo.lib;


import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.sql.Timestamp;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import cucumber.api.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class MobileApp {

    private final Logger logger = LoggerFactory.getLogger(MobileApp.class);
    private Property prop = new Property();
    private IOSDriver driver;
    private String urlAppium = prop.read("appium_server_url");
    private String urlAppUnderTest = prop.read("app_under_test_url");
    private String platformName = prop.read("platform_name");
    private String platformVersion = prop.read("platform_version");
    private String deviceName = prop.read("device_name");
    private boolean noReset = Boolean.parseBoolean(prop.read("capability_no_reset"));
    private String appiumVersion = prop.read("appium_version");
    private Stats stats = new Stats();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private long timeout_in_second = Long.parseLong(prop.read("appium_timeout_in_second"), 10);
    private int window_width = Integer.parseInt(prop.read("appium_window_width"));
    private int window_height = Integer.parseInt(prop.read("appium_window_height"));

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
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        stats.setStartTime(sdf.format(timestamp));
        logger.info("============================Scenario starts=========================================");
    }

    public void afterScenario(Scenario scenario)
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        stats.setEndTime(sdf.format(timestamp));
        stats.setScenario(scenario);
        stats.setWindowWidth(window_width);
        stats.setWindowHeight(window_height);
        stats.setTimeoutInSecond(timeout_in_second);
        stats.setScreenshotName("none");
        driver.quit();
        stats.render();
        logger.info("=============================Scenario ends==========================================");
    }

    public void fillField(String value, By by)
    {
        MobileElement selectedField = (MobileElement) driver.findElement(by);
        selectedField.sendKeys(value);
        logger.info("Fill field {} with value {}.", by, value);
    }

    public void tapButton(By by, int fingers, int durationInMillisecond)
    {
        MobileElement selectedButton = (MobileElement) driver.findElement(by);
        selectedButton.tap(fingers,durationInMillisecond);
        logger.info("Tap button {} with {} finger(s) with a duration {} millisecond." , by, fingers, durationInMillisecond);
    }

    public void assertTextInElementBy(String value, By by)
    {
        MobileElement resultField = (MobileElement) driver.findElement(by);
        assertThat(resultField.getText(), containsString(value));
        logger.info("Assert text in the element {} with value {}.", by, value);
    }
}
