package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;

public class SearchPage {

    private final WebDriver driver;


    // Locators

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public HotelDetailsPage clickOnHotel (String hotelName){

        By hotelElement = By.xpath("//div[@data-testid='title' and contains(., '" + hotelName + "')]");


        explicitWait(driver, ExpectedConditions.elementToBeClickable(hotelElement), 10L);
        driver.findElement(hotelElement).click();
        return new HotelDetailsPage(driver);
    }
}
