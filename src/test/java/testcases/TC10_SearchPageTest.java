package testcases;



import com.giantteddy.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC10_SearchPageTest {

    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to Search page URL
        driver.get("https://example.com/search"); // replace with real URL

        searchPage = new SearchPage(driver);
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        String title = searchPage.getPageTitle();
        System.out.println("Search Page Title: " + title);
        Assert.assertTrue(title.contains("Search"), "Page title mismatch");
    }

    @Test(priority = 2)
    public void verifySearchFunctionality() {
        String searchTerm = "laptop"; // replace with desired search term
        searchPage.enterSearchText(searchTerm);
        searchPage.clickSearchButton();

        List<String> results = searchPage.getAllSearchResults();
        results.forEach(System.out::println);

        Assert.assertFalse(results.isEmpty(), "No search results found for: " + searchTerm);
    }

    @Test(priority = 3)
    public void verifyAllVisibleTexts() {
        List<String> allTexts = searchPage.getAllTexts();
        allTexts.forEach(System.out::println);
        Assert.assertFalse(allTexts.isEmpty(), "No visible text found on Search page");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
