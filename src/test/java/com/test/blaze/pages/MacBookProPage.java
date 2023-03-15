package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacBookProPage {
    public MacBookProPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".name")
    WebElement header1;

    @FindBy(css = ".price-container")
    WebElement priceContainer;

    @FindBy(css = "#more-information")
    WebElement moreInformation;

    @FindBy(linkText = "Add to cart")
    WebElement addToCart;


    public void validateProductInfo(String header, String price, String description) throws InterruptedException {
        System.out.println(moreInformation.getText());
        Assert.assertEquals(BrowserUtils.getText(header1),(header));
        Assert.assertEquals(BrowserUtils.getText(priceContainer),(price));
        Assert.assertTrue(BrowserUtils.getText(moreInformation).contains(description));
    }

    public void clickAddToCartButton(){
        addToCart.click();
    }

    public void validateProductIsAdded(WebDriver driver,String expectedMessage) throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),(expectedMessage));
        alert.accept();
    }
}
