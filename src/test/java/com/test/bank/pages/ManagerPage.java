package com.test.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManagerPage {

    public ManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccount;

    @FindBy(xpath = "//select[@name='userSelect']")
    WebElement customerName;

    @FindBy(css="#currency")
    WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersButton;

    @FindBy(tagName = "input")
    WebElement searchBox;

    @FindBy(xpath = "//tbody//tr[1]//td[@class='ng-binding']")
    List<WebElement> allInformation;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement deleteButton;


    /*
1-Navigate to the website https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
2-Click Bank Manager Login
3-Click Add Customer
4-Fill the blanks and click add customer button
5-Get the text from pop-up and VALIDATE and click OK
6-Click Open Account
7-Choose your name from the list
8-Choose any currency you want from list
9-Get the text from pop-up and VALIDATE account successuflly created contains and click OK
10-Click Customers Button
11-Search your name on the searchBar
12-Validate your firstname,lastName,PostCode and click delete
13-driver.quit
14-Proud of yourself
 */
    public void addNewCustomer(WebDriver driver, String firstName, String lastName, String postCode, String message){
        addCustomer.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submit.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(message));
        alert.accept();
    }

    public void validateOpenAccountFunctionality(WebDriver driver,String fullName,String currencyValue, String message) throws InterruptedException {
        openAccount.click();
        Thread.sleep(3000);
        BrowserUtils.selectBy(customerName,fullName,"text");
        Thread.sleep(3000);
        BrowserUtils.selectBy(currency,currencyValue,"value");
        Thread.sleep(3000);
        processButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(message));
        alert.accept();
    }

    public void validateCustomerInformationAndDeleteFunctionality(String firstName, String lastName, String postCode) throws InterruptedException {
        customersButton.click();
        searchBox.sendKeys(firstName);
        List expectedInformation = Arrays.asList(firstName,lastName,postCode);
        for (int i = 0; i < allInformation.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));
        }
        Thread.sleep(3000);
        deleteButton.click();
    }

}
