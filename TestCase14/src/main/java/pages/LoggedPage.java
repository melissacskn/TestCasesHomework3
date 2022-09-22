package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedPage {
    WebDriver driver;
    public LoggedPage(WebDriver driver){
        this.driver=driver;
    }
    By loggedasLocator= By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a");
    By cartLocator=By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");
    public boolean loggedAs(){
        return driver.findElement(loggedasLocator).isDisplayed();
    }
    public void clickCart(){
        driver.findElement(cartLocator).click();
    }
}
