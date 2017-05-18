package com.fanaticaltest.test_mobile_factory_demo.cucumber;

import com.fanaticaltest.test_mobile_factory_demo.testApp.CalculateSum;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.Scenario;
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
    public  void after_scenario(Scenario scenario)
    {
        afterScenario(scenario);
    }

    @When("^a user is typing the first value \"([^\"]*)\"$")
    public void a_user_is_typing_the_first_value(String firstVal) throws Throwable {
        EnterFirstValue(firstVal);
    }

    @When("^a user is typing the second value \"([^\"]*)\"$")
    public void a_user_is_typing_the_second_value(String secondVal) throws Throwable {
        EnterSecondValue(secondVal);
    }

    @Then("^a user should see the sum equal to \"([^\"]*)\"$")
    public void a_user_should_see_the_sum_equal_to(String sumResult) throws Throwable {
        CheckSumValue(sumResult);
    }

    @When("^a user is tapping Show alert$")
    public void a_user_is_tapping_Show_alert() throws Throwable {
        TapLinkShowAlert();
    }

    @When("^a user is tapping on OK$")
    public void a_user_is_tapping_on_OK() throws Throwable {
        TapOkShowAlert();
    }

    @Then("^a user should see in the result sum \"([^\"]*)\"$")
    public void a_user_should_see_in_the_result_sum(String sumResult) throws Throwable {
        CheckSumValue(sumResult);
    }
}
