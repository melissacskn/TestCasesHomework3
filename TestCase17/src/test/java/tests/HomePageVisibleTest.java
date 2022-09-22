package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class HomePageVisibleTest extends  BaseTest{
    HomePage homePage;
    @BeforeTest
    public void set(){
        homePage= new HomePage(driver);
    }
    @Test
    public void isHomePageVisible(){
        assertEquals(homePage.getHomePageName(),"Automation Exercise","Home Page is not visible");
    }
}
