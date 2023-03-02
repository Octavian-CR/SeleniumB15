package MentoringWithKuba;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LambdaTest {

//    https://www.lambdatest.com/selenium-playground/

    WebDriver driver;

    @BeforeClass()
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Test
    public void ValidateEmailAndName_TC_01() throws InterruptedException {

        driver.findElement(By.xpath("//a[contains(text(),'Table Pagination')]")).click();
        WebElement maxRows = driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtils.selectBy(maxRows,"5000","value");
        Thread.sleep(2000);
        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> phoneNumbers = driver.findElements(By.xpath("//tr//td[4]"));


        for (int i = 0; i < allEmails.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put(allNames.get(i).getText(),allEmails.get(i).getText());
            System.out.println(map);
        }

        for (int i = 0; i < allEmails.size(); i++) {
            Map<String, Long> map = new HashMap<>();
            map.put(allNames.get(i).getText(),Long.parseLong(phoneNumbers.get(i).getText().replace("-","")));
            System.out.println(map);
        }




    }
}
