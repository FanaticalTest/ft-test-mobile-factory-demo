package com.fanaticaltest.fttestmobilefactorydemo.features;


import com.fanaticaltest.ftappium.MobUI;
import com.fanaticaltest.ftconfig.Property;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FanaticalFood {

    public Property p = new Property("./src/main/resources/application.properties");
    public Property iosUI =  new Property("./src/main/resources/iosFanaticalFood.properties");
    public Property lic = new Property("./src/main/resources/licences.properties");
    private final Logger logger = LoggerFactory.getLogger("APPIUM-ROBOT");

    public IOSDriver driver;

    private final By MEAL_TITLE = By.xpath(iosUI.read("iosFanaticalFood.Title.ByXpath"));
    private final By DISPLAY_NAME_LINK = By.xpath(iosUI.read("iosFanaticalFood.TextBox.ByXpath"));
    private final By SUBMIT_LINK = By.xpath(iosUI.read("iosFanaticalFood.Link.ByXpath"));

    public void UserSeeTitle(String val)
    {
        MobUI mobUI = new MobUI(driver);
        logger.info(mobUI.assertTextInElementBy(val,MEAL_TITLE));
    }

    public void UserTapOnLink(String val)
    {
        MobUI mobUI = new MobUI(driver);
        logger.info(mobUI.tapButtonBy(SUBMIT_LINK));
    }

    public void UserTypeMeal(String val)
    {
        MobUI mobUI = new MobUI(driver);
        logger.info(mobUI.fillFieldBy(val,DISPLAY_NAME_LINK));
        logger.info(mobUI.tapButtonByAccessibilityId("Return"));
    }

}
