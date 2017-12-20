package com.fanaticaltest.fttestmobilefactorydemo.features;


import com.fanaticaltest.ftappium.MobUI;
import com.fanaticaltest.ftconfig.Property;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculateSum {

    private Property p = new Property("./src/main/resources/application.properties");
    private String screenshotPath = p.read("global.screenshotPath");
    private final Logger logger = LoggerFactory.getLogger("APPIUM-ROBOT");

    private static final By FIRST_FIELD = By.name("IntegerA");
    private static final By SECOND_FIELD = By.name("IntegerB");
    private static final By COMPUTE_BUTTON = By.name("ComputeSumButton");
    private static final By ANSWER_FIELD = By.name("Answer");
    private static final By LINK_SHOW_ALERT = By.name("show alert");
    private static final String ALERT_OK_BUTTON = "OK";
    private static final String ALERT_COOL_TITLE = "this alert is so cool.";
    private static final By SLIDER_APPELEM = By.xpath("//XCUIElementTypeSlider[@name=\"AppElem\"]");


    public IOSDriver driver;

    public void EnterFirstValue(String val)
    {
        MobUI mobUI = new MobUI(this.driver);
        logger.info(mobUI.fillFieldBy(val,FIRST_FIELD));
    }

    public void EnterSecondValue(String val)
    {
        MobUI mobUI = new MobUI(this.driver);
        logger.info(mobUI.fillFieldBy(val,SECOND_FIELD));
        logger.info(mobUI.tapButtonBy(COMPUTE_BUTTON));
    }

    public void CheckSumValue(String val)
    {
        MobUI mobUI = new MobUI(this.driver);
        logger.info(mobUI.assertTextInElementBy(val, ANSWER_FIELD));
    }

    public void TapLinkShowAlert()
    {
        MobUI mobUI = new MobUI(this.driver);
        logger.info(mobUI.tapButtonBy(LINK_SHOW_ALERT));
        logger.info("Find element Cool title : " + String.valueOf(mobUI.isVisibleElementBy(By.name("Cool title"))));
    }

    public void TapOkShowAlert()
    {
        MobUI mobUI = new MobUI(this.driver);
        logger.info(mobUI.handleAlertMessageByAccessibilityId(ALERT_COOL_TITLE,ALERT_OK_BUTTON));
    }

    public void MoveSliderTo(String val)
    {
        MobUI mobUI = new MobUI(this.driver);
        logger.info(mobUI.swipeSliderBy(SLIDER_APPELEM,val));
    }

    public  void CheckSliderValueWithScreenShot(String val) throws Exception {

        MobUI mobUI = new MobUI(this.driver);
        logger.info(mobUI.getScreenshot(screenshotPath, "slider"));
    }

    public void CheckAssertTextInLink(String val)
    {
        MobUI mobUI = new MobUI(this.driver);
        mobUI.assertTextInElementBy("show alert",LINK_SHOW_ALERT );
    }
}
