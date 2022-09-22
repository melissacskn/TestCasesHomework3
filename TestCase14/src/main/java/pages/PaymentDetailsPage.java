package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class PaymentDetailsPage {
    WebDriver driver;
    public PaymentDetailsPage(WebDriver driver){
        this.driver=driver;
    }
    By nameLocator= By.name("name_on_card");
    By cardNumberLocator=By.name("card_number");
    By cvcLocator=By.name("cvc");
    By expirymonthLocator=By.name("expiry_month");
    By expiryyearLocator=By.name("expiry_year");
    By payandOrderLocator=By.id("submit");

    public void fieldDetails(){
        driver.findElement(nameLocator).sendKeys("hailey");
        driver.findElement(cardNumberLocator).sendKeys("6038372629");
        driver.findElement(cvcLocator).sendKeys("309");
        driver.findElement(expirymonthLocator).sendKeys("june");
        driver.findElement(expiryyearLocator).sendKeys("2024");
        driver.findElement(payandOrderLocator).click();

    }

    public boolean orderplacedSuccessfully(){


        WebDriverWait wait= new WebDriverWait(driver,10);
        WebElement successElement =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='alert-success alert']")));
        driver.findElement(By.cssSelector("div[class='alert-success alert']"));
        try{
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }

    }


}
