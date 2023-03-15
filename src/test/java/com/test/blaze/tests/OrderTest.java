package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class OrderTest extends TestBaseBlaze {

    @Test
    public void validateMacBookProductInfo() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptopButton();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseMacBook("MacBook Pro",driver);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.clickAddToCartButton();
        macBookProPage.validateProductIsAdded(driver,"Product added");
        mainPage.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.validateProductInformation("MacBook Pro","1100");
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickPlaceOrderButton();
        orderPage.validateProductIsPlaced(driver,"Octavian","Moldova",ConfigReader.readProperty("city"), ConfigReader.readProperty("creditCard"),"06","2024","https://www.demoblaze.com/index.html");
    }

}