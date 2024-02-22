import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class loginPage {
    public static void main(String[] args){
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Home page title: " + driver.getTitle());
        WebElement element = driver.findElement(By.id("username"));
        element.sendKeys("admin");
        WebElement element1 = driver.findElement(By.id("password"));
        element1.sendKeys("password");
        WebElement logln = driver.findElement(By.xpath("button"));
        logln.click();
        driver.quit();
    }
}
