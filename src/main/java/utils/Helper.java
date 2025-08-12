package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {

    // Explicit wait
    public static WebElement explicitWait(WebDriver driver, ExpectedCondition<WebElement> condition, long sec) {
        return new WebDriverWait(driver, Duration.ofSeconds(sec)).until(condition);
    }
}
