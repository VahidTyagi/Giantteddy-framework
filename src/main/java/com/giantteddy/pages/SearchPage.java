package com.giantteddy.pages;



import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    private WebDriver driver;

    // LOCATORS (replace with real locators later)
    private By searchBox = By.xpath("locators_find_console_path");
    private By searchButton = By.xpath("locators_find_console_path");
    private By searchResults = By.xpath("locators_find_console_path");
    private By allTexts = By.xpath("locators_find_console_path");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Enter text in search box
    public void enterSearchText(String text) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text);
    }

    // Click search button
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    // Get all search results text
    public List<String> getAllSearchResults() {
        List<WebElement> results = driver.findElements(searchResults);
        return results.stream()
                .map(e -> e.getText().trim())
                .filter(t -> !t.isEmpty())
                .collect(Collectors.toList());
    }

    // Get all visible text on Search page
    public List<String> getAllTexts() {
        List<WebElement> elements = driver.findElements(allTexts);
        return elements.stream()
                .map(e -> e.getText().trim())
                .filter(t -> !t.isEmpty())
                .collect(Collectors.toList());
    }
}

