package com.fanaticaltest.fttestmobilefactorydemo.features;


import com.fanaticaltest.ftappium.MobUI;
import com.fanaticaltest.ftconfig.Property;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigApp {

    public Property p = new Property("./src/main/resources/application.properties");
    private Property androidUI = new Property("./src/main/resources/androidConfigApp.properties");
    private String screenshotPath = p.read("global.screenshotPath");
    private final Logger logger = LoggerFactory.getLogger("APPIUM-ROBOT");

    private final By GENERAL_LINK = By.xpath(androidUI.read("androidConfigApp.General"));
    private final By DISPLAY_NAME_LINK = By.xpath(androidUI.read("androidConfigApp.DisplayName"));
    private final By DISPLAY_NAME_TEXTBOX = By.id(androidUI.read("androidConfigApp.DisplayName.TextBox"));
    private final By DISPLAY_NAME_CANCEL = By.id(androidUI.read("androidConfigApp.DisplayName.Cancel"));
    private final By DISPLAY_NAME_OK = By.id(androidUI.read("androidConfigApp.DisplayName.Ok"));

    public AndroidDriver driver;

    public void UserSeeLink(String val)
    {
        MobUI mobUI = new MobUI(driver);
        if (val.equals("General"))
        {
            logger.info(mobUI.assertTextInElementBy(val, GENERAL_LINK));
        }
        else if(val.equals("Display name"))
        {
            logger.info(mobUI.assertTextInElementBy(val,DISPLAY_NAME_LINK));
        }
    }

    public void UserTapLink(String val) {

        MobUI mobUI = new MobUI(driver);
        if (val.equals("General"))
        {
            logger.info(mobUI.tapButtonBy(GENERAL_LINK));
        }
        else if(val.equals("Display name"))
        {
            logger.info(mobUI.tapButtonBy(DISPLAY_NAME_LINK));
        }
        else if(val.equals("CANCEL"))
        {
            logger.info(mobUI.tapButtonBy(DISPLAY_NAME_CANCEL));
        }
        else if(val.equals("OK"))
        {
            logger.info(mobUI.tapButtonBy(DISPLAY_NAME_OK));
        }
    }

    public void UserSeeTextBox(String val)
    {
        MobUI mobUI = new MobUI(driver);
        logger.info(mobUI.assertTextInElementBy(val,DISPLAY_NAME_TEXTBOX));
    }

    public void UserChangeDisplayNameValue(String val)
    {
        MobUI mobUI = new MobUI(driver);
        logger.info(mobUI.fillFieldBy(val,DISPLAY_NAME_TEXTBOX));
    }
}
