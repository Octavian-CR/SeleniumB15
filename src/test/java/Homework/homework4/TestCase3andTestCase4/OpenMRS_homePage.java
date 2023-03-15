package Homework.homework4.TestCase3andTestCase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.*;

public class OpenMRS_homePage extends TestBaseOpenMRS{
    public OpenMRS_homePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@id='selected-location']")
    WebElement location;

    public void ValidateLocation(String expectedLocation){
        Assert.assertEquals(expectedLocation, BrowserUtils.getText(location));
    }

    @FindBy(xpath = "//div[@id='home-container']")
    WebElement body;
    public void ValidateMessage(String expected){
        Assert.assertTrue(BrowserUtils.getText(body).contains(expected));
    }
    @FindBy(xpath = "//ul[@class='select']//li[@locationname='Pharmacy']")
    WebElement pharmacy;

    @FindBy(xpath = "//div[@class='logo']")
    WebElement logo;
    public void changeLocationToPharmacy(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(location).click(location).click(pharmacy).perform();
        logo.click();
    }
    @FindBy(partialLinkText = "Find Patient Record")
    WebElement findPatient;
    @FindBy(xpath = "//input[@id='patient-search']")
    WebElement searchField;

    public void findAndValidateIdentifierIsUnique(WebDriver driver,String name, String identifier) throws InterruptedException {
        findPatient.click();
        searchField.sendKeys(name);
        Thread.sleep(3000);
        List<WebElement> identifiers = driver.findElements(By.xpath("//tr//td[1]"));
        int counter = 0 ;
        for (int i = 0; i < identifiers.size(); i++) {
            if (BrowserUtils.getText(identifiers.get(i)).contains(identifier)){
                counter++;
            }
        }
        Assert.assertEquals(counter,1);

    }

}
