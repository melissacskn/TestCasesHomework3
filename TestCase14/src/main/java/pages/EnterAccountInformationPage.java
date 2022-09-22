package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EnterAccountInformationPage {
    WebDriver driver;
    public EnterAccountInformationPage(WebDriver driver){
        this.driver=driver;
    }
    By genderLocator= By.id("id_gender2");
    By passwordLocator=By.id("password");
    By daysLocator=By.id("days");
    By monthsLocator=By.id("months");
    By yearsLocator=By.id("years");
    By newsletterLocator=By.cssSelector("#form > div > div > div > div.login-form > form > div:nth-child(7) > label");
    By optinLocator=By.id("optin");
    By nameFieldLocator=By.id("first_name");
    By lastNameFieldLocator=By.id("last_name");
    By companyFieldLocator=By.id("company");
    By address1Locator=By.id("address1");
    By address2Locator=By.id("address2");
    By countryLocator=By.id("country");
    By stateLocator=By.id("state");
    By cityLocator=By.id("city");
    By zipcodeLocator=By.id("zipcode");
    By mobilenumberLocator=By.id("mobile_number");
    By createAccountButtonLocator=By.cssSelector("button[data-qa=\"create-account\"]");
    By continueButtonLocator=By.linkText("Continue");
    public WebElement elementFinder(By locator){
       return  driver.findElement(locator);

    }
    public void enteringFields(){
        elementFinder(genderLocator).click();
        elementFinder(passwordLocator).sendKeys("4mkl");
        Select selectday=new Select(elementFinder(daysLocator));
        selectday.selectByValue("21");
        Select selectmonth=new Select(elementFinder(monthsLocator));
        selectmonth.selectByIndex(2);
        Select selectyear =new Select(elementFinder(yearsLocator));
        selectyear.selectByValue("2001");
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(newsletterLocator));
        elementFinder(newsletterLocator).click();
        elementFinder(optinLocator).click();
        elementFinder(nameFieldLocator).sendKeys("Hailey");
        elementFinder(lastNameFieldLocator).sendKeys("Gilbert");
        elementFinder(companyFieldLocator).sendKeys("amazon");
        elementFinder(address1Locator).sendKeys("United States");
        elementFinder(address2Locator).sendKeys("London");
        Select selectcountry=new Select(elementFinder(countryLocator));
        selectcountry.selectByValue("United States");
        elementFinder(stateLocator).sendKeys("United States");
        elementFinder(cityLocator).sendKeys("London");
        elementFinder(zipcodeLocator).sendKeys("5211");
        elementFinder(mobilenumberLocator).sendKeys("+44 20 7234 3456");
        JavascriptExecutor jss= (JavascriptExecutor)driver;
        jss.executeScript("arguments[0].scrollIntoView();",driver.findElement(createAccountButtonLocator));
        elementFinder(createAccountButtonLocator).click();


    }
    public String gettingAccountCreatedTitle(){
        System.out.println(driver.getTitle());
        return driver.getTitle();

    }
    public void clickOnContinue(){
        elementFinder(continueButtonLocator).click();
    }




}
