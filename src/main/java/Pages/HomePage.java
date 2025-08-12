package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;

public class HomePage {

    private final WebDriver driver;

    // Locators
    private final By locationField = By.id(":rh:");
    private final By calendar = By.xpath("//button[@data-testid='searchbox-dates-container']");
    private final By searchButton = By.xpath("//button[.//span[text()='Search']]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions

    // Set location field
    public void setLocationField(String location) {
        explicitWait(driver, ExpectedConditions.elementToBeClickable(locationField), 10L);
        driver.findElement(locationField).sendKeys(location);
    }

    // Open calendar
    public void openCalendar() {
        explicitWait(driver, ExpectedConditions.elementToBeClickable(calendar), 10L);
        driver.findElement(calendar).click();
    }

    // Select check-in date
    public void setCheckInDate(String startDate) {
        By startDateElement = By.cssSelector("span[data-date='" + startDate + "']");
        while (driver.findElements(startDateElement).isEmpty()) {
            driver.findElement(By.cssSelector("button[aria-label='Next month']")).click();
        }
        explicitWait(driver, ExpectedConditions.elementToBeClickable(calendar), 10L);
        driver.findElement(startDateElement).click();
    }

    // Select check-out date
    public void setCheckOutDate(String endDate) {
        By endDateElement = By.cssSelector("span[data-date='" + endDate + "']");
        while (driver.findElements(endDateElement).isEmpty()) {
            driver.findElement(By.cssSelector("button[aria-label='Next month']")).click();
        }
        explicitWait(driver, ExpectedConditions.elementToBeClickable(calendar), 10L);
        driver.findElement(endDateElement).click();
    }

    // Click on search button
    public SearchPage clickOnSearchButton() {
        explicitWait(driver, ExpectedConditions.elementToBeClickable(searchButton), 10L);
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }
}
