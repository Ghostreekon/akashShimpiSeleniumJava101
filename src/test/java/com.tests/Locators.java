package com.tests;

import org.openqa.selenium.By;

public class Locators {
    public static final By MESSAGE = By.id("message");
    public static final By SHOW_INPUT = By.id("showInput");
    public static final By USER_MESSAGE = By.xpath("(//*[@id='user-message'])[1]");
    public static final By DRAG_DROP_SLIDER = By.linkText("Drag & Drop Sliders");
    public static final By SLIDER = By.xpath("//*[@id='slider3']/div/input");
    public static final By RANGE_SUCCESS = By.id("rangeSuccess");
    public static final By INPUT_FORM_SUBMIT = By.linkText("Input Form Submit");
    public static final By SUBMIT_BUTTON = By.xpath("(//button[@type='submit'])[2]");
    public static final By NAME = By.id("name");
    public static final By INPUT_EMAIL = By.id("inputEmail4");
    public static final By PASSWORD = By.name("password");
    public static final By COMPANY = By.name("company");
    public static final By WEBSITE = By.name("website");
    public static final By COUNTRY = By.name("country");
    public static final By CITY = By.name("city");
    public static final By ADDRESS_LINE_1 = By.name("address_line1");
    public static final By ADDRESS_LINE_2 = By.name("address_line2");
    public static final By INPUT_STATE = By.id("inputState");
    public static final By SUCCESS_MESSAGE = By.xpath("//p[@class='success-msg hidden']");
    public static final By ZIP = By.name("zip");
}
