import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class Activity18 {
    public static void main(String[]args){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver(firefoxOptions);
        driver.get("https://www.google.com/search?q=cheese&rlz=1C1GCEU_enIN1092IN1092&oq=cheese&gs_lcrp=EgZjaHJvbWUyDAgAEEUYORixAxiABDIQCAEQLhiDARixAxjJAxiABDIQCAIQLhjHARixAxjRAxiABDINCAMQABiDARixAxiABDIKCAQQABiSAxiABDINCAUQABiSAxiABBiKBTIKCAYQABixAxiABDIKCAcQABixAxiABDIKCAgQABixAxiABDIKCAkQABixAxiABNIBCDIzMDJqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Cheese");
        searchBox.sendKeys(Keys.RETURN);
        WebElement results = driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
        String resultsText = results.getText();
        System.out.println("Search Results:"+ resultsText);

        //take screenshot
        String fileName = System.currentTimeMillis() + "Test";
        File screenshot = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);

        File outputFile = new File("loggerscrenshots/"+ fileName+".png");
        System.out.println(outputFile.getAbsoluteFile());

        try {
            FileUtils.copyFile(screenshot, outputFile);
        }  catch(IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
