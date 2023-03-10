package mentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JPetStore {

    @Test
    public void validateCostMathFunctionality(){
/*
1-Navigate to the website "https://petstore.octoperf.com/actions/Catalog.action"
2-Choose one category and put the product_id and name as a map format(Only one of the category) then print out
3-Go to the main menu and choose 2 different category and choose one item from there
4-Add them into the card
5-Validate the total cost equals to the price at the bottom shows.
6-Quit
 */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");
        WebElement cats = driver.findElement(By.xpath("//a[contains(@href,'CATS')]"));
        cats.click();
        List<WebElement> productIDs = driver.findElements(By.xpath("//a[contains(@href,'FL')]"));
        List<WebElement> names = driver.findElements(By.xpath("//td[2]"));
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < productIDs.size(); i++) {
            map.put(BrowserUtils.getText(productIDs.get(i)),BrowserUtils.getText(names.get(i)));
        }
        System.out.println(map);
        WebElement home = driver.findElement(By.cssSelector("#LogoContent"));
        home.click();
        WebElement birds = driver.findElement(By.xpath("//a[contains(@href,'BIRDS')]"));
        birds.click();
        WebElement birds_product = driver.findElement(By.linkText("AV-CB-01"));
        birds_product.click();
        WebElement addToCart = driver.findElement(By.linkText("Add to Cart"));
        addToCart.click();
        home = driver.findElement(By.cssSelector("#LogoContent"));
        home.click();
        WebElement dogs = driver.findElement(By.xpath("//a[contains(@href,'DOGS')]"));
        dogs.click();
        WebElement dog_product = driver.findElement(By.linkText("K9-PO-02"));
        dog_product.click();
        WebElement addToCart2 = driver.findElement(By.xpath("//tr[2]//td[5]"));
        addToCart2.click();
        List<WebElement> prices = driver.findElements(By.xpath("//td[7]"));
        Double sum = 0.0;
        for (int i = 0; i < prices.size(); i++) {
            sum = sum + Double.parseDouble(BrowserUtils.getText(prices.get(i)).replace("$",""));
        }
        Assert.assertTrue(BrowserUtils.getText(driver.findElement(By.xpath("//td[@colspan='7']"))).contains(""+sum));

    }
}
