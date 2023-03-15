package mentoringWithAhmet.Bank.tests;

import mentoringWithAhmet.Bank.pages.CustomerPage;
import mentoringWithAhmet.Bank.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DepositTest extends BankTestBase{
    @Test
    public void deposit_withdrawMoney(){
        HomePage homePage = new HomePage(driver);
        homePage.customerLogin();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.selectUser("Harry Potter");
        Assert.assertEquals(customerPage.validateWelcomeMessage(),"Welcome Harry Potter !!");
        customerPage.validateDepositFunctionality("500","Deposit Successful");
    }

}
