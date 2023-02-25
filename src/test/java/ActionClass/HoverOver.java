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
import java.util.*;

public class HoverOver {

    @Test
    public void HoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> names = driver.findElements(By.tagName("h5"));
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1","name: user2","name: user3");
        Actions actions = new Actions(driver);

        for (int i = 0; i < names.size() ; i++) {
            Thread.sleep(2000);
            actions.moveToElement(images.get(i)).perform();//you are hovering over the pictures
            actualNames.add(BrowserUtils.getText(names.get(i))); // you are storing the names inside of the list for validation

        }

        System.out.println(actualNames);
        System.out.println(expectedNames);
        Assert.assertEquals(actualNames,expectedNames);

        driver.close();


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
