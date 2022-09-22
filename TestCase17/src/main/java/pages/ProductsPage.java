package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    WebDriver driver;
    public ProductsPage(WebDriver driver){
        this.driver=driver;
    }
    By firstproductLocator= By.cssSelector("img[src=\"/get_product_picture/4\"]");
    By secondproductLocator= By.cssSelector("img[src=\"/get_product_picture/18\"]");
    By getFirstproductAddToCartLocator=By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(6) > div > div.single-products > div.productinfo.text-center > a");
    By getSecondproductAddToCartLocator=By.cssSelector("body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(17) > div > div.single-products > div.productinfo.text-center > a");
    By modalLocator=By.cssSelector("#cartModal > div > div");


    By continueShoppingLocator=By.cssSelector("#cartModal > div > div > div.modal-footer > button");
    By viewCartButtonLocator = By.cssSelector("a[href=\"/view_cart\"] u");

    public void scrollDownToFirstProduct(){

        WebElement firstProduct=driver.findElement(firstproductLocator);
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",firstProduct);

    }
    public void hoverAndAddFirstProductToCart(){
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(firstproductLocator));
        WebDriverWait wait= new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(getFirstproductAddToCartLocator)));

        driver.findElement(getFirstproductAddToCartLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalLocator));
        driver.findElement(continueShoppingLocator).click();

    }
    public void scrollDownToSecondProduct(){

        WebElement secondProduct=driver.findElement(secondproductLocator);
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",secondProduct);

    }

    public void hoverAndAddSecondProductToCart(){
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(secondproductLocator));
        WebDriverWait wait= new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(getSecondproductAddToCartLocator)));

        driver.findElement(getSecondproductAddToCartLocator).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modalLocator)));
        driver.findElement(viewCartButtonLocator).click();


    }
    public String isCartPage(){
        System.out.println("Carts Page Title is: " + driver.getTitle());
        // Automation Exercise - Checkout
        return driver.getTitle();

    }

    public boolean isFirstProductVisible(){
        driver.findElement(By.cssSelector("a[data-product-id=\"4\"]")).click();
        try{
            driver.findElement(firstproductLocator);
            return  true;
        }catch(NoSuchElementException e){
            return  false;
        }
    }
}
