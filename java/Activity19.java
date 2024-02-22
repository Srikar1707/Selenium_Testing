import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Activity19{
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        searchBox.sendKeys("cheese");
        searchBox.submit();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Search Results:");
        WebElement resultsContainer = driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
        for (WebElement result : resultsContainer.findElements(By.xpath("//*[@id=\"result-stats\"]"))) {
            System.out.println(result.getText());
        }
        driver.quit();
    }
}
