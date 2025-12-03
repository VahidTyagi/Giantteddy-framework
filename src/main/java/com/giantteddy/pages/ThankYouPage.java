package com.giantteddy.pages;



import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ThankYouPage {

    private WebDriver driver;

    // LOCATORS (replace with real locators later)
    private By thankYouHeader = By.xpath("locators_find_console_path");
    private By orderNumber = By.xpath("locators_find_console_path");
    private By messageSection = By.xpath("locators_find_console_path");
    private By allTexts = By.xpath("locators_find_console_path");

    public ThankYouPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Get Thank You header text
    public String getThankYouHeader() {
        return driver.findElement(thankYouHeader).getText().trim();
    }

    // Get order number
    public String getOrderNumber() {
        return driver.findElement(orderNumber).getText().trim();
    }

    // Get any message displayed on the page
    public String getMessage() {
        return driver.findElement(messageSection).getText().trim();
    }

    // Get all visible text on Thank You page
    public List<String> getAllTexts() {
        List<WebElement> elements = driver.findElements(allTexts);
        return elements.stream()
                .map(e -> e.getText().trim())
                .filter(t -> !t.isEmpty())
                .collect(Collectors.toList());
    }
}

