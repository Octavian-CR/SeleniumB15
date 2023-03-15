package mentoringWithAhmet.Bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#userSelect")
    WebElement userSelect;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    public void selectUser(String user){
        BrowserUtils.selectBy(userSelect,user,"text");
        submitButton.click();
    }

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeMessage;

    public String validateWelcomeMessage(){
        return BrowserUtils.getText(welcomeMessage);
    }

    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement depositTop;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitDeposit;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement depositMessage;
    public void validateDepositFunctionality(String amount,String expectedMessage){
        depositTop.click();
        this.amount.sendKeys(amount);
        submitDeposit.click();
        Assert.assertEquals(BrowserUtils.getText(depositMessage),expectedMessage);
    }


}
