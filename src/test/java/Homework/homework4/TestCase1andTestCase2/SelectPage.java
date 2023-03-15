package Homework.homework4.TestCase1andTestCase2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SelectPage extends TestBaseSelect {

    public SelectPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#countriesSingle")
    WebElement dropDownMenu;
    Select select;
    public void validateSelectedCountry(String expectedCountry){
        select = new Select(dropDownMenu);
        Assert.assertEquals(select.getFirstSelectedOption().getText().trim(),expectedCountry);
    }
    public void validateSizeOfDropDown(int expectedSize){
        Assert.assertEquals(select.getOptions().size(),expectedSize);
    }
    public void validateValuesOfDropDown(String country1,String country2, String country3,String country4){
        List<String> expectedCountries = Arrays.asList(country1,country2,country3,country4);
        List<WebElement> actualCountries = select.getOptions();
        for (int i = 0; i < actualCountries.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(actualCountries.get(i)),expectedCountries.get(i));
        }
    }
    public void selectEnglandWithValue(String value){
        BrowserUtils.selectBy(dropDownMenu,value,"value");
    }
    public void selectUSA_WithVisibleText(String visibleText){
        BrowserUtils.selectBy(dropDownMenu,visibleText,"text");
    }

//    Elements and methods for test case 2 :
    @FindBy (xpath = "//select[@id='countriesMultiple']")
    WebElement multipleSelect;
    List<WebElement> actualValues;
    public void validateValuesForMultipleSelect(String country1,String country2, String country3,String country4){
        select = new Select(multipleSelect);
        List<String> expectedValues= Arrays.asList(country1,country2, country3,country4);
        actualValues = select.getOptions();
        for (int i = 0; i < actualValues.size(); i++) {
            Assert.assertEquals(expectedValues.get(i),BrowserUtils.getText(actualValues.get(i)));
        }
    }
    @FindBy (xpath = "//select[@id='countriesMultiple']//option[@value='china']")
    WebElement china;

    @FindBy(xpath = "//select[@id='countriesMultiple']//option[@value='england']")
    WebElement england;

    @FindBy (xpath = "//select[@id='countriesMultiple']//option[@value='usa']")
    WebElement usa;

    @FindBy(xpath = "//select[@id='countriesMultiple']//option[@value='india']")
    WebElement india;
    public void validateChina_EnglandIsDisplayed(String expectedCountry1, String expectedCountry2){
        Assert.assertTrue(china.isDisplayed() && BrowserUtils.getText(china).equals(expectedCountry1));
        Assert.assertTrue(england.isDisplayed() && BrowserUtils.getText(england).equals(expectedCountry2));
    }
    public void deselectAllTheCountries(){
        select.deselectAll();
    }
    public void selectAllTheCountries(){
        for (int i = 0; i < actualValues.size(); i++) {
            if (actualValues.get(i).isDisplayed() && !actualValues.get(i).isSelected()){
                actualValues.get(i).click();
            }
        }
    }
    public void validateIndiaAndUsaAreDisplayed(String expectedCountry1, String expectedCountry2){
        Assert.assertTrue(india.isDisplayed() && BrowserUtils.getText(india).equals(expectedCountry1));
        Assert.assertTrue(usa.isDisplayed() && BrowserUtils.getText(usa).equals(expectedCountry2));
    }
    public void deselectChinaWithIndexNumber(){
        select.deselectByIndex(2);
    }
    public void deselectEnglandWithValue(){
        select.deselectByValue("england");
    }

    @FindBy (partialLinkText = "Register a patient")
    WebElement registerPatient;




}
