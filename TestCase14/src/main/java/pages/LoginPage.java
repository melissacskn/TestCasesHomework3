package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    By nameField= By.name("name");
    By emailAddressField=By.cssSelector("input[data-qa=\"signup-email\"]");
    By signUpButton=By.cssSelector("button[data-qa=\"signup-button\"]");
    public void setSignUp(){
        driver.findElement(nameField).sendKeys("Hailey");
        driver.findElement(emailAddressField).sendKeys("haileey810@gmail.com");
        driver.findElement(signUpButton).click();
    }

}

