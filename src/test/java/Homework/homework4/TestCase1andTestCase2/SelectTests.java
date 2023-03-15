package Homework.homework4.TestCase1andTestCase2;

import org.testng.annotations.Test;

public class SelectTests extends TestBaseSelect{

    @Test
    public void testCase1(){
        SelectPage selectPage = new SelectPage(driver);
        selectPage.validateSelectedCountry("India");
        selectPage.validateSizeOfDropDown(4);
        selectPage.validateValuesOfDropDown("India","United states of America","China","England");
        selectPage.selectEnglandWithValue("england");
        selectPage.selectUSA_WithVisibleText("United states of America");
    }

    @Test
    public void testCase2(){
        SelectPage selectPage = new SelectPage(driver);
        selectPage.validateValuesForMultipleSelect("India","United states of America","China","England");
        selectPage.validateChina_EnglandIsDisplayed("China","England");
        selectPage.deselectAllTheCountries();
        selectPage.selectAllTheCountries();
        selectPage.validateIndiaAndUsaAreDisplayed("India","United states of America");
        selectPage.deselectChinaWithIndexNumber();
        selectPage.deselectEnglandWithValue();

    }
}
