package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {
    //TASK-1
    //Login successfully with "demo" username and "demo" password and validate title


    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(3000);
//        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
//        closeButton.click();
        String expected = "Dashboard";
        String actual = driver.getTitle();

        Assert.assertEquals(actual, expected);
        driver.close();
    }

    /*
    provide wrong username, and wrong password
     */

    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("abra");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("cadabra");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("#alert"));
        Thread.sleep(1000);
        String error = errorMessage.getText();
        String expected =" No match for Username and/or Password. ";
        Assert.assertEquals(error.trim(),expected.trim());
        driver.close();
    }

    @Test
    public void Products() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();

        WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
        catalog.click();
        WebElement products = driver.findElement(By.xpath("//a[.='Products']"));
        Thread.sleep(3000);

        Assert.assertTrue(products.isDisplayed());
        driver.close();
    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();

        WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
        catalog.click();
        WebElement products = driver.findElement(By.xpath("//a[.='Products']"));
        products.click();


        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i<checkBoxes.size() ; i++){
            Assert.assertTrue(checkBoxes.get(i).isDisplayed());
            Assert.assertTrue(checkBoxes.get(i).isEnabled());
            Assert.assertFalse(checkBoxes.get(i).isSelected());
            checkBoxes.get(i).click();

            checkBoxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }
        driver.close();
    }


    @Test
    public void validateDescendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();

        WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
        catalog.click();
        WebElement products = driver.findElement(By.xpath("//a[.='Products']"));
        products.click();


        WebElement ascendingOrder = driver.findElement(By.cssSelector(".asc"));
        ascendingOrder.click();
        Thread.sleep(3000);
        List<WebElement> productNames = driver.findElements(By.xpath("//td[@class='text-start']")); //11 elements

        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = new ArrayList<>();

        for (int i = 1; i < productNames.size(); i++) { //10 elements
            actualNames.add(productNames.get(i).getText().toLowerCase().trim());
            expectedNames.add(productNames.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedNames); // sorting for ascending
        Collections.reverse(expectedNames); //making sure it is descending order
        System.out.println(expectedNames);
        System.out.println(actualNames);
        Assert.assertEquals(actualNames,expectedNames);
        driver.close();
    }

    @Test
    public void validateProductNameFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();

        WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
        catalog.click();
        WebElement products = driver.findElement(By.xpath("//a[.='Products']"));
        products.click();


        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = new ArrayList<>();
        List<WebElement> productList = driver.findElements(By.xpath("//td[@class='text-start']"));
        for (int i = 1; i < productList.size(); i++) {
            actualNames.add(productList.get(i).getText().toLowerCase().trim());
            expectedNames.add(productList.get(i).getText().toLowerCase().trim());

        }

        Collections.sort(expectedNames);

        Assert.assertEquals(expectedNames,actualNames);

        driver.close();
    }
}
