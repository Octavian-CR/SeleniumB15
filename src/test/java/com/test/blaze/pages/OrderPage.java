package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement placeOrderButton;

    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }

    @FindBy(css = "#name")
    WebElement nameField;

    @FindBy(css = "#country")
    WebElement countryField;

    @FindBy(css = "#city")
    WebElement cityField;

    @FindBy(css = "#card")
    WebElement cardField;

    @FindBy(css = "#month")
    WebElement monthField;

    @FindBy(css = "#year")
    WebElement yearField;

    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    WebElement purchaseButton;

    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']//h2")
    WebElement confirmationMessage;

    @FindBy(xpath = "//button[.='OK']")
    WebElement acceptConfirmationMessage;
    public void validateProductIsPlaced(WebDriver driver,String name,String country,String city, String card, String month, String year,String expectedURL) throws InterruptedException {

        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        cardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
        purchaseButton.click();
        Assert.assertTrue(BrowserUtils.getText(confirmationMessage).contains("Thank you"));
        acceptConfirmationMessage.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

    }
}
