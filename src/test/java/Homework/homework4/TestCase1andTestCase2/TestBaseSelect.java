package Homework.homework4.TestCase1andTestCase2;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;

public class TestBaseSelect {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverHelper.getDriver();
        driver.get("http://uitestpractice.com/Students/select#");
    }

    @AfterMethod
    public void tearDown (ITestResult iTestResult) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
