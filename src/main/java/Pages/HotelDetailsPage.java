package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.Helper.explicitWait;

public class HotelDetailsPage {

    private final WebDriver driver;


    // Locators
    private final By twoTwinBedRadioButton =  By.cssSelector("input[name='bedPreference_78883120'][value='1']");
    private final By amountDropDownMenu = By.xpath("//button[@data-testid='searchbox-dates-container']");
    private final By reserveButton = By.xpath("//button[.//span[contains(text(),\"I'll reserve\")]]");

    public HotelDetailsPage(WebDriver driver) {
        this.driver = driver;
    }


    // Actions

    public void selectTwoTwinBed() {
        explicitWait(driver, ExpectedConditions.elementToBeClickable(twoTwinBedRadioButton), 10L);
        driver.findElement(twoTwinBedRadioButton).click();
    }

    public void selectAmount() {

        explicitWait(driver, ExpectedConditions.elementToBeClickable(amountDropDownMenu), 10L);
        driver.findElement(amountDropDownMenu).click();

        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
    }

    public void reserve() {
        explicitWait(driver, ExpectedConditions.elementToBeClickable(reserveButton), 10L);
        driver.findElement(reserveButton).click();
    }
}
