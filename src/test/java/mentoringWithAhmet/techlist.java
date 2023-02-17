package mentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class techlist {
    /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox).
7-Select Automation tools you are familiar with (multiple checkboxes).
8-Select Continent(Send Keys).
9-Click on Submit button.
Try your own logic and automate it without any help.
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //1-Step is: Setting up your automation
        WebDriver driver = new ChromeDriver();
        //2-you need to create a new driver to make a connection between page and intelliJ
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Octavian");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Crestian");
        WebElement sex = driver.findElement(By.id("sex-1"));
        sex.click();
        WebElement yearsExp = driver.findElement(By.id("exp-4"));
        yearsExp.click();
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("06/10/1995");
        WebElement profession = driver.findElement(By.id("profession-1"));
        profession.click();
        WebElement selenium = driver.findElement(By.id("tool-2"));
        if (selenium.isDisplayed() && !selenium.isSelected()){
            selenium.click();
        }
        WebElement tool0 = driver.findElement(By.id("tool-0"));
        if (tool0.isDisplayed() && !tool0.isSelected()){
            tool0.click();
        }
        WebElement tool1= driver.findElement(By.id("tool-1"));
        if (tool1.isDisplayed() && !tool1.isSelected()){
            tool1.click();
        }
        WebElement continents= driver.findElement(By.id("continents"));
        continents.sendKeys("Europe");
        WebElement seleniumComands = driver.findElement(By.id("selenium_commands"));
        seleniumComands.sendKeys("WebElement Commands");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();







    }

}
