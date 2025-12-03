package base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    // ThreadLocal to store separate driver for each thread
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // ----------------- Set Driver -----------------
    public static void setDriver(String browserName) {

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
                System.out.println("❗ Invalid browser: " + browserName + " | Launching Chrome by default.");
                driver.set(new ChromeDriver());
        }
    }

    // ----------------- Get Driver -----------------
    public static WebDriver getDriver() {
        return driver.get();
    }

    // ----------------- Quit Driver -----------------
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
