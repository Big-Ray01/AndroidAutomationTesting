package com.apptesting.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class InitialiseDriver {
    AppiumDriver driver;
    String apkPath;
    Properties properties;


    public InitialiseDriver(AppiumDriver driver, String apkPath) {
        this.driver = driver;
        this.apkPath = apkPath;
    }

    public InitialiseDriver() {

    }

    public void loadProperties() {

        final String propertyFilePath = "C:\\Users\\Administrator\\IdeaProjects\\AndroidAppTesting\\src\\main\\resources\\config\\app.properties";
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Config.properties not found at " + propertyFilePath);
        }
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver driver) {
        this.driver = driver;
    }
//*****************InitialiseDriver
    public void InitialiseDriver(String apk) {
        try {
            loadProperties();
            apkPath = properties.getProperty(apk);

            System.out.println("*******************Launching application...");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Beast");
            caps.setCapability(MobileCapabilityType.UDID, "RZ8N31BHVDA");//RZ8N31BHVDA 3CCC80666A1BB3FE
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
            caps.setCapability(MobileCapabilityType.APP, apkPath);
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

            setDriver(driver = new AppiumDriver(new URL("http://127.0.0.1:50891/wd/hub"), caps));
//            driver = new AppiumDriver(new URL("http://127.0.0.1:50891/wd/hub"), caps);
            System.out.println("*******************Application is Installed and Launched...");
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }

    }

}
