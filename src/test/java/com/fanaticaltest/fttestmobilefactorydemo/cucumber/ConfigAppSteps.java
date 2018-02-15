package com.fanaticaltest.fttestmobilefactorydemo.cucumber;

import com.fanaticaltest.fttestmobilefactorydemo.features.ConfigApp;
import com.fanaticaltest.ftappium.devices.AndroidRealDevice;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.net.MalformedURLException;

public class ConfigAppSteps extends ConfigApp {

    private String appiumServerUrl = System.getenv("APPIUM_SERVER_URL");

    @Before("@Device=AndroidRealDevice")
    public void before_scenario()
    {
        AndroidRealDevice androidRealDevice = new AndroidRealDevice(p.read("androidRealDevice.platformVersion"),
                p.read("androidRealDevice.deviceName"),p.read("androidRealDevice.appZipUrl"),
                p.read("appiumServer.appiumVersion"),appiumServerUrl);

        try {
            this.driver = androidRealDevice.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @After("@Device=AndroidRealDevice")
    public void after_scenario()
    {
        AndroidRealDevice androidRealDevice = new AndroidRealDevice(p.read("androidRealDevice.platformVersion"),p.read("androidRealDevice.deviceName"),
                p.read("androidRealDevice.appZipUrl"),p.read("appiumServer.appiumVersion"),
                appiumServerUrl);
        androidRealDevice.disconnect(this.driver);
    }

    @Given("^a user should see the link \"([^\"]*)\" - AndroidConfigApp$")
    public void a_user_should_see_the_link_AndroidConfigApp(String val) throws Exception {
        UserSeeLink(val);
    }

    @When("^a user is taping on \"([^\"]*)\" menu - AndroidConfigApp$")
    public void a_user_is_taping_on_menu_AndroidConfigApp(String val) throws Exception {
        UserTapLink(val);
    }

    @Then("^a user is changing the Display name to \"([^\"]*)\" - AndroidConfigApp$")
    public void a_user_is_changing_the_Display_name_to_AndroidConfigApp(String val) throws Exception {
        UserChangeDisplayNameValue(val);
    }


    @Then("^a user should see the textbox with \"([^\"]*)\" - AndroidConfigApp$")
    public void a_user_should_see_the_textbox_with_AndroidConfigApp(String val) throws Exception {
        UserSeeTextBox(val);
    }

    @Then("^a user should see the switch for Enabling social recommendation is \"([^\"]*)\" - AndroidConfigApp$")
    public void a_user_should_see_the_switch_for_Enabling_social_recommendation_is_AndroidConfigApp(String val) throws Exception {
        UserSeeSwitchValue(val);
    }

    @Then("^a user checks if the default value for Enable social recommendations is set to \"([^\"]*)\" - AndroidConfigApp$")
    public void a_user_check_if_the_default_value_for_Enable_social_recommendations_is_set_to_AndroidConfigApp(String val) throws Exception {
        CheckDefaultValueEnableSocialRec(val);
    }

    @When("^a user checks if the default value for Display name is set to \"([^\"]*)\" - AndroidConfigApp$")
    public void a_user_checks_if_the_default_value_for_Display_name_is_set_to_AndroidConfigApp(String val) throws Exception {
        CheckDefaultValueDisplayName(val);
    }

    @Given("^the initial value for adding friends to message is set at \"([^\"]*)\" - AndroidConfigApp$")
    public void the_initial_value_for_adding_friends_to_message_is_set_at_AndroidConfigApp(String val) throws Exception {
        CheckDefaultValueAddFriends(val);
    }

}
