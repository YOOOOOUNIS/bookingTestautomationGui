package base;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTests {

    public static WebDriver driver;
    protected HomePage homePage;

    // Test base URL
    protected String baseUrl = "https://www.booking.com/";

    @BeforeMethod
    public void goToLoginPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // Close the sign-in popup if it appears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        try {
            WebElement closePopup = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector("button[aria-label='Dismiss sign-in info.']")
                    )
            );
            closePopup.click();
            System.out.println("Sign-in popup closed.");
        } catch (TimeoutException e) {
            System.out.println("No sign-in popup appeared.");
        }

        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
