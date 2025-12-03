package testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.DriverFactory;
import com.giantteddy.pages.CartPage;
import com.giantteddy.pages.CheckoutPage;
import com.giantteddy.pages.CollectionPage;
import com.giantteddy.pages.ProductPage;


public class TC06_CheckoutPageTest extends BaseTest {

    @Test
    public void checkoutPageEndToEndTest() {

        // STEP 1 → Open collection page
        DriverFactory.getDriver().get("https://giantteddy.com/collections/all");

        CollectionPage collection = new CollectionPage(DriverFactory.getDriver());
        collection.clickFirstProduct();

        // STEP 2 → Product page → Add to cart
        ProductPage product = new ProductPage(DriverFactory.getDriver());
        product.clickAddToCart();

        // STEP 3 → Go to cart page
        DriverFactory.getDriver().get("https://giantteddy.com/cart");

        CartPage cart = new CartPage(DriverFactory.getDriver());
        Assert.assertTrue(cart.getCartItemCount() > 0, "Cart is empty!");

        cart.clickCheckout();

        // STEP 4 → Checkout page
        CheckoutPage checkout = new CheckoutPage(DriverFactory.getDriver());

        System.out.println("----- CHECKOUT PAGE STARTED -----");

        // CONTACT INFO
        checkout.enterEmail("dummyautomation@mail.com");
        checkout.clickContinueToShipping();

        // SHIPPING ADDRESS
        checkout.enterFirstName("Vahid");
        checkout.enterLastName("Tyagi");
        checkout.enterAddress1("Sector 45");
        checkout.enterCity("Noida");
        checkout.selectState("Uttar Pradesh");
        checkout.enterZipCode("201301");
        checkout.enterPhoneNumber("9876543210");

        checkout.clickContinueToPayment();

        // SHIPPING METHOD
        try {
            checkout.selectShippingMethod();
        } catch (Exception e) {
            System.out.println("Shipping method auto-selected by Shopify");
        }

        // PAYMENT METHOD → COD
        checkout.selectCOD();

        // SUMMARY
        System.out.println("Subtotal: " + checkout.getSubtotal());
        System.out.println("Shipping Charge: " + checkout.getShippingCharge());
        System.out.println("Total Amount: " + checkout.getTotalAmount());

        try {
            checkout.clickCompleteOrder();
            System.out.println("Complete Order button clicked!");
        } catch (Exception e) {
            System.out.println("Complete Order button not available yet.");
        }

        System.out.println("----- CHECKOUT PAGE TEST COMPLETED -----");
    }
}

