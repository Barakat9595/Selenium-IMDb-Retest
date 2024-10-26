package BaseTests;

import HomePage.HomePage;
import ImdbSignIn.ImdbSignIn;
import SiteInterfacePage.InterfacePage;
import logInMethodPage.logInMethodPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;


public class BaseTests {

    private WebDriver driver;
    public static HomePage homePage; /* TestNG creates a new instance of the Search class for
     each test method, and the homePage variable in BaseTests is reinitialized or not shared properly.
    To solve this, we need to ensure the same WebDriver session is used across all test classes.
    that's why homePage is static */
    @BeforeTest
    public void setUpBrowser()

    {
        //System.setProperty("webdriver.edge.driver", "E:\\private\\Trash\\ITI\\New folder\\Driver_Notes");

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com/");
        InterfacePage interfacePage = new InterfacePage(driver); //create object first
        logInMethodPage loginMethod = interfacePage.clickSignIn();
        ImdbSignIn imdbSignIn = loginMethod.clickSignWithImdb();
        imdbSignIn.enterEmail("abdulfattahcaz19@gmail.com");
        imdbSignIn.enterPassword("M7moudjr_");
        homePage = imdbSignIn.clickSignIn();


    }

   /*  @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    } */
    /* @BeforeClass
    public void redirectHome()
    {
        driver.get("https://www.imdb.com/?ref_=login"); //redirects to home page
    }
*/
}
