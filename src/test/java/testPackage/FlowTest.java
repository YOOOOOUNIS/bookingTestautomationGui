package testPackage;

import Pages.*;
import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.MockUserDataFetcher;


public class FlowTest extends BaseTests {


    @BeforeClass
    public void setUp() {
    }


    @Test
    public void testMakingOrderFlow() {

        homePage.setLocationField("Tolip Hotel Alexandria");
        homePage.openCalendar();
        homePage.setCheckInDate("2025-10-01");
        homePage.setCheckOutDate("2025-10-14");
        SearchPage searchPage = homePage.clickOnSearchButton();
        HotelDetailsPage hotelDetailsPage = searchPage.clickOnHotel("Tolip");
        hotelDetailsPage.selectTwoTwinBed();
        hotelDetailsPage.selectAmount();
        hotelDetailsPage.reserve();


//        // Fetch mock user data (index 0) from JSONPlaceholder via utility class
//        MockUserDataFetcher.UserData userData = MockUserDataFetcher.getUserData(0);
//
//        // Login to the application
//
//        HomePage homePage = loginPage.clickSubmitLoginButton();
//
//        // Add two items to the cart
//        homePage.addSauceLabsFleeceJacketToCart();
//        SingleProductPage singleProductPage = homePage.clickOnSauceLabsOnesieItem();
//        singleProductPage.addItemToCart();
//
//        // Assert that the cart shows 2 items
//        WebElement cartItemsElement = singleProductPage.getNumberOfItems();
//        Assert.assertTrue(cartItemsElement.getText().contains("2"), "Cart item count should be 2");
//        System.out.println("Items in cart = 2");
//
//        // Proceed to checkout
//        CartPage cartPage = singleProductPage.goToCart();
//        InfoPage infoPage = cartPage.checkout();
//
//        // Fill in checkout information using mock user data
//        infoPage.setFirstNameField(userData.getFirstName());
//        infoPage.setLastNameField(userData.getLastName());
//        infoPage.setPostalCodeField(userData.getZipCode());
//
//        // Continue to the overview page
//        OverviewPage overviewPage = infoPage.clickOnContinue();
//
//        // Assert the correct items are in the order summary
//        WebElement firstItemElement = overviewPage.getFirstItemElement();
//        Assert.assertTrue(firstItemElement.getText().contains("Sauce Labs Fleece Jacket"), "First item not found");
//
//        WebElement secondItemElement = overviewPage.getSecondItemElement();
//        Assert.assertTrue(secondItemElement.getText().contains("Sauce Labs Onesie"), "Second item not found");
//
//        System.out.println("Order details are correct");
//
//        // Finish the order
//        CompletePage completePage = overviewPage.clickOnFinish();
//
//        // Confirm successful order
//        WebElement successfulElement = completePage.checkSuccessfulOrder();
//        Assert.assertTrue(successfulElement.isDisplayed(), "Order was not successful");
//
//        System.out.println("Successful order");
    }
}
