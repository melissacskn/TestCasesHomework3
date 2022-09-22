package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

public class CartPageDisplayedTest extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;

    @BeforeTest
    public void set(){
        homePage= new HomePage(driver);
        productsPage=new ProductsPage(driver);
    }
    @Test
    public void testingCartPageDisplayed(){
        homePage.clickOnProducts();

        productsPage.scrollDownToFirstProduct();
        productsPage.hoverAndAddFirstProductToCart();

        productsPage.scrollDownToSecondProduct();
        productsPage.hoverAndAddSecondProductToCart();

        Assert.assertEquals(productsPage.isCartPage(),"Automation Exercise - Checkout","Cart Page is not displayed");

    }



}
