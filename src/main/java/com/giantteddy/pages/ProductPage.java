package com.giantteddy.pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	private WebDriver driver;

	// ----------- LOCATORS (Replace later) -----------
	private By productTitle = By.xpath("locators_find_console_path");
	private By productPrice = By.xpath("locators_find_console_path");
	private By productDescription = By.xpath("locators_find_console_path");
	private By productImages = By.xpath("locators_find_console_path");

	private By addToCartBtn = By.xpath("locators_find_console_path");
	private By buyNowBtn = By.xpath("locators_find_console_path");
	private By addToWishlistBtn = By.xpath("locators_find_console_path");

	private By quantityDropdown = By.xpath("locators_find_console_path");
	private By variantOptions = By.xpath("locators_find_console_path");

	private By breadcrumbLinks = By.xpath("locators_find_console_path");
	private By reviewStars = By.xpath("locators_find_console_path");
	private By reviewCount = By.xpath("locators_find_console_path");

	private By relatedProducts = By.xpath("locators_find_console_path");

	// Constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	// --------------------------------------------------------------
	// PRODUCT BASIC DETAILS
	// --------------------------------------------------------------

	public String getProductTitle() {
		return driver.findElement(productTitle).getText();
	}

	public String getProductPrice() {
		return driver.findElement(productPrice).getText();
	}

	public String getProductDescription() {
		return driver.findElement(productDescription).getText();
	}

	public List<String> getProductImages() {
		List<WebElement> imgs = driver.findElements(productImages);
		List<String> srcList = new ArrayList<>();

		for (WebElement e : imgs) {
			srcList.add(e.getAttribute("src"));
		}
		return srcList;
	}

	// --------------------------------------------------------------
	// ACTIONS
	// --------------------------------------------------------------

	public void clickAddToCart() {
		driver.findElement(addToCartBtn).click();
	}

	public void clickBuyNow() {
		driver.findElement(buyNowBtn).click();
	}

	public void addToWishlist() {
		driver.findElement(addToWishlistBtn).click();
	}

	public void selectQuantity(String qtyText) {
		driver.findElement(quantityDropdown).click();
		driver.findElement(By.xpath("locators_find_console_path")).click(); // later update
	}

	public void selectVariant(String variantName) {
		driver.findElement(By.xpath("locators_find_console_path")).click(); // update later
	}

	// --------------------------------------------------------------
	// REVIEWS SECTION
	// --------------------------------------------------------------

	public String getReviewStars() {
		return driver.findElement(reviewStars).getText();
	}

	public String getReviewCount() {
		return driver.findElement(reviewCount).getText();
	}

	// --------------------------------------------------------------
	// BREADCRUMB
	// --------------------------------------------------------------

	public List<String> getBreadcrumbLinks() {
		List<WebElement> links = driver.findElements(breadcrumbLinks);
		List<String> texts = new ArrayList<>();

		for (WebElement e : links) {
			texts.add(e.getText());
		}
		return texts;
	}

	// --------------------------------------------------------------
	// RELATED PRODUCTS
	// --------------------------------------------------------------

	public List<String> getRelatedProductTitles() {
		List<WebElement> items = driver.findElements(relatedProducts);
		List<String> titles = new ArrayList<>();

		for (WebElement e : items) {
			titles.add(e.getText());
		}
		return titles;
	}

	// --------------------------------------------------------------
	// CLICK FIRST RELATED PRODUCT
	// --------------------------------------------------------------

	public void clickFirstRelatedProduct() {
		driver.findElements(relatedProducts).get(0).click();
	}
}

