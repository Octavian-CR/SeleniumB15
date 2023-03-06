package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("C:\\Users\\Cory\\Desktop\\usa.png");
//        chooseFileButton.sendKeys("C:\\Users\\Cory\\Desktop\\bind.txt");
        WebElement fileUploadButton = driver.findElement(By.cssSelector("#file-submit"));
        fileUploadButton.click();
        WebElement attachment = driver.findElement(By.cssSelector("#uploaded-files"));
        String actualMessage = BrowserUtils.getText(attachment);
        String expectedMessage = "usa.png";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void practice2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement chooseFileButton = driver.findElement(By.cssSelector(".upload_txt"));
        chooseFileButton.sendKeys("C:\\Users\\Cory\\Desktop\\usa.png");
                                                                                            // finding xpath by using sibling
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("//div[@id='uploadmode3']//following-sibling::span"))),"Select file to send(max 196.45 MB)");

        WebElement terms = driver.findElement(By.cssSelector("#terms"));
        terms.click();
        WebElement sendButton = driver.findElement(By.xpath("//button[@name='send']"));
        sendButton.click();

        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.xpath("//h3[@id='res']//center"))),"1 file\n" +
                "has been successfully uploaded.");

    }
}
