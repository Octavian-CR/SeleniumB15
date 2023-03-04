package FrameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FramePractice {

    @Test
    public void iFramePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");

        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualHeader = BrowserUtils.getText(driver.findElement(By.xpath("//h3")));
        Assert.assertEquals(expectedHeader,actualHeader);
        driver.switchTo().frame("mce_0_ifr");
        WebElement field = driver.findElement(By.cssSelector("#tinymce"));
        field.clear();
        field.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();
        BrowserUtils.switchByID(driver);
        Thread.sleep(3000);
        String actualMessage = driver.findElement(By.xpath("//h1")).getText().trim();
        String expected = "Elemental Selenium";
        Assert.assertEquals(actualMessage,expected);


    }
}
