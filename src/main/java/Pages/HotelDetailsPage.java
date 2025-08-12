package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Helper.explicitWait;

public class HotelDetailsPage {

    private final WebDriver driver;

    // Locators
    private final By twoTwinBedRadioButton = By.xpath("//*[@id='hprt-table']/tbody/tr[1]/th/div/div[3]/div[1]/label[2]/div/input");
    private final By amountDropDownMenu = By.id("hprt_nos_select_78883120_386871369_0_33_0_131741");
    private final By reserveButton = By.cssSelector("button.js-reservation-button");
    private final By checkInLocator = By.xpath("//*[@id='hp_availability_style_changes']/div[3]/div/form/div/div[1]/div/div/button[1]/span");
    private final By checkOutLocator = By.xpath("//*[@id='hp_availability_style_changes']/div[3]/div/form/div/div[1]/div/div/button[2]/span");

    public HotelDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions

    // Switch to hotel details tab & Get check-in date element
    public WebElement getCheckInDate() {
        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for a second tab and switch to it
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(
                driver.getWindowHandles()
                        .stream()
                        .filter(handle -> !handle.equals(originalWindow))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("No new tab found"))
        );

        // Scroll to element
        WebElement checkInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkInLocator));
        new Actions(driver).scrollToElement(checkInElement).perform();

        return explicitWait(driver, ExpectedConditions.visibilityOfElementLocated(checkInLocator), 10L);
    }

    // Get check-out date element
    public WebElement getCheckOutDate() {
        return explicitWait(driver, ExpectedConditions.visibilityOfElementLocated(checkOutLocator), 10L);
    }

    // Select two twin bed option
    public void selectTwoTwinBed() {
        explicitWait(driver, ExpectedConditions.elementToBeClickable(twoTwinBedRadioButton), 10L);
        driver.findElement(twoTwinBedRadioButton).click();
    }

    // Select amount from dropdown menu
    public void selectAmount() {
        explicitWait(driver, ExpectedConditions.elementToBeClickable(amountDropDownMenu), 10L);
        driver.findElement(amountDropDownMenu).click();
        new Actions(driver).sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
    }

    // Click on reserve button and switch to reservation page
    public ReservationPage reserve() {
        explicitWait(driver, ExpectedConditions.elementToBeClickable(reserveButton), 10L);
        driver.findElement(reserveButton).click();

        // Switch to latest tab if a new one opens
        var tabs = driver.getWindowHandles();
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.toArray()[tabs.size() - 1].toString());
        }

        return new ReservationPage(driver);
    }
}
