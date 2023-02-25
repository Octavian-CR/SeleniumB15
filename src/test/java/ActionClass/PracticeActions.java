package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class PracticeActions {
    @Test
    public void validateMessageAndColor() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");

        WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement emptyBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragger).moveToElement(emptyBox).release().perform();
        Thread.sleep(3000);
        String actualMessage = BrowserUtils.getText(emptyBox);
        String expectedMessage = "Dropped!";
        Assert.assertEquals(actualMessage, expectedMessage);
        String actualColor = emptyBox.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);
    }
}
