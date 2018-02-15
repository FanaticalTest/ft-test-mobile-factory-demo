package com.fanaticaltest.fttestmobilefactorydemo.features;


import com.fanaticaltest.ftappium.MobUI;
import com.fanaticaltest.ftconfig.Property;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
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
    private final By ENABLE_SOCIAL_REC = By.id(androidUI.read("androidConfigApp.EnableSocialRec.Switch"));
    private final By ADD_FRIENDS_TEXTBOX = By.id(androidUI.read("androidConfigApp.AddFriends.TextBox"));
    private final By ADD_FRIENDS_NEVER = By.id(androidUI.read("androidConfigApp.AddFriends.Never"));
    private final By ADD_FRIENDS_ALWAYS = By.id(androidUI.read("androidConfigApp.AddFriends.Always"));

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

    public void UserTapLink(String val) throws Exception {

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
            logger.info(mobUI.freezeProcess(1L));
        }
        else if (val.equals("Switch enabling social recommendations"))
        {
            logger.info(tapOnOffSwitch(ENABLE_SOCIAL_REC));
            logger.info(mobUI.freezeProcess(1L));
        }
        else if (val.equals("Add friends to messages"))
        {
            logger.info(mobUI.tapButtonBy(ADD_FRIENDS_TEXTBOX));
            logger.info(mobUI.freezeProcess(1L));
        }
        else if (val.equals("Add friends Never"))
        {
            logger.info(mobUI.tapButtonBy(ADD_FRIENDS_NEVER));
            logger.info(mobUI.freezeProcess(1L));
        }
        else if (val.equals("Add friends Always"))
        {
            logger.info(mobUI.tapButtonBy(ADD_FRIENDS_ALWAYS));
            logger.info(mobUI.freezeProcess(1L));
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

    public void UserSeeSwitchValue(String val)
    {
        MobUI mobUI = new MobUI(driver);
        logger.info(mobUI.assertTextInElementBy(val,ENABLE_SOCIAL_REC));
    }

    public void CheckDefaultValueEnableSocialRec(String val)
    {
        MobUI mobUI = new MobUI(driver);

        if (!checkTextInElementBy(val, ENABLE_SOCIAL_REC))
        {
            logger.info(tapOnOffSwitch(ENABLE_SOCIAL_REC));
            logger.info(mobUI.freezeProcess(1L));
        }
    }

    public void CheckDefaultValueDisplayName(String val)throws Exception
    {
        UserTapLink("Display name");
        UserChangeDisplayNameValue(val);
        UserTapLink("OK");
    }

    public void CheckDefaultValueAddFriends(String val) throws Exception
    {
        MobUI mobUI = new MobUI(driver);

        if (!checkTextInElementBy(val,ADD_FRIENDS_TEXTBOX))
        {
            UserTapLink("Add friends to messages");
            UserTapLink("Add friends Never");
        }
    }

    //To be moved in ft-appium in v0.1.8
    @Deprecated
    private String tapOnOffSwitch(By by)
    {
        MobileElement mobileElement = (MobileElement) driver.findElement(by);
        String initialValue = mobileElement.getText();
        mobileElement.click();
        String finalValue = mobileElement.getText();
        Assert.assertNotEquals(initialValue,finalValue);
        return ("Tap On/Off switch " + by + " - initial value was : " + initialValue + " - final value is : " + finalValue);
    }

    //To be moved in ft-appium in v0.1.8
    @Deprecated
    private boolean checkTextInElementBy(String expectedVal, By by)
    {
        MobileElement mobileElement = (MobileElement) driver.findElement(by);
        String currentVal = mobileElement.getText();
        logger.info("Assert Text in element : " + by + " - current text is : " + currentVal + " - and the value should be : " + expectedVal);
        return expectedVal.equals(currentVal);
    }

}
