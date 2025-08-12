package testPackage;

import Pages.*;
import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtils;
import utils.PathUtils;

import java.io.IOException;

public class FlowTest extends BaseTests {

    @BeforeClass
    public void setUp() {}

    @DataProvider(name = "hotelData")
    public Object[][] getHotelData() throws IOException {
        String filePath = PathUtils.getTestFileAbsolutePath();
        return ExcelUtils.readExcelData(filePath, "Sheet1");
    }

    @Test(dataProvider = "hotelData")
    public void testReserveTolipHotel(String location, String checkIn, String checkOut) {
        homePage.setLocationField(location);
        homePage.openCalendar();
        homePage.setCheckInDate(checkIn);
        homePage.setCheckOutDate(checkOut);

        SearchPage searchPage = homePage.clickOnSearchButton();
        HotelDetailsPage hotelDetailsPage = searchPage.clickOnHotel(location);

        WebElement checkInDate = hotelDetailsPage.getCheckInDate();
        WebElement checkOutDate = hotelDetailsPage.getCheckOutDate();

        Assert.assertTrue(
                checkInDate.getText().contains("Wed, Oct 1"),
                "Check-in date is wrong"
        );
        Assert.assertTrue(
                checkOutDate.getText().contains("Tue, Oct 14"),
                "Check-out date is wrong"
        );
        System.out.println("Check-in & check-out dates set correctly");

        hotelDetailsPage.selectTwoTwinBed();
        hotelDetailsPage.selectAmount();

        ReservationPage reservationPage = hotelDetailsPage.reserve();
        WebElement hotelName = reservationPage.getHotelName();

        Assert.assertTrue(
                hotelName.getText().contains(location),
                "Hotel name is wrong"
        );
        System.out.println("Hotel name is correct");
    }
}
