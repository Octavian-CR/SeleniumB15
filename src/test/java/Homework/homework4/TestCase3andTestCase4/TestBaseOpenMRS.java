package Homework.homework4.TestCase3andTestCase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;

public class TestBaseOpenMRS {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get("http://codefish.ninja/openmrs/login.htm");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin123");
        driver.findElement(By.xpath("//li[@id='Laboratory']")).click();
        driver.findElement(By.xpath("//input[@id='loginButton']")).click();
    }

    @AfterMethod
    public void tearDown (ITestResult iTestResult) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
