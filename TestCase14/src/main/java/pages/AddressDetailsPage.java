package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressDetailsPage {
    WebDriver driver;
    public AddressDetailsPage(WebDriver driver){
        this.driver=driver;
    }
    By addressLocator= By.cssSelector("#cart_items > div > div:nth-child(2) > h2");
    By reviewOrderLocator=By.cssSelector("#cart_items > div > div:nth-child(4) > h2");
    By commentOrderLocator=By.cssSelector("#ordermsg > textarea");
    By placeHolder=By.cssSelector("#cart_items > div > div:nth-child(7) > a");


    public boolean addressVisibleOrNot(){
        return driver.findElement(addressLocator).isDisplayed();

    }
    public boolean reviewOrderOrNot(){
        return driver.findElement(reviewOrderLocator).isDisplayed();
    }
    public void commentOrder(){
        driver.findElement(commentOrderLocator).sendKeys("the orders are emergent");
        driver.findElement(placeHolder).click();
    }

}
