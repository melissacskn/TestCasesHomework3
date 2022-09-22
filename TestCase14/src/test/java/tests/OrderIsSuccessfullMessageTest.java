package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class OrderIsSuccessfullMessageTest extends BaseTest{  HomePage homePage;
    ProductsPage productsPage;
    CartsPage cartsPage;
    LoginPage loginPage;
    EnterAccountInformationPage enterAccountInformationPage;
    LoggedPage loggedPage;
    AddressDetailsPage addressDetailsPage;
    PaymentDetailsPage paymentDetailsPage;
    @BeforeTest
    public void set(){
        homePage= new HomePage(driver);
        productsPage=new ProductsPage(driver);
        cartsPage=new CartsPage(driver);
        loginPage=new LoginPage(driver);
        enterAccountInformationPage=new EnterAccountInformationPage(driver);
        loggedPage =new LoggedPage(driver);
        addressDetailsPage=new AddressDetailsPage(driver);
        paymentDetailsPage=new PaymentDetailsPage(driver);
    }
    @Test
    public void verifyingAddress() {
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
        addressDetailsPage.commentOrder();
        paymentDetailsPage.fieldDetails();
        Assert.assertTrue(paymentDetailsPage.orderplacedSuccessfully(),"'Your order has been placed successfully!' is not verified ");
    }
}
