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
import org.testng.annotations.Parameters;
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
    @Parameters({"laptopBrand","laptopPrice","description"})
    @Test
    public void validateMacBookProductInfo(String laptopBrand,String laptopPrice, String description) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptopButton();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseMacBook(laptopBrand,driver); //MacBook Pro
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.validateProductInfo("MacBook Pro",laptopPrice,description);

        //$1100 *includes tax
        //Apple has introduced three new versions of its MacBook Pro line
    }

    @AfterMethod
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
