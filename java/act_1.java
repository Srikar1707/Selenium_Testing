import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class act_1 {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.in");
        System.out.println("Home page title" + driver.getTitle());
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone 15");

        driver.findElement(By.id("nav-search-submit-button")).click();

        List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        WebElement fourthPrice = priceList.get(4);
        System.out.println("Fourth price: " + fourthPrice.getText());

        driver.quit();
    }
}
