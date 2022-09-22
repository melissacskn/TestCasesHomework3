package tests;

import io.cucumber.java.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

public class ProductIsRemovedTest extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    @BeforeTest
    public void set(){
        homePage=new HomePage(driver);
        productsPage=new ProductsPage(driver);
    }
    @Test
    public void productIsRemoved(){
        homePage.clickOnProducts();
        productsPage.scrollDownToFirstProduct();
        productsPage.hoverAndAddFirstProductToCart();
        productsPage.scrollDownToSecondProduct();
        productsPage.hoverAndAddSecondProductToCart();
        Assert.assertFalse(productsPage.isFirstProductVisible(),"deletion of the first product is not successfull");
    }
}
