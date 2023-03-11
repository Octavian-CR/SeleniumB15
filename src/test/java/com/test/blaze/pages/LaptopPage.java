package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopPage {
    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//div[@id='tbodyid']//h4")
    List<WebElement> products;


    public void chooseMacBook(String requiredProduct,WebDriver driver) throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        for (WebElement product : products){
            if (product.getText().contains(requiredProduct)){
                BrowserUtils.scrollWithJS(driver,product);
                actions.moveToElement(product).click(product).perform();

                break;
            }
        }
    }
}
