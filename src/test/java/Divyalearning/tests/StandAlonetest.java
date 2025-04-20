package Divyalearning.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Divyalearning.CartPage;
import Divyalearning.CheckoutPage;
import Divyalearning.ConfirmationPage;
import Divyalearning.ProductCatalogue;
import Divyaleraning.TestComponents.BaseTest;

public class StandAlonetest extends BaseTest {

    @Test
    public void submitOrder() throws IOException, InterruptedException {
        String Productname = "ZARA COAT 3"; // Product to be added to cart
        
        // Step 1: Login
        ProductCatalogue productcatalogue = login.value("divyarun@gmail.com", "Arun@2611");

        // Step 2: List products
        productcatalogue.listingproducts();

        // Step 3: Add product to cart
        CartPage cartpage = productcatalogue.addToCart(Productname);

        // Step 4: Open cart
        cartpage.clickcart();

        // Step 5: Verify product in cart
        Boolean match = cartpage.matchToOriginal(Productname);
        Assert.assertTrue(match);  // Assert product is in cart

        // Step 6: Proceed to checkout
        CheckoutPage checkoutpage = cartpage.checkoutButton();

        // Step 7: Enter card details
        checkoutpage.cardDetails("443", "Divya");

        // Step 8: Select country & place order
        ConfirmationPage confirmpage = checkoutpage.mouse("Ind");

        // Step 9: Verify confirmation message
        String msgreturn = confirmpage.confirmMessage();
        Assert.assertTrue(msgreturn.equalsIgnoreCase("Thankyou for the order."));
    }
}
