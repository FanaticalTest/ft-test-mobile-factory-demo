package com.fanaticaltest.test_mobile_factory_demo.cucumber;

import com.fanaticaltest.test_mobile_factory_demo.testApp.CalculateSum;
import cucumber.api.java.Before;
import cucumber.api.java.After;

import java.net.MalformedURLException;


public class CalculateSumSteps extends CalculateSum{

    @Before
    public void before_scenario()
    {
        try{
            beforeScenario();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @After
    public  void after_scenario()
    {
        afterScenario();
    }
}
