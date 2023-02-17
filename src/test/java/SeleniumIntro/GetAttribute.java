package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointmentButton = driver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]"));
        makeAppointmentButton.click();

        WebElement demoUser = driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        System.out.println(demoUser.getAttribute("value"));
        System.out.println(demoUser.getAttribute("placeholder"));

        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys(demoUser.getAttribute("value"));















    }



}
