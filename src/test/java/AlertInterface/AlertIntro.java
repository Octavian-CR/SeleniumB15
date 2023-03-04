package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void alertAcceptAndGetText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JS_Alert = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
                                                                        //button[contains(text(),'jsAlert')]
        JS_Alert.click();
        Alert alert = driver.switchTo().alert();
        String actualJS_AlertText = alert.getText(); //to get the text from Alert Pop-UP
        String expectedJS_alertText = "I am a JS Alert";
        Assert.assertEquals(actualJS_AlertText,expectedJS_alertText);
        Thread.sleep(3000);
        alert.accept(); //it clicks OK button
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message); // this is webelement, so I can use browser utils
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void alertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        alertButton.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message); // this is webelement, so I can use browser utils
        String expectedMessage = "You clicked: Cancel";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void sendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("I love UI automation");
        alert.accept();
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message); // this is webElement, so I can use browser utils
        String expectedMessage = "You entered: I love UI automation";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

}
