package Homework.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Task_2_26_23 {

        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
         */

    @Test
    public void switchWindow (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");

        WebElement courseButton = driver.findElement(By.xpath("//span[contains(text(),'Find out which course is for you')]"));
        courseButton.click();
        String mainPageID = driver.getWindowHandle();
        Set<String> allPagesID = driver.getWindowHandles();
        for (String id : allPagesID){
            if (!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
        //driver.close();

    }
}
