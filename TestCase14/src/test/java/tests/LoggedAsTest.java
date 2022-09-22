package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class LoggedAsTest extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    CartsPage cartsPage;
    LoginPage loginPage;
    EnterAccountInformationPage enterAccountInformationPage;
    LoggedPage loggedPage;


    @BeforeTest
    public void set(){
        homePage= new HomePage(driver);
        productsPage=new ProductsPage(driver);
        cartsPage=new CartsPage(driver);
        loginPage=new LoginPage(driver);
        enterAccountInformationPage=new EnterAccountInformationPage(driver);
        loggedPage =new LoggedPage(driver);
    }
    @Test
    public void loggedAsVisibleTest(){
        homePage.clickOnProducts();
        productsPage.scrollDownToFirstProduct();
        productsPage.hoverAndAddFirstProductToCart();

        productsPage.scrollDownToSecondProduct();
        productsPage.hoverAndAddSecondProductToCart();
        cartsPage.clickOnCheckOut();
        cartsPage.clickRegisterOrLogin();
        loginPage.setSignUp();
        enterAccountInformationPage.enteringFields();

        enterAccountInformationPage.clickOnContinue();
        Assert.assertTrue(loggedPage.loggedAs(),"Logged as is not visible");
        loggedPage.clickCart();
        cartsPage.clickOnCheckOut();

    }

}
