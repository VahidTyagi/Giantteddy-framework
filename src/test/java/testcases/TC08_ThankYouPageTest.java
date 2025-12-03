package testcases;



import com.giantteddy.pages.ThankYouPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC08_ThankYouPageTest {

    private WebDriver driver;
    private ThankYouPage thankYouPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to Thank You page URL
        driver.get("https://example.com/thank-you"); // replace with real URL

        thankYouPage = new ThankYouPage(driver);
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        String title = thankYouPage.getPageTitle();
        System.out.println("Thank You Page Title: " + title);
        Assert.assertTrue(title.contains("Thank You"), "Page title mismatch");
    }

    @Test(priority = 2)
    public void verifyThankYouHeader() {
        String header = thankYouPage.getThankYouHeader();
        System.out.println("Thank You Header: " + header);
        Assert.assertEquals(header, "Thank You", "Thank You header text mismatch");
    }

    @Test(priority = 3)
    public void verifyOrderNumber() {
        String orderNum = thankYouPage.getOrderNumber();
        System.out.println("Order Number: " + orderNum);
        Assert.assertTrue(orderNum.startsWith("#"), "Order number format incorrect");
    }

    @Test(priority = 4)
    public void verifyMessageSection() {
        String message = thankYouPage.getMessage();
        System.out.println("Message: " + message);
        Assert.assertTrue(message.contains("successfully"), "Thank You message missing or incorrect");
    }

    @Test(priority = 5)
    public void verifyAllVisibleTexts() {
        List<String> allTexts = thankYouPage.getAllTexts();
        allTexts.forEach(System.out::println);
        Assert.assertFalse(allTexts.isEmpty(), "No visible text found on Thank You page");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

