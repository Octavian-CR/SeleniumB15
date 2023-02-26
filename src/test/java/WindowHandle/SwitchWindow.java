package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public  void switchPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        clickHere.click();
        String mainPageID = driver.getWindowHandle();
        System.out.println(mainPageID); //CDwindow-031E3AB5C7AC1E37A37F3B12BD30E6F6
        Set<String> allPagesId = driver.getWindowHandles();
        System.out.println(allPagesId);
        for (String id : allPagesId){
            if (!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
//        driver.navigate().to(clickHere.getAttribute("href"));
//        System.out.println(driver.getTitle());



    }
}
