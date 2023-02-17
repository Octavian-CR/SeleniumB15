package Homework.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCase3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("Java");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
        System.out.println(error.getText());
        driver.quit();

    }
}
