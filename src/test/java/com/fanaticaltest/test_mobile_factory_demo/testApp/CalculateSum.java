package com.fanaticaltest.test_mobile_factory_demo.testApp;

import com.fanaticaltest.test_mobile_factory_demo.lib.MobileApp;
import org.openqa.selenium.By;



public class CalculateSum  extends MobileApp{

    private static final By FIRST_FIELD = By.name("IntegerA");
    private static final By SECOND_FIELD = By.name("IntegerB");
    private static final By COMPUTE_BUTTON = By.name("ComputeSumButton");
    private static final By ANSWER_FIELD = By.name("Answer");

    public void EnterFirstValue(String val)
    {
        fillField(val,FIRST_FIELD);
    }

    public void EnterSecondValue(String val)
    {
        fillField(val,SECOND_FIELD);
        clickButton(COMPUTE_BUTTON);
    }

    public void CheckSumValue(String val)
    {
        assertTextInElementBy(val, ANSWER_FIELD);
    }
}
