package Homework.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework3 {

    @Test
    public void Task1 () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://uitestpractice.com/Students/Index");

        WebElement createNew = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        createNew.click();

        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var ads = document.querySelectorAll('div.ad'); for (var i = 0; i < ads.length; i++) { ads[i].parentNode.removeChild(ads[i]); }");
        driver.switchTo().frame("aswift_2");
        driver.switchTo().frame("ad_iframe");
        Thread.sleep(3000);
        WebElement closeAd = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
        closeAd.click();
        driver.switchTo().parentFrame();

        Thread.sleep(4000);
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Octavian");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Crestian");
        WebElement enrolmentDate = driver.findElement(By.xpath("//input[@id='EnrollmentDate']"));
        enrolmentDate.sendKeys("3/2/2022");
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        WebElement search = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        search.sendKeys("Octavian");
        WebElement findBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        findBtn.click();


        List<WebElement> lastNames = driver.findElements(By.xpath("//tr//td[2]"));

        for (int i = 0; i < lastNames.size(); i++) {
            Assert.assertTrue(BrowserUtils.getText(lastNames.get(i)).contains("Crestian"));
        }
    }

    @Test
    public void Test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://uitestpractice.com/Students/Index");
        WebElement search = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        search.sendKeys("Crestian");
        WebElement findBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        findBtn.click();
        WebElement editBtn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[2]/td[4]/button[1]"));
        editBtn.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys("EditedFirstName");
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();
        Thread.sleep(3000);
        search = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        search.sendKeys("EditedFirstName");
        findBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        findBtn.click();
        List<WebElement> firstNames = driver.findElements(By.xpath("//tr//td[1]"));

        for (int i = 0; i < firstNames.size(); i++) {
            Assert.assertTrue(BrowserUtils.getText(firstNames.get(i)).contains("EditedFirstName"));
        }
        driver.quit();

    }


    @Test
    public void Test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://uitestpractice.com/Students/Index");
        WebElement search = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        search.sendKeys("Crestian");
        WebElement findBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        findBtn.click();
        WebElement delete = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[2]/td[4]/button[3]"));
        delete.click();
        WebElement confirmDelete = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/div/input"));
        confirmDelete.click();
        search = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        search.sendKeys("Crestian");
        findBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        findBtn.click();
        String expected = "There are zero students with this search text Page 0 of 0";
        String actual = BrowserUtils.getText(driver.findElement(By.xpath("/html/body/div[2]/div[1]")));
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(3000);
        driver.close();
    }
}
