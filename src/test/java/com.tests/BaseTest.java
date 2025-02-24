package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BaseTest {
    protected WebDriver driver;
    protected String username = "akashshimpi53";
    protected String accessKey = "LT_HiMWkyZLTQasg2oXsauFtS3VYIP26WqFffjN4TqIAJRf4FA";
    protected String hub = "https://hub.lambdatest.com/wd/hub";
    protected String baseURL = "https://www.lambdatest.com/selenium-playground/";

    @BeforeMethod
    @Parameters({"Browser", "Version", "Platform"})
    public void setUp(String browser, String version, String platform) {
        // Setting ChromeOptions with LambdaTest capabilities
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName(platform);
        browserOptions.setBrowserVersion(version);

        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", accessKey);
        ltOptions.put("project", "Cross Browser Testing");
        ltOptions.put("build", "1.7");
        ltOptions.put("name", this.getClass().getSimpleName());
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        ltOptions.put("console", "true");
        ltOptions.put("network", true);
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("browserName", browser);
        ltOptions.put("browserVersion", version);
        ltOptions.put("platform", platform);

        browserOptions.setCapability("LT:Options", ltOptions);

        try {
            driver = new RemoteWebDriver(new URL(hub), browserOptions);
            driver.manage().window().maximize();
            driver.get(baseURL);
            System.out.println("Navigated to base url successfully");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
