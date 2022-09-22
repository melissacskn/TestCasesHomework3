package stepDefinations;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.*;

import static org.testng.Assert.assertEquals;

public class RegisterWhileCheckout {
    WebDriver driver;
    HomePage homePage;
    ProductsPage productsPage;
    CartsPage cartsPage;
    LoginPage loginPage;
    EnterAccountInformationPage enterAccountInformationPage;
    LoggedPage loggedPage;
    AddressDetailsPage addressDetailsPage;
    PaymentDetailsPage paymentDetailsPage;



    @Given("launch browser")
    public void launch_browser() {
        System.setProperty("webdriver.chrome.driver","/Users/vngrs/Desktop/chromedriver");
        driver=new ChromeDriver();
        System.out.println("Launched the browser");


    }

    @When("user navigates to home page")
    public void user_navigates_to_home_page() {
        driver.get("https://automationexercise.com/");
        System.out.println("navigated to home page");
        homePage=new HomePage(driver);


    }

    @Then("verify that home page is visible")
    public void verify_that_home_page_is_visible() {

        assertEquals(homePage.getHomePageName(),"Automation Exercise","Home Page is not visible");
        System.out.println("Home page is visible");
    }

    @Given("add products to cart")
    public void add_products_to_cart() {
        productsPage=new ProductsPage(driver);

        productsPage.scrollDownToFirstProduct();
        productsPage.hoverAndAddFirstProductToCart();

        productsPage.scrollDownToSecondProduct();
        productsPage.hoverAndAddSecondProductToCart();


        System.out.println("user added products to cart");

    }

    @When("user clicks on X button")
    public void user_clicks_on_x_button() {
        System.out.println("User clicked to X buttton ");

    }

    @Then("verify that cart page is visible")
    public void verify_that_cart_page_is_visible() {
        Assert.assertEquals(productsPage.isCartPage(),"Automation Exercise - Checkout","Cart Page is not displayed");
        System.out.println("verified that cart page is visible");

    }

    @Given("click to proceed to checkout")
    public void click_to_proceed_to_checkout() {

 driver.findElement(By.cssSelector("#do_action > div.container > div > div > a")).click();

    }

    @Given("click on register\\/login button")
    public void click_on_register_login_button() {
        cartsPage=new CartsPage(driver);
        loginPage=new LoginPage(driver);

        cartsPage.clickRegisterOrLogin();
        loginPage.setSignUp();

    }

    @When("fill all the details in signup and create account")
    public void fill_all_the_details_in_signup_and_create_account() {
        enterAccountInformationPage=new EnterAccountInformationPage(driver);

        enterAccountInformationPage.enteringFields();

    }

    @Then("verify Account Created")
    public void verify_account_created() {
        Assert.assertEquals(enterAccountInformationPage.gettingAccountCreatedTitle(),"Automation Exercise - Account Created","Account is not created");



    }

    @Then("click continue button")
    public void click_continue_button() {
        enterAccountInformationPage.clickOnContinue();

    }

    @Then("Verify Logged in as username at top")
    public void verify_logged_in_as_username_at_top() {
        loggedPage =new LoggedPage(driver);

        Assert.assertTrue(loggedPage.loggedAs(),"Logged as is not visible");

    }

    @Given("Click Cart button")
    public void click_cart_button() {
        loggedPage.clickCart();

    }

    @When("Click Proceed To Checkout button")
    public void click_proceed_to_checkout_button() {
        cartsPage.clickOnCheckOut();

    }

    @Then("verify Address Details and Review Your Order")
    public void verify_address_details_and_review_your_order() {
        addressDetailsPage=new AddressDetailsPage(driver);

        Assert.assertTrue(addressDetailsPage.addressVisibleOrNot(),"Address details are not true");
        Assert.assertTrue(addressDetailsPage.reviewOrderOrNot(),"Review Order is not visible");

    }

    @Given("Enter description in comment text area and click Place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {
        addressDetailsPage.commentOrder();

    }

    @Given("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {
        By nameLocator= By.name("name_on_card");
        By cardNumberLocator=By.name("card_number");
        By cvcLocator=By.name("cvc");
        By expirymonthLocator=By.name("expiry_month");
        By expiryyearLocator=By.name("expiry_year");

        driver.findElement(nameLocator).sendKeys("hailey");
        driver.findElement(cardNumberLocator).sendKeys("6038372629");
        driver.findElement(cvcLocator).sendKeys("309");
        driver.findElement(expirymonthLocator).sendKeys("june");
        driver.findElement(expiryyearLocator).sendKeys("2024");

    }

    @When("Click Pay and Confirm Order button")
    public void click_pay_and_confirm_order_button() {
        By payandOrderLocator=By.id("submit");
        driver.findElement(payandOrderLocator).click();

    }

    @Then("Verify success message Your order has been placed successfully!")
    public void verify_success_message_your_order_has_been_placed_successfully() {
        paymentDetailsPage=new PaymentDetailsPage(driver);
        Assert.assertTrue(paymentDetailsPage.orderplacedSuccessfully(),"'Your order has been placed successfully!' is not verified ");

    }
}
