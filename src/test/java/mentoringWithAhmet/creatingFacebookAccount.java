package mentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class creatingFacebookAccount {
    /*
1-Navigate to the website "https://www.facebook.com/"
2-Click Create Account Button
3-Fill all the boxes
4-Choose Custom Gender
5-Choose any pronoun you want from
6-Click Sign up button
7-In general facebook has a protection to automate create account  so once you
click sign up button if there is a message then validate it. If no, just close or quit

   PURPOSE:
       1-This task can come during the interview
       2-How to deal with dynamic elements

 */

    @Test
    public void createAccount() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(3000);
        WebElement createAcc = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createAcc.click();
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Oct");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("cres");
        WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        email.sendKeys("sdasokdasd@yahoo.com");
        Thread.sleep(3000);
        WebElement emailConfirmation = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        emailConfirmation.sendKeys("sdasokdasd@yahoo.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        password.sendKeys("Ceburek#7891");
        WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        year.sendKeys("1985");
        WebElement sex = driver.findElement(By.xpath("//input[@value='2']"));
        sex.click();
        WebElement submit = driver.findElement(By.xpath("//button[@name='websubmit']"));
        submit.click();



    }


}
