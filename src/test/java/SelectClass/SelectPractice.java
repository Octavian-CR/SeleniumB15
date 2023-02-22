package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {
   // @Test
//    public void validateFirstOptionAndPrintAllOptions() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.navigate().to("file:///C:/Users/Cory/Desktop/Techtorialhtml.html");
//
//        WebElement CountryBox = driver.findElement(By.xpath("//select[@name='country']"));
//        Select countries = new Select(CountryBox);
//
//        String actual=countries.getFirstSelectedOption().getText().trim();
//        String expected="UNITED STATES";
//        Assert.assertEquals(actual,expected);
//        List<WebElement> allCountries = countries.getOptions();
//        int count =0;
//        for (int i = 0; i < allCountries.size(); i++) {
//            System.out.println( i+1 +""+allCountries.get(i).getText());
//
//            count ++;
//        }
//        System.out.println(count);
//
//
//
//
//        countries.selectByValue("134");
//        Thread.sleep(3000);
//        countries.selectByVisibleText("UKRAINE");
//        Thread.sleep(3000);
//        countries.selectByIndex(100);
//    }
/*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
"After flight finder - No Seats Avaialble"

NOTE:Your test should fail and say available is not matching with Available.
NOTE2:You can use any select method value,visibleText
*/
    @Test
    public void validateOrderMessage(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement type = driver.findElement(By.xpath("//input[@value='oneway']"));
        type.click();

        WebElement passangers = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passCount = new Select(passangers);
        passCount.selectByValue("4");

        WebElement from = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select fromCity = new Select(from);
        fromCity.selectByValue("San Francisco");

        WebElement departureMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select departureM = new Select(departureMonth);
        departureM.selectByValue("8");

        WebElement departureDate = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select departureD = new Select(departureDate);
        departureD.selectByIndex(14);

        WebElement to = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select toCity = new Select(to);
        toCity.selectByValue("London");

        WebElement arrivalMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select arrivalM = new Select(arrivalMonth);
        arrivalM.selectByValue("12");

        WebElement arrivalDate = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select arrivalD = new Select(arrivalDate);
        arrivalD.selectByIndex(14);

        WebElement servClas = driver.findElement(By.xpath("//input[@value='Business']"));
        servClas.click();

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline1 = new Select(airline);
        airline1.selectByVisibleText("Unified Airlines");

        List<WebElement> allAirlines = airline1.getOptions();
        List<String> expectedAirlines = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for (int i = 0; i < allAirlines.size(); i++) {
            Assert.assertEquals(allAirlines.get(i).getText().trim(),expectedAirlines.get(i));
        }

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='image']"));
        continueButton.click();

        String expected = "After flight finder - No Seats Available";
        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        String actual = header.getText().trim();

        Assert.assertEquals(expected,actual);



    }

}
