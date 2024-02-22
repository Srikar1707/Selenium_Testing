import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Activity17 {

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://en.wikipedia.org/wiki/Cheese");

        String pageTitle = driver.getTitle();
        System.out.println("Cheese Results Page Title: " + pageTitle);
        java.util.List<WebElement> cheeseResults = driver.findElements(By.xpath("//div[@class='cheese-result']"));
        int numberOfCheeseResults = cheeseResults.size();
        System.out.println("Number of Cheese Results: " + numberOfCheeseResults);
        System.out.println("Cheese Results Information:");
        for (int i = 0; i < numberOfCheeseResults; i++) {
            WebElement cheeseResult = cheeseResults.get(i);
            String cheeseName = cheeseResult.findElement(By.xpath(".//h2")).getText();
            String cheeseDescription = cheeseResult.findElement(By.xpath(".//p")).getText();

            System.out.println("Cheese " + (i + 1) + ": " + cheeseName);
            System.out.println("Description: " + cheeseDescription);
            System.out.println("Cheese Results");
        }

        driver.quit();
    }
}
