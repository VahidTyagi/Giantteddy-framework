package base;



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public Properties prop;

    // ----------------- Load Config -----------------
    public void loadConfig() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ----------------- Get Driver -----------------
    public WebDriver getDriver() {
        return driver.get();
    }

    // ----------------- Launch Browser -----------------
    public void launchBrowser(String browserName) {

        switch (browserName.toLowerCase()) {

        case "chrome":
            driver.set(new ChromeDriver());
            break;

        case "firefox":
            driver.set(new FirefoxDriver());
            break;

        case "edge":
            driver.set(new EdgeDriver());
            break;

        case "safari":
            driver.set(new SafariDriver());
            break;

        default:
            System.out.println("Browser Not Supported → " + browserName + "  | Launching Chrome instead");
            driver.set(new ChromeDriver());
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
    }

    // ----------------- Setup -----------------
    @BeforeMethod
    public void setUp() {
        loadConfig();
        String browser = prop.getProperty("browser").trim();
        String url = prop.getProperty("url").trim();

        launchBrowser(browser);
        getDriver().get(url);
    }

    // ----------------- Tear Down -----------------
    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
