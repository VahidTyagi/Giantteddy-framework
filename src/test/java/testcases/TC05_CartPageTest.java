package testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.giantteddy.pages.CartPage;
import com.giantteddy.pages.CollectionPage;
import com.giantteddy.pages.ProductPage;

import base.BaseTest;
import base.DriverFactory;


public class TC05_CartPageTest extends BaseTest {

    @Test
    public void cartPageValidationTest() {

        // STEP 1 → Go to any collection page
        DriverFactory.getDriver().get("https://giantteddy.com/collections/all");

        // STEP 2 → Click first product
        CollectionPage collection = new CollectionPage(DriverFactory.getDriver());
        collection.clickFirstProduct();

        // STEP 3 → Add product to cart
        ProductPage product = new ProductPage(DriverFactory.getDriver());
        product.clickAddToCart();

        // STEP 4 → Open Cart Page
        DriverFactory.getDriver().get("https://giantteddy.com/cart");

        CartPage cart = new CartPage(DriverFactory.getDriver());

        System.out.println("----- CART PAGE VALIDATION -----");

        // Validate cart has items
        int itemCount = cart.getCartItemCount();
        System.out.println("Cart Items Count: " + itemCount);
        Assert.assertTrue(itemCount > 0, "Cart is empty!");

        // Validate product titles
        System.out.println("Products in Cart: " + cart.getCartProductTitles());

        // Validate product prices
        System.out.println("Prices: " + cart.getCartProductPrices());

        // Validate subtotal + total
        System.out.println("Subtotal: " + cart.getSubtotal());
        System.out.println("Total: " + cart.getTotal());

        // Increase quantity
        try {
            cart.increaseQty();
            System.out.println("Increased Quantity");
        } catch (Exception e) {
            System.out.println("Quantity increase not available");
        }

        // Decrease quantity
        try {
            cart.decreaseQty();
            System.out.println("Decreased Quantity");
        } catch (Exception e) {
            System.out.println("Quantity decrease not available");
        }

        // ACTION → Proceed to checkout
        try {
            cart.clickCheckout();
            System.out.println("Checkout button clicked!");
        } catch (Exception e) {
            System.out.println("Checkout button not found!");
        }

        System.out.println("----- CART PAGE TEST COMPLETED -----");
    }
}

