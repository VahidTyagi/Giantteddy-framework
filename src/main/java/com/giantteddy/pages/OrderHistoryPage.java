package com.giantteddy.pages;



import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage {

    private WebDriver driver;

    // LOCATORS (replace with real locators later)
    private By pageHeader = By.xpath("locators_find_console_path");
    private By orderList = By.xpath("locators_find_console_path");
    private By orderDetails = By.xpath("locators_find_console_path");
    private By allTexts = By.xpath("locators_find_console_path");

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Get page header text
    public String getPageHeader() {
        return driver.findElement(pageHeader).getText().trim();
    }

    // Get all orders in the order history
    public List<String> getAllOrders() {
        List<WebElement> orders = driver.findElements(orderList);
        return orders.stream()
                .map(e -> e.getText().trim())
                .filter(t -> !t.isEmpty())
                .collect(Collectors.toList());
    }

    // Get details of a specific order (pass index 0 for first order)
    public String getOrderDetails(int index) {
        List<WebElement> orders = driver.findElements(orderDetails);
        if (index >= 0 && index < orders.size()) {
            return orders.get(index).getText().trim();
        } else {
            return "Invalid order index";
        }
    }

    // Get all visible text on the Order History page
    public List<String> getAllTexts() {
        List<WebElement> elements = driver.findElements(allTexts);
        return elements.stream()
                .map(e -> e.getText().trim())
                .filter(t -> !t.isEmpty())
                .collect(Collectors.toList());
    }
}

