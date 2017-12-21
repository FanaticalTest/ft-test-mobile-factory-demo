package com.fanaticaltest.fttestmobilefactorydemo.cucumber;

import com.fanaticaltest.ftappium.devices.IosRealDevice;
import com.fanaticaltest.fttestmobilefactorydemo.features.FanaticalFood;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.net.MalformedURLException;

public class FanaticalFoodSteps extends FanaticalFood{

    @Before("@Device=IosRealDevice")
    public void before_scenario()
    {
        IosRealDevice iosRealDevice = new IosRealDevice(p.read("ios.platformVersion"),lic.read("lic.deviceName"),
                p.read("ios.appZipUrl"),lic.read("lic.xcodeOrgId"),lic.read("lic.xcodeSigningId"),
                lic.read("lic.udid"), p.read("appiumServer.appiumVersion"),p.read("appiumServer.appiumServerUrl"));
        try {
            this.driver = iosRealDevice.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @After("@Device=IosRealDevice")
    public void after_scenario()
    {
        IosRealDevice iosRealDevice = new IosRealDevice(p.read("ios.platformVersion"),lic.read("lic.deviceName"),
                p.read("ios.appZipUrl"),lic.read("lic.xcodeOrgId"),lic.read("lic.xcodeSigningId"),
                lic.read("lic.udid"), p.read("appiumServer.appiumVersion"),p.read("appiumServer.appiumServerUrl"));
        iosRealDevice.disconnect(this.driver);
    }

    @Given("^a user sees the Title \"([^\"]*)\" - FanaticalFood$")
    public void a_user_sees_the_Title_FanaticalFood(String val) throws Exception {
        UserSeeTitle(val);
    }

    @When("^a user taps on the button \"([^\"]*)\"$")
    public void a_user_taps_on_the_button(String val) throws Exception {
        UserTapOnLink(val);
    }

    @When("^a user types a meal \"([^\"]*)\" - FanaticalFood$")
    public void a_user_types_a_meal_FanaticalFood(String val) throws Exception {
        UserTypeMeal(val);
    }

}
