package com.giantteddy.pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CollectionPage {

    private WebDriver driver;

    // ===== Locators (You will replace these manually later) =====
    private By collectionTitle = By.xpath("locators_find_console_path");
    private By productNames = By.xpath("locators_find_console_path");
    private By productPrices = By.xpath("locators_find_console_path");
    private By productImages = By.xpath("locators_find_console_path");
    private By filterOptions = By.xpath("locators_find_console_path");
    private By sortDropdown = By.xpath("locators_find_console_path");
    private By paginationLinks = By.xpath("locators_find_console_path");

    // Constructor
    public CollectionPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== Actions =====

    // Page title text
    public String getCollectionTitle() {
        return driver.findElement(collectionTitle).getText().trim();
    }

    // Get total products count
    public int getProductsCount() {
        return driver.findElements(productNames).size();
    }

    // Get all product names
    public List<String> getAllProductNames() {
        List<WebElement> list = driver.findElements(productNames);
        List<String> names = new ArrayList<>();

        for (WebElement e : list) {
            names.add(e.getText().trim());
        }
        return names;
    }

    // Get all product prices
    public List<String> getAllProductPrices() {
        List<WebElement> list = driver.findElements(productPrices);
        List<String> prices = new ArrayList<>();

        for (WebElement e : list) {
            prices.add(e.getText().trim());
        }
        return prices;
    }

    // Click a product by index
    public void clickProductByIndex(int index) {
        List<WebElement> products = driver.findElements(productNames);
        products.get(index).click();
    }

    // Click product by name
    public void clickProductByName(String productName) {
        List<WebElement> products = driver.findElements(productNames);
        for (WebElement p : products) {
            if (p.getText().trim().equalsIgnoreCase(productName)) {
                p.click();
                break;
            }
        }
    }

    // All product images source URLs
    public List<String> getAllProductImages() {
        List<WebElement> images = driver.findElements(productImages);
        List<String> srcList = new ArrayList<>();

        for (WebElement img : images) {
            srcList.add(img.getAttribute("src"));
        }
        return srcList;
    }

    // Filter click
    public void clickFilterOption(String optionName) {
        List<WebElement> options = driver.findElements(filterOptions);
        for (WebElement opt : options) {
            if (opt.getText().trim().equalsIgnoreCase(optionName)) {
                opt.click();
                break;
            }
        }
    }

    // Sort option select
    public void selectSortOption(String optionText) {
        driver.findElement(sortDropdown).click();
        // You will replace below locator later
        driver.findElement(By.xpath("locators_find_console_path//*[text()='" + optionText + "']")).click();
    }

    // Pagination link click
    public void clickPagination(int pageNumber) {
        List<WebElement> pages = driver.findElements(paginationLinks);
        for (WebElement pg : pages) {
            if (pg.getText().trim().equals(String.valueOf(pageNumber))) {
                pg.click();
                break;
            }
        }
    }

	public void clickFirstProduct() {
		// TODO Auto-generated method stub
		
	}
}

