package FrameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void NestedFramePractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("/html/body"))),"LEFT");


        //Middle and right
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("/html/body/div"))),"MIDDLE");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("/html/body"))),"RIGHT");
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent(); //directly to the main html
        driver.switchTo().frame("frame-bottom");
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("/html/body"))),"BOTTOM");




    }
}
