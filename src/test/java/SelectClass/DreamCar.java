package SelectClass;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DreamCar {

    @Test
    public void validateHeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");
/*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
*/
        WebElement new_used = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(new_used,"new","value");

        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make,"lexus","value");

        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");

        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"40","value");

        WebElement zip = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zip.clear();
        zip.sendKeys("60056");

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();

        WebElement header = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        String actualHeader = header.getText();
        String expectedHeader= "New Lexus RX 350 for sale";

        Assert.assertEquals(actualHeader,expectedHeader);

        WebElement sortBy = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(sortBy,"list_price","value");
        Thread.sleep(3000);

        List<WebElement> titles = driver.findElements(By.xpath("//h2[@class='Title']"));
        for (WebElement title : titles){
            Assert.assertTrue(title.getText().contains("Lexus RX 350"));
        }

        //validate that sort by lowest is working

        List<Integer> actualPrices = new ArrayList<>();
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Integer> expectedPrices = Arrays.asList(53750,54505,54960,55270,55460,55460,55535,56080,57125,57125,57215,57565,58500,58660,58665,58940,59260,59330,59385,59425);
        for (WebElement price : prices){
            actualPrices.add(Integer.parseInt(price.getText().substring(1).replace(",","")));
        }
        Collections.sort(actualPrices);

        Assert.assertEquals(actualPrices,expectedPrices);

        driver.quit();
    }

    @Test
    public void HoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> names = driver.findElements(By.tagName("h5"));
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1","name: user2","name: user3");
        Actions actions = new Actions(driver);

        for (int i = 0; i < names.size() ; i++) {
            Thread.sleep(2000);
            actions.moveToElement(images.get(i)).perform();//you are hovering over the pictures
            actualNames.add(BrowserUtils.getText(names.get(i))); // you are storing the names inside of the list for validation

        }

        System.out.println(actualNames);
        System.out.println(expectedNames);
        Assert.assertEquals(actualNames,expectedNames);

        driver.close();


    }
}
