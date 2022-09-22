package stepDefinations;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;

public class RemoveProducts {
    HomePage homePage;
    ProductsPage productsPage;
    WebDriver driver;

    @Given("Launch browser")
    public void launch_browser() {
        System.setProperty("webdriver.chrome.driver","/Users/vngrs/Desktop/chromedriver");
        driver=new ChromeDriver();
        System.out.println("Launched the browser");
    }

    @When("Navigate to the home page")
    public void navigate_to_the_home_page() {
        driver.get("https://automationexercise.com/");
        System.out.println("navigated to home page");
    }

    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        homePage=new HomePage(driver);
        assertEquals(homePage.getHomePageName(),"Automation Exercise","Home Page is not visible");
        System.out.println("Home page is visible");
    }

    @Given("User adds products to cart")
    public void user_adds_products_to_cart() {
        homePage= new HomePage(driver);
        productsPage=new ProductsPage(driver);
        productsPage.scrollDownToFirstProduct();
        productsPage.hoverAndAddFirstProductToCart();

        productsPage.scrollDownToSecondProduct();
        productsPage.hoverAndAddSecondProductToCart();


        System.out.println("user added products to cart");
    }

    @When("User click's to the Cart button")
    public void user_click_s_to_the_cart_button() {
        System.out.println("User clicked to cart's buttton ");
    }

    @Then("User is verified that cart page is displayed")
    public void user_is_verified_that_cart_page_is_displayed() {
        Assert.assertEquals(productsPage.isCartPage(),"Automation Exercise - Checkout","Cart Page is not displayed");
        System.out.println("User is verified that cart page is displayed");
    }

    @Given("On Carts page")
    public void on_carts_page() {
        System.out.println("user is in"+ driver.getTitle());
    }

    @When("User clicks to X button")
    public void user_clicks_to_x_button() {
        System.out.println("user clicked to the X button");
    }

    @Then("Verified that product is removed from cart")
    public void verified_that_product_is_removed_from_cart() {
        Assert.assertFalse(productsPage.isFirstProductVisible(),"deletion of the first product is not successfull");
        System.out.println("first product is removed from cart");
    }

}
