import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Act_9e {
    WebDriver driver;

    @BeforeClass()
    public void beforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        Reporter.log("Opened Browser");
    }
    @BeforeMethod
    public void switchToDefaultContent() {
        Reporter.log("Test case start");
        driver.switchTo().defaultContent();
    }
    @Test
    public void simpleAlertTestCase() {
        driver.findElement(By.id("simple")).click();
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println("Simple Alert Text: " + simpleAlert.getText());
        Reporter.log("Simple Alert open");
        simpleAlert.accept();
    }

    @Test
    public void confirmAlertTestCase() {
        driver.findElement(By.id("confirm")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirm Alert Text: " + confirmAlert.getText());
        Reporter.log("Confirm Alert open");
        confirmAlert.dismiss();
    }

    @Test
    public void promptAlertTestCase() {
        driver.findElement(By.id("prompt")).click();
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt Alert Text: " + promptAlert.getText());
        Reporter.log("Prompt Alert open");
        promptAlert.accept();
    }

    public void afterMethod () {
        //Close the browser
        Reporter.log("Ending Test");
        driver.close();
    }
}