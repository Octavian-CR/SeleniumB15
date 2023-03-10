package com.test.bank.tests;

import com.test.bank.pages.ManagerPage;
import com.test.bank.pages.LoginBankPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ManagerTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }


    @Test
    public void validateBankFunctionality() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        LoginBankPage loginManager = new LoginBankPage(driver);
        loginManager.login();
        ManagerPage addCustomer = new ManagerPage(driver);
        addCustomer.addNewCustomer(driver,"Borea","Tsigan","12345","Customer added successfully");
        addCustomer.validateOpenAccountFunctionality(driver,"Borea Tsigan","Dollar","Account created successfully");
        addCustomer.validateCustomerInformationAndDeleteFunctionality("Borea","Tsigan","12345");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
