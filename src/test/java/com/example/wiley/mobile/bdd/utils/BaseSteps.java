package com.example.wiley.mobile.bdd.utils;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.example.wiley.mobile.bdd.util.AppiumUtil;
import com.example.wiley.mobile.bdd.util.DemoApplication;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

@ContextConfiguration(classes = DemoApplication.class)
public class BaseSteps {

    @Autowired
    private AppiumUtil appiumUtil;

    protected AndroidDriver<AndroidElement> getDriver() throws MalformedURLException {
        return appiumUtil.getDriver();
    }
}
