package testcases;



import com.giantteddy.pages.WishlistPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC04_WishlistTest {

    private WebDriver driver;
    private WishlistPage wishlistPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to Wishlist page URL
        driver.get("https://example.com/wishlist"); // replace with real URL

        wishlistPage = new WishlistPage(driver);
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        String title = wishlistPage.getPageTitle();
        System.out.println("Wishlist Page Title: " + title);
        Assert.assertTrue(title.contains("Wishlist"), "Page title mismatch");
    }

    @Test(priority = 2)
    public void verifyPageHeader() {
        String header = wishlistPage.getPageHeader();
        System.out.println("Page Header: " + header);
        Assert.assertEquals(header, "Wishlist", "Page header text mismatch");
    }

    @Test(priority = 3)
    public void verifyWishlistItems() {
        List<String> items = wishlistPage.getAllWishlistItems();
        items.forEach(System.out::println);
        Assert.assertFalse(items.isEmpty(), "No items found in wishlist");
    }

    @Test(priority = 4)
    public void verifyFirstItemDetails() {
        String details = wishlistPage.getItemDetails(0); // first item
        System.out.println("First Item Details: " + details);
        Assert.assertFalse(details.equals("Invalid item index"), "No details found for first wishlist item");
    }

    @Test(priority = 5)
    public void verifyAllVisibleTexts() {
        List<String> allTexts = wishlistPage.getAllTexts();
        allTexts.forEach(System.out::println);
        Assert.assertFalse(allTexts.isEmpty(), "No visible text found on Wishlist page");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

