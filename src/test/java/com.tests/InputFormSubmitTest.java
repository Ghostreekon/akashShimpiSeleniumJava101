package com.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InputFormSubmitTest extends BaseTest {

    @Test(timeOut = 40000)
    public void testInputFormSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement inputFormSubmitLink = wait.until(ExpectedConditions.elementToBeClickable(Locators.INPUT_FORM_SUBMIT));
        inputFormSubmitLink.click();

        WebElement submitButton = driver.findElement(Locators.SUBMIT_BUTTON);
        submitButton.click();

        // Verify validation for required fields
        WebElement nameField = driver.findElement(Locators.NAME);
        WebElement emailField = driver.findElement(Locators.INPUT_EMAIL);
        Assert.assertEquals(nameField.getAttribute("validationMessage"), "Please fill in this field.");

        nameField.sendKeys("AkashShimpi");
        emailField.sendKeys("hello@world.com");
        driver.findElement(Locators.PASSWORD).sendKeys("password123");
        driver.findElement(Locators.COMPANY).sendKeys("ABC Company");
        driver.findElement(Locators.WEBSITE).sendKeys("www.abc.com");

        WebElement countryDropdown = driver.findElement(Locators.COUNTRY);
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("United States");

        driver.findElement(Locators.CITY).sendKeys("NEW YORK");
        driver.findElement(Locators.ADDRESS_LINE_1).sendKeys("Too Pack Street ");
        driver.findElement(Locators.ADDRESS_LINE_2).sendKeys("11x9");
        driver.findElement(Locators.INPUT_STATE).sendKeys("Nashik");
        driver.findElement(Locators.ZIP).sendKeys("422401");

        submitButton.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SUCCESS_MESSAGE));
        String successText = successMessage.getText();
        System.out.println(successText);
        Assert.assertEquals(successText, "Thanks for contacting us, we will get back to you shortly.",
                "Success message is not as expected");
    }
}
