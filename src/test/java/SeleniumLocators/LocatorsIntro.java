package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
//      ID Locator
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/Cory/Desktop/Techtorialhtml.html");

        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader=header.getText().trim(); //Techtorial Academy
        String expectedHeader = "Techtorial Academy";
        System.out.println(actualHeader);
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Failed");

//      task1
        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

//      Name Locator
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Octavian");

        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement email = driver.findElement(By.name("userName"));
        WebElement phone= driver.findElement(By.name("phone"));
        WebElement address = driver.findElement(By.name("address1"));
        WebElement city = driver.findElement(By.name("city"));
        WebElement state = driver.findElement(By.name("state"));
        WebElement postalCode = driver.findElement(By.name("postalCode"));
//        WebElement country = driver.findElement(By.name())

        lastName.sendKeys("Crestian");
        email.sendKeys("okt@gmail.com");
        phone.sendKeys("123566");
        address.sendKeys("6213 Ahoskie Dr");
        city.sendKeys("Charlotte");
        state.sendKeys("NC");
        postalCode.sendKeys("28215");
//        Thread.sleep(3000);

        //Class Locator
        WebElement checkBoxesLabel= driver.findElement(By.className("checkboxes"));
        System.out.println(checkBoxesLabel.getText());

//        for (int i=1; i<=4 ; i++){
//            WebElement javaBox = driver.findElement(By.id("cond"+i));
//            if (javaBox.isDisplayed() && !javaBox.isSelected()){
//                javaBox.click();
//            }
//
//        }


        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();
        }

        WebElement SeleniumBox = driver.findElement(By.id("cond2"));
        if (SeleniumBox.isDisplayed() && !SeleniumBox.isSelected()){
            SeleniumBox.click();
        }

        WebElement TestNGBox = driver.findElement(By.id("cond3"));
        if (TestNGBox.isDisplayed() && !TestNGBox.isSelected()){
            TestNGBox.click();
        }

        WebElement CucumberBox = driver.findElement(By.id("cond4"));
        if (CucumberBox.isDisplayed() && !CucumberBox.isSelected()){
            CucumberBox.click();
        }

        //TAG NAME LOCATOR:
        WebElement version = driver.findElement(By.tagName("u"));
        String actualVersion=version.getText().trim();
        String expectedVersion="Use Java Version";
        System.out.println(actualVersion.equals(expectedVersion) ? "Validation is passed" : "Validation is false");
        driver.quit();











    }
}
