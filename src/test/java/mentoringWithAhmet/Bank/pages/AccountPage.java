package mentoringWithAhmet.Bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    public AccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(partialLinkText = "Deposit")
    WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;

    @FindBy(linkText = "Deposit")
    WebElement submitDeposit;
    public void depositMoney(int depositAmount){

    }
}
