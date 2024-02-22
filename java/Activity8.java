import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;


public class Activity8 {
    public static void main(String[] args){
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get(" https://v1.training-support.net/selenium/drag-drop");
        System.out.println("Home page title" + driver.getTitle());
        WebElement football = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        Actions builder = new Actions(driver);
        builder.clickAndHold(football).moveToElement(dropzone1).pause(3000).release().build().perform();
        builder.dragAndDrop(football, dropzone2).build().perform();
        driver.close();

    }
}
