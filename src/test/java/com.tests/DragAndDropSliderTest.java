package com.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDropSliderTest extends BaseTest {

    @Test
    public void testDragAndDropSlider() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dragDropSlidersLink = wait.until(ExpectedConditions.elementToBeClickable(Locators.DRAG_DROP_SLIDER));
        dragDropSlidersLink.click();

        WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SLIDER));

        for (int i = 1; i <= 80; i++) {
            System.out.println(i);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        String actualText = driver.findElement(Locators.RANGE_SUCCESS).getText();
        Assert.assertEquals(actualText, "95", "Slider value is not as expected");
    }
}
