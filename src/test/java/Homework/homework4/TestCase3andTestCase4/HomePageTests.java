package Homework.homework4.TestCase3andTestCase4;

import org.testng.annotations.Test;

public class HomePageTests extends TestBaseOpenMRS{

    @Test
    public void testCase3() throws InterruptedException {
        OpenMRS_homePage homePage = new OpenMRS_homePage(driver);
        homePage.ValidateLocation("Laboratory");
        homePage.ValidateMessage("Logged in as Super User (admin) at Laboratory");
        homePage.changeLocationToPharmacy(driver);
        homePage.ValidateMessage("Logged in as Super User (admin) at Pharmacy");
        homePage.ValidateLocation("Pharmacy");
        homePage.findAndValidateIdentifierIsUnique(driver,"john johns","100TUE");
    }

}
