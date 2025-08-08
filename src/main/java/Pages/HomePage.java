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
    public void setLocationField(String location) {
        explicitWait(driver, ExpectedConditions.elementToBeClickable(locationField), 10L);
        driver.findElement(locationField).sendKeys(location);
    }

    public void openCalendar (){
        explicitWait(driver, ExpectedConditions.elementToBeClickable(calendar), 10L);
        driver.findElement(calendar).click();
    }

    public void setCheckInDate (String startDate){

        while (driver.findElements(By.cssSelector("span[data-date='" + startDate + "']")).isEmpty()) {
            driver.findElement(By.cssSelector("button[aria-label='Next month']")).click();
        }

        By checkInDate =By.cssSelector("span[data-date='" + startDate + "']");
        explicitWait(driver, ExpectedConditions.elementToBeClickable(calendar), 10L);
        driver.findElement(checkInDate).click();
    }

    public void setCheckOutDate (String endDate){

        while (driver.findElements(By.cssSelector("span[data-date='" + endDate + "']")).isEmpty()) {
            driver.findElement(By.cssSelector("button[aria-label='Next month']")).click();
        }

        By checkOutDate =  By.cssSelector("span[data-date='" + endDate + "']");
        explicitWait(driver, ExpectedConditions.elementToBeClickable(calendar), 10L);
        driver.findElement(checkOutDate).click();
    }

    public SearchPage clickOnSearchButton() {
        explicitWait(driver, ExpectedConditions.elementToBeClickable(searchButton), 10L);
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }
}
