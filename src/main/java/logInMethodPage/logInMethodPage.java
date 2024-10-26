package logInMethodPage;

import EmailPage.EmailPage;
import ImdbSignIn.ImdbSignIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import HomePage.HomePage;

public class logInMethodPage {
    private WebDriver driver;
    public logInMethodPage(WebDriver driver)
/* constructor creation >> makes the return type logInMethodPage available in the InterfacePage class */

    {
        this.driver = driver;
    }

    private By imdbSignInBtn = By.xpath("//span[text()=\"Sign in with IMDb\"]");

    public ImdbSignIn clickSignWithImdb()
    {
        driver.findElement(imdbSignInBtn).click();
        return new ImdbSignIn(driver); //driver is here >> don't have to put it as a parameter for constructor of page switch
    }


}
