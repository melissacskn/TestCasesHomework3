package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public String getHomePageName(){
        return driver.getTitle();

    }
    By productsButtonLocator = By.cssSelector("a[href=\"/products\"]");
    public void clickOnProducts(){
        WebElement element=driver.findElement(productsButtonLocator);
        element.click();



    }

}
