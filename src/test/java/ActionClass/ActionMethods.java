package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionMethods {

    @Test
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        WebElement contextMenu = driver.findElement(By.linkText("Context Menu"));
        contextMenu.click();
        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }

    @Test
    public void ContextClickPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClickMe = driver.findElement(By.xpath("//span[contains(text(), 'right click me')]"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMe).perform();

    }

    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClick = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).perform();
    }

}
