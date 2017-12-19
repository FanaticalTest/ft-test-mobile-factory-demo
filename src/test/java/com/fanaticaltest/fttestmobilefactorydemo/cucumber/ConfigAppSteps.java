package com.fanaticaltest.fttestmobilefactorydemo.cucumber;

import com.fanaticaltest.ftconfig.Property;
import com.fanaticaltest.fttestmobilefactorydemo.features.ConfigApp;
import com.fanaticaltest.ftappium.devices.AndroidRealDevice;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.net.MalformedURLException;

public class ConfigAppSteps extends ConfigApp {

    private Property p = new Property("./src/main/resources/application.properties");

    @Before("@Device=AndroidRealDevice")
    public void before_scenario()
    {
        AndroidRealDevice androidRealDevice = new AndroidRealDevice(p.read("androidRealDevice.platformVersion"),p.read("androidRealDevice.deviceName"),p.read("androidRealDevice.appZipUrl"),p.read("appiumServer.appiumVersion"),p.read("appiumServer.appiumServerUrl"));

        try {
            this.driver = androidRealDevice.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @After("@Device=AndroidRealDevice")
    public void after_scenario()
    {
        AndroidRealDevice androidRealDevice = new AndroidRealDevice(p.read("androidRealDevice.platformVersion"),p.read("androidRealDevice.deviceName"),p.read("androidRealDevice.appZipUrl"),p.read("appiumServer.appiumVersion"),p.read("appiumServer.appiumServerUrl"));
        androidRealDevice.disconnect(this.driver);
    }

    @Given("^a user should see the link \"([^\"]*)\" - AndroidConfigApp$")
    public void a_user_should_see_the_link_AndroidConfigApp(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^a user is taping on \"([^\"]*)\" menu - AndroidConfigApp$")
    public void a_user_is_taping_on_menu_AndroidConfigApp(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
