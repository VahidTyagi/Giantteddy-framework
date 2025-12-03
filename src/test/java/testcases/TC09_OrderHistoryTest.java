package testcases;



import com.giantteddy.pages.OrderHistoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC09_OrderHistoryTest {

    private WebDriver driver;
    private OrderHistoryPage orderHistoryPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to Order History page URL
        driver.get("https://giantteddy/order-history"); // replace with real URL

        orderHistoryPage = new OrderHistoryPage(driver);
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        String title = orderHistoryPage.getPageTitle();
        System.out.println("Order History Page Title: " + title);
        Assert.assertTrue(title.contains("Order History"), "Page title mismatch");
    }

    @Test(priority = 2)
    public void verifyPageHeader() {
        String header = orderHistoryPage.getPageHeader();
        System.out.println("Page Header: " + header);
        Assert.assertEquals(header, "Order History", "Page header text mismatch");
    }

    @Test(priority = 3)
    public void verifyOrdersList() {
        List<String> orders = orderHistoryPage.getAllOrders();
        orders.forEach(System.out::println);
        Assert.assertFalse(orders.isEmpty(), "No orders found in order history");
    }

    @Test(priority = 4)
    public void verifyFirstOrderDetails() {
        String details = orderHistoryPage.getOrderDetails(0); // first order
        System.out.println("First Order Details: " + details);
        Assert.assertFalse(details.equals("Invalid order index"), "No details found for first order");
    }

    @Test(priority = 5)
    public void verifyAllVisibleTexts() {
        List<String> allTexts = orderHistoryPage.getAllTexts();
        allTexts.forEach(System.out::println);
        Assert.assertFalse(allTexts.isEmpty(), "No visible text found on Order History page");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

