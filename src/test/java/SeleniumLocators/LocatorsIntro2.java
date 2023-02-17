package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//optional
        driver.navigate().to("file:///C:/Users/Cory/Desktop/Techtorialhtml.html");

        //LINKTEXT LOCATOR
        WebElement javaLink = driver.findElement(By.linkText("Java")); //a tag with the text
        javaLink.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println(header.getText().trim().equals("Java") ? "Passed" : "Failed");
        Thread.sleep(2000); //to pause system for 2 sec then I can see what is going on
        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement header1 = driver.findElement(By.tagName("h1"));
        System.out.println(header1.getText().trim().equals("Selenium automates browsers. That's it!") ? "Header has passed" : "Header is not passing");
        driver.navigate().back();

        WebElement cucumber = driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        WebElement header2 = driver.findElement(By.className("font-light"));
        System.out.println(header2.getText().trim().equals("Tools & techniques that elevate teams to greatness") ? "Cucumber test is passing" : "Cucumber test is not passing");
        driver.navigate().back();

        WebElement TestNG = driver.findElement(By.linkText("TestNG"));
        TestNG.click();
        WebElement header3 = driver.findElement(By.tagName("h2"));
        System.out.println(header3.getText().trim().equals("TestNG") ? "TestNG header is passing" : "TestNG header is not passing");
        driver.navigate().back();

        System.out.println(driver.getCurrentUrl().equals("file:///C:/Users/Cory/Desktop/Techtorialhtml.html") ? "Current URL is passing" : "Current URL is not passing");

        //partial Link Locator : // must have a tag and text

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        String actualUrlRestApi = driver.getCurrentUrl();
        String expectedUrlRestApi = "https://rest-assured.io/";
        System.out.println(actualUrlRestApi.equals(expectedUrlRestApi) ? "Passed" : "Failed");
        driver.navigate().back();







    }
}
