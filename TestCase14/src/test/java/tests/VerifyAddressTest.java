package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class VerifyAddressTest extends  BaseTest{
    HomePage homePage;
    ProductsPage productsPage;
    CartsPage cartsPage;
    LoginPage loginPage;
    EnterAccountInformationPage enterAccountInformationPage;
    LoggedPage loggedPage;
    AddressDetailsPage addressDetailsPage;
    @BeforeTest
    public void set(){
        homePage= new HomePage(driver);
        productsPage=new ProductsPage(driver);
        cartsPage=new CartsPage(driver);
        loginPage=new LoginPage(driver);
        enterAccountInformationPage=new EnterAccountInformationPage(driver);
        loggedPage =new LoggedPage(driver);
        addressDetailsPage=new AddressDetailsPage(driver);
    }
    @Test
    public void verifyingAddress(){
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
        loggedPage.clickCart();
        cartsPage.clickOnCheckOut();
        Assert.assertTrue(addressDetailsPage.addressVisibleOrNot(),"Address details are not true");
        Assert.assertTrue(addressDetailsPage.reviewOrderOrNot(),"Review Order is not visible");
        addressDetailsPage.commentOrder();
    }

}
