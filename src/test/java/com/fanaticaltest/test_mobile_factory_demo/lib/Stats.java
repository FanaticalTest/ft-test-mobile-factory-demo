package com.fanaticaltest.test_mobile_factory_demo.lib;

import cucumber.api.Scenario;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stats {

    private String mStartTime;
    private String mEndTime;
    private Scenario mScenario;
    private int mWindowWidth;
    private int mWindowHeight;
    private long mTimeoutInSecond;
    private String mScreenshotName;

    public void setStartTime(String value){this.mStartTime=value;}
    public void setEndTime(String value){this.mEndTime=value;}
    public void setScenario(Scenario value){this.mScenario=value;}
    public void setWindowWidth(int value){this.mWindowWidth=value;}
    public void setWindowHeight(int value){this.mWindowHeight=value;}
    public void setTimeoutInSecond(long value){this.mTimeoutInSecond=value;}
    public void setScreenshotName(String value){this.mScreenshotName=value;}

    public String getEndTime(){return this.mEndTime;}

    public void render(){
        final Logger logger = LoggerFactory.getLogger(Stats.class);
        Property prop = new Property();
        String urlBuilder = prop.read("ft_test_log_url");
        int ft_test_log_required = Integer.parseInt(prop.read("ft_test_log_required"));
        LogTest logTest = new LogTest();

        try {
            logger.info("******Scenario statistics******");
            logger.info("Test started at : {} ", mStartTime);
            urlBuilder += "test_start_date=" + URLEncoder.encode(mStartTime, "UTF-8") +"&";
            logger.info("Test finished at : {} ", mEndTime);
            urlBuilder += "test_end_date=" + URLEncoder.encode(mEndTime, "UTF-8") +"&";
            logger.info("Scenario status : {} ", mScenario.getStatus());
            urlBuilder += "test_status=" + URLEncoder.encode(mScenario.getStatus(), "UTF-8") +"&";
            logger.info("Tags : {} ", mScenario.getSourceTagNames());
            urlBuilder += "tags=" + URLEncoder.encode(mScenario.getSourceTagNames().toString(), "UTF-8") +"&";
            logger.info("Project Id : {} ", Tags.getProject(mScenario.getSourceTagNames()));
            urlBuilder += "project_id=" + URLEncoder.encode(Tags.getProjectId(mScenario.getSourceTagNames()), "UTF-8") +"&";
            logger.info("Feature name : {} ", Tags.getFeature(mScenario.getSourceTagNames()));
            urlBuilder += "feature=" + URLEncoder.encode(Tags.getFeature(mScenario.getSourceTagNames()), "UTF-8") +"&";
            logger.info("Scenario id : {} ", Tags.getId(mScenario.getSourceTagNames()));
            urlBuilder += "scenario_id=" + URLEncoder.encode(Tags.getId(mScenario.getSourceTagNames()), "UTF-8") +"&";
            logger.info("Scenario name : {} ", mScenario.getName());
            urlBuilder += "scenario_name=" + URLEncoder.encode(mScenario.getName(), "UTF-8") +"&";
            logger.info("Set window size to : {} by {}", mWindowWidth, mWindowHeight);
            urlBuilder += "test_windows_size=" + URLEncoder.encode(mWindowWidth + " by "+mWindowHeight, "UTF-8") +"&";
            logger.info("Set default timeout to : {} ", mTimeoutInSecond);
            urlBuilder += "test_timeout=" + URLEncoder.encode(String.valueOf(mTimeoutInSecond), "UTF-8") +"&";
            logger.info("Test Suite : {} ", Tags.getTestSuite(mScenario.getSourceTagNames()));
            urlBuilder += "test_suite=" + URLEncoder.encode(Tags.getTestSuite(mScenario.getSourceTagNames()), "UTF-8") +"&" ;
            logger.info("Screenshot : {} ", mScreenshotName);
            urlBuilder += "screenshot_url=" + URLEncoder.encode(mScreenshotName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.info("UnsupportedEncodingException : {} ", e.toString());
        }
        if (ft_test_log_required==1){
            //logger.info("ft-test-log url {}",urlBuilder);
            try {
                logger.info("ft-test-log url {}",urlBuilder);
                logTest.send(urlBuilder);
            } catch (IOException e) {
                logger.info("IOException : {} ", e.toString());
            }
        }
        else {
            logger.info("Test log is unable.");
        }
    }
}