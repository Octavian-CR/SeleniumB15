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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void food() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");

        Thread.sleep(3000);
        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Actions actions = new Actions(driver);
        actions.click(acceptCookies);

        Thread.sleep(2000);

        List<WebElement> images = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> dish = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        actions.scrollByAmount(200,200);
        Map<String, String> dish_price = new HashMap<>();

        for (int i = 0; i < images.size() ; i++) {

            actions.moveToElement(images.get(i)).perform();
            dish_price.put(BrowserUtils.getText(dish.get(i)),BrowserUtils.getText(prices.get(i)));

        }

        System.out.println(dish_price);

    }
}
