import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class act_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.flipkart.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iPhone 15");
        searchBox.sendKeys(Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_1AtVbE")));
        WebElement productName = driver.findElements(By.className("_4rR01T")).get(2);
        String thirdProductName = productName.getText();
        WebElement productPrice = driver.findElements(By.className("_30jeq3")).get(2);
        String thirdProductPrice = productPrice.getText();
        System.out.println("Third product name: " + thirdProductName);
        System.out.println("Third product price: " + thirdProductPrice);
        String fileName = System.currentTimeMillis() + " test";
        File screenshot = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        File outputFile = new File("LoggerScreenshots/" + fileName + ".png");
        System.out.println(outputFile.getAbsolutePath());
        try {
            FileUtils.copyFile(screenshot, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}