package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;


public class Helper {


    //    Explicit wait
    public static WebElement explicitWait(WebDriver driver, ExpectedCondition<WebElement> condition, long sec) {
        return new WebDriverWait(driver, Duration.ofSeconds(sec)).until(condition);
    }


//_______________________________________________________________________________________________________________________________________________________________

    //    get absolute path of attachment
    public class getAbsolutePath {
        public static String testImageAbsolutePath = generateAbsolutePath();

        public static String generateAbsolutePath() {
            String projectPath = "src/test/resources/TestDataFiles/testImage.png";  // Relative path
            File file = new File(projectPath);
            String absolutePath = file.getAbsolutePath();
            return absolutePath;
        }
    }
}
