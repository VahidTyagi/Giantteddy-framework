package com.giantteddy.pages;



import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    // ----------------- Constructor -----------------
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ----------------- Locators (Placeholders) -----------------

    By headerText = By.xpath("locators_find_console_path");
    By mainBanner = By.xpath("locators_find_console_path");
    By allPageLinks = By.tagName("a");  // correct for whole page scanning
    By footerLinks = By.xpath("locators_find_console_path");

    // ----------------- Actions -----------------

    // 1. Get page title
    public String getHomePageTitle() {
        return driver.getTitle();
    }

    // 2. Get header text
    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }

    // 3. Get main banner link
    public String getMainBannerLink() {
        String url = driver.findElement(mainBanner).getAttribute("href");
        return url;
    }

    // 4. Get all links from the page
    public List<String> getAllLinks() {
        List<WebElement> links = driver.findElements(allPageLinks);
        List<String> urlList = new ArrayList<>();

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                urlList.add(url);
            }
        }
        return urlList;
    }

    // 5. Get all footer links
    public List<String> getFooterLinks() {
        List<WebElement> links = driver.findElements(footerLinks);
        List<String> urlList = new ArrayList<>();

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                urlList.add(url);
            }
        }
        return urlList;
    }

    // 6. Check if a link is broken
    public boolean isLinkBroken(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setConnectTimeout(5000);
            http.connect();

            int statusCode = http.getResponseCode();

            // 200 = OK, 300-399 = redirected, 400+ = broken
            return statusCode >= 400;

        } catch (Exception e) {
            return true;
        }
    }

    // 7. Return list of broken links
    public List<String> getBrokenLinks() {
        List<String> allLinks = getAllLinks();
        List<String> broken = new ArrayList<>();

        for (String link : allLinks) {
            if (isLinkBroken(link)) {
                broken.add(link);
            }
        }
        return broken;
    }

	public void clickOnCollection(String string) {
		// TODO Auto-generated method stub
		
	}
}
