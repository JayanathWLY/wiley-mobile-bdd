package com.example.wiley.mobile.bdd.service.impl;

import javax.annotation.PostConstruct;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.wiley.mobile.bdd.service.AppiumService;

@Service
public class AppiumServiceImpl implements AppiumService {

    @Value("${device.name}")
    private String deviceName;
    @Value("${device.version}")
    private String deviceVersion;
    @Value("${device.platform}")
    private String devicePlatform;
    @Value("${application.package}")
    private String applicationPackage;
    @Value("${application.activity}")
    private String applicationActivity;
    @Value("${device.orientation}")
    private String deviceOrientation;

    private DesiredCapabilities capabilities = new DesiredCapabilities();

    @PostConstruct
    public void setup(){
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability(CapabilityType.VERSION, deviceVersion);
        capabilities.setCapability("platformName", devicePlatform);
        capabilities.setCapability("appPackage", applicationPackage);
        capabilities.setCapability("appActivity", applicationActivity);
        capabilities.setCapability("deviceOrientation", deviceOrientation);
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }
}
