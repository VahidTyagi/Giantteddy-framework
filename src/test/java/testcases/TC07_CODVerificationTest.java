package testcases;



import com.giantteddy.pages.CashOnDeliveryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC07_CODVerificationTest {

    private WebDriver driver;
    private CashOnDeliveryPage codPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the COD page URL
        driver.get("https://example.com/cash-on-delivery"); // replace with real URL

        codPage = new CashOnDeliveryPage(driver);
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        String title = codPage.getPageTitle();
        System.out.println("COD Page Title: " + title);
        Assert.assertTrue(title.contains("Cash on Delivery"), "Page title mismatch");
    }

    @Test(priority = 2)
    public void verifyCODHeader() {
        String header = codPage.getCODHeader();
        System.out.println("COD Header: " + header);
        Assert.assertEquals(header, "Cash on Delivery", "COD header text mismatch");
    }

    @Test(priority = 3)
    public void verifyOrderSummaryDetails() {
        String orderSummary = codPage.getOrderSummaryDetails();
        System.out.println("Order Summary: " + orderSummary);
        Assert.assertTrue(orderSummary.contains("Item"), "Order summary missing items");
    }

    @Test(priority = 4)
    public void verifyPayableAmount() {
        String amount = codPage.getPayableAmount();
        System.out.println("Payable Amount: " + amount);
        Assert.assertTrue(amount.startsWith("₹"), "Payable amount format incorrect");
    }

    @Test(priority = 5)
    public void verifyAllTextsAreVisible() {
        List<String> allTexts = codPage.getAllTexts();
        allTexts.forEach(System.out::println);
        Assert.assertFalse(allTexts.isEmpty(), "No visible text found on COD page");
    }

    @Test(priority = 6)
    public void clickConfirmCODButton() {
        codPage.clickConfirmCOD();
        // You can add verification here if clicking leads to another page
        System.out.println("Confirm COD button clicked");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

