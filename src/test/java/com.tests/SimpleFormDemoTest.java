package com.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SimpleFormDemoTest extends BaseTest {

    @Test(timeOut = 20000)
    public void testSimpleFormDemo() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement simpleFormDemoLink = wait.until(ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.linkText("Simple Form Demo")
        ));
        System.out.println("Scrolling down");
        Thread.sleep(2000);
        simpleFormDemoLink.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotNull(currentUrl, "Current URL is null");
        Assert.assertTrue(currentUrl.contains("simple-form-demo"), "URL does not contain 'simple-form-demo'");

        String message = "Welcome to LambdaTest";

        WebElement messageBox = driver.findElement(Locators.USER_MESSAGE);
        messageBox.sendKeys(message);
        driver.findElement(Locators.SHOW_INPUT).click();

        WebElement displayedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.MESSAGE));
        String actualMessage = displayedMessage.getText();
        Assert.assertEquals(actualMessage, message, "The message displayed is not as expected");

        System.out.println("Test Passed! The message was correctly displayed.");
    }
}
