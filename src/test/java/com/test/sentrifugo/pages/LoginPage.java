package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {


    //I store my all webElements and methods inside of a specific pages(LoginPage)
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    //WebElement username = driver.findElement(By.xpath="//input[@id='username']")

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'T')]")
    WebElement errorMessage;


    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();

    }

    public String validateMessage(){
        return BrowserUtils.getText(errorMessage);
    }

    public String validateColorOfErrorMessage(){
        return errorMessage.getCssValue("color").trim(); //rgba color
    }



}
