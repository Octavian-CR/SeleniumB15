package FrameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class FramePractice2 {
    @Test
    public void practiceFrame() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://skpatro.github.io/demo/iframes/");
        WebElement pavilion = driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        BrowserUtils.switchByID(driver);
        WebElement selenium = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        WebElement selenium_java = driver.findElement(By.xpath("//span[contains(text(),'Selenium-Java')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selenium).perform();
        Thread.sleep(3000);
        actions.click(selenium_java).perform();
        String actualHeader = driver.findElement(By.xpath("//h1")).getText().trim();
        String expectedHeader = "Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualHeader,expectedHeader);

        List<WebElement> table = driver.findElements(By.xpath("//ul[@class='ht_toc_list']//li"));

        for (WebElement element : table){
            System.out.println(BrowserUtils.getText(element));
        }

        System.out.println("****************");
        BrowserUtils.switchByTitle(driver,"iframes");

/*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)

 */
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='Frame1']"));
        driver.switchTo().frame(iframe);
        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        BrowserUtils.switchByTitle(driver,"Archives");
        String categoryHeader = BrowserUtils.getText(driver.findElement(By.xpath("//h1")));
        String expectedCategoryHeader = "Category Archives: SeleniumTesting";
        Assert.assertEquals(categoryHeader,expectedCategoryHeader);
        List<WebElement> headers = driver.findElements(By.xpath("//h3"));
        for (WebElement header : headers){
            System.out.println(BrowserUtils.getText(header));
        }
/*
Task3:
1-Go back main page
2-click category3
3-validate the header "Category archives, software testing

 */
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3 = driver.findElement(By.xpath("//a[contains(text(),'Category3')]"));
        category3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting");
        String ST_expectedHeader = "Category Archives: SoftwareTesting";
        String ST_actualHeader = BrowserUtils.getText(driver.findElement(By.xpath("//h1")));
        Assert.assertEquals(ST_actualHeader,ST_expectedHeader);

        driver.quit();
    }


}
