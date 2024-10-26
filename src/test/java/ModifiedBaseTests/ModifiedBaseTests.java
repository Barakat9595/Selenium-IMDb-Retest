package ModifiedBaseTests;

import ImdbSignIn.ImdbSignIn;
import SiteInterfacePage.InterfacePage;
import logInMethodPage.logInMethodPage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import HomePage.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

public class ModifiedBaseTests {

    //this is the start of the independent test cases/methods in each test class
    protected WebDriver driver;
    protected HomePage homePage;
    @DataProvider(name = "osBrowserData", parallel = true)
    public Object[][] getOSAndBrowserData() {
        return new Object[][]{
                {"LINUX", "firefox"}
        };
    }
    @BeforeClass
    @org.testng.annotations.Parameters({"os", "browser"}) //parametrization for the @Before annotations
    public void setUp(String os, String browser) throws MalformedURLException {
        // Configure WebDriver based on the provided OS and browser parameters
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (os.equalsIgnoreCase("windows"))
        {
           capabilities.setPlatform(Platform.WIN11);
        }
        else if (os.equalsIgnoreCase("linux"))
        {
            capabilities.setPlatform(Platform.LINUX);
        }
        else
        {
            capabilities.setPlatform(Platform.MAC);
        }

        switch (browser.toLowerCase())
        {
            case"chrome": capabilities.setBrowserName("chrome");
            break;
            case"edge": capabilities.setBrowserName("edge");
            break;
            case"firefox": capabilities.setBrowserName("firefox");
            default:
                System.out.println("No such browser");
        }


        driver = new RemoteWebDriver(new URL("http://169.254.247.101:4444"), capabilities);
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com/");
        InterfacePage interfacePage = new InterfacePage(driver); //create object first
        logInMethodPage loginMethod = interfacePage.clickSignIn();
        ImdbSignIn imdbSignIn = loginMethod.clickSignWithImdb();
        imdbSignIn.enterEmail("email");
        imdbSignIn.enterPassword("password");
        homePage = imdbSignIn.clickSignIn(); // Initialize HomePage
    }

    @AfterMethod  //redirects the driver to start from home page
    public void goToHomePage() {
        // Navigate to the home page before each test starts
        driver.get("https://www.imdb.com/?ref_=nv_home");
        homePage = new HomePage(driver); // Reinitialize the homePage
    }

  /*  @AfterClass
    public void tearDown() {

            driver.quit();

    } */
}
