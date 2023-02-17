package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XPathHealthProject {
    /*
    THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your command for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointment = driver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]"));
        makeAppointment.click();
        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement login = driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
        WebElement selector = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        selector.sendKeys("Hongkong CURA Healthcare Center");
        WebElement medicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();
        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("23/02/2023");
        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I need to get healthy ASAP");
        WebElement bookAppointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppointment.click();

        //header confirmation
        String expected = "Appointment Confirmation".trim();
        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
        String actual = header.getText().trim();
        System.out.println(expected.equals(actual) ? "Confirmation passed" : "Confirmation failed");
        System.out.println(actual);
        WebElement facility = driver.findElement(By.xpath("//p[@id='facility']"));
        System.out.println(facility.getText());
        WebElement hospitalReadMission = driver.findElement(By.xpath("//p[@id='hospital_readmission']"));
        System.out.println(hospitalReadMission.getText());
        WebElement healthcareProgram = driver.findElement(By.xpath("//p[@id='program']"));
        System.out.println(healthcareProgram.getText());
        WebElement visitDate = driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(visitDate.getText());
        WebElement comment1 = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(comment1.getText());

        WebElement goHome = driver.findElement(By.xpath("//a[contains(text(),'Go to Homepage')]"));
        goHome.click();

        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.quit();


    }


}
