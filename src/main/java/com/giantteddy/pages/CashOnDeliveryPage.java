package com.giantteddy.pages;


import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CashOnDeliveryPage {

    private WebDriver driver;

    // LOCATORS (You will add real locators later)
    private By codHeader = By.xpath("locators_find_console_path");
    private By orderSummarySection = By.xpath("locators_find_console_path");
    private By payableAmount = By.xpath("locators_find_console_path");
    private By confirmCODButton = By.xpath("locators_find_console_path");
    private By allTexts = By.xpath("locators_find_console_path");

    public CashOnDeliveryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // COD page header text
    public String getCODHeader() {
        return driver.findElement(codHeader).getText().trim();
    }

    // Order summary text content
    public String getOrderSummaryDetails() {
        return driver.findElement(orderSummarySection).getText().trim();
    }

    // Total payable amount
    public String getPayableAmount() {
        return driver.findElement(payableAmount).getText().trim();
    }

    // Click Confirm COD
    public void clickConfirmCOD() {
        driver.findElement(confirmCODButton).click();
    }

    // Get all visible text on COD page
    public List<String> getAllTexts() {
        List<WebElement> elements = driver.findElements(allTexts);
        return elements.stream()
                .map(e -> e.getText().trim())
                .filter(t -> !t.isEmpty())
                .collect(Collectors.toList());
    }

}

