package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class AccountCreatedTest extends BaseTest {
    HomePage homePage;
    ProductsPage productsPage;
    CartsPage cartsPage;
    LoginPage loginPage;
    EnterAccountInformationPage enterAccountInformationPage;

    @BeforeTest
    public void set(){
        homePage= new HomePage(driver);
        productsPage=new ProductsPage(driver);
        cartsPage=new CartsPage(driver);
        loginPage=new LoginPage(driver);
        enterAccountInformationPage=new EnterAccountInformationPage(driver);
    }
    @Test
    public void isAccountCreated(){
        homePage.clickOnProducts();
        productsPage.scrollDownToFirstProduct();
        productsPage.hoverAndAddFirstProductToCart();

        productsPage.scrollDownToSecondProduct();
        productsPage.hoverAndAddSecondProductToCart();
        cartsPage.clickOnCheckOut();
        cartsPage.clickRegisterOrLogin();
        loginPage.setSignUp();
        enterAccountInformationPage.enteringFields();
        Assert.assertEquals(enterAccountInformationPage.gettingAccountCreatedTitle(),"Automation Exercise - Account Created","Account is not created");
        enterAccountInformationPage.clickOnContinue();

    }

}
