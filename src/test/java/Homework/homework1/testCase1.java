package Homework.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCase1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");
        String fullName = "Octavian Crestian";
        String email = "okta777@gmail.com";
        String currentAddress = "2500 cross point cirlce";
        String permanentAddress = "101 independence street";

        WebElement name = driver.findElement(By.xpath("//input[@id='userName']"));
        name.sendKeys(fullName);
        WebElement e_mail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        e_mail.sendKeys(email);
        WebElement current = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        current.sendKeys(currentAddress);
        WebElement permanent = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanent.sendKeys(permanentAddress);
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();

        //Validation
        WebElement nameResult = driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(nameResult.getText() +" - "+ nameResult.getText().contains(fullName));
        WebElement emailResult = driver.findElement(By.xpath("//p[@id='email']"));
        System.out.println(emailResult.getText() + " - "+ emailResult.getText().contains(email));
        WebElement currentResult = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        System.out.println(currentResult.getText()+" - "+currentResult.getText().contains(currentAddress));
        WebElement permanentResult = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        System.out.println(permanentResult.getText()+" - "+permanentResult.getText().contains(permanentAddress));








    }
}
