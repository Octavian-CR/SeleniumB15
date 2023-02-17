package Homework.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCase2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/radio-button");
        WebElement yesButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();
        System.out.println(driver.findElement(By.xpath("//p[@class='mt-3']")).getText());

        Thread.sleep(3000);

        WebElement impressive = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressive.click();
        System.out.println(driver.findElement(By.xpath("//p[@class='mt-3']")).getText());

        driver.quit();


    }
}
