package Homework.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homework2 {

/*
navigate to : http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?
*/
    @Test
    public void Test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle().trim();
        Assert.assertEquals(expectedTitle,actualTitle);

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        String expectedTitle2 = "Web Orders";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle2,actualTitle2);
        driver.close();
    }

    @Test
    public void Test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        WebElement allProductsButton = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        allProductsButton.click();

        WebElement isSelected = driver.findElement(By.xpath("//li[@class='selected']"));
        Assert.assertEquals(isSelected.getText(),"View all products");

        String expectedHeader = "List of Products";
        WebElement Header = driver.findElement(By.tagName("h2"));


        String actualHeader = Header.getText().trim();
        Assert.assertEquals(expectedHeader,actualHeader);
        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));

        driver.close();
    }

    @Test
    public void Test3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        WebElement allOrdersButton = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        String allOrdersLink = allOrdersButton.getAttribute("href");
        WebElement allProductsButton = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        String allProductsLink = allProductsButton.getAttribute("href");
        WebElement orderButton = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        String othersLink = allProductsButton.getAttribute("href");



        Assert.assertTrue(allOrdersButton.getAttribute("href").contains("Default.aspx"));
        Assert.assertTrue(allProductsButton.getAttribute("href").contains("Products.aspx"));
        Assert.assertTrue(orderButton.getAttribute("href").contains("Process.aspx"));
        driver.close();

    }

    @Test
    public void Test4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        WebElement orderButton = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderButton.click();

        Thread.sleep(2000);
        WebElement productInput = driver.findElement(By.xpath("//select[@onchange='productsChanged()']"));
        Select product = new Select(productInput);
        product.selectByValue("ScreenSaver");
        WebElement quantity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("Code Fish IT School");
        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E Devon");
        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");
        WebElement zipCode = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zipCode.sendKeys("60018");
        WebElement card = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        card.click();
        WebElement cardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        cardNumber.sendKeys("44993876233");
        WebElement expDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        expDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

        String expectedText = "New order has been successfully added.";
        String actualText = driver.findElement(By.xpath("//strong[contains(text(),'New order has been successfully added.')]")).getText().trim();
        Assert.assertEquals(expectedText,actualText);

        WebElement allOrdersButton = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        allOrdersButton.click();

        String expectedOrder = "Code Fish IT School";
        String actualOrder = driver.findElement(By.xpath("//td[contains(text(),'Code Fish IT School')]")).getText().trim();
        Assert.assertEquals(expectedOrder,actualOrder);

        driver.close();

    }

}
