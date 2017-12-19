package com.fanaticaltest.fttestmobilefactorydemo.features;


import com.fanaticaltest.ftconfig.Property;
import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigApp {

    private Property p = new Property("./src/main/resources/application.properties");
    private String screenshotPath = p.read("global.screenshotPath");
    private final Logger logger = LoggerFactory.getLogger("APPIUM-ROBOT");

    public AndroidDriver driver;


}
