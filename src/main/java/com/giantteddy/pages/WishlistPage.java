package com.giantteddy.pages;



import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage {

    private WebDriver driver;

    // LOCATORS (replace with real locators later)
    private By pageHeader = By.xpath("locators_find_console_path");
    private By wishlistItems = By.xpath("locators_find_console_path");
    private By itemDetails = By.xpath("locators_find_console_path");
    private By allTexts = By.xpath("locators_find_console_path");

    public WishlistPage(WebDriver driver) {
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

    // Get all wishlist items
    public List<String> getAllWishlistItems() {
        List<WebElement> items = driver.findElements(wishlistItems);
        return items.stream()
                .map(e -> e.getText().trim())
                .filter(t -> !t.isEmpty())
                .collect(Collectors.toList());
    }

    // Get details of a specific wishlist item (pass index 0 for first item)
    public String getItemDetails(int index) {
        List<WebElement> items = driver.findElements(itemDetails);
        if (index >= 0 && index < items.size()) {
            return items.get(index).getText().trim();
        } else {
            return "Invalid item index";
        }
    }

    // Get all visible text on the Wishlist page
    public List<String> getAllTexts() {
        List<WebElement> elements = driver.findElements(allTexts);
        return elements.stream()
                .map(e -> e.getText().trim())
                .filter(t -> !t.isEmpty())
                .collect(Collectors.toList());
    }
}
