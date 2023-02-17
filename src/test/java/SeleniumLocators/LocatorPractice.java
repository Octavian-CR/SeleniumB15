package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPractice {
    public static void main(String[] args) {

        //1-Setup automation
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        //2-Automation process
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Octavian");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Crestian");
        WebElement eMail = driver.findElement(By.xpath("//input[@placeholder='E-Mail']"));
        eMail.sendKeys("blablabvla@yahoo.com");
        WebElement telephone = driver.findElement(By.xpath("//input[@type='tel']"));
        telephone.sendKeys("7776669999");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("octa1234");
        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConfirm.sendKeys("octa1234");
        WebElement agree = driver.findElement(By.xpath("//input[@name='agree']"));
        agree.click();
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Your Account')]"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader) ? "PASSED" : "FAILED");





    }
}
