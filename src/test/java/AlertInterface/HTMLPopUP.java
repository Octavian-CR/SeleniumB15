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

public class HTMLPopUP {
    @Test
    public void htmlPopUpPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://sweetalert.js.org/");
        WebElement normalAlert = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        normalAlert.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Oops, something went wrong!");
        alert.accept();
        WebElement sweetAlert = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        sweetAlert.click();
        Thread.sleep(3000);
        Assert.assertTrue(BrowserUtils.getText(driver.findElement(By.xpath("//div[@class='swal-modal']"))).contains("Something went wrong"));
        WebElement accept = driver.findElement(By.xpath("//div[@class='swal-button-container']//button[@class='swal-button swal-button--confirm']"));
        accept.click();
        driver.close();

    }
}
