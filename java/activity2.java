import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

public class activity2 {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        String pageTitle = driver.getTitle();
        System.out.println("Home page title: " + driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        performSingleSelectActions(driver);
        driver.close();
    }
    private static void performSingleSelectActions(WebDriver driver) {
        WebElement singleSelectDropdown = driver.findElement(By.id("single-select"));
        Select select = new Select(singleSelectDropdown);
        select.selectByVisibleText("Option 2");
        System.out.println("Selected option by visible text: Option 2");
        select.selectByIndex(2);
        System.out.println("Selected option by index: Option 3");
        select.selectByValue("4");
        System.out.println("Selected option by value: Option 4");
        List<WebElement> allOptions = select.getOptions();
        System.out.println("All options in the dropdown:");
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }
    }
}
