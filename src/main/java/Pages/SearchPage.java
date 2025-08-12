package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;

public class SearchPage {

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions

    // Scroll down to hotel & click on it from search page
    public HotelDetailsPage clickOnHotel(String hotelName) {
        By hotelLocator = By.xpath(
                "//div[@data-testid='title' and contains(., '" + hotelName + "')]"
        );

        Actions actions = new Actions(driver);
        int maxScrollAttempts = 10;
        int scrollCount = 0;

        while (driver.findElements(hotelLocator).isEmpty() && scrollCount < maxScrollAttempts) {
            actions.scrollByAmount(0, 1000).perform();
            scrollCount++;
        }

        if (driver.findElements(hotelLocator).isEmpty()) {
            throw new RuntimeException("Hotel '" + hotelName + "' not found after scrolling.");
        }

        explicitWait(driver, ExpectedConditions.presenceOfElementLocated(hotelLocator), 10L);
        WebElement hotelElement = driver.findElement(hotelLocator);

        actions.scrollToElement(hotelElement).perform();
        explicitWait(driver, ExpectedConditions.elementToBeClickable(hotelElement), 10L);

        hotelElement.click();
        return new HotelDetailsPage(driver);
    }
}
