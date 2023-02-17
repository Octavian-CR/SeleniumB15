package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/Cory/Desktop/Techtorialhtml.html");
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']")); //4 elements
        for( WebElement box : allBoxes){
            Thread.sleep(1000);
            if (box.isDisplayed() && !box.isSelected() && box.isEnabled()){
                box.click();
            }
        }

        /*
        get attribute, and check all boxes by list and loop
        URL "https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html"
         */






    }



}
