package com.test.blaze.tests;

import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import com.test.blaze.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MacBookProTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/#");
    }

    @Test
    public void validateMacBookProductInfo() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptopButton();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseMacBook("MacBook Pro",driver);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.validateProductInfo("MacBook Pro","$1100 *includes tax","Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");

    }

    @AfterMethod
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
