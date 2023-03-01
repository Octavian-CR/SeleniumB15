package mentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SpruceInterviewQuestion {
    @Test
    public void spruceEats() throws InterruptedException {
/*
1-Navigate to the website "https://www.thespruceeats.com/"
2-Under Ingredients option --> choose Fish&SeaFood option
3-ScrollDown to the search bar
4-Send the data: "Fish for dinner"
5-On the left side choose 4 star up option
6-From popular: Choose the Editor's choice option
7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
8-Quit or close your driver
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.thespruceeats.com/");

        WebElement ingredients = driver.findElement(By.xpath("//span[.='Ingredients']"));
        Actions actions = new Actions(driver);
        WebElement fish = driver.findElement(By.xpath("//a[contains(text(),'Fish & Seafood')]"));
        actions.moveToElement(ingredients).perform();
        actions.click(fish).perform();
        Thread.sleep(3000);
        WebElement search = driver.findElement(By.cssSelector("#search-form-input"));
        BrowserUtils.scrollWithJS(driver,search);
        Thread.sleep(3000);
        search.sendKeys("Fish for dinner", Keys.ENTER);
        WebElement star = driver.findElement(By.xpath("//label[@for='starRating_score_4Star']"));
        star.click();
        WebElement editorsChoice = driver.findElement(By.xpath("//label[@for='pop_search_editor']"));
        editorsChoice.click();
        Thread.sleep(3000);
        String actual = driver.findElement(By.xpath("//span[contains(text(),'Salmon Fillets')]")).getText().trim();
        String expected = "6-Ingredient Roasted Salmon Fillets";
        Assert.assertEquals(actual,expected);
        Thread.sleep(5000);
        driver.close();

    }
}
