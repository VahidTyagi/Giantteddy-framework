package testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.giantteddy.pages.CollectionPage;
import com.giantteddy.pages.HomePage;

import base.BaseTest;
import base.DriverFactory;


public class TC02_CollectionPageTest extends BaseTest {

    @Test(description = "Verify Collection Page details and product validations")
    public void collectionPageValidationTest() throws InterruptedException {

        // STEP 1: Launch home page
        HomePage home = new HomePage(DriverFactory.getDriver());

        // Navigate to a collection (you will update locator manually)
        home.clickOnCollection("locators_find_console_path");

        // STEP 2: Now initialize CollectionPage
        CollectionPage collection = new CollectionPage(DriverFactory.getDriver());

        // ===== Validations =====

        System.out.println("----- COLLECTION PAGE VALIDATION STARTED -----");

        // 1. Validate Title
        String title = collection.getCollectionTitle();
        System.out.println("Collection Title: " + title);
        Assert.assertNotNull(title, "Collection title should not be empty");

        // 2. Product Count
        int count = collection.getProductsCount();
        System.out.println("Total Products: " + count);
        Assert.assertTrue(count > 0, "Products count should be greater than 0");

        // 3. Get all product names
        List<String> names = collection.getAllProductNames();
        System.out.println("Product Names: " + names);

        // 4. Get product prices
        List<String> prices = collection.getAllProductPrices();
        System.out.println("Product Prices: " + prices);

        // 5. Validate images
        List<String> images = collection.getAllProductImages();
        System.out.println("Product Images Count: " + images.size());

        // 6. Pagination test (if needed)
        // collection.clickPagination(2);

        // 7. Sort option test
        // collection.selectSortOption("Price, low to high");

        // 8. Filter test
        // collection.clickFilterOption("locators_find_console_path");

        // 9. Click first product
        // collection.clickProductByIndex(0);

        System.out.println("----- COLLECTION PAGE VALIDATION COMPLETED -----");
    }
}
