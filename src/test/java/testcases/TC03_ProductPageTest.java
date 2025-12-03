package testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverFactory;
import com.giantteddy.pages.CollectionPage;
import com.giantteddy.pages.ProductPage;

public class TC03_ProductPageTest extends BaseTest {

    @Test
    public void productPageValidationTest() {

        // STEP 1 → Open Collection Page first
        DriverFactory.getDriver().get("https://giantteddy.com/collections/all");

        CollectionPage collection = new CollectionPage(DriverFactory.getDriver());
        collection.clickFirstProduct();   // navigate to first product

        // STEP 2 → Product Page Object
        ProductPage product = new ProductPage(DriverFactory.getDriver());

        System.out.println("----- PRODUCT PAGE VALIDATION -----");

        // Validate Title
        String title = product.getProductTitle();
        System.out.println("Product Title: " + title);
        Assert.assertFalse(title.isEmpty(), "Product Title is empty!");

        // Validate Price
        String price = product.getProductPrice();
        System.out.println("Product Price: " + price);
        Assert.assertFalse(price.isEmpty(), "Product Price is missing!");

        // Validate Description
        String desc = product.getProductDescription();
        System.out.println("Description: " + desc);

        // Validate Images
        System.out.println("Images: " + product.getProductImages().size());

        // Validate Breadcrumb
        System.out.println("Breadcrumb: " + product.getBreadcrumbLinks());

        // Validate Related Products
        System.out.println("Related Products: " + product.getRelatedProductTitles());

        // ACTION: Add to cart
        product.clickAddToCart();
        System.out.println("Add To Cart clicked!");

        System.out.println("----- PRODUCT PAGE TEST COMPLETED -----");
    }
}

