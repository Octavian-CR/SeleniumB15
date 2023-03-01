package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SwitchMultipleWindows {

    @Test
    public void multipleWindowPractice () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
//        BrowserUtils.switchByID(driver);
        BrowserUtils.switchByTitle(driver,"Contact");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Home");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Courses");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void task2() throws InterruptedException {
/*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button4 = driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();
        BrowserUtils.switchByTitle(driver,"Basic");
        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Octavian");
        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Crestian");
        WebElement english = driver.findElement(By.cssSelector("#englishchbx"));
        english.click();
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("asdasdasd@yahoo.com");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Dqweqw!@#123");
        WebElement registerButton = driver.findElement(By.cssSelector("#registerbtn"));
        BrowserUtils.clickWithJS(driver,registerButton);
        String actualMessage = driver.findElement(By.xpath("//label[contains(text(),'Registration is Successful')]")).getText().trim();
        Assert.assertEquals(actualMessage,"Registration is Successful");
        BrowserUtils.switchByTitle(driver,"Window Handles Practice");
        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Window Handles Practice')]"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Window Handles Practice";
        Assert.assertEquals(actualHeader,expectedHeader);
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement clickMe = driver.findElement(By.cssSelector("#promptBox"));
        BrowserUtils.clickWithJS(driver,clickMe);
        Thread.sleep(3000);
        driver.quit();




    }


}
