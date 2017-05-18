package com.fanaticaltest.test_mobile_factory_demo.testApp;

import com.fanaticaltest.test_mobile_factory_demo.lib.MobileApp;
import com.fanaticaltest.test_mobile_factory_demo.lib.Property;
import org.openqa.selenium.By;



public class CalculateSum  extends MobileApp{

    private Property prop = new Property();
    private int tapDurationMillisecond = Integer.parseInt(prop.read("tap_duration_millisecond"));
    private static final By FIRST_FIELD = By.name("IntegerA");
    private static final By SECOND_FIELD = By.name("IntegerB");
    private static final By COMPUTE_BUTTON = By.name("ComputeSumButton");
    private static final By ANSWER_FIELD = By.name("Answer");
    private static final By LINK_SHOW_ALERT = By.name("show alert");
    private static final By ALERT_OK_BUTTON = By.name("OK");

    public void EnterFirstValue(String val)
    {
        fillField(val,FIRST_FIELD);
    }

    public void EnterSecondValue(String val)
    {
        fillField(val,SECOND_FIELD);
        getIntermediateScreenshots("mid");
        tapButton(COMPUTE_BUTTON,1,tapDurationMillisecond);
    }

    public void CheckSumValue(String val)
    {
        assertTextInElementBy(val, ANSWER_FIELD);
    }

    public void TapLinkShowAlert()
    {
        tapButton(LINK_SHOW_ALERT,1,tapDurationMillisecond);
    }

    public void TapOkShowAlert()
    {
        tapButton(ALERT_OK_BUTTON,1,tapDurationMillisecond);
    }
}
