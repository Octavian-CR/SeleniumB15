package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement copywright = driver.findElement(By.xpath("//div[contains(text(),'Copyright © 2023')]"));
        BrowserUtils.scrollWithJS(driver,copywright);
        String actualMessage = BrowserUtils.getText(copywright);
        String expectedMessage = "Copyright © 2023";
        Assert.assertEquals(actualMessage,expectedMessage);
        Thread.sleep(3000);
        WebElement applyNow = driver.findElement(By.xpath("//span[contains(text(),'Apply Now')]"));
        BrowserUtils.scrollWithJS(driver,applyNow);
        BrowserUtils.clickWithJS(driver,applyNow);

        List<WebElement> headers = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedHeaders = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for (int i = 0; i < headers.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(headers.get(i)),expectedHeaders.get(i));
        }

    }
}
