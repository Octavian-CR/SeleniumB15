package mentoringWithAhmet.Bank.pages;

import mentoringWithAhmet.Bank.tests.BankTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage extends BankTestBase {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement loginButton;
    public void customerLogin(){
        loginButton.click();
    }




}
