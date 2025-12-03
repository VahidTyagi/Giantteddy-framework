package com.giantteddy.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	private WebDriver driver;

	// -------------------------- LOCATORS (Update later) --------------------------

	// --- CONTACT INFORMATION ---
	private By emailField = By.xpath("locators_find_console_path");
	private By continueToShippingBtn = By.xpath("locators_find_console_path");

	// --- SHIPPING ADDRESS ---
	private By firstName = By.xpath("locators_find_console_path");
	private By lastName = By.xpath("locators_find_console_path");
	private By address1 = By.xpath("locators_find_console_path");
	private By city = By.xpath("locators_find_console_path");
	private By stateDropdown = By.xpath("locators_find_console_path");
	private By zipCode = By.xpath("locators_find_console_path");
	private By phoneNumber = By.xpath("locators_find_console_path");

	private By continueToPaymentBtn = By.xpath("locators_find_console_path");

	// --- SHIPPING METHOD ---
	private By shippingOption = By.xpath("locators_find_console_path");

	// --- PAYMENT PAGE ---
	private By codOption = By.xpath("locators_find_console_path");
	private By cardOption = By.xpath("locators_find_console_path");
	private By upiOption = By.xpath("locators_find_console_path");

	private By payNowBtn = By.xpath("locators_find_console_path");
	private By completeOrderBtn = By.xpath("locators_find_console_path");

	// --- ORDER SUMMARY ---
	private By subtotalText = By.xpath("locators_find_console_path");
	private By shippingCharge = By.xpath("locators_find_console_path");
	private By totalAmount = By.xpath("locators_find_console_path");

	// Constructor
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	// -------------------------- CONTACT INFO --------------------------

	public void enterEmail(String email) {
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
	}

	public void clickContinueToShipping() {
		driver.findElement(continueToShippingBtn).click();
	}

	// -------------------------- SHIPPING ADDRESS --------------------------

	public void enterFirstName(String fName) {
		driver.findElement(firstName).sendKeys(fName);
	}

	public void enterLastName(String lName) {
		driver.findElement(lastName).sendKeys(lName);
	}

	public void enterAddress1(String addr) {
		driver.findElement(address1).sendKeys(addr);
	}

	public void enterCity(String cityName) {
		driver.findElement(city).sendKeys(cityName);
	}

	public void selectState(String stateName) {
		driver.findElement(stateDropdown).click();
		driver.findElement(By.xpath("locators_find_console_path")).click(); // update at end
	}

	public void enterZipCode(String zip) {
		driver.findElement(zipCode).sendKeys(zip);
	}

	public void enterPhoneNumber(String phone) {
		driver.findElement(phoneNumber).sendKeys(phone);
	}

	public void clickContinueToPayment() {
		driver.findElement(continueToPaymentBtn).click();
	}

	// -------------------------- SHIPPING METHOD --------------------------

	public void selectShippingMethod() {
		driver.findElement(shippingOption).click();
	}

	// -------------------------- PAYMENT SECTION --------------------------

	public void selectCOD() {
		driver.findElement(codOption).click();
	}

	public void selectCard() {
		driver.findElement(cardOption).click();
	}

	public void selectUPI() {
		driver.findElement(upiOption).click();
	}

	public void clickPayNow() {
		driver.findElement(payNowBtn).click();
	}

	public void clickCompleteOrder() {
		driver.findElement(completeOrderBtn).click();
	}

	// -------------------------- ORDER SUMMARY DETAILS --------------------------

	public String getSubtotal() {
		return driver.findElement(subtotalText).getText();
	}

	public String getShippingCharge() {
		return driver.findElement(shippingCharge).getText();
	}

	public String getTotalAmount() {
		return driver.findElement(totalAmount).getText();
	}

}
