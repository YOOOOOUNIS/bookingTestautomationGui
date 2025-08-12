package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;

public class ReservationPage {

    private final WebDriver driver;

    // Locators
    private final By hotelNameElement = By.xpath(
            "//*[@id='bodyconstraint-inner']/div[3]/div[3]/aside/div/div[1]/div/div/div/div[2]/div/div/div[1]/div[1]/h1"
    );

    public ReservationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions

    // Get hotel name element
    public WebElement getHotelName() {
        return explicitWait(driver, ExpectedConditions.visibilityOfElementLocated(hotelNameElement), 10L);
    }
}
