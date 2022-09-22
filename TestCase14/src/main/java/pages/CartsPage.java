package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartsPage {
    WebDriver driver;
    public CartsPage(WebDriver driver){
        this.driver=driver;
    }
    By proceedToCheckoutLocator= By.linkText("Proceed To Checkout");
    By modalLocator= By.cssSelector("#checkoutModal > div > div");
    By registerOrLoginLocator= By.cssSelector("#checkoutModal > div > div > div.modal-body > p:nth-child(2) > a > u");
    public void clickOnCheckOut(){
        driver.findElement(proceedToCheckoutLocator).click();
    }

    public void clickRegisterOrLogin(){
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalLocator)));
        driver.findElement(registerOrLoginLocator).click();
    }
}
