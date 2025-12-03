package com.giantteddy.pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	private WebDriver driver;

	// ------------------- LOCATORS (Update later) -------------------
	private By cartItems = By.xpath("locators_find_console_path");
	private By productTitle = By.xpath("locators_find_console_path");
	private By productPrice = By.xpath("locators_find_console_path");
	private By productQty = By.xpath("locators_find_console_path");
	private By removeItemButton = By.xpath("locators_find_console_path");

	private By updateQtyDropdown = By.xpath("locators_find_console_path");
	private By increaseQtyButton = By.xpath("locators_find_console_path");
	private By decreaseQtyButton = By.xpath("locators_find_console_path");

	private By subtotalAmount = By.xpath("locators_find_console_path");
	private By totalAmount = By.xpath("locators_find_console_path");

	private By checkoutButton = By.xpath("locators_find_console_path");
	private By continueShoppingLink = By.xpath("locators_find_console_path");

	// Constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	// --------------------------------------------------------------
	// GET CART DETAILS
	// --------------------------------------------------------------

	public int getCartItemCount() {
		return driver.findElements(cartItems).size();
	}

	public List<String> getCartProductTitles() {
		List<WebElement> items = driver.findElements(productTitle);
		List<String> titles = new ArrayList<>();

		for (WebElement e : items) {
			titles.add(e.getText());
		}
		return titles;
	}

	public List<String> getCartProductPrices() {
		List<WebElement> items = driver.findElements(productPrice);
		List<String> prices = new ArrayList<>();

		for (WebElement e : items) {
			prices.add(e.getText());
		}
		return prices;
	}

	public List<String> getCartQuantities() {
		List<WebElement> items = driver.findElements(productQty);
		List<String> qty = new ArrayList<>();

		for (WebElement e : items) {
			qty.add(e.getText());
		}
		return qty;
	}

	// --------------------------------------------------------------
	// CART ACTIONS
	// --------------------------------------------------------------

	public void increaseQty() {
		driver.findElement(increaseQtyButton).click();
	}

	public void decreaseQty() {
		driver.findElement(decreaseQtyButton).click();
	}

	public void selectQtyFromDropdown(String qty) {
		driver.findElement(updateQtyDropdown).click();
		driver.findElement(By.xpath("locators_find_console_path")).click(); // you will update later
	}

	public void removeItem() {
		driver.findElement(removeItemButton).click();
	}

	// --------------------------------------------------------------
	// TOTAL AMOUNTS
	// --------------------------------------------------------------

	public String getSubtotal() {
		return driver.findElement(subtotalAmount).getText();
	}

	public String getTotal() {
		return driver.findElement(totalAmount).getText();
	}

	// --------------------------------------------------------------
	// NAVIGATION ACTIONS
	// --------------------------------------------------------------

	public void clickCheckout() {
		driver.findElement(checkoutButton).click();
	}

	public void clickContinueShopping() {
		driver.findElement(continueShoppingLink).click();
	}
}

